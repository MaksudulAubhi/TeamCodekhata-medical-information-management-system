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

import com.example.demo.model.Doctor;
import com.example.demo.model.Ward;
import com.example.demo.repository.WardRepository;
import com.example.demo.service.WardService;


@Controller
public class WardController {
	
	@Autowired
	WardService wardService;
	
	@Autowired
	WardRepository wardRepository;
	
	@RequestMapping(value = { "{url}/wardInfoAdd" }, method = RequestMethod.GET)
	public ModelAndView WardRegPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("receptionist/wardInfoAdd");
		modelAndView.addObject("ward",new Ward());
		return modelAndView;
	}

	@RequestMapping(value = "{url}/wardInfoAdd", method = RequestMethod.POST)
	public ModelAndView WardRegister(@Valid Ward ward, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("errorMessage", "please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
		
		} else {
			wardService.saveWard(ward);
			modelAndView.addObject("successMessage", "Information updated successfully");
		}
		
		modelAndView.addObject("ward", new Ward());
		modelAndView.setViewName("receptionist/wardInfoAdd");
		return modelAndView;
	}
    
	@RequestMapping(value= "{url}/wardList", method=RequestMethod.GET)
	public ModelAndView displayAllWard() {
		Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
		Collection<? extends GrantedAuthority> role = auth.getAuthorities();
		String roles = role.toString();
		
		ModelAndView mv=new ModelAndView();
		List wardList=wardService.getAllWards();
        int length=wardList.size();
       
		mv.addObject("length",length);
		mv.addObject("role",roles);
		mv.addObject("wardList",wardList);
		mv.setViewName("receptionist/wardList");
		return mv;
	}
	
	
	//Edit ward information......................................
			@RequestMapping(value = { "{url}/wardList/editWard/{id}" }, method = RequestMethod.GET)
			public ModelAndView wardEditPage(@PathVariable int id) {
				Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
				Collection<? extends GrantedAuthority> role = auth.getAuthorities();
				String roles = role.toString();
				
				ModelAndView modelAndView = new ModelAndView();
				Ward ward=wardRepository.findById(id);
				modelAndView.setViewName("receptionist/wardInfoUpdate");
				modelAndView.addObject("ward",ward);
				modelAndView.addObject("role",roles);
				return modelAndView;
			}

			@RequestMapping(value = "{url}/wardList/editWard/{id}", method = RequestMethod.POST)
			public ModelAndView doctorEdit(@Valid Ward ward, BindingResult bindingResult, ModelMap modelMap) {
				Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication(); // For find role;
				Collection<? extends GrantedAuthority> role = auth.getAuthorities();
				String roles = role.toString();
				
				ModelAndView modelAndView = new ModelAndView();
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("errorMessage", "please correct the errors in form");
					modelMap.addAttribute("bindingResult", bindingResult);
				}
				else {
					wardService.saveWard(ward);
					modelAndView.addObject("successMessage", "Ward information updated successfully");
					
				}
				
				modelAndView.addObject("role", roles);
				modelAndView.addObject("ward", new Ward());
				modelAndView.setViewName("receptionist/wardInfoUpdate");
				return modelAndView;
			}
}
