package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.datasecure.EncryptionDecryption;

@Entity
@Table(name="pharmacy_info")
public class Pharmacy {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="medicine_id")
	private int id;
	
	@NotNull(message="medicine name is compulsory")
	@Column(name="medicine_name")
	private String name;
	
	@NotNull(message="medicine stock is compulsory")
	@Column(name="medicine_stock")
	private int stock;
	
	@NotNull(message="medicine expired date is compulsory")
	@Column(name="medicine_expired")
	private String expireDate;

	public int getId() {
		return id;
	}

	public String getName() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(name);
	}

	public int getStock() {
		return stock;
	}

	public String getExpireDate() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(expireDate);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.name = encryption.dataEncode(name);
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setExpireDate(String expireDate) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.expireDate = encryption.dataEncode(expireDate);
	}
}
