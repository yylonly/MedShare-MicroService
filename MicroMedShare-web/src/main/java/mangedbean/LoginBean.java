package mangedbean;

import net.mydreamy.auth.entity.User;
import net.mydreamy.auth.CheckLogin;
import net.mydreamy.auth.ejb.ListQuerys;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.*;
import javax.servlet.http.HttpServletRequest;


import org.primefaces.context.RequestContext;
import net.mydreamy.auth.result.ListResult;


@ManagedBean
@SessionScoped
public class LoginBean  
{
    

    @EJB
    private ListQuerys listQuerys;
    
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
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
        token = "";
	System.out.println("run finish logout");
    }
	
	
    public void addMessage(String summary) {
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void login() {
        //invoke login session bean to check username and password
	Map<String, String> result = check.Check(user.getUsername(), user.getPassword());
	
        //Set Message Display
	RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null; 
        //Login State
        if (result.get("isVaild") == "True"){
            loggedIn = true;
        }else {
            loggedIn = false;     
        }
        token = result.get("token");
        System.out.print("isValid:" + result.get("isVaild"));
        System.out.print("token:" + result.get("token"));
        //Store session
        // externalContext.getSessionMap().put("LoginState", loggedIn);
        
        if(loggedIn == true) {    
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getUsername());  
        } else {   
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid Username or Password");  
        }  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("token", token);
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
