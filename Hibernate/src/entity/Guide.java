package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	@Column(name="staff_id",nullable=false)
	private String staffId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="salary")
	private Integer salary;
	
	@OneToMany(mappedBy="guide",cascade= {CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Set<Student> studentSet= new HashSet<Student>();
	
	public Guide()
	{
		
	}
	public Guide(String staffId, String name, Integer salary) {
		super();
		this.staffId = staffId;
		this.name = name;
		this.salary = salary;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Set<Student> getStudentSet() {
		return studentSet;
	}
	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}
	public void addStudent(Student student)
	{
		student.setGuide(this);
		studentSet.add(student);
	}
	
	@Override
	public String toString() {
		return "Guide [id=" + id + ", staffId=" + staffId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
