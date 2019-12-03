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
	
	@Column(name="total_ammount")
	private float rec_total;
	
	@Column(name="paid_ammount")
	private float rec_paid;
	
	@Column(name="due_ammount")
	private float rec_due;
	
	
	@Column(name="patient_id")
	private int patient_id;
	
	@Column(name="billing_date")
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRec1_name() {
		return rec1_name;
	}

	public void setRec1_name(String rec1_name) {
		this.rec1_name = rec1_name;
	}

	public float getRec1_ammount() {
		return rec1_ammount;
	}

	public void setRec1_ammount(float rec1_ammount) {
		this.rec1_ammount = rec1_ammount;
	}

	public String getRec2_name() {
		return rec2_name;
	}

	public void setRec2_name(String rec2_name) {
		this.rec2_name = rec2_name;
	}

	public float getRec2_ammount() {
		return rec2_ammount;
	}

	public void setRec2_ammount(float rec2_ammount) {
		this.rec2_ammount = rec2_ammount;
	}

	

	public float getRec_total() {
		return rec_total;
	}

	public void setRec_total(float rec_total) {
		this.rec_total = rec_total;
	}

	public float getRec_paid() {
		return rec_paid;
	}

	public void setRec_paid(float rec_paid) {
		
		this.rec_paid = rec_paid;
	}

	public float getRec_due() {
		
		return rec_due;
	}

	public void setRec_due(float rec_due) {
		this.rec_due = this.rec_total-this.rec_paid;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
