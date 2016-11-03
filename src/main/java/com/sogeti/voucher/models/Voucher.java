package com.sogeti.voucher.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the voucher database table.
 * 
 */
@Entity
@Table(name="voucher")
@NamedQuery(name="Voucher.findAll", query="SELECT v FROM Voucher v")
public class Voucher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=12)
	private String code;

	@Column(length=2147483647)
	private String comment;

	@Column(nullable=false, length=255)
	private String status;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date validtill;

	//bi-directional many-to-one association to Exam
	@JsonIgnore
	@OneToMany(mappedBy="voucher", fetch=FetchType.LAZY)
	private List<Exam> exams;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="company_id", nullable=false)
	private Company company;

	//bi-directional many-to-one association to Purchaseorder
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="purchaseorder_code", nullable=false)
	private Purchaseorder purchaseorder;

	public Voucher() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getValidtill() {
		return this.validtill;
	}

	public void setValidtill(Date validtill) {
		this.validtill = validtill;
	}

	public List<Exam> getExams() {
		return this.exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Exam addExam(Exam exam) {
		getExams().add(exam);
		exam.setVoucher(this);

		return exam;
	}

	public Exam removeExam(Exam exam) {
		getExams().remove(exam);
		exam.setVoucher(null);

		return exam;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Purchaseorder getPurchaseorder() {
		return this.purchaseorder;
	}

	public void setPurchaseorder(Purchaseorder purchaseorder) {
		this.purchaseorder = purchaseorder;
	}

}