/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import result.QueryFiveListResult;

/**
 *
 * @author lp
 */
@Stateless
@LocalBean
public class QueryFiveBean {
    
     /**
     * Default constructor. 
     */
    @PersistenceUnit(unitName = "EHR")
    EntityManagerFactory emf;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public QueryFiveBean(){
        
    }
    
    // Return Diagnoses_Text and  Number
    public String query(String sql)
    {
    	String result = "[";
        Query query =  emf.createEntityManager().createQuery(sql);
	
        @SuppressWarnings("unchecked")
	List<QueryFiveListResult> list = query.getResultList();
	
		
        for (int i = 0; i < list.size(); i++){
            QueryFiveListResult item = list.get(i);
            
            if (i == list.size() - 1){
                result += item.toJson();
            }else {
                result += item.toJson() + ",";
            }
        }
        result += "]";
	return result;
    }
}
