package com.janja.rental.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class BookingInfoBean {
	
	private List<Price> prices;
	
	@Autowired
	private Price price;
	
	private HashMap<String, String> offices;
	
	public void setOffices(String officeName, String location) {
		offices.put(officeName, location);
	}
	
	public HashMap<String, String> getOffices() {
		return offices;
	}
	
	public List<Price> getPrices() {
		return prices;
	}
	
	public void setPrice(String category, double daily, int daysFrom, int daysTo) {
		price = new Price();
		price.setCategory(category);
		price.setDailyPrice(daily);
		price.setDaysFrom(daysFrom);
		price.setDaysTo(daysTo);
		prices.add(price);
	}
	
	public BookingInfoBean() {
		offices = new HashMap<String, String>();
		prices = new ArrayList<Price>();
	}
}
