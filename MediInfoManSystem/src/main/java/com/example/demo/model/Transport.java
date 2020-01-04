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
@Table(name="transport_info")
public class Transport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transport_id")
	private int id;
	
	@NotNull(message="transport id is compulsory")
	@Column(name="vehicle_id")
	private String vehicleId;
	
	@NotNull(message="driver name is compulsory")
	@Column(name="driver_name")
	private String name;
	
	@NotNull(message="driver address is compulsory")
	@Column(name="driver_address")
	private String address;

	public int getId() {
		return id;
	}

	public String getVehicleId() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(vehicleId);
	}

	public String getName() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(name);
	}

	public String getAddress() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(address);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setVehicleId(String vehicleId) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.vehicleId = encryption.dataEncode(vehicleId);
	}

	public void setName(String name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.name = encryption.dataEncode(name);
	}

	public void setAddress(String address) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.address = encryption.dataEncode(address);
	}
	
	
}
