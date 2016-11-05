package tn.esprit.entites;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: agencies
 *
 */
@Entity

public class agencies implements Serializable {

	private int id;
	private String adress;
	private String name;
	private String email;
	private String num;
	private static final long serialVersionUID = 1L;

	public agencies() {
		super();
	}

	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
   
}
