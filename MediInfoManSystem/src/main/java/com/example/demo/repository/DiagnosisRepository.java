package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Diagnosis;


public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer>  {
	Diagnosis findById(int id);
}
