package tn.esprit.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.services.GestionEmployee;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String login=null;
	private String pwd;
	private boolean loggedIn=false; 
	
	@EJB
	GestionEmployee ges;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public GestionEmployee getGes() {
		return ges;
	}
	public void setGes(GestionEmployee ges) {
		this.ges = ges;
	}
	public String doLogin()
	{
		String mosh=null;
		
		if(ges.findEmployee(login, pwd) != null)
		{

			
				
				if (ges.findEmployee(login, pwd).getRole().equals("HR Manager")) {
					
					loggedIn = true;
					mosh= "/Employee/test?faces-redirect=true";
				}
				if (ges.findEmployee(login, pwd).getRole().equals("Inventory Manager")) {
					
					loggedIn = true;
					mosh= "/customerAgencies/customerAgency?faces-redirect=true";
				}
				if (ges.findEmployee(login, pwd).getRole().equals("Financial Manager"))
				{
					loggedIn =true;
					mosh= "finance/ClientCrud?faces-redirect=true";
				}
			
			
		}
		else { 
			login=null;
			loggedIn=false;
			return "erreur?faces-redirect=true";}
		
		return mosh;
	}
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		loggedIn= false;
		return "/index?faces-redirect=true";
	}

}
