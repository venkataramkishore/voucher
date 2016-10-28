package com.sogeti.voucher.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emailtemplate database table.
 * 
 */
@Entity
@Table(name="emailtemplate")
@NamedQuery(name="Emailtemplate.findAll", query="SELECT e FROM Emailtemplate e")
public class Emailtemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=255)
	private String recipientroles;

	@Column(nullable=false, length=100)
	private String subject;

	@Column(nullable=false, length=5000)
	private String templatebody;

	@Column(nullable=false, length=255)
	private String type;

	public Emailtemplate() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipientroles() {
		return this.recipientroles;
	}

	public void setRecipientroles(String recipientroles) {
		this.recipientroles = recipientroles;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplatebody() {
		return this.templatebody;
	}

	public void setTemplatebody(String templatebody) {
		this.templatebody = templatebody;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}