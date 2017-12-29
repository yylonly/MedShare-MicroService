package rws;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import ejb.QueryThreeBean;
import result.NumberOfAge;

@Path("querythree")
public class QueryThree {

    @Context
    private UriInfo context;
    @EJB 
    QueryThreeBean bean;
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
    @Produces("application/json")
    public String getHtml() {
        // TODO return proper representation object

        String numBelow18SQL = "SELECT COUNT( p.pid) "
                + "FROM Patient p, Examination e "
                + "WHERE e.patientID.pid = p.pid "
                + "AND FUNC('YEAR', CURRENT_DATE) - FUNC('YEAR', p.doB) < 18";
        long numBelow18 = bean.query(numBelow18SQL);
        
        String num18to40SQL = "SELECT COUNT( p.pid) "
                + "FROM Patient p, Examination e "
                + "WHERE e.patientID.pid = p.pid "
                + "AND FUNC('YEAR', CURRENT_DATE) - FUNC('YEAR', p.doB) "
                + "BETWEEN 18 "
                + "AND 40 ";
        long num18to40 = bean.query(num18to40SQL);
        
        String num40to60SQL = "SELECT COUNT( p.pid) "
                + "FROM Patient p, Examination e "
                + "WHERE e.patientID.pid = p.pid "
                + "AND FUNC('YEAR', CURRENT_DATE) - FUNC('YEAR', p.doB) "
                + "BETWEEN 40 "
                + "AND 60 ";
        long num40to60 = bean.query(num40to60SQL);
        
        String numAbove60SQL = "SELECT COUNT( p.pid) "
                + "FROM Patient p, Examination e "
                + "WHERE e.patientID.pid = p.pid "
                + "AND FUNC('YEAR', CURRENT_DATE) - FUNC('YEAR', p.doB) > 60";
        long numAbove60 = bean.query(numAbove60SQL);
        
        NumberOfAge numberOfAge = new NumberOfAge(numBelow18, num18to40, num40to60, numAbove60);
  
        return numberOfAge.toJson();
    }
    
     
    

   
   
    
    
    

    
   
    
   
    

    


}