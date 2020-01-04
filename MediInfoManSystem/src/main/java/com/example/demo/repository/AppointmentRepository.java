package com.example.demo.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.model.Appointment;

public interface AppointmentRepository extends JpaRepositoryImplementation<Appointment, Integer> {
	Appointment findById(int id);
}
