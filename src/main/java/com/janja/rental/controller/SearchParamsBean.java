package com.janja.rental.controller;

import org.springframework.stereotype.Component;

@Component
public class SearchParamsBean {
	
	private String name;
	
	private String city;
	
	private String carClass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}
	
}
