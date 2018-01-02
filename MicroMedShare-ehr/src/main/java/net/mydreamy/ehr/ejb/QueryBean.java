package net.mydreamy.ehr.ejb;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import net.mydreamy.ehr.result.DQListResult;

/**
 * Run specific SQL and return XML
 */
@Stateless
@LocalBean

public class QueryBean {

    /**
     * Default constructor. 
     */
    @PersistenceUnit(unitName = "EHR")
    EntityManagerFactory emf;
	
    public QueryBean() {
        // TODO Auto-generated constructor stub
    }
    // Return Country and Total number
    public String query(String sql) {
    	
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
//        System.out.print("list size:" + list.size());
	
        result += "]";
	return result;
    }
}
