package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Doctor;
import com.example.demo.model.Employee;
import com.example.demo.model.Patient;
import com.example.demo.service.DoctorService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.PatientService;

@Controller
public class LoginRegistrationController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	PatientService patientService;

	/*
	 * { for log in all user-->>>>
	 * 
	 * }
	 */

	@RequestMapping(value = { "/logon" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	/*
	 * { for register employee without doctor and head-->>>>
	 * 
	 * }
	 */

	@RequestMapping(value = { "{url}/employeeRegister" }, method = RequestMethod.GET)
	public ModelAndView empRegPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/employeeRegister");
		modelAndView.addObject("employee",new Employee());
		return modelAndView;
	}

	@RequestMapping(value = "{url}/employeeRegister", method = RequestMethod.POST)
	public ModelAndView employeeRegister(@Valid Employee employee, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else if (employeeService.isUserAlreadyPresent(employee)) {
			modelAndView.addObject("errorMessage", "employee already exists.");
		} else {
			employeeService.saveUser(employee);
			modelAndView.addObject("successMessage", "employee registered successfully");
		}
		
		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("admin/employeeRegister");
		return modelAndView;
	}

	

	/*
	 * { for doctor register(doc and head)-->>>>
	 * 
	 * }
	 */

	@RequestMapping(value = { "{url}/doctorRegister" }, method = RequestMethod.GET)
	public ModelAndView docRegPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/doctorRegister");
		modelAndView.addObject("doctor",new Doctor());
		return modelAndView;
	}
	
	@RequestMapping(value = "{url}/doctorRegister", method = RequestMethod.POST)
	public ModelAndView doctorRegister(@Valid Doctor doctor, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else if (doctorService.isUserAlreadyPresent(doctor)) {
			modelAndView.addObject("errorMessage", "doctor already exists.");
		} else {
			doctorService.saveUser(doctor);
			modelAndView.addObject("successMessage", "doctor registered successfully");
		}
		
		modelAndView.addObject("doctor", new Doctor());
		modelAndView.setViewName("admin/doctorRegister");
		return modelAndView;
	}

	/*
	 * { for patient admit-->>>>
	 * 
	 * }
	 */
	
	@RequestMapping(value = { "{url}/patientAdmit" }, method = RequestMethod.GET)
	public ModelAndView patientRegPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("patient", new Patient());
		modelAndView.setViewName("receptionist/patientAdmit");
		return modelAndView;
	}
	
	
	@RequestMapping(value = { "{url}/patientAdmit" }, method = RequestMethod.POST)
	public ModelAndView PatientRegister(@Valid Patient patient, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else if (patientService.isUserAlreadyPresent(patient)) {
			modelAndView.addObject("errorMessage", "patient already exists.");
		} else {
			patientService.saveUser(patient);
			modelAndView.addObject("successMessage", "patient registered successfully");
		}
		
		modelAndView.addObject("patient", new Patient());
		modelAndView.setViewName("receptionist/patientAdmit");
		return modelAndView;
	}
}
