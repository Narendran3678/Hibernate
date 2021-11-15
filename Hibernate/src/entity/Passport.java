package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="passport_number",nullable=false)
	private String passportNumber;
	@Column(name="passport_expiry",nullable=false)
	private String expiryDate;
	/*@OneToOne(mappedBy="passport")
	private Citizen citizen;
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}*/
	public Passport()
	{
		
	}
	public Passport(String passportNumber, String expiryDate) {
		super();
		this.passportNumber = passportNumber;
		this.expiryDate = expiryDate;
	}
	

	
	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + ", expiryDate=" + expiryDate + ", citizen="
				+  "]";
	}
	
	
	
}
