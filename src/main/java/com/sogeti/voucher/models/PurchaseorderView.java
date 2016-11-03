package com.sogeti.voucher.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the purchaseorder_view database table.
 * 
 */
@Entity
@Table(name="purchaseorder_view")
@NamedQuery(name="PurchaseorderView.findAll", query="SELECT p FROM PurchaseorderView p")
public class PurchaseorderView implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;

	@Column(name="company_id")
	private Long companyId;

	@Column(name="employee_id")
	private Long employeeId;

	private String firstname;

	private String lastname;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date orderdate;

	@Id
	@Column(name="voucher_id")
	private Long voucherId;

	public PurchaseorderView() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Long getVoucherId() {
		return this.voucherId;
	}

	public void setVoucherId(Long voucherId) {
		this.voucherId = voucherId;
	}

}