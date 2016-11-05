package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.City;
import tn.esprit.entites.Employee;
import tn.esprit.interfaces.CityServiceLocal;

/**
 * Session Bean implementation class CityService
 */
@Stateless
@LocalBean
public class CityService implements CityServiceLocal {

    /**
     * Default constructor. 
     */
    public CityService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(name = "city")
	EntityManager entityManager;

	@Override
	public City findCityByName(String cname) {
		
		List<City> cities = entityManager.createQuery("select e from City e").getResultList();
		for (City city : cities) {
			if(city.getName().equalsIgnoreCase(cname))
			{
				return city;
			}
		}
	//	return (City) entityManager.createQuery("select e from City e where e.name=:name",City.class).setParameter("name",cname).getResultList().get(0);
		return null;

	}

	@Override
	public List<City> getallCities() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select e from City e").getResultList();
	}

	@Override
	public void addCity(City c) {
		entityManager.persist(c);
		
	}
	public boolean existecity(String name) {
		boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from City u where u.name=:name";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("name", name);
		exists = (Boolean) query.getSingleResult();
		return exists;

	}
}
