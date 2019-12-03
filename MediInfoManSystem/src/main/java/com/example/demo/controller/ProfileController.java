package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.component.AgeCount;
import com.example.demo.datasecure.EncryptionDecryption;
import com.example.demo.model.Doctor;
import com.example.demo.model.Employee;
import com.example.demo.model.Patient;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.DoctorService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.PatientService;

@Controller
public class ProfileController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	PatientService patientService;

	@Autowired
	EmployeeRepository empRepository;

	@Autowired
	DoctorRepository docRepository;

	@Autowired
	PatientRepository patientRepository;

	// For view employee profile(own profile)

	@RequestMapping(value = { "{url}/employeeProfile" }, method = RequestMethod.GET)
	public ModelAndView viewEmployeeProfile(@AuthenticationPrincipal UserDetails currentUser) {
		Employee employee = (Employee) empRepository.findByEmail(currentUser.getUsername());

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		ModelAndView modelAndView = new ModelAndView(); // Set data on object
		AgeCount ageCount = new AgeCount();

		modelAndView.setViewName("employeeProfile");
		modelAndView.addObject("id", employee.getId());
		modelAndView.addObject("name", employee.getName());
		modelAndView.addObject("email", employee.getEmail());
		modelAndView.addObject("phone", employee.getPhone());
		modelAndView.addObject("title", employee.getTitle());
		modelAndView.addObject("office", employee.getOffice());
		modelAndView.addObject("schedule", employee.getSchedule());
		modelAndView.addObject("salary", employee.getSalary() + " /-");
		// Age Count**//
		String age = ageCount.ageCount(employee.getBirthyear(), employee.getBirthmonth(), employee.getBirthdate())
				+ " Years";
		modelAndView.addObject("age", age);
		/**/
		modelAndView.addObject("joindate", employee.getJoindate());
		modelAndView.addObject("gender", employee.getGender());
		modelAndView.addObject("status", employee.getStatus());
		modelAndView.addObject("extrainfo", employee.getExtrainfo());
		modelAndView.addObject("address", employee.getAddress());
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	// For view Doctors profile(own profile)
	@RequestMapping(value = { "{url}/doctorProfile" }, method = RequestMethod.GET)
	public ModelAndView viewDoctorProfile(@AuthenticationPrincipal UserDetails currentUser) {

		Doctor doctor = (Doctor) docRepository.findByEmail(currentUser.getUsername());

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		ModelAndView modelAndView = new ModelAndView(); // Set data on object
		AgeCount ageCount = new AgeCount();

		modelAndView.setViewName("doctor/doctorProfile");
		modelAndView.addObject("id", doctor.getId());
		modelAndView.addObject("name", doctor.getName());
		modelAndView.addObject("email", doctor.getEmail());
		modelAndView.addObject("phone", doctor.getPhone());
		modelAndView.addObject("title", doctor.getTitle());
		modelAndView.addObject("office", doctor.getOffice());
		modelAndView.addObject("schedule", doctor.getSchedule());
		modelAndView.addObject("salary", doctor.getSalary());
		// Age Count**//
		String age = ageCount.ageCount(doctor.getBirthyear(), doctor.getBirthmonth(), doctor.getBirthdate());
		modelAndView.addObject("age", age);
		/**/

		modelAndView.addObject("joindate", doctor.getJoindate());
		modelAndView.addObject("gender", doctor.getGender());
		modelAndView.addObject("status", doctor.getStatus());
		modelAndView.addObject("extrainfo", doctor.getExtrainfo());
		modelAndView.addObject("address", doctor.getAddress());
		modelAndView.addObject("role", roles);
		modelAndView.addObject("specialities", doctor.getSpecialities());
		return modelAndView;
	}

	/*
	 * For employee............................
	 */

	// Get employee list........................
	@RequestMapping(value = "{url}/employeeList", method = RequestMethod.GET)
	public ModelAndView displayAllEmployee() {
		ModelAndView mv = new ModelAndView();
		List employeeList = employeeService.getAllUser();
		int length = employeeList.size();

		mv.addObject("length", length);

		mv.addObject("employeeList", employeeList);
		mv.setViewName("admin/employeeList");
		return mv;
	}

	// Edit employee profile......................................
	@RequestMapping(value = { "{url}/employeeList/editEmployee/{id}" }, method = RequestMethod.GET)
	public ModelAndView empEditPage(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = empRepository.findById(id);
		modelAndView.setViewName("admin/employeeEdit");
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

	@RequestMapping(value = "{url}/employeeList/editEmployee/{id}", method = RequestMethod.POST)
	public ModelAndView employeeEdit(@Valid Employee employee, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {
			employeeService.saveUser(employee);
			modelAndView.addObject("successMessage", "employee profile updated successfully");

		}

		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("admin/employeeEdit");
		return modelAndView;
	}

	// Delete Employee profile...........................

	@RequestMapping(value = { "{url}/employeeList/deleteEmployee/{id}" }, method = RequestMethod.GET)
	public ModelAndView employeedelete(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean isDelete = employeeService.deleteEmployee(id);
		if (isDelete == true) {
			modelAndView.addObject("message", "Employee remove successfully.");
		} else {
			modelAndView.addObject("message", "Employee not removed, try again.");
		}
		modelAndView.setViewName("admin/employeeList");

		return modelAndView;
	}

	// view employee profile.......................................
	@RequestMapping(value = { "{url}/employeeList/viewEmployee/{id}" }, method = RequestMethod.GET)
	public ModelAndView viewEmployee(@PathVariable int id) {
		Employee employee = (Employee) empRepository.findById(id);

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		ModelAndView modelAndView = new ModelAndView(); // Set data on object
		AgeCount ageCount = new AgeCount();

		modelAndView.setViewName("admin/employeeProfileView");
		modelAndView.addObject("id", employee.getId());
		modelAndView.addObject("name", employee.getName());
		modelAndView.addObject("email", employee.getEmail());
		modelAndView.addObject("phone", employee.getPhone());
		modelAndView.addObject("title", employee.getTitle());
		modelAndView.addObject("office", employee.getOffice());
		modelAndView.addObject("schedule", employee.getSchedule());
		modelAndView.addObject("salary", employee.getSalary() + " /-");
		// Age Count**//
		String age = ageCount.ageCount(employee.getBirthyear(), employee.getBirthmonth(), employee.getBirthdate())
				+ " Years";
		modelAndView.addObject("age", age);
		/**/
		modelAndView.addObject("joindate", employee.getJoindate());
		modelAndView.addObject("gender", employee.getGender());
		modelAndView.addObject("status", employee.getStatus());
		modelAndView.addObject("extrainfo", employee.getExtrainfo());
		modelAndView.addObject("address", employee.getAddress());
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	/*
	 * For doctor............................
	 */
	// Get doctor list.............
	@RequestMapping(value = "{url}/doctorList", method = RequestMethod.GET)
	public ModelAndView displayAllDoctor() {
		ModelAndView mv = new ModelAndView();
		List employeeList = doctorService.getAllDoctors();
		int length = employeeList.size();

		mv.addObject("length", length);

		mv.addObject("employeeList", employeeList);
		mv.setViewName("admin/doctorList");
		return mv;
	}

	// Edit doctor profile......................................
	@RequestMapping(value = { "{url}/doctorList/editDoctor/{id}" }, method = RequestMethod.GET)
	public ModelAndView docEditPage(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		Doctor doctor = docRepository.findById(id);
		modelAndView.setViewName("admin/doctorEdit");
		modelAndView.addObject("doctor", doctor);
		return modelAndView;
	}

	@RequestMapping(value = "{url}/doctorList/editDoctor/{id}", method = RequestMethod.POST)
	public ModelAndView doctorEdit(@Valid Doctor doctor, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {
			doctorService.saveUser(doctor);
			modelAndView.addObject("successMessage", "doctor profile updated successfully");

		}

		modelAndView.addObject("doctor", new Doctor());
		modelAndView.setViewName("admin/doctorEdit");
		return modelAndView;
	}

	// Delete doctor profile...........................

	@RequestMapping(value = { "{url}/doctorList/deleteDoctor/{id}" }, method = RequestMethod.GET)
	public ModelAndView doctordelete(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean isDelete = doctorService.deleteDoctor(id);
		if (isDelete == true) {
			modelAndView.addObject("message", "Employee removed successfully.");
		} else {
			modelAndView.addObject("message", "Employee not removed, try again.");
		}
		modelAndView.setViewName("admin/doctorList");

		return modelAndView;
	}

	// view doctor profile.......................................
	@RequestMapping(value = { "{url}/doctorList/viewDoctor/{id}" }, method = RequestMethod.GET)
	public ModelAndView viewDoctor(@PathVariable int id) {
		Doctor doctor = (Doctor) docRepository.findById(id);

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		ModelAndView modelAndView = new ModelAndView(); // Set data on object
		AgeCount ageCount = new AgeCount();

		modelAndView.setViewName("admin/doctorProfileView");
		modelAndView.addObject("id", doctor.getId());
		modelAndView.addObject("name", doctor.getName());
		modelAndView.addObject("email", doctor.getEmail());
		modelAndView.addObject("phone", doctor.getPhone());
		modelAndView.addObject("title", doctor.getTitle());
		modelAndView.addObject("office", doctor.getOffice());
		modelAndView.addObject("schedule", doctor.getSchedule());
		modelAndView.addObject("salary", doctor.getSalary() + " /-");
		// Age Count**//
		String age = ageCount.ageCount(doctor.getBirthyear(), doctor.getBirthmonth(), doctor.getBirthdate()) + " Years";
		modelAndView.addObject("age", age);
		/**/
		modelAndView.addObject("joindate", doctor.getJoindate());
		modelAndView.addObject("gender", doctor.getGender());
		modelAndView.addObject("status", doctor.getStatus());
		modelAndView.addObject("extrainfo", doctor.getExtrainfo());
		modelAndView.addObject("address", doctor.getAddress());
		modelAndView.addObject("specialities", doctor.getSpecialities());
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	/*
	 * For Patient............................
	 */
	// Get Patient list.............
	@RequestMapping(value = "{url}/patientList", method = RequestMethod.GET)
	public ModelAndView displayAllPatient() {

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		ModelAndView mv = new ModelAndView();

		List patientList = patientService.getAllPatient();
		int length = patientList.size();

		mv.addObject("length", length);
		mv.addObject("role", roles);
		mv.addObject("patientList", patientList);
		mv.setViewName("admin/patientList");
		return mv;
	}

	// Edit Patient profile......................................
	@RequestMapping(value = { "{url}/patientList/editPatient/{id}" }, method = RequestMethod.GET)
	public ModelAndView patientEditPage(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		Patient patient = patientRepository.findById(id);
		modelAndView.setViewName("admin/patientEdit");
		modelAndView.addObject("patient", patient);
		return modelAndView;
	}

	@RequestMapping(value = "{url}/patientList/editPatient/{id}", method = RequestMethod.POST)
	public ModelAndView doctorEdit(@Valid Patient patient, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {
			patientService.saveUser(patient);
			modelAndView.addObject("successMessage", "patient profile updated successfully");

		}

		modelAndView.addObject("patient", new Patient());
		modelAndView.setViewName("admin/patientEdit");
		return modelAndView;
	}

	// view patient profile.......................................
	@RequestMapping(value = { "{url}/patientList/viewPatient/{id}","{url}/patientAssign/viewPatient/{id}" }, method = RequestMethod.GET)
	public ModelAndView viewPatient(@PathVariable int id) {
		Patient patient = (Patient) patientRepository.findById(id);

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		ModelAndView modelAndView = new ModelAndView(); // Set data on object
		

		modelAndView.setViewName("admin/patientProfileView");
		modelAndView.addObject("id", patient.getId());
		modelAndView.addObject("name", patient.getName());
		modelAndView.addObject("email", patient.getEmail());
		modelAndView.addObject("phone", patient.getPhone());	
		modelAndView.addObject("gender", patient.getGender());
		modelAndView.addObject("status", patient.getStatus());
		modelAndView.addObject("extrainfo", patient.getExtrainfo());
		modelAndView.addObject("address", patient.getAddress());
		modelAndView.addObject("age", patient.getAge());
		modelAndView.addObject("doc_id", patient.getDoctorId());
		modelAndView.addObject("type", patient.getType());
		modelAndView.addObject("wardNumber", patient.getWardNumber());
		modelAndView.addObject("bedNumber", patient.getBedNumber());
		modelAndView.addObject("admitDate", patient.getAdmitDate());
		modelAndView.addObject("releaseDate", patient.getRealeseDate());
		modelAndView.addObject("labNumber", patient.getLabNumber());
		modelAndView.addObject("deathDate", patient.getDeathDate());
		modelAndView.addObject("deathCause", patient.getDeathCause());
		modelAndView.addObject("role", roles);
		return modelAndView;
	}
    

	// Delete patient profile...........................

	@RequestMapping(value = { "{url}/patientList/deletePatient/{id}" }, method = RequestMethod.GET)
	public ModelAndView patientdelete(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean isDelete = patientService.deletePatient(id);
		if (isDelete == true) {
			modelAndView.addObject("message", "Patient removed successfully.");
		} else {
			modelAndView.addObject("message", "Patient not removed, try again.");
		}
		modelAndView.setViewName("admin/patientList");

		return modelAndView;
	}
	
	// Get assigned Patient list.............
			@RequestMapping(value = "{url}/patientAssign", method = RequestMethod.GET)
			public ModelAndView displayAllAssignPatient() {

				Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
				Collection<? extends GrantedAuthority> role = auth.getAuthorities();
				String roles = role.toString();
				String email=auth.getName();
				Doctor doctor=(Doctor) docRepository.findByEmail(email);
				
				
				ModelAndView mv = new ModelAndView();
				
				List<Patient> patientList = patientService.findByDocId(doctor.getId());
				int length = patientList.size();
				
				mv.addObject("length", length);
				mv.addObject("role", roles);
				mv.addObject("patientList", patientList);
				mv.setViewName("doctor/patientAssign");
				return mv;
			}
	
}
