package rws;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import ejb.QueryOneBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;


@Path("queryone")
public class QueryOne {
	
    @Context
    private UriInfo context;
    
    @EJB
    QueryOneBean bean;

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
    @Produces("application/json")
    public String getHtml() {
        // TODO return proper representation object
//        String sql = "SELECT new result.DQListResult(p.country,  1) "
//                + "FROM Patient p ";
         
        String sql = "SELECT new result.DQListResult(p.country,  COUNT(e.reportID)) "
            + "FROM Examination e, Patient p "
            + "WHERE e.patientID.pid = p.pid "
            + "AND e.endoscopyDate BETWEEN \'2010-1-1\' AND \'2010-12-30\' "
            + "GROUP BY p.country "
            + "ORDER BY COUNT(e.reportID) DESC";
        System.out.print(sql);
        String list = bean.query(sql);
//        System.out.print("result size:" + list.size());
//        System.out.print(sql);
//        Query query =  emf.createEntityManager().createQuery(sql);
        
//        List<DQListResult> result = query.getResultList();
//        System.out.print("result size:" + result.size());
//        
//        return "";
    	 
//    	String sql = "select Country, COUNT(Report_ID ) AS TotalNum " +
//			"FROM examination, patient " + 
//			"WHERE examination.Patient_ID = patient.PID " +
//			"AND Endoscopy_Date " +
//			"BETWEEN \'2010-1-1\' " +
//			"AND \'2010-12-30\' " +
//			"GROUP BY Country   " +
//			"Order By TotalNum desc ";
//    	return bean.query(sql);
        return list;
    }

    public void persist(Object object) {
        /* Add this to the deployment descriptor of this module (e.g. web.xml, ejb-jar.xml):
         * <persistence-context-ref>
         * <persistence-context-ref-name>persistence/LogicalName</persistence-context-ref-name>
         * <persistence-unit-name>EHR</persistence-unit-name>
         * </persistence-context-ref>
         * <resource-ref>
         * <res-ref-name>UserTransaction</res-ref-name>
         * <res-type>javax.transaction.UserTransaction</res-type>
         * <res-auth>Container</res-auth>
         * </resource-ref> */
        try {
            javax.naming.Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("java:comp/env/persistence/LogicalName");
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}