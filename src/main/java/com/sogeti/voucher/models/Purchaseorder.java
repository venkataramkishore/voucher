package com.sogeti.voucher.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the purchaseorder database table.
 * 
 */
@Entity
@Table(name="purchaseorder")
@NamedQuery(name="Purchaseorder.findAll", query="SELECT p FROM Purchaseorder p")
public class Purchaseorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=20)
	private String code;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date orderdate;

	//bi-directional many-to-one association to Voucher
	@JsonIgnore
	@OneToMany(mappedBy="purchaseorder")
	private List<Voucher> vouchers;

	public Purchaseorder() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public List<Voucher> getVouchers() {
		return this.vouchers;
	}

	public void setVouchers(List<Voucher> vouchers) {
		this.vouchers = vouchers;
	}

	public Voucher addVoucher(Voucher voucher) {
		getVouchers().add(voucher);
		voucher.setPurchaseorder(this);

		return voucher;
	}

	public Voucher removeVoucher(Voucher voucher) {
		getVouchers().remove(voucher);
		voucher.setPurchaseorder(null);

		return voucher;
	}

}