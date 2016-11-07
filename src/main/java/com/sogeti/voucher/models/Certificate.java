package com.sogeti.voucher.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the certificate database table.
 * 
 */
@Entity
@Table(name="certificate")
@NamedQuery(name="Certificate.findAll", query="SELECT c FROM Certificate c")
public class Certificate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=10)
	private String abbreviation;

	@Column(nullable=false, length=20)
	private String code;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false)
	private Integer passingscore;

	@Column(nullable=false, length=255)
	private String status;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id", nullable=false)
	private Company company;

	//bi-directional many-to-one association to Exam
	@JsonIgnore
	@OneToMany(mappedBy="certificate")
	private List<Exam> exams;

	public Certificate() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPassingscore() {
		return this.passingscore;
	}

	public void setPassingscore(Integer passingscore) {
		this.passingscore = passingscore;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Exam> getExams() {
		return this.exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Exam addExam(Exam exam) {
		getExams().add(exam);
		exam.setCertificate(this);

		return exam;
	}

	public Exam removeExam(Exam exam) {
		getExams().remove(exam);
		exam.setCertificate(null);

		return exam;
	}

}