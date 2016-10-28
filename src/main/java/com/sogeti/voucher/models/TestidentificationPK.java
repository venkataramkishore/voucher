package com.sogeti.voucher.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the testidentification database table.
 * 
 */
@Embeddable
public class TestidentificationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="company_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Long companyId;

	@Column(name="employee_id", insertable=false, updatable=false, unique=true, nullable=false)
	private Long employeeId;

	public TestidentificationPK() {
	}
	public Long getCompanyId() {
		return this.companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TestidentificationPK)) {
			return false;
		}
		TestidentificationPK castOther = (TestidentificationPK)other;
		return 
			this.companyId.equals(castOther.companyId)
			&& this.employeeId.equals(castOther.employeeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyId.hashCode();
		hash = hash * prime + this.employeeId.hashCode();
		
		return hash;
	}
}