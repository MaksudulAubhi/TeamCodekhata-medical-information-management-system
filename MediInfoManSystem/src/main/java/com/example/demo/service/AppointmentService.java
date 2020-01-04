package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Appointment;


public interface AppointmentService {
	public void saveAppointment(Appointment appointment);
	public List getAllAppointment();
	public boolean deleteAppointment(int id);
}
