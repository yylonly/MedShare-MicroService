package rws;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import ejb.QueryBean;

@Path("querytwo")
public class QueryTwo {
    @Context
    private UriInfo context;
    @EJB
    QueryBean bean;
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
    @Produces("application/xml")
    public String getHtml() {
    	String sql = "SELECT Diagnoses_Text, COUNT( Diagnoses_Text ) AS Num " +
    			"FROM examination " + 
    			"GROUP BY Diagnoses_Text " +
    			"HAVING COUNT( Diagnoses_Text ) >0 " +
    			" LIMIT 5 ";
    	return bean.query(sql);
    }
}