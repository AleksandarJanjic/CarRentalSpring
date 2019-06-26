package com.janja.rental.beans;

import org.springframework.stereotype.Component;

@Component
public class Price {
	
	private String category;
	
	private double dailyPrice;
	
	private int daysFrom;
	
	private int daysTo;
	
	public void setPrice(String cat, double daily, int from, int to) {
		this.category = cat;
		this.dailyPrice = daily;
		this.daysFrom = from;
		this.daysTo = to;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double daily) {
		this.dailyPrice = daily;
	}

	public int getDaysFrom() {
		return daysFrom;
	}

	public void setDaysFrom(int daysFrom) {
		this.daysFrom = daysFrom;
	}

	public int getDaysTo() {
		return daysTo;
	}

	public void setDaysTo(int daysTo) {
		this.daysTo = daysTo;
	}
	
}
