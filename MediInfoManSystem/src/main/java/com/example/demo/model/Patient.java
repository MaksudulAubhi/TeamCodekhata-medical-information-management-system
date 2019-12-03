package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.example.demo.datasecure.EncryptionDecryption;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int id;
	
	@NotNull(message = "Name is compulsory")
	@Column(name = "patient_name")
	private String name;
	
	@NotNull(message = "Email is compulsory")
	@Column(name = "patient_email")
	@Email(message = "Email is not valid")
	private String email;
	
	@NotNull(message = "Phone is compulsory")
	@Column(name = "patient_phone")
	private String phone;

	@NotNull(message = "Password is compulsory")
	@Column(name = "patient_password")
	private String password;
	
	@NotNull(message = "Gender is compulsory")
	@Column(name = "patient_gender")
	private String gender;
	
	@NotNull(message = "Status is compulsory")
	@Column(name = "patient_status")
	private String status;
	
	@Column(name = "patient_extra_info")
	private String extrainfo;

	@NotNull(message = "Address is compulsory")
	@Column(name = "patient_address")
	private String address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "auth_patient_role", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<Role> roles;
	
	@NotNull(message = "age is compulsory")
	@Column(name = "patient_age")
	private int age;
	
	@Column(name = "patient_ward_number")
	private int wardNumber;
	
	@Column(name = "patient_bed_number")
	private int bedNumber;
	
	@Column(name = "patient_lab")
	private int labNumber;
	
	
	@Column(name = "patient_type")
	private String type;
	
	@Column(name = "patient_release_date")
	private String realeseDate;
	
	
	@Column(name = "patient_admit_date")
	private Date admitDate;
	
	@Column(name = "patient_death_date")
	private String deathDate;
	
	@NotNull(message = "doctor_id is compulsory")
	@Column(name = "doctor_id")
	private int doctorId;
	
	@Column(name = "patient_death_cause")
	private String deathCause;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(phone);
	}

	public void setPhone(String phone) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.phone = encryption.dataEncode(phone);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(gender);
	}

	public void setGender(String gender) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.gender = encryption.dataEncode(gender);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExtrainfo() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(extrainfo);
	}

	public void setExtrainfo(String extrainfo) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.extrainfo = encryption.dataEncode(extrainfo);
	}

	public String getAddress() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(address);
	}

	public void setAddress(String address) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.address = encryption.dataEncode(address);
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWardNumber() {
		return wardNumber;
	}

	public void setWardNumber(int wardNumber) {
		this.wardNumber = wardNumber;
	}

	public int getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}

	public int getLabNumber() {
		return labNumber;
	}

	public void setLabNumber(int labNumber) {
		this.labNumber = labNumber;
	}

	public String getType() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(type);
	}

	public void setType(String type) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.type = encryption.dataEncode(type);
	}

	public String getRealeseDate() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(realeseDate);
	}

	public void setRealeseDate(String realeseDate) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.realeseDate = encryption.dataEncode(realeseDate);
	}

	public String getDeathDate() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(deathDate);
	}

	public void setDeathDate(String deathDate) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.deathDate = encryption.dataEncode(deathDate);
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}

	public String getDeathCause() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(deathCause);
	}

	public void setDeathCause(String deathCause) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.deathCause = encryption.dataEncode(deathCause);
	}

	

	
	
	
}
