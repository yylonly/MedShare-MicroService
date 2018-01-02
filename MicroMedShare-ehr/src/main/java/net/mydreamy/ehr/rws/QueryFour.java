package net.mydreamy.ehr.rws;

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

import net.mydreamy.ehr.ejb.QueryFourBean;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.QueryParam;

@Path("queryfour")
public class QueryFour {

    @Context
    private UriInfo context;
    @EJB 
    QueryFourBean bean;
    /**
     * Default constructor. 
     */
    public QueryFour() {
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
        
    	String sql = "SELECT new net.mydreamy.ehr.result.QueryFourListResult(p.gender, COUNT(c.patientID.pid)) " +
    			"FROM Clinicaldetection c, Patient p " +
                        "WHERE c.patientID.pid = p.pid " +
                        "AND c.times = \'1\' " +
                        "AND c.hBsAg = \'0\' " +
                        "AND c.patientID.pid IN ( SELECT cl.patientID.pid FROM Clinicaldetection cl " +
                        "WHERE cl.times = \'3\' " +
                        "AND cl.antiHBs = \'0\' ) " +
                        "GROUP BY p.gender ";
    	return  bean.query(sql);
    }
}