package tn.esprit.bean;


import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import tn.esprit.entites.*;
import tn.esprit.interfaces.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

@RequestScoped
@ManagedBean
public class GestionClientBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	IgestionClientLocal local;
	
	private List<Client> clients = new ArrayList<Client>();
	private Client client=new Client();
	private Client beforeEditItem = null;
    private boolean edit;
    private String sea;
    private Date date4;
    private Date date5;

	public String getSea() {
		return sea;
	}


	public void setSea(String sea) {
		this.sea = sea;
	}


	@PostConstruct
	public void init(){
		clients=local.findClient();
		client.setRole("Client");
		
	}
	

	public Date getDate5() {
		return date5;
	}


	public void setDate5(Date date5) {
		this.date5 = date5;
	}


	public Date getDate4() {
		return date4;
	}


	public void setDate4(Date date4) {
		this.date4 = date4;
	}


	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	

	   public Client getBeforeEditItem() {
		return beforeEditItem;
	}


	public void setBeforeEditItem(Client beforeEditItem) {
		this.beforeEditItem = beforeEditItem;
	}


	public boolean isEdit() {
		return edit;
	}


	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	
	public String doUpdate(){
		return null;
	}
	public String doDelete(){
		return null;
	}
	
	
	 public void add() {
	
		 client.setRole("Client");
		 local.addClient(client);
		 init();
	    }
	    
	    public void resetAdd() {
	       // item = new Student();
	    }
	    
	    public void edit(Client item) {
	
	    	 this.client = item;
	    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date4 = format.parse(item.getBirthDate());
				date5 = format.parse(item.getRegistrationDate());
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	       
	        edit = true;
	    }
	    
	    public void cancelEdit() {
	   
	        this.client = new Client();
	        edit = false;
	    }
	    
	    public void doEdit() {
	    	try{
	    	if(client.getId() != 0)
	    	{
	    		client.setRole("Client");
	    		java.text.SimpleDateFormat sdf = 
	    			     new java.text.SimpleDateFormat("yyyy-MM-dd");

	    			String currentTime = sdf.format(date4);
	    			String currentTime2 = sdf.format(date5);
	    		
	    			client.setBirthDate(currentTime);
		    		client.setRegistrationDate(currentTime2);
	    			
		    	local.updateClient(client);
                init();
                client = new Client();
	    	}
	    	else
	    	{
	    		java.text.SimpleDateFormat sdf = 
	    			     new java.text.SimpleDateFormat("yyyy-MM-dd");

	    			String currentTime = sdf.format(date4);
	    			String currentTime2 = sdf.format(date5);
	               
	    		client.setBirthDate(currentTime);
	    		client.setRegistrationDate(currentTime2);
	    		local.addClient(client);
	    		init();
	    		client = new Client();
	    	}
	    	}catch(Exception e){init(); client=new Client();}
	    	
	    	date4=null;
	    	date5=null;
	    }
	    
	    public void delete(Client item) throws IOException {
	       local.deleteClient(item);
	    	init();
	    }
	  
	    
public void search()
{
 clients=	local.findClientByName(sea);
}

public void onDateSelect(SelectEvent event) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
}

}
