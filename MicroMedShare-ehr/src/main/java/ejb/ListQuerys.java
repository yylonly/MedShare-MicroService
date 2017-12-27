package ejb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import entity.User;
import result.ListResult;

/**
 * Get Query list by specific user
 */
@Stateless
@LocalBean
public class ListQuerys {
 
    @PersistenceUnit(unitName = "EHR")
    EntityManagerFactory emf;	
    /**
     * Default constructor. 
     */
    public ListQuerys() {
        // TODO Auto-generated constructor stub
    //	externalContext = FacesContext.getCurrentInstance().getExternalContext();
    }
    public List<ListResult> listAll(User user, boolean loggedIn)
    {	
        if (loggedIn == true){ 
            //Run Query :name is vaibiles, result is a list type of ListResult
            Query query = emf.createEntityManager().createQuery("select new result.ListResult(l.id, l.description, l.sqlquery, url.url) " +
	    	"from Querylist l, Urlforwebservice url,  Querytorole qtor, Role r, User u " +
                "where l.urlid = url and qtor.querylist = l and qtor.role = r and u.role = r and " +
                "u.username = :name"); 
	    	
	    //set variables value
	    query.setParameter("name", user.getUsername()); 	
	    List<ListResult> result = query.getResultList();	
	    return result; 
    	} else {
            return new ArrayList<ListResult>();
    	}
    }
}
