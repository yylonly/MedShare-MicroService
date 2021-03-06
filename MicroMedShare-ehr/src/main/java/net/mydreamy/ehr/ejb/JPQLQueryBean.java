package net.mydreamy.ehr.ejb;


import java.lang.reflect.Field;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 * Run specific SQL and return XML
 */
@Stateless
@LocalBean

public class JPQLQueryBean {

    /**
     * Default constructor. 
     */
    @PersistenceUnit(unitName = "EHR")
    EntityManagerFactory emf;
	
    public JPQLQueryBean() {
        // TODO Auto-generated constructor stub
    }
    
//    public String query(String sql)
//    {
//    	String result = "";
//		Query query =  emf.createEntityManager().createNativeQuery(sql);
//		
//		
//		@SuppressWarnings("unchecked")
//		List<Object[]> list = query.getResultList();
//		Object[] aa;
//	//	result += "<tr>";
//		
//	/*	Field[] f = list.get(0).getClass().getDeclaredFields();
//		
//		for (int i = 1; i <= f.length; i++)
//		{
//			result += "<td>" + f[i].getName() + "</td>";
//		}
//		
//		result += "</tr>";*/
//		
//		for (int i = 0; i < list.size(); i++)
//		{
//			result += "<item>";
//			aa = list.get(i);
//			for (int j = 0; j < aa.length; j++)
//			{
//				result += "<element>" + aa[j]  + "</element>";
//			}
//			result += "</item>"; 
//		}		
//		return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +  "<dataset>" +  result + "</dataset>";
//	//	return result;
// }
    public List query(String sql)
    {
        Query query =  emf.createEntityManager().createQuery(sql);
        @SuppressWarnings("unchecked")
	List list = query.getResultList();
        return list;
    }
}
