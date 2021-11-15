package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="organization")
public class Organization 
{
	//ID, COMPANY_NAME, YEARS_OF_INCORPORATION, POSTAL_CODE, EMPLOYEE_COUNT, SLOGAN
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="YEARS_OF_INCORPORATION")
	private int yearOfIncorporation;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="EMPLOYEE_COUNT")
	private int employeeCount;
	
	@Column(name="SLOGAN")
	private String slogan;
	
	@Enumerated(EnumType.STRING)
	private CompanyType companyType;
	
	public Organization()
	{
		
	}
	
	public Organization(String companyName, int yearOfIncorporation, String postalCode, int employeeCount,
			String slogan, CompanyType companyType) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		this.postalCode = postalCode;
		this.employeeCount = employeeCount;
		this.slogan = slogan;
		this.companyType = companyType;
	}

	
	public int getId() {
		return id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getYearOfIncorporation() {
		return yearOfIncorporation;
	}
	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", companyName=" + companyName + ", yearOfIncorporation="
				+ yearOfIncorporation + ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan="
				+ slogan + ", companyType=" + companyType + "]";
	}
	
}
