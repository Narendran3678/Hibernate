package entity;

import java.util.*;
import javax.persistence.*;

@Entity
public class Employer 
{
	@EmbeddedId
	private EmployerPK employerPK;
	
	@Column(name="employer_name")
	private String name;
	@Column(name="employer_location")
	private String locaiton;
	
	@OneToMany(mappedBy="employer",cascade= CascadeType.PERSIST)
	private Set<Employee> employeeSet= new HashSet<Employee>();
	
	public Employer()
	{
		
	}
	public Employer(EmployerPK employerPK, String name, String locaiton) {
		super();
		this.employerPK = employerPK;
		this.name = name;
		this.locaiton = locaiton;
	}


	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}

	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocaiton() {
		return locaiton;
	}

	public void setLocaiton(String locaiton) {
		this.locaiton = locaiton;
	}
	public void addEmployee(Employee employee)
	{
		employee.setEmployer(this);
		employeeSet.add(employee);
	}
	@Override
	public String toString() {
		return "Employer [employerPK=" + employerPK + ", name=" + name + ", locaiton=" + locaiton + ", employeeSet="
				+ employeeSet + "]";
	}
	
	
}
