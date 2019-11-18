package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	public void saveUser(Employee employee);
	public boolean isUserAlreadyPresent(Employee employee);
	public List getAllUser();
	public boolean deleteEmployee(int id);
	
}
