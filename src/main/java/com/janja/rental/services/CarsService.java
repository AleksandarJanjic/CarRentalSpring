package com.janja.rental.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janja.rental.beans.Car;
import com.janja.rental.controller.SearchParamsBean;
import com.janja.rental.data.CarsData;

@Service
public class CarsService {
		
	@Autowired
	CarsData staticSQL;
	
	public ArrayList<Car> getAllCars(SearchParamsBean searchParam) {
		ArrayList<Car> list = new ArrayList<Car>();
		String SQL = "select vm.name as model, vmn.name as brand, vc.name as class, vs.status, vc.Description, v.RegNumber, v.doors, v.seats, v.volume, v.power, c.name, ft.FuelType, tt.Name from vehicle v " + 
				" left join vehiclemodel vm on v.modelID=vm.modelID " + 
				" left join vehiclemanufacturer vmn on vm.manufacturerID=vmn.manufacturerID " + 
				" left join vehiclecategory vc on v.categoryID=vc.categoryID " + 
				" left join vehiclestatus vs on v.statusID=vs.statusID " + 
				" left join fueltype ft on v.fueltypeID=ft.fueltypeID " + 
				" left join transmissiontype tt on v.transmissiontypeID=tt.transmissiontypeID " + 
				" left join office o on o.officeID=v.officeID " + 
				" left join city c on o.cityID=c.cityID ";
		
		list = staticSQL.getAllCars(SQL, searchParam);
		return list;
	}
	
}
