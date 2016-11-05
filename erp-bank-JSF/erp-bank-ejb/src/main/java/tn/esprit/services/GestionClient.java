package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entites.Client;
import tn.esprit.interfaces.IgestionClientLocal;

@Stateless
@LocalBean
public class GestionClient implements IgestionClientLocal{

	@PersistenceContext(name="gestionemploye")
	EntityManager entityManager;

	 public GestionClient() {
	        // TODO Auto-generated constructor stub
	    }

	@Override
	public void addClient(Client client) {

		entityManager.persist(client);

	}

	@Override
	public List<Client> findClient(){
				String jpql = "select c from Client c";
				Query query = entityManager.createQuery(jpql);
				System.out.print(query.getResultList().toString());
				return query.getResultList();
			}

	@Override
	public Client findClientById(int id) {
		String jpql = "select c from Client c where c.id = :id ";
		Query query = entityManager.createQuery(jpql);
		return (Client) query.setParameter("id", id).getSingleResult();
	}

	@Override
	public void updateClient(Client client) {

        entityManager.merge(client);

	}

	@Override
	public void deleteClient(Client client) {
		entityManager.remove(entityManager.contains(client) ? client : entityManager.merge(client));
	///	entityManager.remove(entityManager.merge(client));
	}

	@Override
	public List<Client> findClientByName(String name) {
		name = name+"%";
		String jpql = "select c from Client c where c.name like :name";
		Query query = entityManager.createQuery(jpql);
		return  query.setParameter("name", name).getResultList();
	}
}
