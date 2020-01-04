package com.example.demo.controller;


import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientBilling;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;

@Controller
public class AppointmentController {
	@Autowired
	AppointmentRepository appointmentRepository;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	DoctorRepository docRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	DoctorService doctorService;

	@Autowired
	PatientService patientService;
	
	@Autowired
	private JavaMailSender javaMailSender;

// Create Appointment......................

	@RequestMapping(value = { "{url}/patientList/appointmentCreate/{id}" }, method = RequestMethod.GET)
	public ModelAndView createAappointment(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		Patient patient = (Patient) patientRepository.findById(id);

		Appointment appointment = new Appointment();

		appointment.setPatientId(patient.getId());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("receptionist/appointmentCreate");
		modelAndView.addObject("appointment", appointment);
		modelAndView.addObject("patient", patient);
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/patientList/appointmentCreate/{id}" }, method = RequestMethod.POST)
	public ModelAndView createAppointment(@PathVariable int id, @Valid Appointment appointment,
			BindingResult bindingResult, ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			appointmentService.saveAppointment(appointment);
			modelAndView.addObject("successMessage", "Appointment created successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("appointment", new Appointment());
		modelAndView.setViewName("receptionist/appointmentCreate");
		return modelAndView;
	}

	// get all appointment............................

	@RequestMapping(value = { "{url}/appointmentList" }, method = RequestMethod.GET)
	public ModelAndView displayAllAppointment() {
		ModelAndView mv = new ModelAndView();
		List appointmentList = appointmentService.getAllAppointment();
		int length = appointmentList.size();

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		mv.addObject("appointmentList", appointmentList);
		mv.addObject("length", length);
		mv.addObject("role", roles);
		mv.setViewName("receptionist/appointmentList");
		return mv;
	}

	// appointment Edit

	@RequestMapping(value = { "{url}/appointmentList/appointmentEdit/{id}" }, method = RequestMethod.GET)
	public ModelAndView editAappointment(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		Patient patient = (Patient) patientRepository.findById(id);

		Appointment appointment = (Appointment) appointmentRepository.findById(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("receptionist/appointmentEdit");
		modelAndView.addObject("appointment", appointment);

		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/appointmentList/appointmentEdit/{id}" }, method = RequestMethod.POST)
	public ModelAndView editAppointment(@PathVariable int id, @Valid Appointment appointment,
			BindingResult bindingResult, ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			appointmentService.saveAppointment(appointment);
			modelAndView.addObject("successMessage", "Appointment edited successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("appointment", new Appointment());
		modelAndView.setViewName("receptionist/appointmentEdit");
		return modelAndView;
	}

	// Delete Appointment...................................................

	@RequestMapping(value = { "{url}/appointmentList/appointmentDelete/{id}" }, method = RequestMethod.GET)
	public ModelAndView billingReportDelete(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		boolean isDelete = appointmentService.deleteAppointment(id);
		if (isDelete == true) {
			modelAndView.addObject("message", "Appointment removed successfully.");
		} else {
			modelAndView.addObject("message", "Appointment not removed, try again.");
		}
		modelAndView.addObject("role", roles);
		modelAndView.setViewName("receptionist/appointmentList");

		return modelAndView;
	}

	// get all appointment for doctor
	// get all appointment............................

	@RequestMapping(value = { "{url}/doctorAppointmentList" }, method = RequestMethod.GET)
	public ModelAndView displayAllAppointmentforDoctor() {
		ModelAndView mv = new ModelAndView();
		List appointmentList = appointmentService.getAllAppointment();
		int length = appointmentList.size();

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		Doctor doctor = (Doctor) docRepository.findByEmail(email);

		mv.addObject("docid", doctor.getId());

		mv.addObject("appointmentList", appointmentList);
		mv.addObject("length", length);
		mv.addObject("role", roles);
		mv.setViewName("receptionist/appointmentList");
		return mv;
	}
	
	//send email to doctor and patient .............................
	@RequestMapping(value = { "{url}/appointmentList/sendRemainder/{id}" }, method = RequestMethod.GET)
	public ModelAndView sendRemainder(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		
		Appointment appointment = (Appointment) appointmentRepository.findById(id);
		Patient patient = (Patient) patientRepository.findById(appointment.getPatientId());
		Doctor doctor = (Doctor) docRepository.findById(appointment.getDoctorId());
		
		
		
		
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(patient.getEmail(),doctor.getEmail());
		msg.setSubject("Appointment Remainder: Medical Information Management System");
		msg.setText("Assalamu Alikum, \n\n\n"+"Appointment:"+"\n\n"+"Patient Name: "+patient.getName()+"\n\n"+"Doctor Name: "+doctor.getName()+"\n\n"
				                    +"Schedule: "+appointment.getDateAndTime()+"\n\n"+"Appointment description: \n\n"+appointment.getAppointmentMessage()
				                    +"\n\n"+"Room Location: "+appointment.getRoomNumber()+"\n\n\n"+"Thank you.");
		
		javaMailSender.send(msg);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Send Remainder successfully");
		mv.setViewName("receptionist/appointmentList");
		mv.addObject("role", roles);
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
