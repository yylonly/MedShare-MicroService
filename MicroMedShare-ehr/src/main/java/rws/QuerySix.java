package rws;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import ejb.QuerySixBean;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.QueryParam;

@Path("querysix")
public class QuerySix {

    @Context
    private UriInfo context;
    @EJB 
    QuerySixBean bean;
    /**
     * Default constructor. 
     */
    public QuerySix() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of QueryFour
     * @param token
     * @return an instance of String
     */
    @GET
    @Produces("application/json")
    public String getHtml(@QueryParam("token") String token) {
        // TODO return proper representation object
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            return "";
        }
        
        // SELECT DISTINCT COUNT(pres.PID) as PresNum
        // FROM prescription as pres
        // WHERE pres.Pres_Date BETWEEN '2017-1-1' AND '2017-12-31';
        String sql = "SELECT new result.QuerySixListResult(COUNT(pres.pid)) "
                + "FROM Patient p, Doctor d, Prescription pres "
                + "WHERE p.pid=pres.patientID.pid "
                + "AND d.did=pres.doctorID.did "
                + "AND d.name=\'Tom\' "
                + "AND d.surname = \'Baker\' "
                + "AND pres.presDate BETWEEN \'2017-1-1\' AND \'2017-12-31\' ";
        
//    	String sql = "SELECT new result.QueryFourListResult(p.gender, COUNT(c.patientID.pid)) " +
//    			"FROM Clinicaldetection c, Patient p " +
//                        "WHERE c.patientID.pid = p.pid " +
//                        "AND c.times = \'1\' " +
//                        "AND c.hBsAg = \'0\' " +
//                        "AND c.patientID.pid IN ( SELECT cl.patientID.pid FROM Clinicaldetection cl " +
//                        "WHERE cl.times = \'3\' " +
//                        "AND cl.antiHBs = \'0\' ) " +
//                        "GROUP BY p.gender ";
    	return  bean.query(sql);
    }
}