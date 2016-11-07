package com.sogeti.voucher.ui.models;

import java.io.Serializable;


/**
 * The persistent class for the certificate database table.
 * 
 */
public class UICertificate implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String abbreviation;
	private String code;
	private String name;
	private Integer passingscore;
	private String status;
	private Long companyId;
	
	public UICertificate() {
		
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the passingscore
	 */
	public Integer getPassingscore() {
		return passingscore;
	}

	/**
	 * @param passingscore the passingscore to set
	 */
	public void setPassingscore(Integer passingscore) {
		this.passingscore = passingscore;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UICertificate [id=");
		builder.append(id);
		builder.append(", abbreviation=");
		builder.append(abbreviation);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", passingscore=");
		builder.append(passingscore);
		builder.append(", status=");
		builder.append(status);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append("]");
		return builder.toString();
	}
	

}