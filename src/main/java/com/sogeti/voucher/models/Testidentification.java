package com.sogeti.voucher.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the testidentification database table.
 * 
 */
@Entity
@Table(name="testidentification")
@NamedQuery(name="Testidentification.findAll", query="SELECT t FROM Testidentification t")
public class Testidentification implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TestidentificationPK id;

	@Column(nullable=false, length=20)
	private String testingid;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id", nullable=false, insertable=false, updatable=false)
	private Company company;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id", nullable=false, insertable=false, updatable=false)
	private Employee employee;

	public Testidentification() {
	}

	public TestidentificationPK getId() {
		return this.id;
	}

	public void setId(TestidentificationPK id) {
		this.id = id;
	}

	public String getTestingid() {
		return this.testingid;
	}

	public void setTestingid(String testingid) {
		this.testingid = testingid;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}