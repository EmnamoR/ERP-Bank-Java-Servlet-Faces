package tn.esprit.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entites.Employee;

@Local                                                                                                                         
public interface IgestionEmployeeLocal {
	boolean ajouterEmploye (Employee employe) ;
	void supprimerEmploye(Employee employe);
	Employee modifierEmploye(Employee employe);
	List<Employee> findEmployees();
	Employee findEmployee(String user, String pass);
	boolean findEmployeeInventory(String user, String pass);
	boolean findEmployeeFinancial(String user, String pass);
	
	
	public Employee findEmployeeById(int id);
	public List<Employee> EmployeeList();
	Employee findEmployeeByPseudo(String pseudo);
	public void editemployee (Employee e);
	public List<Employee> emplyees(String username);
	public List<Employee> findEmployeeByName(String name);


}
