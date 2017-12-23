package rws;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import ejb.QueryBean;

@Path("querythree")
public class QueryThree {

    @Context
    private UriInfo context;
    @EJB 
    QueryBean bean;
    /** 
     * Default constructor. 
     */
    public QueryThree() {
        // TODO Auto-generated constructor stub
    } 

    /**
     * Retrieves representation of an instance of QueryThere
     * @return an instance of String
     */
    @GET
    @Produces("application/xml")
    public String getHtml() {
        // TODO return proper representation object
    	String sql = "SELECT * " +
    			"FROM ( " + 
    			" SELECT DISTINCT COUNT( PID ) AS NumBelow18 " +
    			" FROM patient, examination " +
    			"WHERE patient.PID = examination.Patient_ID " +
    			"AND YEAR( CURRENT_DATE( ) ) - YEAR( DoB ) <18 " +
    			") AS NumBelow18, ( " +
    			
    			"SELECT DISTINCT COUNT( PID ) AS Num18to40 " +		
    			"FROM patient, examination " +   			
    			"WHERE patient.PID = examination.Patient_ID " +
    			"AND YEAR( CURRENT_DATE( ) ) - YEAR( DoB )  " +		
    			"BETWEEN 18 " +
    			"AND 40 " +
    			" ) AS Num18to40, ( " +
    			
    			"SELECT DISTINCT COUNT( PID ) AS Num40to60 " +
			    "FROM patient, examination "+
			    "WHERE patient.PID = examination.Patient_ID "+
			    "AND YEAR( CURRENT_DATE( ) ) - YEAR( DoB ) " + 
			    "BETWEEN 40 " + 
			    "AND 60 " +
			    ") AS Num40to60, ( " +
			   
    			"SELECT DISTINCT COUNT( PID ) AS NumAbove60 " +
			    "FROM patient, examination " +
			    "WHERE patient.PID = examination.Patient_ID " +
			    "AND YEAR( CURRENT_DATE( ) ) - YEAR( DoB ) >60 " +
			    ") AS NumAbove60 ";
    	return bean.query(sql);
    }
    
     
    

   
   
    
    
    

    
   
    
   
    

    


}