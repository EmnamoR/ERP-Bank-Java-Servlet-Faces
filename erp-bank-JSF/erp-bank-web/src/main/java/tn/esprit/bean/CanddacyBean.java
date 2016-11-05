package tn.esprit.bean;
import java.awt.image.BandedSampleModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

import tn.esprit.entites.Candidature;
import tn.esprit.entites.City;
import tn.esprit.services.CityService;
import tn.esprit.services.GestionCandidature;

@ManagedBean(name = "candidacyBean")
@ApplicationScoped
public class CanddacyBean {
	
	
	
	@EJB
	GestionCandidature candidatureService;
	@EJB
	CityService mapService;
	private List<Candidature> candidatures;
	private List<City> cities;
	private Candidature selected;
	private List<String> names;
	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String State;
	private UploadedFile file;
	private String locationDep ;
	private String locationArr;
//	 RequestContext requestContext = RequestContext.getCurrentInstance();  
//	  requestContext.execute("document.drawRoad("+airDep.getLatitude()+","+airDep.getLongitude()+","+airArr.getLatitude()+","+airArr.getLongitude()+")");
//	
	  public String doShowDetails(Candidature c) {
			
selected=c;			
			return "/candidacy/sendAppointment?faces-redirect=true";
			
		}

	public String addCandidacy() {
		Candidature candidat = new Candidature();

		candidat.setEmail(email);
		candidat.setLastName(lastName);
		candidat.setName(firstName);
		candidat.setRole(role);
		candidat.setState(State);
		
		String filename = FilenameUtils.getName(file.getFileName());
	    InputStream input = null;
	    OutputStream output  = null;
	    try {
			input = file.getInputstream();
			 output = new FileOutputStream(new File("D:/IDE/WorkSpaceJSF/erp-bank/erp-bank-web/src/main/webapp/assets/files", filename));
			IOUtils.copy(input, output);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}finally{
			 IOUtils.closeQuietly(input);
		        IOUtils.closeQuietly(output);
		}
	   

		
		candidat.setCv(file.getFileName());
	candidatureService.addCandidacy(candidat);
		
		
	
        if(file != null) {
           FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
       }
        return "";
	}

	


	

	
	public List<Candidature> getCandidatures() {
		return candidatures;
	}







	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}







	public String getFirstName() {
		return firstName;
	}







	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}







	public String getLastName() {
		return lastName;
	}







	public void setLastName(String lastName) {
		this.lastName = lastName;
	}







	public String getEmail() {
		return email;
	}







	public void setEmail(String email) {
		this.email = email;
	}







	public String getRole() {
		return role;
	}







	public void setRole(String role) {
		this.role = role;
	}







	public String getState() {
		return State;
	}







	public void setState(String state) {
		State = state;
	}







	public UploadedFile getFile() {
		return file;
	}







	public void setFile(UploadedFile file) {
		this.file = file;
	}







	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@PostConstruct
	private void init() {
		cities = mapService.getallCities();
		names = new ArrayList<String>();
		for (City city : cities) {
			names.add(city.getName());
		}
		candidatures =candidatureService.candidates();
	}

	public Candidature getSelected() {
		return selected;
	}

	public void setSelected(Candidature selected) {
		this.selected = selected;
	}

	public String getLocationDep() {
		return locationDep;
	}

	public void setLocationDep(String locationDep) {
		this.locationDep = locationDep;
	}

	public String getLocationArr() {
		return locationArr;
	}

	public void setLocationArr(String locationArr) {
		this.locationArr = locationArr;
	}
	
	public void save() {
//		  RequestContext requestContext = RequestContext.getCurrentInstance();  
//		  requestContext.execute("document.drawRoad("+locationDep.getLatitude()+","+airDep.getLongitude()+","+airArr.getLatitude()+","+airArr.getLongitude()+")");
		
		//mapService.getallCities();
		City bankDep = mapService.findCityByName(locationDep);
		City bankArr = mapService.findCityByName(locationArr);
		
		if(mapService.findCityByName(locationDep)== null)
		{
			System.out.println("hello");
			
		}
		if(bankArr==null || bankDep==null)
		{
			System.out.println("null");
		}
		if((bankDep!=null) && (bankArr!=null))
		{
		  RequestContext requestContext = RequestContext.getCurrentInstance();  
		  requestContext.execute("document.drawRoad("+bankDep.getLattitude()+","+bankDep.getLongitude()+","+bankArr.getLattitude()+","+bankArr.getLongitude()+")");
		}
		else 
			System.out.println("noooooooooooooooooooooooooooooo");
		  
		}
	}

