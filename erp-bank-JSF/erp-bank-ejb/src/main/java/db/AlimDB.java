package db;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.entites.City;
import tn.esprit.interfaces.CityServiceLocal;
import tn.esprit.services.CityService;
@Singleton
@Startup
public class AlimDB {
	@EJB
	CityServiceLocal citylocal;
	
	public CityServiceLocal getCitylocal() {
		return citylocal;
	}
	public void setCitylocal(CityServiceLocal citylocal) {
		this.citylocal = citylocal;
	}

	public AlimDB()
	{
		
	}
	@PostConstruct
	public void addData() {
		if (!citylocal.existecity("Tunis")) {
		City tunis =new City("Tunis", 10.183333333333334, 36.8333333);
		citylocal.addCity(tunis);}
		if (!citylocal.existecity("Marsa")) {
		City Marsa =new City("Marsa", 10.307579040527344, 36.88840804313823);
		citylocal.addCity(Marsa);}
		if (!citylocal.existecity("Rades")) {
		City rades =new City("Rades", 10.27695894241333, 36.77161743431175);
		citylocal.addCity(rades);}
		
	}
}
