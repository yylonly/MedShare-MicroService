package rws;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import ejb.QueryFourBean;

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
     * @return an instance of String
     */
    @GET
    @Produces("application/json")
    public String getHtml() {
        // TODO return proper representation object
    	String sql = "SELECT GENDER, COUNT( PATIENT_ID ) AS NUMBEROFPATIENTS " +
    			"FROM clinicaldetection, patient " +
    			"WHERE clinicaldetection.PATIENT_ID = patient.PID " +
    			"AND TIMES =1 " +
    			"AND HBSAG =0 " +
    			"AND PATIENT_ID " +
    			"IN ( " +
    			"SELECT PATIENT_ID " +
    			"FROM CLINICALDETECTION " + 
    			"WHERE TIMES =3 " +
    			"AND ANTIHBS =0 " +
    			") " +
    			"GROUP BY GENDER ";

    	
    	return  bean.query(sql);
    }
}