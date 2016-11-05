package tn.esprit.bean;



import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.mail.MessagingException;

import tn.esprit.services.MailService;



@ManagedBean( name = "clientBean" )
@ViewScoped
public class clientBean {

//	@ManagedProperty("#{candidacyBean.email}")
//	private String email;
//	
//    public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
    
   
    public void send(String email) {
        statusMessage = "Message Sent";
        try {
            MailService.sendMessage(email, subject, message);
        }
        catch(MessagingException ex) {
            statusMessage = ex.getMessage();
        }
        //return "index";  // redisplay page with status message
    }
    
    private String recipient;
    private String subject;
    private String message;
    private String statusMessage = "";
    
}