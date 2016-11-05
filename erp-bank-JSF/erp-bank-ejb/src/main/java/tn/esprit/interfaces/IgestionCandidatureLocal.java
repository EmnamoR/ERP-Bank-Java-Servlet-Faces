package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entites.Candidature;

@Local
public interface IgestionCandidatureLocal {
	 List<Candidature> candidates();
	boolean addCandidacy(Candidature c);
	Candidature findCandidatureById(int id);
	public void removeCandidature(Candidature candidature);
}
