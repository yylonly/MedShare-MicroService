package net.mydreamy.ehr.rws;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import net.mydreamy.ehr.ejb.QueryBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import net.mydreamy.ehr.result.ListResult;

@Stateless
@Path("dq")
public class DQ {
	
    @Context
    private UriInfo context;
    @EJB 
    QueryBean bean;
    
    @PersistenceUnit(unitName = "EHR")
    EntityManagerFactory emf;	

    /**
     * Default constructor. 
     */
    public DQ() {
        // TODO Auto-generated constructor stub
    }

//    /**
//     * Retrieves representation of an instance of QueryOne
//     * @return an instance of String
//     */
//    @GET 
//    @Produces("application/json")
//    public String getHtml(@QueryParam("startdate") String startdate, @QueryParam("enddate") String enddate) {
//        // TODO return proper representation object
//    	
//    	String sql = "select Country, COUNT(Report_ID ) AS TotalNum " +
//			"FROM examination, patient " + 
//			"WHERE examination.Patient_ID = patient.PID " +
//			"AND Endoscopy_Date " +
//			"BETWEEN '" + startdate + "' " + 
//			"AND '" + enddate + "' " + 
//			"GROUP BY Country   " +
//			"Order By TotalNum desc ";
//    	System.out.println(sql);
//    
//    	String f =  bean.query(sql);
//    	return f;
//   // 	return "";
//     
//    }

     /**
     * Retrieves representation of an instance of QueryOne
     * @return an instance of String
     */
    @GET 
    @Produces("application/json")
    public String getHtml(@QueryParam("startdate") String startdate, @QueryParam("enddate") String enddate) {
        // TODO return proper representation object
        //Run Query :name is vaibiles, result is a list type of ListResult
        String sql = "SELECT new net.mydreamy.ehr.result.DQListResult(p.country,  COUNT(e.reportID))"
                + "FROM Examination e, Patient p"
                + "WHERE e.patientID = p.pid"
                + "AND e.endoscopyDate BETWEEN :startdate AND :enddate"
                + "GROUP BY p.country"
                + "ORDER BY COUNT(e.reportID) DESC";
        Query query =  emf.createEntityManager().createNativeQuery(sql);
        
        List<ListResult> result = query.getResultList();
        System.out.print("result size:" + result.size());
	return ""; 
    }
}