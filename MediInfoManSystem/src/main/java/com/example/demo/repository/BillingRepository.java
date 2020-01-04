package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.PatientBilling;

public interface BillingRepository extends JpaRepository<PatientBilling, Integer> {
	PatientBilling findById(int id);
}
