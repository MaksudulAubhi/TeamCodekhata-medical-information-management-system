package com.example.demo.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;


import com.example.demo.model.Pharmacy;

public interface PharmacyRepository extends JpaRepositoryImplementation<Pharmacy, Integer> {
	Pharmacy findById(int id);
}
