package com.example.demo.controller;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;

@Controller
public class ReportController {
	
	@Autowired
	DoctorRepository docRepository;

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DoctorService doctorService;

	@Autowired
	PatientService patientService;
    
	
}
