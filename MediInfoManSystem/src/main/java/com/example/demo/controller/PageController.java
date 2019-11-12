package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	//admin custom page open mapping
	
	@RequestMapping(value= {"/adminPage"},method=RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("admin/adminPage");
		return modelAndView;
	}
	
	//doctor custom page open mapping
	
	@RequestMapping(value= {"/doctorPage"},method=RequestMethod.GET)
	public ModelAndView doctorPage() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("doctor/doctorPage");
		return modelAndView;
	}
	
	//Receptionist page open mapping
	
	@RequestMapping(value= {"/receptionistPage"},method=RequestMethod.GET)
	public ModelAndView receptionPage() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("receptionist/receptionistPage");
		return modelAndView;
	}
	
}
