package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.model.Role;

import com.example.demo.repository.PatientRepository;

@Service
public class PatientServiceImplementation implements PatientService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	

	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public void saveUser(Patient patient) {
		patient.setPassword(encoder.encode(patient.getPassword()));
		patient.setRoles(new HashSet<Role>(patient.getRoles()));
		patientRepository.save(patient);
		
	}

	@Override
	public boolean isUserAlreadyPresent(Patient patient) {
		boolean isUserAlreadyExists=false;
		Patient exitingEmployee=patientRepository.findByEmail(patient.getEmail());
		
		if(exitingEmployee!=null) {
			isUserAlreadyExists=true;
		}
		return isUserAlreadyExists;
	}

	@Override
	public List<Patient> getAllPatient() {
		List<Patient> patientList=new ArrayList<Patient>();
		patientRepository.findAll().forEach(e->patientList.add(e));
		return patientList;
	}

	@Override
	public boolean deletePatient(int id) {
		try {
			patientRepository.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	@Override
	public List<Patient> findByDocId(int id) {
		List<Patient> patientList=patientRepository.findByDocId(id);
		return patientList;
	}
 
	
	
}
