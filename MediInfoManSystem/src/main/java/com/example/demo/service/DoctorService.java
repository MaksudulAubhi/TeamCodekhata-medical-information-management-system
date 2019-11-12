package com.example.demo.service;

import com.example.demo.model.Doctor;

public interface DoctorService {
	public void saveUser(Doctor doctor);
	public boolean isUserAlreadyPresent(Doctor doctor);
}
