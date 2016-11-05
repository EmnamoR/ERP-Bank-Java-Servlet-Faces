package tn.esprit.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tn.esprit.entites.Employee;
import tn.esprit.interfaces.IgestionEmployeeLocal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@ManagedBean
public class testBean {

	@EJB
	IgestionEmployeeLocal local;

	private List<Employee> employees = new ArrayList<Employee>();
	private Employee employee = new Employee();
	private Employee beforeEditItem = null;
	private boolean edit;
	private String sea;
	 private String password2; 

	@PostConstruct
	public void init() {
		employees = local.EmployeeList();

	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void doEdit() {
		
		if (employee.getId() != null) {
			local.modifierEmploye(employee);
			init();
			employee = new Employee();
		} else {
			local.ajouterEmploye(employee);
			init();
			employee = new Employee();
		}
		

	}

	public void cancelEdit() {
		this.employee = new Employee();
		employee = new Employee();
		edit = false;
	}

	public void delete(Employee item) throws IOException {
		local.supprimerEmploye(item);
		init();
	}

	public void Edit(Employee item) {
		this.employee = item;
	}

	public String getSea() {
		return sea;
	}

	public void setSea(String sea) {
		this.sea = sea;
	}

	public void search() {
		employees = local.findEmployeeByName(sea);
	}
	public String getPassword2() {
        return password2;
    }
 
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
