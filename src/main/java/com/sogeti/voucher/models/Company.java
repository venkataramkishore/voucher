package com.sogeti.voucher.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=255)
	private String coachesmail;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, length=255)
	private String status;

	private Integer voucherthreshold;

	//bi-directional many-to-one association to Certificate
	@JsonIgnore
	@OneToMany(mappedBy="company")
	private List<Certificate> certificates;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="administrator_id", nullable=false)
	private Employee employee;

	//bi-directional many-to-one association to Testidentification
	@JsonIgnore
	@OneToMany(mappedBy="company")
	private List<Testidentification> testidentifications;

	//bi-directional many-to-one association to Voucher
	@JsonIgnore
	@OneToMany(mappedBy="company")
	private List<Voucher> vouchers;

	public Company() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoachesmail() {
		return this.coachesmail;
	}

	public void setCoachesmail(String coachesmail) {
		this.coachesmail = coachesmail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getVoucherthreshold() {
		return this.voucherthreshold;
	}

	public void setVoucherthreshold(Integer voucherthreshold) {
		this.voucherthreshold = voucherthreshold;
	}

	public List<Certificate> getCertificates() {
		return this.certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public Certificate addCertificate(Certificate certificate) {
		getCertificates().add(certificate);
		certificate.setCompany(this);

		return certificate;
	}

	public Certificate removeCertificate(Certificate certificate) {
		getCertificates().remove(certificate);
		certificate.setCompany(null);

		return certificate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Testidentification> getTestidentifications() {
		return this.testidentifications;
	}

	public void setTestidentifications(List<Testidentification> testidentifications) {
		this.testidentifications = testidentifications;
	}

	public Testidentification addTestidentification(Testidentification testidentification) {
		getTestidentifications().add(testidentification);
		testidentification.setCompany(this);

		return testidentification;
	}

	public Testidentification removeTestidentification(Testidentification testidentification) {
		getTestidentifications().remove(testidentification);
		testidentification.setCompany(null);

		return testidentification;
	}

	public List<Voucher> getVouchers() {
		return this.vouchers;
	}

	public void setVouchers(List<Voucher> vouchers) {
		this.vouchers = vouchers;
	}

	public Voucher addVoucher(Voucher voucher) {
		getVouchers().add(voucher);
		voucher.setCompany(this);

		return voucher;
	}

	public Voucher removeVoucher(Voucher voucher) {
		getVouchers().remove(voucher);
		voucher.setCompany(null);

		return voucher;
	}

}