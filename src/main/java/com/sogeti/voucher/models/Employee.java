package com.sogeti.voucher.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	private String emailname;

	@Column(nullable=false, length=100)
	private String firstname;

	@Column(nullable=false, length=100)
	private String functiondescription;

	@Column(nullable=false, length=3)
	private String functionnumber;

	@Column(nullable=false, length=100)
	private String lastname;

	private Long managerid;

	@Column(nullable=false, length=255)
	private String role;

	@Column(nullable=false, length=255)
	private String status;

	@Column(length=10)
	private String tussenvoegsel;

	@Column(nullable=false, length=20)
	private String username;

	//bi-directional many-to-one association to Company
	@JsonIgnore
	@OneToMany(mappedBy="employee")
	private List<Company> companies;

	//bi-directional many-to-one association to Exam
	@JsonIgnore
	@OneToMany(mappedBy="employee")
	private List<Exam> exams;

	//bi-directional many-to-one association to Testidentification
	@JsonIgnore
	@OneToMany(mappedBy="employee")
	private List<Testidentification> testidentifications;

	public Employee() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailname() {
		return this.emailname;
	}

	public void setEmailname(String emailname) {
		this.emailname = emailname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFunctiondescription() {
		return this.functiondescription;
	}

	public void setFunctiondescription(String functiondescription) {
		this.functiondescription = functiondescription;
	}

	public String getFunctionnumber() {
		return this.functionnumber;
	}

	public void setFunctionnumber(String functionnumber) {
		this.functionnumber = functionnumber;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getManagerid() {
		return this.managerid;
	}

	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTussenvoegsel() {
		return this.tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setEmployee(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setEmployee(null);

		return company;
	}

	public List<Exam> getExams() {
		return this.exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Exam addExam(Exam exam) {
		getExams().add(exam);
		exam.setEmployee(this);

		return exam;
	}

	public Exam removeExam(Exam exam) {
		getExams().remove(exam);
		exam.setEmployee(null);

		return exam;
	}

	public List<Testidentification> getTestidentifications() {
		return this.testidentifications;
	}

	public void setTestidentifications(List<Testidentification> testidentifications) {
		this.testidentifications = testidentifications;
	}

	public Testidentification addTestidentification(Testidentification testidentification) {
		getTestidentifications().add(testidentification);
		testidentification.setEmployee(this);

		return testidentification;
	}

	public Testidentification removeTestidentification(Testidentification testidentification) {
		getTestidentifications().remove(testidentification);
		testidentification.setEmployee(null);

		return testidentification;
	}

}