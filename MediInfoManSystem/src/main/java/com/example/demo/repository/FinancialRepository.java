package com.example.demo.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.model.Financial;


public interface FinancialRepository extends JpaRepositoryImplementation<Financial, Integer> {
	Financial findById(int id);
}
