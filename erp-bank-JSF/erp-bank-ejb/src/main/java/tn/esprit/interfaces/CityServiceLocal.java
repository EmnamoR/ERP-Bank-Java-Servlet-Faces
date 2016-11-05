package tn.esprit.interfaces;

import java.awt.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entites.City;

@Local
public interface CityServiceLocal {
	
	
	
	
	public City findCityByName(String name);
	public java.util.List<City> getallCities();
public void addCity(City c);
public boolean existecity(String name);
}
