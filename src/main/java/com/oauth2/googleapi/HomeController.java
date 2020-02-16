package com.oauth2.googleapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oauth2.googleapi.model.Flights;
import com.oauth2.googleapi.repo.FlightsRepo;

@Controller
public class HomeController {
	
	@Autowired
	FlightsRepo repo;
	
	@RequestMapping("home")
	public String home() 
	{
		return "home";
	}
	
	@RequestMapping("/getFlights")
	public ModelAndView addFlights(String flightNumber) 
	{
		ModelAndView mv = new ModelAndView("showFlights");
		Flights fl = repo.findById(flightNumber).orElse(new Flights());
		mv.addObject(fl);
		
//		System.out.println(repo.findByDepartureAirport("DXB"));
		return mv;
		
	}
	
	@RequestMapping("/login")
	public String loginPage() 
	{
		
		return "login";
	}
	

	@RequestMapping("/logout-success")
	public String logoutPage() 
	{
		
		return "logout";
	}

}
