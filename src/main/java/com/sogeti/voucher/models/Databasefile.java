package com.sogeti.voucher.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the databasefile database table.
 * 
 */
@Entity
@NamedQuery(name="Databasefile.findAll", query="SELECT d FROM Databasefile d")
public class Databasefile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private byte[] bytes;

	private String filename;

	public Databasefile() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getBytes() {
		return this.bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}