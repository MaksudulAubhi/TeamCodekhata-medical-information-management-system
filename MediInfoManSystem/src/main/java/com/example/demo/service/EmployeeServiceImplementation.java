package com.example.demo.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.repository.EmployeeRepository;


@Service
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveUser(Employee employee) {
		employee.setPassword(encoder.encode(employee.getPassword()));
		employee.setRoles(new HashSet<Role>(employee.getRoles()));
		employeeRepository.save(employee);
		
	}

	@Override
	public boolean isUserAlreadyPresent(Employee employee) {
		boolean isUserAlreadyExists=false;
		Employee exitingEmployee=employeeRepository.findByEmail(employee.getEmail());
		
		if(exitingEmployee!=null) {
			isUserAlreadyExists=true;
		}
		return isUserAlreadyExists;
	}


	

}
