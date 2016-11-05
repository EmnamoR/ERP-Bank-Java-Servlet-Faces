package tn.esprit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.entites.agencies;
import tn.esprit.interfaces.agenciesCrudLocal;

@ManagedBean
@RequestScoped
public class agenciesManagement {
	
	@EJB
	agenciesCrudLocal agencyService;
	
	private List<agencies> agencies;
	private agencies agency=new agencies();
	private boolean showForm = false;
	private Boolean dispTable = false;
	private String name;
	private int id;
	private boolean edit;
	private String searchh;
	
	
	
	
	
	
	public String getSearchh() {
		return searchh;
	}
	public void setSearchh(String searchh) {
		this.searchh = searchh;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
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
	public Boolean getDispTable() {
		return dispTable;
	}
	public void setDispTable(Boolean dispTable) {
		this.dispTable = dispTable;
	}
	public List<agencies> getAgencies() {
		return agencies;
	}
	public void setAgencies(List<agencies> agencies) {
		this.agencies = agencies;
	}
	public agencies getAgency() {
		return agency;
	}
	public void setAgency(agencies agency) {
		this.agency = agency;
	}
	public boolean isShowForm() {
		return showForm;
	}
	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}
	@PostConstruct
	private void init() {
		agencies =agencyService.findAllAgency();
	}
		
	
	public void doDisplayTable() {
		dispTable = true;
	}
	public String doCreateAgency() {
		
		if(agency.getId() != 0)
    	{
			agencyService.UpdateAgency(agency);
			init();
			agency=new agencies();
    	}
		else
		{
			
		agencyService.addAgency(agency);
		init();
		agency=new agencies();
		dispTable = false;
		}
		return "";
	}
	public void edit(agencies item) {
		
    	
        this.agency = item;
        edit = true;
    }
	
	public String doDeleteAgency() {
		agencyService.deleteAgency(agency);
		init();
		agency=new agencies();
		return "";
	}
	public String doFindAgencyByName() {
		agencies=agencyService.findAgencyByName(searchh);
		return "";
	}
	public String doUpdateAgency(){
		agencyService.UpdateAgency(agency);
		return "";
	}
	public String doFindAgencyById(){
		agencyService.findAgencyById(id);
		return"";
	}
	
	
	}

