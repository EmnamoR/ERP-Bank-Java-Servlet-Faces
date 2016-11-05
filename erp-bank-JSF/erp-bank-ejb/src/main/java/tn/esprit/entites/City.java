package tn.esprit.entites;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: City
 *
 */
@Entity
public class City implements Serializable {

	
	private int id;
	private String name;
	private double longitude;
	private double lattitude;
	private static final long serialVersionUID = 1L;

	public City() {
		super();
	}   
	
	public City(String name, double longitude, double lattitude) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.lattitude = lattitude;
	}

	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	@Column(nullable = false, precision = 22, scale = 0)
	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}   
	@Column(nullable = false, precision = 22, scale = 0)
	public double getLattitude() {
		return this.lattitude;
	}

	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
   
}
