package mangedbean;

import entity.User;
import net.mydreamy.auth.CheckLogin;
import ejb.ListQuerys;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.*;
import javax.servlet.http.HttpServletRequest;


import org.primefaces.context.RequestContext;
import result.ListResult;


@ManagedBean
@SessionScoped
public class LoginBean  
{

    @EJB
    private ListQuerys listQuerys;
    
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //Result of querys
    private List<ListResult> rsquerylist;
    private String domain;
    private boolean loggedIn;
    private ExternalContext externalContext;
    @EJB
    CheckLogin check;
    //SessionBean Queryentires by user
    @EJB
    ListQuerys listquerys;
	  
    @PostConstruct
    public void init() { 
        //init user and query list
	user = new User();
	rsquerylist = new ArrayList<ListResult>();
	externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
	//Get Domain
	HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	domain = origRequest.getRequestURL().toString();
    }
		        
	  
    public void logout(){       
        System.out.println("run logout");
	addMessage("Successful Logout");
	externalContext.invalidateSession();
        //init user and query list
	user = new User();
	rsquerylist = new ArrayList<ListResult>();
	loggedIn = false;
	System.out.println("run finish logout");
    }
	
	
    public void addMessage(String summary) {
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void login() {
        //invoke login session bean to check username and password
	boolean result = check.Check(user.getUsername(), user.getPassword());
	
        //Set Message Display
	RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null; 
        //Login State
        loggedIn = result;        
        //Store session
        // externalContext.getSessionMap().put("LoginState", loggedIn);
        
        if(result == true) {    
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getUsername());  
        } else {   
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid Username or Password");  
        }  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn); 
    }	
	
    //Get Queryentities by user
    public List<ListResult> getRsquerylist() {
        return listquerys.listAll(user, loggedIn);
    }

    public void setRsquerylist(List<ListResult> rsquerylist) {
        this.rsquerylist = rsquerylist;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
	this.domain = domain;
    }
}
