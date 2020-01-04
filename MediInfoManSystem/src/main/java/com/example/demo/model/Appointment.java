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
@Table(name="appointment")

public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private int id;
	

	@NotNull(message="Patient id is compulsory")
	@Column(name="patient_id")
	private int patientId;
	
	@NotNull(message="doctor id is compulsory")
	@Column(name="doctor_id")
	private int doctorId;
	
	@NotNull(message="date and time is compulsory")
	@Column(name="appointment_shedule")
	private String dateAndTime;
	
	@NotNull(message="date and time is compulsory")
	@Column(name="appointment_message")
	private String appointmentMessage;
	
	@NotNull(message="Room number is compulsory")
	@Column(name="room_number")
	private String roomNumber;

	public int getId() {
		return id;
	}

	public int getPatientId() {
		return patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public String getDateAndTime() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(dateAndTime);
	}

	public String getAppointmentMessage() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(appointmentMessage);
	}

	public String getRoomNumber() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(roomNumber);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public void setDateAndTime(String dateAndTime) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.dateAndTime = encryption.dataEncode(dateAndTime);
	}

	public void setAppointmentMessage(String appointmentMessage) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.appointmentMessage = encryption.dataEncode(appointmentMessage);
	}

	public void setRoomNumber(String roomNumber) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.roomNumber = encryption.dataEncode(roomNumber);
	}
	
	
	
}
