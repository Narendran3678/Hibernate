package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
@Entity
public class Citizen 
{
	public Citizen()
	{
		
	}
	
	public Citizen(String name, String country) 
	{
		super();
		this.name = name;
		this.country = country;
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="citizen_name",nullable=false)
	private String name;
	@Column(name="citizen_country",nullable=false)
	private String country;
	
	@OneToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="passport_id",unique = true)
	@MapsId
	private Passport passport;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Citizen [id=" + id + ", name=" + name + ", country=" + country + ", passport=" + passport + "]";
	}
	
}
