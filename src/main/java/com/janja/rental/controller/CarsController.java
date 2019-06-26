package com.janja.rental.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.janja.rental.beans.Car;
import com.janja.rental.services.CarsService;

@RestController
public class CarsController {
	
	@Autowired
	CarsService carsService;
	
	@Autowired
	SearchParamsBean searchParam;
	
	@RequestMapping(value="/cars/all", method=RequestMethod.GET)
	public ArrayList<Car> getAllCars(
			@RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String city,
			@RequestParam(defaultValue = "") String carclass
			) {
		SearchParamsBean searchParam = new SearchParamsBean();
		searchParam.setName(name);
		searchParam.setCity(city);
		searchParam.setCarClass(carclass);
		ArrayList<Car> result = carsService.getAllCars(searchParam);
		return result;
	}
}
