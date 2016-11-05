package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.Candidature;
import tn.esprit.interfaces.IgestionCandidatureLocal;

/**
 * Session Bean implementation class IgestionCandidature
 */
@Stateless
@LocalBean
public class GestionCandidature implements  IgestionCandidatureLocal {
	@PersistenceContext(name="gestioncandidate")
	EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public GestionCandidature() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Candidature> candidates() {

		Query query= entityManager.createQuery("select e from Candidature e");
		return query.getResultList();
	}

	@Override
	public boolean addCandidacy(Candidature c) {
		entityManager.persist(c);
		return false;
	}

	@Override
	public Candidature findCandidatureById(int id) {
		return entityManager.find(Candidature.class, id);
	}

	@Override
	public void removeCandidature(Candidature candidature) {
		entityManager.remove(entityManager.merge(candidature));
		
	}

}
