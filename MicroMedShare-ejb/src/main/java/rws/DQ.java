package rws;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import ejb.QueryBean;


@Path("dq")
public class DQ {
	
    @Context
    private UriInfo context;
    @EJB 
    QueryBean bean;

    /**
     * Default constructor. 
     */
    public DQ() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of QueryOne
     * @return an instance of String
     */
    @GET 
    @Produces("application/xml")
    public String getHtml(@QueryParam("startdate") String startdate, @QueryParam("enddate") String enddate) {
        // TODO return proper representation object
    	
    	String sql = "select Country, COUNT(Report_ID ) AS TotalNum " +
			"FROM examination, patient " + 
			"WHERE examination.Patient_ID = patient.PID " +
			"AND Endoscopy_Date " +
			"BETWEEN '" + startdate + "' " + 
			"AND '" + enddate + "' " + 
			"GROUP BY Country   " +
			"Order By TotalNum desc ";
    	System.out.println(sql);
    
    	String f =  bean.query(sql);
    	return f;
   // 	return "";
     
    }


}