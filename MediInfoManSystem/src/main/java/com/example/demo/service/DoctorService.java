package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Doctor;

public interface DoctorService {
	public void saveUser(Doctor doctor);
	public boolean isUserAlreadyPresent(Doctor doctor);
	public List getAllDoctors();
	public boolean deleteDoctor(int id);
}
