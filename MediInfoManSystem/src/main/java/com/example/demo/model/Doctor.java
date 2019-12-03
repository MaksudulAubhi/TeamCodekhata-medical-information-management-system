package com.example.demo.model;


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
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.example.demo.datasecure.EncryptionDecryption;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doc_id")
	private int id;

	@NotNull(message = "Name is compulsory")
	@Column(name = "doc_name")
	private String name;

	@NotNull(message = "Email is compulsory")
	@Column(name = "doc_email")
	@Email(message = "Email is not valid")
	private String email;

	@NotNull(message = "Phone is compulsory")
	@Column(name = "doc_phone")
	private String phone;

	@NotNull(message = "Password is compulsory")
	@Column(name = "doc_password")
	private String password;

	@NotNull(message = "Title is compulsory")
	@Column(name = "doc_title")
	private String title;

	@NotNull(message = "Office is compulsory")
	@Column(name = "doc_office")
	private String office;

	@NotNull(message = "Schedule is compulsory")
	@Column(name = "doc_schedule")
	private String schedule;

	@NotNull(message = "Salary is compulsory")
	@Column(name = "doc_salary")
	private String salary;


	@Column(name = "doc_join_date")
	private String joindate;

	@NotNull(message = "Gender is compulsory")
	@Column(name = "doc_gender")
	private String gender;

	@NotNull(message = "Status is compulsory")
	@Column(name = "doc_status")
	private String status;

	@Column(name = "doc_extra_info")
	private String extrainfo;

	@NotNull(message = "Address is compulsory")
	@Column(name = "doc_address")
	private String address;
	
	@NotNull(message = "Specialities is compulsory")
	@Column(name = "doc_specialities")
	private String specialities;
	
	@NotNull(message="Birth date is compulsory")
	@Column(name="doc_birth_date")
	private int birthdate;
	
	@NotNull(message="Birth month is compulsory")
	@Column(name="doc_birth_month")
	private int birthmonth;
	
	@NotNull(message="Birth year is compulsory")
	@Column(name="doc_birth_year")
	private int birthyear;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "auth_doc_role", joinColumns = @JoinColumn(name = "doc_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<Role> roles;

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

	public String getAddress() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(address);
	}

	public void setAddress(String address) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.address = encryption.dataEncode(address);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(title);
	}

	public void setTitle(String title) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.title = encryption.dataEncode(title);
	}

	public String getOffice() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(office);
	}

	public void setOffice(String office) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.office = encryption.dataEncode(office);
	}

	public String getSchedule() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(schedule);
	}

	public void setSchedule(String schedule) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.schedule = encryption.dataEncode(schedule);
	}

	public String getSalary() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(salary);
	}

	public void setSalary(String salary) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.salary = encryption.dataEncode(salary);
	}

	

	public String getJoindate() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(joindate);
	}

	public void setJoindate(String joindate) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.joindate = encryption.dataEncode(joindate);
		
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	public int getBirthyear() {
		return birthyear;
	}

	
	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	
	public int getBirthdate() {
		return birthdate;
	}

	
	public void setBirthdate(int birthdate) {
		this.birthdate = birthdate;
	}

	
	public int getBirthmonth() {
		return birthmonth;
	}


	public void setBirthmonth(int birthmonth) {
		this.birthmonth = birthmonth;
	}

	
	

	public String getSpecialities() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(specialities);
	}

	public void setSpecialities(String specialities) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.specialities = encryption.dataEncode(specialities);
	}
	
}
