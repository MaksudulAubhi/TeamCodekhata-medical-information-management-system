package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.component.AgeCount;
import com.example.demo.datasecure.EncryptionDecryption;
import com.example.demo.model.Doctor;
import com.example.demo.model.Employee;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.EmployeeRepository;


@Controller
public class ProfileController {
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	DoctorRepository docRepository; 

	
	//For view employee profile(own profile)
	
	@RequestMapping(value = { "{url}/employeeProfile" }, method = RequestMethod.GET)
	public ModelAndView viewEmployeeProfile(@AuthenticationPrincipal UserDetails currentUser) {
		Employee employee=(Employee)empRepository.findByEmail(currentUser.getUsername());                    
		
		Authentication auth=(Authentication) SecurityContextHolder.getContext().getAuthentication();         //For find role;
		Collection<? extends GrantedAuthority> role=auth.getAuthorities();
		String roles=role.toString();
		                                                                     
		ModelAndView modelAndView = new ModelAndView();                                           //Set data on object
		AgeCount ageCount=new AgeCount();
		EncryptionDecryption decryption=new EncryptionDecryption();
		
		modelAndView.setViewName("employeeProfile");
		modelAndView.addObject("id",employee.getId());
		modelAndView.addObject("name",decryption.decodeData(employee.getName()));
		modelAndView.addObject("email",employee.getEmail());
		modelAndView.addObject("phone",decryption.decodeData(employee.getPhone()));
		modelAndView.addObject("title",decryption.decodeData(employee.getTitle()));
		modelAndView.addObject("office",decryption.decodeData(employee.getOffice()));
		modelAndView.addObject("schedule",decryption.decodeData(employee.getSchedule()));
		modelAndView.addObject("salary",decryption.decodeData(employee.getSalary())+" /-");
		//Age Count**//
		String age=ageCount.ageCount(employee.getBirthyear(), employee.getBirthmonth(), employee.getBirthdate())+" Years";
		modelAndView.addObject("age",age);
		/**/
		modelAndView.addObject("joindate",decryption.decodeData(employee.getJoindate()));
		modelAndView.addObject("gender",decryption.decodeData(employee.getGender()));
		modelAndView.addObject("status",employee.getStatus());
		modelAndView.addObject("extrainfo",decryption.decodeData(employee.getExtrainfo()));
		modelAndView.addObject("address",decryption.decodeData(employee.getAddress()));
		modelAndView.addObject("role",roles);
		return modelAndView;
	}
	
	//For view Doctors profile(own profile)
	@RequestMapping(value = { "{url}/doctorProfile" }, method = RequestMethod.GET)
	public ModelAndView viewDoctorProfile(@AuthenticationPrincipal UserDetails currentUser) {

		Doctor doctor=(Doctor)docRepository.findByEmail(currentUser.getUsername());                    
		
		Authentication auth=(Authentication) SecurityContextHolder.getContext().getAuthentication();         //For find role;
		Collection<? extends GrantedAuthority> role=auth.getAuthorities();
		String roles=role.toString();
		                                                                     
		ModelAndView modelAndView = new ModelAndView();                                           //Set data on object
		AgeCount ageCount=new AgeCount();
		EncryptionDecryption decryption=new EncryptionDecryption();
		
		modelAndView.setViewName("doctor/doctorProfile");
		modelAndView.addObject("id",doctor.getId());
		modelAndView.addObject("name",decryption.decodeData(doctor.getName()));
		modelAndView.addObject("email",doctor.getEmail());
		modelAndView.addObject("phone",decryption.decodeData(doctor.getPhone()));
		modelAndView.addObject("title",decryption.decodeData(doctor.getTitle()));
		modelAndView.addObject("office",decryption.decodeData(doctor.getOffice()));
		modelAndView.addObject("schedule",decryption.decodeData(doctor.getSchedule()));
		modelAndView.addObject("salary",decryption.decodeData(doctor.getSalary()));
		//Age Count**//
				String age=ageCount.ageCount(doctor.getBirthyear(), doctor.getBirthmonth(), doctor.getBirthdate());
				modelAndView.addObject("age",age);
				/**/
		
		modelAndView.addObject("joindate",decryption.decodeData(doctor.getJoindate()));
		modelAndView.addObject("gender",decryption.decodeData(doctor.getGender()));
		modelAndView.addObject("status",doctor.getStatus());
		modelAndView.addObject("extrainfo",decryption.decodeData(doctor.getExtrainfo()));
		modelAndView.addObject("address",decryption.decodeData(doctor.getAddress()));
		modelAndView.addObject("role",roles);
		modelAndView.addObject("specialities",decryption.decodeData(doctor.getSpecialities()));
		return modelAndView;
	}
	
	//For update employee profile
	@RequestMapping(value = { "{url}/employeeProfileUpdate" }, method = RequestMethod.GET)
	public ModelAndView updateEmployeeProfile(@RequestParam(value="search")String q) {
		ModelAndView modelAndView=new ModelAndView();
		
		Employee employee=(Employee)empRepository.findByEmail(q);
		String name=employee.getName();
		modelAndView.addObject("name",name);
		
		modelAndView.setViewName("admin/employeeProfileUpdate");
		return modelAndView;
	}
	




}
