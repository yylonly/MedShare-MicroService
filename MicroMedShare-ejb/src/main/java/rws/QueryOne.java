package rws;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import ejb.QueryBean;


@Path("queryone")
public class QueryOne {
	
    @Context
    private UriInfo context;
    @EJB 
    QueryBean bean;

    /**
     * Default constructor. 
     */
    public QueryOne() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of QueryOne
     * @return an instance of String
     */
    @GET 
    @Produces("application/xml")
    public String getHtml() {
        // TODO return proper representation object
    	 
    	String sql = "select Country, COUNT(Report_ID ) AS TotalNum " +
			"FROM examination, patient " + 
			"WHERE examination.Patient_ID = patient.PID " +
			"AND Endoscopy_Date " +
			"BETWEEN \'2010-1-1\' " +
			"AND \'2010-12-30\' " +
			"GROUP BY Country   " +
			"Order By TotalNum desc ";
    	//Database query = new Database();
    	String f =  bean.query(sql);
    	System.out.println(f);
    	return f;
    //	return bean.query(sql);
    }


}