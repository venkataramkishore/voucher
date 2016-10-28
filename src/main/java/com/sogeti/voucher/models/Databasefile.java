package com.sogeti.voucher.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the databasefile database table.
 * 
 */
@Entity
@Table(name="databasefile")
@NamedQuery(name="Databasefile.findAll", query="SELECT d FROM Databasefile d")
public class Databasefile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=255)
	private String filename;

	@Column(nullable=false)
	private byte[] bytes;

	public Databasefile() {
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getBytes() {
		return this.bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}