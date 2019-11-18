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
@Table(name="ward_information")
public class Ward {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Ward_Number")
	private int id;
    
	@NotNull(message="Ward name is compulsory")
	@Column(name="ward_name")
	private String name;
	
	@NotNull(message="Total bed number is compulsory")
	@Column(name="total_bed")
	private int bed;
	
	@NotNull(message="Available bed numbers is compulsory")
	@Column(name="available_bed")
	private String available;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(name);
	}

	public void setName(String name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.name = encryption.dataEncode(name);
	}

	public int getBed() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeDataInt(bed);
	}

	public void setBed(int bed) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.bed = encryption.dataEncodeInt(bed);
	}

	public String getAvailable() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(available);
	}

	public void setAvailable(String available) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.available = encryption.dataEncode(available);
	}
}
