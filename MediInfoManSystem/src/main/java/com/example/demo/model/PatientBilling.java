package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.datasecure.EncryptionDecryption;

@Entity
@Table(name="patient_billing")
public class PatientBilling {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="billing_id")
	private int id;
	
	@Column(name="resource_name1")
	private String rec1_name;
	
	@Column(name="resource_ammount1")
	private float rec1_ammount;
	
	@Column(name="resource_name2")
	private String rec2_name;
	
	@Column(name="resource_ammount2")
	private float rec2_ammount;
	
	@Column(name="resource_name3")
	private String rec3_name;
	
	@Column(name="resource_ammount3")
	private float rec3_ammount;
	
	@Column(name="resource_name4")
	private String rec4_name;
	
	@Column(name="resource_ammount4")
	private float rec4_ammount;
	
	@Column(name="resource_name5")
	private String rec5_name;
	
	@Column(name="resource_ammount5")
	private float rec5_ammount;
	
	@Column(name="resource_name6")
	private String rec6_name;
	
	@Column(name="resource_ammount6")
	private float rec6_ammount;
	
	@Column(name="resource_name7")
	private String rec7_name;
	
	@Column(name="resource_ammount7")
	private float rec7_ammount;
	
	@Column(name="resource_name8")
	private String rec8_name;
	
	@Column(name="resource_ammount8")
	private float rec8_ammount;
	
	@Column(name="resource_name9")
	private String rec9_name;
	
	@Column(name="resource_ammount9")
	private float rec9_ammount;
	
	@Column(name="resource_name10")
	private String rec10_name;
	
	@Column(name="resource_ammount10")
	private float rec10_ammount;
	
	@Column(name="total_ammount")
	private float rec_total;
	
	@Column(name="paid_ammount")
	private float rec_paid;
	
	@Column(name="due_ammount")
	private float rec_due;
	
	@NotNull(message = "Patient id is compoulsory")
	@Column(name="patient_id")
	private int patient_id;
	
	@Column(name="billing_date")
	private String billing_date;

	public int getId() {
		return id;
	}

	public String getRec1_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec1_name);
	}

	public float getRec1_ammount() {
		return rec1_ammount;
	}

	public String getRec2_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec2_name);
	}

	public float getRec2_ammount() {
		return rec2_ammount;
	}

	public String getRec3_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec3_name);
	}

	public float getRec3_ammount() {
		return rec3_ammount;
	}

	public String getRec4_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec4_name);
	}

	public float getRec4_ammount() {
		return rec4_ammount;
	}

	public String getRec5_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec5_name);
	}

	public float getRec5_ammount() {
		return rec5_ammount;
	}

	public String getRec6_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec6_name);
	}

	public float getRec6_ammount() {
		return rec6_ammount;
	}

	public String getRec7_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec7_name);
	}

	public float getRec7_ammount() {
		return rec7_ammount;
	}

	public String getRec8_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec8_name);
	}

	public float getRec8_ammount() {
		return rec8_ammount;
	}

	public String getRec9_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec9_name);
	}

	public float getRec9_ammount() {
		return rec9_ammount;
	}

	public String getRec10_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(rec10_name);
	}

	public float getRec10_ammount() {
		return rec10_ammount;
	}

	public float getRec_total() {
		return rec_total;
	}

	public float getRec_paid() {
		return rec_paid;
	}

	public float getRec_due() {
		return rec_due;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public String getBilling_date() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(billing_date);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRec1_name(String rec1_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec1_name = encryption.dataEncode(rec1_name);
	}

	public void setRec1_ammount(float rec1_ammount) {
		this.rec1_ammount = rec1_ammount;
	}

	public void setRec2_name(String rec2_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec2_name = encryption.dataEncode(rec2_name);
	}

	public void setRec2_ammount(float rec2_ammount) {
		this.rec2_ammount = rec2_ammount;
	}

	public void setRec3_name(String rec3_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec3_name = encryption.dataEncode(rec3_name);
	}

	public void setRec3_ammount(float rec3_ammount) {
		this.rec3_ammount = rec3_ammount;
	}

	public void setRec4_name(String rec4_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec4_name = encryption.dataEncode(rec4_name);
	}

	public void setRec4_ammount(float rec4_ammount) {
		this.rec4_ammount = rec4_ammount;
	}

	public void setRec5_name(String rec5_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec5_name = encryption.dataEncode(rec5_name);
	}

	public void setRec5_ammount(float rec5_ammount) {
		this.rec5_ammount = rec5_ammount;
	}

	public void setRec6_name(String rec6_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec6_name = encryption.dataEncode(rec6_name);
	}

	public void setRec6_ammount(float rec6_ammount) {
		this.rec6_ammount = rec6_ammount;
	}

	public void setRec7_name(String rec7_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec7_name = encryption.dataEncode(rec7_name);
	}

	public void setRec7_ammount(float rec7_ammount) {
		this.rec7_ammount = rec7_ammount;
	}

	public void setRec8_name(String rec8_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec8_name = encryption.dataEncode(rec8_name);
	}

	public void setRec8_ammount(float rec8_ammount) {
		this.rec8_ammount = rec8_ammount;
	}

	public void setRec9_name(String rec9_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec9_name = encryption.dataEncode(rec9_name);
	}

	public void setRec9_ammount(float rec9_ammount) {
		this.rec9_ammount = rec9_ammount;
	}

	public void setRec10_name(String rec10_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.rec10_name = encryption.dataEncode(rec10_name);
	}

	public void setRec10_ammount(float rec10_ammount) {
		this.rec10_ammount = rec10_ammount;
	}

	public void setRec_total(float rec_total) {
		this.rec_total = rec_total;
	}

	public void setRec_paid(float rec_paid) {
		this.rec_paid = rec_paid;
	}

	public void setRec_due(float rec_due) {
		this.rec_due = rec_due;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public void setBilling_date(String billing_date) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.billing_date = encryption.dataEncode(billing_date);
	}


}
