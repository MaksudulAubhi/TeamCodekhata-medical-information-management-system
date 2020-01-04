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
@Table(name="prescription")
public class Prescription {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prescription_id")
	private int id;
	
	@NotNull(message="Patient_id is compulsory")
	@Column(name="patient_id")
	private int patientId;
	
	@NotNull(message="doctor_id is compulsory")
	@Column(name="doctor_id")
	private int doctorId;
	
	
	@Column(name="disease_1")
	private String disease1;
	
	@Column(name="disease_2")
	private String disease2;
	
	@Column(name="disease_3")
	private String disease3;
	
	@Column(name="disease_4")
	private String disease4;
	
	@Column(name="disease_5")
	private String disease5;
	
	@Column(name="disease_6")
	private String disease6;
	
	@Column(name="disease_7")
	private String disease7;
	
	@Column(name="disease_8")
	private String disease8;
	
	@Column(name="disease_9")
	private String disease9;
	
	@Column(name="disease_10")
	private String disease10;
	
	
	@Column(name="medicine_1")
	private String medicine1;
	
	@Column(name="medicine_2")
	private String medicine2;
	
	@Column(name="medicine_3")
	private String medicine3;
	
	@Column(name="medicine_4")
	private String medicine4;
	
	@Column(name="medicine_5")
	private String medicine5;
	
	@Column(name="medicine_6")
	private String medicine6;
	
	@Column(name="medicine_7")
	private String medicine7;
	
	@Column(name="medicine_8")
	private String medicine8;
	
	@Column(name="medicine_9")
	private String medicine9;
	
	@Column(name="medicine_10")
	private String medicine10;
	
	
	@Column(name="test_1")
	private String test1;
	
	@Column(name="test_2")
	private String test2;
	
	@Column(name="test_3")
	private String test3;
	
	@Column(name="test_4")
	private String test4;
	
	@Column(name="test_5")
	private String test5;
	
	@Column(name="test_6")
	private String test6;
	
	@Column(name="test_7")
	private String test7;
	
	@Column(name="test_8")
	private String test8;
	
	@Column(name="test_9")
	private String test9;
	
	@Column(name="test_10")
	private String test10;
	
	@Column(name="advice")
	private String advice;
	
	@Column(name="information")
	private String information;

	public int getId() {
		return id;
	}

	public int getPatientId() {
		return patientId;
	}

	public int getDoctorId() {
		return doctorId;
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

	public String getDisease1() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease1);
	}

	public String getDisease2() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease2);
	}

	public String getDisease3() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease3);
	}

	public String getDisease4() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease4);
	}

	public String getDisease5() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease5);
	}

	public String getDisease6() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease6);
	}

	public String getDisease7() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease7);
	}

	public String getDisease8() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease8);
	}

	public String getDisease9() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease9);
	}

	public String getDisease10() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(disease10);
	}



	public void setDisease1(String disease1) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease1 = encryption.dataEncode(disease1);
	}

	public void setDisease2(String disease2) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease2 = encryption.dataEncode(disease2);
	}

	public void setDisease3(String disease3) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease3 = encryption.dataEncode(disease3);
	}

	public void setDisease4(String disease4) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease4 = encryption.dataEncode(disease4);
	}

	public void setDisease5(String disease5) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease5 = encryption.dataEncode(disease5);
	}

	public void setDisease6(String disease6) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease6 = encryption.dataEncode(disease6);
	}

	public void setDisease7(String disease7) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease7 = encryption.dataEncode(disease7);
	}

	public void setDisease8(String disease8) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease8 = encryption.dataEncode(disease8);
	}

	public void setDisease9(String disease9) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease9 = encryption.dataEncode(disease9);
	}

	public void setDisease10(String disease10) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.disease10 = encryption.dataEncode(disease10);
	}
    
	
	public String getMedicine1() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine1);
	}

	public String getMedicine2() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine2);
	}

	public String getMedicine3() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine3);
	}

	public String getMedicine4() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine4);
	}

	public String getMedicine5() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine5);
	}

	public String getMedicine6() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine6);
	}

	public String getMedicine7() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine7);
	}

	public String getMedicine8() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine8);
	}

	public String getMedicine9() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine9);
	}

	public String getMedicine10() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(medicine10);
	}



	public void setMedicine1(String medicine1) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine1 = encryption.dataEncode(medicine1);
	}

	public void setMedicine2(String medicine2) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine2 = encryption.dataEncode(medicine2);
	}

	public void setMedicine3(String medicine3) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine3 = encryption.dataEncode(medicine3);
	}

	public void setMedicine4(String medicine4) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine4 = encryption.dataEncode(medicine4);
	}

	public void setMedicine5(String medicine5) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine5 = encryption.dataEncode(medicine5);
	}

	public void setMedicine6(String medicine6) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine6 = encryption.dataEncode(medicine6);
	}

	public void setMedicine7(String medicine7) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine7 = encryption.dataEncode(medicine7);
	}

	public void setMedicine8(String medicine8) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine8 = encryption.dataEncode(medicine8);
	}

	public void setMedicine9(String medicine9) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine9 = encryption.dataEncode(medicine9);
	}

	public void setMedicine10(String medicine10) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.medicine10 = encryption.dataEncode(medicine10);
	}

	
	
	
	public String getTest1() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test1);
	}

	public String getTest2() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test2);
	}

	public String getTest3() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test3);
	}

	public String getTest4() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test4);
	}

	public String getTest5() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test5);
	}

	public String getTest6() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test6);
	}

	public String getTest7() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test7);
	}

	public String getTest8() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test8);
	}

	public String getTest9() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test9);
	}

	public String getTest10() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(test10);
	}



	public void setTest1(String test1) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test1 = encryption.dataEncode(test1);
	}

	public void setTest2(String test2) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test2 = encryption.dataEncode(test2);
	}

	public void setTest3(String test3) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test3 = encryption.dataEncode(test3);
	}

	public void setTest4(String test4) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test4 = encryption.dataEncode(test4);
	}

	public void setTest5(String test5) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test5 = encryption.dataEncode(test5);
	}

	public void setTest6(String test6) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test6 = encryption.dataEncode(test6);
	}

	public void setTest7(String test7) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test7 = encryption.dataEncode(test7);
	}

	public void setTest8(String test8) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test8 = encryption.dataEncode(test8);
	}

	public void setTest9(String test9) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test9 = encryption.dataEncode(test9);
	}

	public void setTest10(String test10) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.test10 = encryption.dataEncode(test10);
	}

	public String getAdvice() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(advice);
	}

	public String getInformation() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(information);
	}

	public void setAdvice(String advice) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.advice = encryption.dataEncode(advice);
	}

	public void setInformation(String information) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.information = encryption.dataEncode(information);
	}

	
	
}
