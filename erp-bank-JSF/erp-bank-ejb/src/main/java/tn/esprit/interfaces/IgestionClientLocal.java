package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entites.Client;

@Local
public interface IgestionClientLocal {

	public void addClient(Client client);
	public Client findClientById(int id);
	public List<Client> findClient();
	public void updateClient(Client client);
	public void deleteClient(Client client);
	public List<Client> findClientByName(String name);
}
