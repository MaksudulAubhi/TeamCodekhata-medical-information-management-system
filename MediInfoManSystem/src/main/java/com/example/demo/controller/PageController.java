package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	// admin custom page open mapping

	@RequestMapping(value = { "/adminPage" }, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/adminPage");
		return modelAndView;
	}

	// doctor custom page open mapping

	@RequestMapping(value = { "/doctorPage" }, method = RequestMethod.GET)
	public ModelAndView doctorPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("doctor/doctorPage");
		return modelAndView;
	}

	// Receptionist page open mapping

	@RequestMapping(value = { "/receptionistPage" }, method = RequestMethod.GET)
	public ModelAndView receptionPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("receptionist/receptionistPage");
		return modelAndView;
	}

	// Nurse page open mapping

	@RequestMapping(value = { "/nursePage" }, method = RequestMethod.GET)
	public ModelAndView nursePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("nurse/nursePage");
		return modelAndView;
	}

	// Lab page open mapping

	@RequestMapping(value = { "/labPage" }, method = RequestMethod.GET)
	public ModelAndView labPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("lab/labPage");
		return modelAndView;
	}

	// officer page open mapping

	@RequestMapping(value = { "/officerPage" }, method = RequestMethod.GET)
	public ModelAndView officerPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("officer/officerPage");
		return modelAndView;
	}

	// head page open mapping

	@RequestMapping(value = { "/headPage" }, method = RequestMethod.GET)
	public ModelAndView headPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("head/headPage");
		return modelAndView;
	}
	// transport page open mapping

		@RequestMapping(value = { "/transportPage" }, method = RequestMethod.GET)
		public ModelAndView transportPage() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("transport/transportPage");
			return modelAndView;
		}
		// officer page open mapping

		@RequestMapping(value = { "/pharmacyPage" }, method = RequestMethod.GET)
		public ModelAndView pharmacyPage() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("pharmacy/pharmacyPage");
			return modelAndView;
		}

}
