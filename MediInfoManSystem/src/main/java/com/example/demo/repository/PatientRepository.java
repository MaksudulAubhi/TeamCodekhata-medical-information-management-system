package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;


import com.example.demo.model.Patient;

public interface PatientRepository extends JpaRepositoryImplementation<Patient, Integer> {
	Patient findByEmail(String Email);
	Patient findById(int id);
	
	@Query("select p from Patient p, Doctor d where p.doctorId = d.id")
	public List<Patient>findByDocId(int id);
	
	
}
