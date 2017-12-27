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

/**
 *
 * @author lp
 */
@Stateless
@LocalBean
public class QueryFourBean {
    
     /**
     * Default constructor. 
     */
    @PersistenceUnit(unitName = "EHR")
    EntityManagerFactory emf;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public QueryFourBean(){
        
    }
    
    // Return Diagnoses_Text and  Number
    public String query(String sql)
    {
    	String result = "[";
        Query query =  emf.createEntityManager().createNativeQuery(sql);
	
        @SuppressWarnings("unchecked")
	List<Object[]> list = query.getResultList();
	Object[] aa;
		
        for (int i = 0; i < list.size(); i++){
            aa = list.get(i);
            
            if (aa.length != 2){
                continue;
            }
            result += "{";
            if (i == list.size() - 1){
                result += "\"Gender\":\"" + aa[0] +"\",\"NumberOfPatients\":\"" + aa[1] + "\"}"; 
            }else{
                result += "\"Gender\":\"" + aa[0] +"\",\"NumberOfPatients\":\"" + aa[1] + "\"},"; 
            }
        }
    
        result += "]";
	return result;
    }
}
