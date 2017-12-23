package ejb;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.User;

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
    public boolean Check(String username, String password)
    {
    	String passwd = "";
    	String sql = "select u.password from User u where u.username = :name";
    	Query query =  em.createQuery(sql);
    	query.setParameter("name", username);
    	
    	try
    	{
    		passwd = (String) query.getSingleResult();
    	}
    	catch (NoResultException e)
    	{
    		return false;
    	}
    	
    	
    	if (password.equals(passwd))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}
