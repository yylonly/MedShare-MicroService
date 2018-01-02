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

import ejb.QueryTwoBean;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.QueryParam;

@Path("querytwo")
public class QueryTwo {
    @Context
    private UriInfo context;
    @EJB
    QueryTwoBean bean;
    /**
     * Default constructor.
     */
    public QueryTwo() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of QueryTwo
     * @return an instance of String
     */
    @GET
    @Produces("application/json")
    public String getHtml(@QueryParam("token") String token) {
        
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
        
        String sql = "SELECT new result.QueryTwoListResult(e.diagnosesText,  COUNT(e.diagnosesText)) "
            + "FROM Examination e "
            + "GROUP BY e.diagnosesText "
            + "ORDER BY COUNT(e.diagnosesText) DESC";
        
        String list = bean.query(sql);
    	return list;
    }
}