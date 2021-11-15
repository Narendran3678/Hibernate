package entity;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class EmployerPK implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyId;
	private String companyName;
	
	public EmployerPK()
	{
		
	}
	public EmployerPK(String companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}
	
	
	@Override
	public int hashCode() 
	{ 
		return 31* companyId.hashCode() + companyName.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployerPK empPk= (EmployerPK)obj;
		if (!companyId.equals(empPk.companyId)) return false;		
		if (!companyName.equals(empPk.companyName)) return false;
		return true;
	}
	@Override
	public String toString() {
		return "EmployerPK [companyId=" + companyId + ", companyName=" + companyName + "]";
	}
	
	
}
