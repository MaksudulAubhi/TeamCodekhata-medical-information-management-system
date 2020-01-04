package com.example.demo.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import com.example.demo.model.Appointment;
import com.example.demo.model.Transport;

public interface TransportRepository extends JpaRepositoryImplementation<Transport, Integer> {
	Transport findById(int id);
}
