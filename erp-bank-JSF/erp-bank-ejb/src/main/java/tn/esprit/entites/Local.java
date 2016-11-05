package tn.esprit.entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the local database table.
 * 
 */
@Entity
@NamedQuery(name="Local.findAll", query="SELECT l FROM Local l")
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String city;
	private String region;
	private String typeLocal;

	public Local() {
	}


	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}


	public String getTypeLocal() {
		return this.typeLocal;
	}

	public void setTypeLocal(String typeLocal) {
		this.typeLocal = typeLocal;
	}


	


}