package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Doctor;
import com.example.demo.model.Employee;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	Doctor findByEmail(String Email);
	Doctor findById(int id);
}
