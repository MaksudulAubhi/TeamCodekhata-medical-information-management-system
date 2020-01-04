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

import com.example.demo.model.Financial;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientBilling;
import com.example.demo.repository.FinancialRepository;
import com.example.demo.service.FinancialService;

@Controller
public class GraphicalReportController {
	
	@Autowired
	FinancialService financialService;
	
	@Autowired
	FinancialRepository financialRepository;
	
	
	//Financial Report Create.....................................................
	
	@RequestMapping(value = { "{url}/financialReportCreate" }, method = RequestMethod.GET)
	public ModelAndView createFinancialReport() {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		
        Financial financial=new Financial();
		

		

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("financial",financial);
		modelAndView.setViewName("officer/financialReportCreate");
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/financialReportCreate" }, method = RequestMethod.POST)
	public ModelAndView createFinancialReport( @Valid Financial financial, BindingResult bindingResult,
			ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			financialService.saveReport(financial);;
			modelAndView.addObject("successMessage", "Report created successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("billing", new Financial());
		modelAndView.setViewName("officer/financialReportCreate");
		return modelAndView;
	}
	
	//Financial report list.........................................................
	
	@RequestMapping(value = { "{url}/financialReportList" }, method = RequestMethod.GET)
	public ModelAndView displayAllBillingReport() {
		ModelAndView mv = new ModelAndView();
		List billingList = financialService.getAllReport();
		int length = billingList.size();

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		mv.addObject("billingList", billingList);
		mv.addObject("length", length);
		mv.addObject("role", roles);
		mv.setViewName("officer/financialReportList");
		return mv;
	}
	
	//Financial Report Edit...................................................
	
	@RequestMapping(value = { "{url}/financialReportList/financialReportEdit/{id}" }, method = RequestMethod.GET)
	public ModelAndView editFinancialReport(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		
        Financial financial=(Financial)financialRepository.findById(id);
		

		

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("financial",financial);
		modelAndView.setViewName("officer/financialReportEdit");
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/financialReportList/financialReportEdit/{id}" }, method = RequestMethod.POST)
	public ModelAndView editFinancialReport(@PathVariable int id, @Valid Financial financial, BindingResult bindingResult,
			ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			financialService.saveReport(financial);;
			modelAndView.addObject("successMessage", "Report edited successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("billing", new Financial());
		modelAndView.setViewName("officer/financialReportEdit");
		return modelAndView;
	}
	
	//Financial Report Delete.........................................................
	
	
		@RequestMapping(value = { "{url}/financialReportList/financialReportDelete/{id}" }, method = RequestMethod.GET)
		public ModelAndView billingReportDelete(@PathVariable int id) {
			Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

			Collection<? extends GrantedAuthority> role = auth.getAuthorities();
			String roles = role.toString();
			ModelAndView modelAndView = new ModelAndView();
			boolean isDelete = financialService.deleteReport(id);
			if (isDelete == true) {
				modelAndView.addObject("message", "Financial report removed successfully.");
			} else {
				modelAndView.addObject("message", "Financial report not removed, try again.");
			}
			modelAndView.addObject("role", roles);
			modelAndView.setViewName("Officer/financialReportList");
	       
			return modelAndView;
		}
	
	//View Financial Report......................................
		
		@RequestMapping(value = { "{url}/financialReportList/financialReportView/{id}"  }, method = RequestMethod.GET)
		public ModelAndView viewFinancialReport(@PathVariable int id) {
			ModelAndView mv = new ModelAndView();
			
			Financial financial=(Financial)financialRepository.findById(id);

			Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

			Collection<? extends GrantedAuthority> role = auth.getAuthorities();
			String roles = role.toString();

			mv.addObject("role", roles);
			mv.addObject("financial", financial);
			
			mv.setViewName("officer/financialReportView");
			return mv;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
