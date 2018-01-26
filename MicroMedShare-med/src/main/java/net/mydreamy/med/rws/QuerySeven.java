package net.mydreamy.med.rws;

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

import net.mydreamy.med.ejb.QuerySevenBean;
import java.io.UnsupportedEncodingException;
import javax.ejb.Stateless;
import javax.ws.rs.QueryParam;
import net.mydreamy.med.result.QuerySevenListResult;

@Stateless
@Path("queryseven")
public class QuerySeven {

    @Context
    private UriInfo context;
    @EJB 
    QuerySevenBean bean;
    /**
     * Default constructor. 
     */
    public QuerySeven() {
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
        String numBelow18SQL = "SELECT COUNT(p.pid) "
                + "FROM Paientmed p "
                + "WHERE p.name = \'Acetaminophen\' "
                + "AND FUNC('YEAR', CURRENT_DATE) - FUNC('YEAR', p.doB) < 18";
        long numBelow18 = bean.query(numBelow18SQL);
        
        String num18to40SQL = "SELECT COUNT( p.pid) "
                + "FROM Paientmed p "
                + "WHERE p.name = \'Acetaminophen\' "
                + "AND FUNC('YEAR', CURRENT_DATE) - FUNC('YEAR', p.doB) "
                + "BETWEEN 18 "
                + "AND 40 ";
        long num18to40 = bean.query(num18to40SQL);

        String numAbove40SQL = "SELECT COUNT( p.pid) "
                + "FROM Paientmed p "
                + "WHERE p.name = \'Acetaminophen\' "
                + "AND FUNC('YEAR', CURRENT_DATE) - FUNC('YEAR', p.doB) > 40";
        long numAbove40 = bean.query(numAbove40SQL);
        
        QuerySevenListResult querySevenListResult = new QuerySevenListResult(numBelow18, num18to40, numAbove40);
  
        return querySevenListResult.toJson();
        
    }
}