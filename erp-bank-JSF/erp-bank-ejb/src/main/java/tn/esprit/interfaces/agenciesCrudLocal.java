package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entites.agencies;


@Local
public interface agenciesCrudLocal {
	
	public boolean addAgency(agencies agency);
	public void UpdateAgency(agencies agency);
	public void deleteAgency(agencies agency);
	public agencies findAgencyById(int id);
	public List<agencies> findAgencyByName(String name);
	public List<agencies> findAllAgency();
	
	

}