/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
public class QueryThreeBean {
    
     /**
     * Default constructor. 
     */
    @PersistenceUnit(unitName = "EHR")
    EntityManagerFactory emf;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public QueryThreeBean(){
        
    }
    
    // Return Diagnoses_Text and  Number
    public long query(String sql)
    {
        Query query =  emf.createEntityManager().createQuery(sql);

        @SuppressWarnings("unchecked")
	long number = (long) query.getSingleResult();
	return number;
    }
}
