package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.agencies;
import tn.esprit.interfaces.agenciesCrudLocal;

/**
 * Session Bean implementation class agenciesCrud
 */
@Stateless
@LocalBean
public class agenciesCrud implements agenciesCrudLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(name = "ERP-Bank-JSF-ejb")
	EntityManager em;
    public agenciesCrud() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addAgency(agencies agency) {
		try{
			em.persist(agency);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public void UpdateAgency(agencies agency) {
		em.merge(agency);
		
	}

	@Override
	public void deleteAgency(agencies agency) {
		em.remove(em.merge(agency));
	}


	@Override
	public agencies findAgencyById(int id) {
		return em.find(agencies.class, id);
	}

	@Override
	public List<agencies> findAgencyByName(String name) {
		name = name+"%";
		String jpql = "select a from agencies a where a.name like :name";
		Query query = em.createQuery(jpql);
		return  query.setParameter("name", name).getResultList();
	}


	@Override
	public List<agencies> findAllAgency() {
		Query query = em.createQuery("select a from agencies a");
		return query.getResultList();
	}

}
