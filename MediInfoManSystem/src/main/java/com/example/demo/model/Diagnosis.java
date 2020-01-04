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
@Table(name="diagnosis_report")
public class Diagnosis {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="diagnosis_id")
	private int id;
	
	@NotNull(message="Patient id is compulsory")
	@Column(name="patient_id")
	private int patientId;
	
	
	@Column(name="Prepared_doctor_id")
	private int preDoctorId;
	
	
	@Column(name="reference_doctor")
	private String refDoctor;
	
	@Column(name="test_1")
	private String test1;
	
	@Column(name="test_1_discussion")
	private String test1Discussion;
	
	@Column(name="test_2")
	private String test2;
	
	@Column(name="test_2_discussion")
	private String test2Discussion;
	
	@Column(name="test_3")
	private String test3;
	
	@Column(name="test_3_discussion")
	private String test3Discussion;
	
	@Column(name="test_4")
	private String test4;
	
	@Column(name="test_4_discussion")
	private String test4Discussion;
	
	@Column(name="test_5")
	private String test5;
	
	@Column(name="test_5_discussion")
	private String test5Discussion;
	
	@Column(name="test_6")
	private String test6;
	
	@Column(name="test_6_discussion")
	private String test6Discussion;
	
	@Column(name="test_7")
	private String test7;
	
	@Column(name="test_7_discussion")
	private String test7Discussion;
	
	@Column(name="test_8")
	private String test8;
	
	@Column(name="test_8_discussion")
	private String test8Discussion;
	
	@Column(name="test_9")
	private String test9;
	
	@Column(name="test_9_discussion")
	private String test9Discussion;
	
	@Column(name="test_10")
	private String test10;
	
	@Column(name="test_10_discussion")
	private String test10Discussion;

	public int getId() {
		return id;
	}

	public int getPatientId() {
		return patientId;
	}

	public int getPreDoctorId() {
		return preDoctorId;
	}

	public String getRefDoctor() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(refDoctor);
	}

	public String getTest1() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test1);
	}

	public String getTest1Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test1Discussion);
	}

	public String getTest2() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test2);
	}

	public String getTest2Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test2Discussion);
	}

	public String getTest3() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test3);
	}

	public String getTest3Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test3Discussion);
	}

	public String getTest4() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test4);
	}

	public String getTest4Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test4Discussion);
	}

	public String getTest5() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test5);
	}

	public String getTest5Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test5Discussion);
	}

	public String getTest6() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test6);
	}

	public String getTest6Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test6Discussion);
	}

	public String getTest7() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test7);
	}

	public String getTest7Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test7Discussion);
	}

	public String getTest8() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test8);
	}

	public String getTest8Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test8Discussion);
	}

	public String getTest9() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test9);
	}

	public String getTest9Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test9Discussion);
	}

	public String getTest10() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test10);
	}

	public String getTest10Discussion() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test10Discussion);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public void setPreDoctorId(int preDoctorId) {
		this.preDoctorId = preDoctorId;
	}

	public void setRefDoctor(String refDoctor) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.refDoctor = encryption.dataEncode(refDoctor);
	}

	public void setTest1(String test1) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test1 = encryption.dataEncode(test1);
	}

	public void setTest1Discussion(String test1Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test1Discussion = encryption.dataEncode(test1Discussion);
	}

	public void setTest2(String test2) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test2 = encryption.dataEncode(test2);
	}

	public void setTest2Discussion(String test2Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test2Discussion = encryption.dataEncode(test2Discussion);
	}

	public void setTest3(String test3) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test3 = encryption.dataEncode(test3);
	}

	public void setTest3Discussion(String test3Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test3Discussion = encryption.dataEncode(test3Discussion);
	}

	public void setTest4(String test4) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test4 = encryption.dataEncode(test4);
	}

	public void setTest4Discussion(String test4Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test4Discussion = encryption.dataEncode(test4Discussion);
	}

	public void setTest5(String test5) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test5 = encryption.dataEncode(test5);
	}

	public void setTest5Discussion(String test5Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test5Discussion = encryption.dataEncode(test5Discussion);
	}

	public void setTest6(String test6) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test6 = encryption.dataEncode(test6);
	}

	public void setTest6Discussion(String test6Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test6Discussion = encryption.dataEncode(test6Discussion);
	}

	public void setTest7(String test7) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test7 = encryption.dataEncode(test7);
	}

	public void setTest7Discussion(String test7Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test7Discussion = encryption.dataEncode(test7Discussion);
	}

	public void setTest8(String test8) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test8 = encryption.dataEncode(test8);
	}

	public void setTest8Discussion(String test8Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test8Discussion = encryption.dataEncode(test8Discussion);
	}

	public void setTest9(String test9) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test9 = encryption.dataEncode(test9);
	}

	public void setTest9Discussion(String test9Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test9Discussion = encryption.dataEncode(test9Discussion);
	}

	public void setTest10(String test10) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test10 = encryption.dataEncode(test10);
	}

	public void setTest10Discussion(String test10Discussion) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test10Discussion = encryption.dataEncode(test10Discussion);
	}
	
	
	
	
	
	
	
}
