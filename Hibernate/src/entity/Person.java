package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="person_name")
	private String name;
	
	@Column(name="person_contact_no")
	private String contactNo;
	
	@Embedded
	@AttributeOverrides
	({
	       @AttributeOverride(name="street",column=@Column(name="perm_street",nullable=false)),
	       @AttributeOverride(name="city",column=@Column(name="perm_city",nullable=false)),
	       @AttributeOverride(name="zipCode",column=@Column(name="perm_zipcode",nullable=false))
	})
	private Address address;
	public Person(String name, String contactNo, Address address) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", address=" + address + "]";
	}
	
	
}
