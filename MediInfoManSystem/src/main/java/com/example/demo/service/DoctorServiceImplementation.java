package com.example.demo.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Role;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.RoleRepository;

@Service
public class DoctorServiceImplementation implements DoctorService{
   
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public void saveUser(Doctor doctor) {
		doctor.setPassword(encoder.encode(doctor.getPassword()));
		doctor.setRoles(new HashSet<Role>(doctor.getRoles()));
		doctorRepository.save(doctor);
		
	}

	@Override
	public boolean isUserAlreadyPresent(Doctor doctor) {
		boolean isUserAlreadyExists=false;
		Doctor exitingEmployee=doctorRepository.findByEmail(doctor.getEmail());
		
		if(exitingEmployee!=null) {
			isUserAlreadyExists=true;
		}
		return isUserAlreadyExists;
	}

}
