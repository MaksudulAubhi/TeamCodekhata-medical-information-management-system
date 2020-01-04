package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Patient;

public interface PatientService {
	public void saveUser(Patient patient);
	public boolean isUserAlreadyPresent(Patient patient);
	public List getAllPatient();
	public boolean deletePatient(int id);
	
	public List<Patient>findByDocId(int id);
	
}
