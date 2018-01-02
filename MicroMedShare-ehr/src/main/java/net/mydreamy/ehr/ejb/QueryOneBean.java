/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mydreamy.ehr.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import net.mydreamy.ehr.result.DQListResult;


/**
 *
 * @author lp
 */
@Stateless
@LocalBean
public class QueryOneBean {
    
    /**
     * Default constructor. 
     */
    @PersistenceUnit(unitName = "EHR")
    EntityManagerFactory emf;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public QueryOneBean(){
        
    }
    
    // Return Country and Total number
       public String query(String sql)
    {
    	
        Query query =  emf.createEntityManager().createQuery(sql);
        String result = "[";
        @SuppressWarnings("unchecked")
	List<DQListResult> list = query.getResultList();
        for(int i = 0; i < list.size(); i++){
            DQListResult item = list.get(i);
            
            if (i == list.size() - 1){
                result += item.toJson();
            }else {
                result += item.toJson() + ",";
            }
        }	
        result += "]";
	return result;
    }
    
//    // Return Country and Total number
//    public String query(String sql)
//    {
//    	String result = "[";
//        Query query =  emf.createEntityManager().createNativeQuery(sql);
//	
//        @SuppressWarnings("unchecked")
//	List<Object[]> list = query.getResultList();
//	Object[] aa;
//		
//        for (int i = 0; i < list.size(); i++){
//            aa = list.get(i);
//            if (aa.length != 2){
//                continue;
//            }
//            result += "{";
//            if (i == list.size() - 1){
//                result += "\"Country\":\"" + aa[0] +"\",\"TotalNumber\":\"" + aa[1] + "\"}"; 
//            }else{
//                result += "\"Country\":\"" + aa[0] +"\",\"TotalNumber\":\"" + aa[1] + "\"},"; 
//            }
//        }
//        result += "]";
//	return result;
//    }
}
