/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mydreamy.med.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import net.mydreamy.med.result.QuerySevenListResult;

/**
 *
 * @author lp
 */
@Stateless
@LocalBean
public class QuerySevenBean {
    
     /**
     * Default constructor. 
     */
    @PersistenceUnit(unitName = "EHR")
    EntityManagerFactory emf;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public QuerySevenBean(){
        
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
