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
import com.example.demo.model.Pharmacy;
import com.example.demo.model.Transport;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.repository.TransportRepository;
import com.example.demo.service.PharmacyService;
import com.example.demo.service.TransportService;

@Controller
public class ResourceController {
	@Autowired 
	private TransportService transportService;
	
	@Autowired 
	private TransportRepository transportRepository;
	
	@Autowired 
	private PharmacyService pharmacyService;
	
	@Autowired 
	private PharmacyRepository pharmacyRepository;
	
	
	//transport create...........................................................
	@RequestMapping(value = { "{url}/transportCreate" }, method = RequestMethod.GET)
	public ModelAndView createTransport() {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		
        Transport transport=new Transport();
		

		

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("transport",transport);
		modelAndView.setViewName("transport/transportCreate");
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/transportCreate" }, method = RequestMethod.POST)
	public ModelAndView createTransport( @Valid Transport transport, BindingResult bindingResult,
			ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			transportService.saveTransport(transport);
			modelAndView.addObject("successMessage", "Transport created successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("transport", new Transport());
		modelAndView.setViewName("transport/transportCreate");
		return modelAndView;
	}
	
	//find tranport list................................
	
	@RequestMapping(value = { "{url}/transportList" }, method = RequestMethod.GET)
	public ModelAndView displayAlltransport() {
		ModelAndView mv = new ModelAndView();
		List transportList = transportService.getAllTransport();
		int length = transportList.size();

		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();

		mv.addObject("transportList", transportList);
		mv.addObject("length", length);
		mv.addObject("role", roles);
		mv.setViewName("transport/transportList");
		return mv;
	}
	
	//Edit transport list...........................................
	@RequestMapping(value = { "{url}/transportList/transportEdit/{id}" }, method = RequestMethod.GET)
	public ModelAndView EditTransport(@PathVariable int id) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		
        Transport transport=(Transport)transportRepository.findById(id);
		

		

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("transport",transport);
		modelAndView.setViewName("transport/transportEdit");
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/transportList/transportEdit/{id}" }, method = RequestMethod.POST)
	public ModelAndView EditTransport(@PathVariable int id, @Valid Transport transport, BindingResult bindingResult,
			ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			transportService.saveTransport(transport);
			modelAndView.addObject("successMessage", "Transport edited successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("transport", new Transport());
		modelAndView.setViewName("transport/transportEdit");
		return modelAndView;
	}
	
	/////////pharmacy create medicine................
	
	@RequestMapping(value = { "{url}/pharmacyCreate" }, method = RequestMethod.GET)
	public ModelAndView createMedicine() {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		String email = auth.getName();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		
        Pharmacy pharmacy=new Pharmacy();
		

		

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pharmacy",pharmacy);
		modelAndView.setViewName("pharmacy/pharmacyCreate");
		modelAndView.addObject("role", roles);
		return modelAndView;
	}

	@RequestMapping(value = { "{url}/pharmacyCreate" }, method = RequestMethod.POST)
	public ModelAndView createMedicine( @Valid Pharmacy pharmacy, BindingResult bindingResult,
			ModelMap modelMap) {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		} else {

			pharmacyService.saveMedicine(pharmacy);
			modelAndView.addObject("successMessage", "Medicine added successfully");
		}
		modelAndView.addObject("role", roles);
		modelAndView.addObject("pharmacy",new Pharmacy());
		modelAndView.setViewName("pharmacy/pharmacyCreate");
		return modelAndView;
	}
	
	///////medicine list
	//find tranport list................................
	
		@RequestMapping(value = { "{url}/pharmacyList" }, method = RequestMethod.GET)
		public ModelAndView displayAllMedicine() {
			ModelAndView mv = new ModelAndView();
			List medicineList = pharmacyService.getAllMedicine();
			int length = medicineList.size();

			Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;

			Collection<? extends GrantedAuthority> role = auth.getAuthorities();
			String roles = role.toString();

			mv.addObject("medicineList", medicineList);
			mv.addObject("length", length);
			mv.addObject("role", roles);
			mv.setViewName("pharmacy/pharmacyList");
			return mv;
		}
		
		//Edit pharmacy info..........................
		@RequestMapping(value = { "{url}/pharmacyList/pharmacyEdit/{id}" }, method = RequestMethod.GET)
		public ModelAndView editMedicine(@PathVariable int id) {
			Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
			String email = auth.getName();
			Collection<? extends GrantedAuthority> role = auth.getAuthorities();
			String roles = role.toString();
			
	        Pharmacy pharmacy=pharmacyRepository.findById(id);
			

			

			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("pharmacy",pharmacy);
			modelAndView.setViewName("pharmacy/pharmacyEdit");
			modelAndView.addObject("role", roles);
			return modelAndView;
		}

		@RequestMapping(value = { "{url}/pharmacyList/pharmacyEdit/{id}"}, method = RequestMethod.POST)
		public ModelAndView editMedicine(@PathVariable int id, @Valid Pharmacy pharmacy, BindingResult bindingResult,
				ModelMap modelMap) {
			Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
			Collection<? extends GrantedAuthority> role = auth.getAuthorities();
			String roles = role.toString();
			ModelAndView modelAndView = new ModelAndView();
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("errorMessage", "please correct the errors in form");
				modelMap.addAttribute("bindingResult", bindingResult);
			} else {

				pharmacyService.saveMedicine(pharmacy);
				modelAndView.addObject("successMessage", "Medicine edited successfully");
			}
			modelAndView.addObject("role", roles);
			modelAndView.addObject("pharmacy",new Pharmacy());
			modelAndView.setViewName("pharmacy/pharmacyEdit");
			return modelAndView;
		}
	
}
