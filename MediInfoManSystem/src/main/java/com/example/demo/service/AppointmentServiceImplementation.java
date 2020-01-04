package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
@Service
public class AppointmentServiceImplementation implements AppointmentService {
	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public void saveAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);

	}

	@Override
	public List<Appointment> getAllAppointment() {
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		appointmentRepository.findAll().forEach(e -> appointmentList.add(e));
		return appointmentList;
	}

	@Override
	public boolean deleteAppointment(int id) {
		try {
			appointmentRepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
