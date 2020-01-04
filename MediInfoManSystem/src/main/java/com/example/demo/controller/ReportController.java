package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.model.Diagnosis;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientBilling;
import com.example.demo.model.Prescription;
import com.example.demo.repository.BillingRepository;
import com.example.demo.repository.DiagnosisRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.service.BillingService;
import com.example.demo.service.DiagnosisService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import com.example.demo.service.PrescriptionService;

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

	@Autowired
	PrescriptionService prescriptionService;

	@Autowired
	PrescriptionRepository prescriptionRepository;

	@Autowired
	DiagnosisService diagnosisService;

	@Autowired
	DiagnosisRepository diagnosisRepository;

	@Autowired
	BillingRepository billingRepository;

	@Autowired
	BillingService billingService;
	// Prescription Create....................................

	@RequestMapping(value = "{url}/patientAssign/prescriptionCreate/{id}", method = RequestMethod.GET)
	public ModelAndView loadPrescription(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();

		Doctor doctor = (Doctor) docRepository.findByEmail(email);
		Patient patient = (Patient) patientRepository.findById(id);

		Prescription prescription = new Prescription();

		prescription.setPatientId(id);
		prescription.setDoctorId(doctor.getId());

		ModelAndView mv = new ModelAndView();
		mv.addObject("prescription", prescription);

		mv.addObject("doctorID", doctor.getId());
		mv.addObject("patientID", patient.getId());
		mv.addObject("name", patient.getName());
		mv.addObject("age", patient.getAge());
		mv.addObject("gender", patient.getGender());

		mv.setViewName("doctor/prescriptionCreate");
		return mv;
	}

	@RequestMapping(value = "{url}/patientAssign/prescriptionCreate/{id}", method = RequestMethod.POST)
	public ModelAndView createPrescription(@PathVariable int id, @Valid Prescription prescription,
			BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {
			prescriptionService.savePrescription(prescription);
			modelAndView.addObject("successMessage", "Prescription create successfully");
		}

		modelAndView.addObject("prescription", new Prescription());
		modelAndView.setViewName("doctor/prescriptionCreate");
		return modelAndView;
	}

//getAll Prescription to assigned Patient Prescription..........................
	@RequestMapping(value = { "{url}/patientAssign/assignedPatientPrescription/{id}",
			"{url}/patientList/assignedPatientPrescription/{id}" }, method = RequestMethod.GET)
	public ModelAndView displayAllAssignedPres(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		List prescriptionList = prescriptionService.getAllPrescriptin();
		int length = prescriptionList.size();

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		Doctor doctor = (Doctor) docRepository.findByEmail(email);
		Patient patient = (Patient) patientRepository.findById(id);

		mv.addObject("role", roles);

		if (roles == "[Doctor]") {
			mv.addObject("docid", doctor.getId());
			mv.addObject("doctorName", doctor.getName());
		}
		mv.addObject("patientId", id);

		mv.addObject("patientName", patient.getName());

		mv.addObject("prescriptionList", prescriptionList);
		mv.setViewName("doctor/assignedPatientPrescription");
		return mv;
	}

	// View Prescription..............................
	@RequestMapping(value = { "{url}/patientAssign/assignedPatientPrescription/{url}/prescriptionView/{id}",
			"{url}/patientList/assignedPatientPrescription/{url}/prescriptionView/{id}" }, method = RequestMethod.GET)
	public ModelAndView viewPrescription(@PathVariable int id) {

		Prescription prescription = (Prescription) prescriptionRepository.findById(id);
		Patient patient = (Patient) patientRepository.findById(prescription.getPatientId());
		Doctor doctor = (Doctor) docRepository.findById(prescription.getDoctorId());

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		ModelAndView modelAndView = new ModelAndView(); // Set data on object
		modelAndView.addObject("prescription", prescription);
		modelAndView.addObject("patientName", patient.getName());
		modelAndView.addObject("patientAge", patient.getAge());
		modelAndView.addObject("patientGender", patient.getGender());

		modelAndView.addObject("doctorName", doctor.getName());
		modelAndView.addObject("doctorSpeciality", doctor.getSpecialities());

		modelAndView.setViewName("doctor/prescriptionView");

		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	// Edit
	// Prescription...............................................................
	@RequestMapping(value = {
			"{url}/patientAssign/assignedPatientPrescription/{url}/prescriptionEdit/{id}" }, method = RequestMethod.GET)
	public ModelAndView editPrescription(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView();
		Prescription prescription = (Prescription) prescriptionRepository.findById(id);

		Patient patient = (Patient) patientRepository.findById(prescription.getPatientId());

		modelAndView.addObject("patientName", patient.getName());
		modelAndView.addObject("patientAge", patient.getAge());
		modelAndView.addObject("patientGender", patient.getGender());

		modelAndView.addObject("patient", patient);
		modelAndView.addObject("prescription", prescription);
		modelAndView.setViewName("doctor/prescriptionEdit");
		return modelAndView;
	}

	@RequestMapping(value = {
			"{url}/patientAssign/assignedPatientPrescription/{url}/prescriptionEdit/{id}" }, method = RequestMethod.POST)
	public ModelAndView editPrescription(@PathVariable int id, @Valid Prescription prescription,
			BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {
			prescriptionService.savePrescription(prescription);
			modelAndView.addObject("successMessage", "Prescription edited successfully");
		}

		modelAndView.addObject("prescription", new Prescription());
		modelAndView.setViewName("doctor/prescriptionEdit");
		return modelAndView;
	}

	// delete prescription................................

	@RequestMapping(value = {
			"{url}/patientAssign/assignedPatientPrescription/{url}/prescriptionDelete/{id}" }, method = RequestMethod.GET)
	public ModelAndView prescriptionDelete(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		
		ModelAndView modelAndView = new ModelAndView();
		boolean isDelete = prescriptionService.deletePrescription(id);
		if (isDelete == true) {
			modelAndView.addObject("message", "Prescription removed successfully.");
		} else {
			modelAndView.addObject("message", "Prescription not removed, try again.");
		}
		modelAndView.addObject("role", roles);
		modelAndView.setViewName("doctor/assignedPatientPrescription");

		return modelAndView;
	}

	// Diagnosis Report assign...........................
	@RequestMapping(value = { "{url}/patientList/diagnosisReportAssign/{id}" }, method = RequestMethod.GET)
	public ModelAndView createDiagnosis(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		Doctor doctor = (Doctor) docRepository.findByEmail(email);
		Patient patient = (Patient) patientRepository.findById(id);

		Diagnosis diagnosis = new Diagnosis();

		diagnosis.setPatientId(patient.getId());
		if (roles == "[Doctor]") {
			diagnosis.setPreDoctorId(doctor.getId());
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("role", roles);
		modelAndView.addObject("diagnosis", diagnosis);
		modelAndView.setViewName("doctor/diagnosisReport");
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/patientList/diagnosisReportAssign/{id}" }, method = RequestMethod.POST)
	public ModelAndView createDiagnosis(@PathVariable int id, @Valid Diagnosis diagnosis, BindingResult bindingResult,
			ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
	
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			diagnosisService.saveDiagnosis(diagnosis);
			modelAndView.addObject("successMessage", "Diagnosis report create successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("diagnosis", new Diagnosis());
		modelAndView.setViewName("doctor/diagnosisReport");
		return modelAndView;
	}

	// getAll diagnosis report for prepare..........................
	@RequestMapping(value = { "{url}/diagnosisReportList" }, method = RequestMethod.GET)
	public ModelAndView displayAlldiagnosisReport() {
		ModelAndView mv = new ModelAndView();
		List reportList = diagnosisService.getAllDiagnosis();
		int length = reportList.size();

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		mv.addObject("reportList", reportList);
		mv.addObject("length", length);
		mv.addObject("role", roles);
		mv.setViewName("doctor/diagnosisReportList");
		return mv;
	}

	// getAll diagnosis report for view assign patient
	// doctor..........................
	@RequestMapping(value = { "{url}/patientAssign/patientDiagnosisReport/{id}",
			"{url}/patientList/patientDiagnosisReport/{id}" }, method = RequestMethod.GET)
	public ModelAndView displayAlldiagnosisReportForAssignedDoctor(@PathVariable int id) {

		Patient patient = (Patient) patientRepository.findById(id);

		ModelAndView mv = new ModelAndView();
		List reportList = diagnosisService.getAllDiagnosis();
		int length = reportList.size();

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		mv.addObject("reportList", reportList);
		mv.addObject("patient", patient);
		mv.addObject("length", length);
		mv.addObject("role", roles);
		mv.setViewName("doctor/patientDiagnosisReport");
		return mv;
	}

	// update diagnosis report..............
	@RequestMapping(value = { "{url}/diagnosisReportList/diagnosisReportPrepare/{id}" }, method = RequestMethod.GET)
	public ModelAndView updateDiagnosis(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		Diagnosis diagnosis = (Diagnosis) diagnosisRepository.findById(id);

		Doctor doctor = (Doctor) docRepository.findByEmail(email);
		Patient patient = (Patient) patientRepository.findById(diagnosis.getPatientId());

		diagnosis.setPreDoctorId(doctor.getId());

		String patientName = patient.getName();
		String patientAge = String.valueOf(patient.getAge());
		String patientGender = patient.getGender();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("patientName", patientName);
		modelAndView.addObject("patientAge", patientAge);
		modelAndView.addObject("patientGender", patientGender);
		modelAndView.addObject("role", roles);
		modelAndView.addObject("diagnosis", diagnosis);
		modelAndView.setViewName("doctor/diagnosisReportPrepare");
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/diagnosisReportList/diagnosisReportPrepare/{id}" }, method = RequestMethod.POST)
	public ModelAndView prepareDiagnosis(@PathVariable int id, @Valid Diagnosis diagnosis, BindingResult bindingResult,
			ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			diagnosisService.saveDiagnosis(diagnosis);
			modelAndView.addObject("successMessage", "Diagnosis report prepared successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("diagnosis", new Diagnosis());
		modelAndView.setViewName("doctor/diagnosisReportPrepare");
		return modelAndView;
	}

	// view diagnosis report..........................

	@RequestMapping(value = { "{url}/diagnosisReportList/diagnosisReportView/{id}",
			"{url}/patientAssign/patientDiagnosisReport/{url}/diagnosisReportView/{id}",
			"{url}/patientList/patientDiagnosisReport/{url}/diagnosisReportView/{id}" }, method = RequestMethod.GET)
	public ModelAndView viewDiagnosisReport(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		Diagnosis diagnosis = (Diagnosis) diagnosisRepository.findById(id);
		Patient patient = (Patient) patientRepository.findById(diagnosis.getPatientId());
		Doctor doctor = (Doctor) docRepository.findById(diagnosis.getPreDoctorId());

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		mv.addObject("role", roles);
		mv.addObject("diagnosis", diagnosis);
		mv.addObject("doctor", doctor);
		mv.addObject("patient", patient);
		mv.setViewName("doctor/diagnosisReportView");
		return mv;
	}

	// delete diagnosis report................................

	@RequestMapping(value = { "{url}/diagnosisReportList/diagnosisReportDelete/{id}" }, method = RequestMethod.GET)
	public ModelAndView diagnosissReportDelete(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		
		ModelAndView modelAndView = new ModelAndView();
		boolean isDelete = diagnosisService.deletediagnosis(id);
		if (isDelete == true) {
			modelAndView.addObject("message", "Diagnosis Report removed successfully.");
		} else {
			modelAndView.addObject("message", "Diagnosis Report not removed, try again.");
		}
		modelAndView.addObject("role", roles);
		modelAndView.setViewName("doctor/diagnosisReportList");

		return modelAndView;
	}

	// create billing report.......................................

	@RequestMapping(value = { "{url}/patientList/billingCreate/{id}" }, method = RequestMethod.GET)
	public ModelAndView createBilling(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		Patient patient = (Patient) patientRepository.findById(id);

		PatientBilling billing = new PatientBilling();

		billing.setPatient_id(patient.getId());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("officer/billingCreate");
		modelAndView.addObject("billing", billing);
		modelAndView.addObject("patient", patient);
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/patientList/billingCreate/{id}" }, method = RequestMethod.POST)
	public ModelAndView createBilling(@PathVariable int id, @Valid PatientBilling billing, BindingResult bindingResult,
			ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			billingService.saveBilling(billing);
			modelAndView.addObject("successMessage", "Billing created successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("billing", new PatientBilling());
		modelAndView.setViewName("officer/billingCreate");
		return modelAndView;
	}

	// get all billing report...............................

	@RequestMapping(value = { "{url}/billingList" }, method = RequestMethod.GET)
	public ModelAndView displayAllBillingReport() {
		ModelAndView mv = new ModelAndView();
		List billingList = billingService.getAllBilling();
		int length = billingList.size();

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		mv.addObject("billingList", billingList);
		mv.addObject("length", length);
		mv.addObject("role", roles);
		mv.setViewName("officer/billingList");
		return mv;
	}

	// Edit Billing Report.............................................
	@RequestMapping(value = { "{url}/billingList/billingEdit/{id}" }, method = RequestMethod.GET)
	public ModelAndView EditBilling(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		

		PatientBilling billing = (PatientBilling)billingRepository.findById(id);

		

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("officer/billingEdit");
		modelAndView.addObject("billing", billing);
		
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/billingList/billingEdit/{id}" }, method = RequestMethod.POST)
	public ModelAndView editBilling(@PathVariable int id, @Valid PatientBilling billing, BindingResult bindingResult,
			ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			billingService.saveBilling(billing);
			modelAndView.addObject("successMessage", "Billing edited successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("billing", new PatientBilling());
		modelAndView.setViewName("officer/billingEdit");
		return modelAndView;
	}
	//view billing report...............................
	@RequestMapping(value = { "{url}/billingList/billingView/{id}"  }, method = RequestMethod.GET)
	public ModelAndView viewBillingReport(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		PatientBilling billing = (PatientBilling)billingRepository.findById(id);
		Patient patient = (Patient) patientRepository.findById(billing.getPatient_id());
		

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		mv.addObject("role", roles);
		mv.addObject("billing",billing);
		
		mv.addObject("patient", patient);
		mv.setViewName("officer/billingView");
		return mv;
	}
	//delete billing report...............................
	@RequestMapping(value = { "{url}/billingList/billingDelete/{id}" }, method = RequestMethod.GET)
	public ModelAndView billingReportDelete(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		boolean isDelete = billingService.deleteBilling(id);
		if (isDelete == true) {
			modelAndView.addObject("message", "Billing report removed successfully.");
		} else {
			modelAndView.addObject("message", "Billing report not removed, try again.");
		}
		modelAndView.addObject("role", roles);
		modelAndView.setViewName("Officer/billingList");
       
		return modelAndView;
	}
	

}
