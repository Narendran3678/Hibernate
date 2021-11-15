package entity;

import javax.persistence.*;

@Entity
public class Employee 
{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumns
	(
		{
			@JoinColumn(name="companyId_pk",referencedColumnName = "companyId"),
			@JoinColumn(name="companyName_pk" ,referencedColumnName = "companyName")
		}
	)
	private Employer employer;
	@Column(name="employee_name")
	private String name;
	@Column(name="employee_email")
	private String mailId;
	
	public Employee()
	{
		
	}
	
	public Employee(String name, String mailId) {
		super();
		this.name = name;
		this.mailId = mailId;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employer=" + employer + ", name=" + name + ", mailId=" + mailId + "]";
	}
	
	
}
