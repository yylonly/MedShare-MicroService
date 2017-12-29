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
        
    	String sql = "SELECT new result.QueryFourListResult(p.gender, COUNT(c.patientID.pid)) " +
    			"FROM Clinicaldetection c, Patient p " +
                        "WHERE c.patientID.pid = p.pid " +
                        "AND c.times = \'1\' " +
                        "AND c.hBsAg = \'0\' " +
                        "AND c.patientID.pid IN ( SELECT cl.patientID.pid FROM Clinicaldetection cl " +
                        "WHERE cl.times = \'3\' " +
                        "AND cl.antiHBs = \'0\' ) " +
                        "GROUP BY p.gender ";
    	return  bean.query(sql);
    }
}