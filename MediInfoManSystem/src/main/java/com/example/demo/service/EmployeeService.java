package com.example.demo.service;

import com.example.demo.model.Employee;

public interface EmployeeService {
	public void saveUser(Employee employee);
	public boolean isUserAlreadyPresent(Employee employee);
	
}
