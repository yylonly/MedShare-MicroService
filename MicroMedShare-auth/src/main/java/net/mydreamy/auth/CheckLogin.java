package net.mydreamy.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class CheckLogin
 */
@Stateless
@LocalBean
public class CheckLogin {
    /**
     * Default constructor. 
     */
    @PersistenceContext(unitName = "EHR")
    EntityManager em;
	
    public CheckLogin() {
        // TODO Auto-generated constructor stub
    }
    public Map<String, String> Check(String username, String password) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("isVaild", "False");
        result.put("token", "");
        
    	String passwd = "";
    	String sql = "select u.password from User u where u.username = :name";
    	Query query =  em.createQuery(sql);
    	query.setParameter("name", username);
    	
    	try {
            passwd = (String) query.getSingleResult();
    	} catch (NoResultException e) {
            result.put("isVaild", "False");
    	}
        String token = "";
    	if (password.equals(passwd)) {
            try {
                Algorithm algorithm = Algorithm.HMAC256("secret");
                token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            } catch (UnsupportedEncodingException exception){
                //UTF-8 encoding not supported
            } catch (JWTCreationException exception){
                //Invalid Signing configuration / Couldn't convert Claims.
            }
            
            result.put("isVaild", "True");
            result.put("token", token);
    	} 
        return result;
    }
}
