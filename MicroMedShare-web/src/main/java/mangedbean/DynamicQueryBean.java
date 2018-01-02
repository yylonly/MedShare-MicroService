package mangedbean;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.*;
import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class DynamicQueryBean  
{
    private Date startdate;
    private Date enddate;   
    private String URL; 
       
    
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
        
        URL = "http://127.0.0.1:8080/MicroMedShare-web/rws/dq?startdate=" + new SimpleDateFormat("yyyy-MM-dd").format(startdate) + "&enddate=" + new SimpleDateFormat("yyyy-MM-dd").format(enddate);
    } 
	
    public void endDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
        
        //finished URL
        URL = "http://127.0.0.1:8080/MicroMedShare-web/rws/dq?startdate=" + new SimpleDateFormat("yyyy-MM-dd").format(startdate) + "&enddate=" + new SimpleDateFormat("yyyy-MM-dd").format(enddate);
    } 
	   
    public void dynamicQuery() {
	//Get Domain
	FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dynamic Query URL", URL));
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
	this.startdate = startdate;
    }

    public Date getEnddate() {
	return enddate;
    }

    public void setEnddate(Date enddate) {
	this.enddate = enddate;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }
}
