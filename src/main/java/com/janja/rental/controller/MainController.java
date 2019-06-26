package com.janja.rental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping("/cars")
	public String getCars() {
		return "cars";
	}
	
	@RequestMapping("/booking")
	public String getBooking() {
		return "booking";
	}
}
