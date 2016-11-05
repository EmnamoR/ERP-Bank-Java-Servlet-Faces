package tn.esprit.bean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.soap.SOAPException;

import tn.esprit.entites.Employee;
import tn.esprit.services.GestionEmployee;

@ManagedBean
@SessionScoped
public class AddEmployeeBean {

	private String email ;
	private String password ;
	private String role;
	private String username;
	private String name;
	private String lastname;

	@EJB
	GestionEmployee employeeService;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String generate(int length)
	{
		    String chars = "ab1cdefg2hijklmnop3qrst4uvwxyz5ABCDE9FGHIJK6LMNOP7QRSTUVW8XYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
		    String pass = "";
		    for(int x=0;x<length;x++)
		    {
		       int i = (int)Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
		       pass += chars.charAt(i);
		    }
		    System.out.println(pass);
		    return pass;
	}

	public String doRegister() throws SOAPException
	{
		Employee e=new Employee();
		e.setEmail(email);
		e.setLastName(lastname);
		e.setName(name);
		e.setPassWord("Erp-bank!111");
		e.setUserName(username);
		e.setRole(role);
		e.setId(generate(36));
		employeeService.ajouterEmploye(e);

		Inscription auth = new Inscription();
		//auth.

		if(auth.getInscription(e.getEmail(), e.getPassWord(),e.getRole()).equalsIgnoreCase("ok"))
			return "/Employee/AddEmployee?faces-redirect=true";
		else
		return null;
	}
}
