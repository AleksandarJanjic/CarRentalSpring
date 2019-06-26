package com.janja.rental.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.janja.rental.beans.BookingInfoBean;
import com.janja.rental.beans.Price;
import com.janja.rental.beans.PriceCalculationBean;
import com.janja.rental.data.BookingData;

@Service
public class BookingService {
	
	@Autowired
	BookingData bookingData;
	
	public BookingInfoBean getInfo() {
		BookingInfoBean result = bookingData.getData();
		return result;
	}
	
	public double getTotalPrice(PriceCalculationBean clb) {
		List<Price> prices = new ArrayList<Price>();
		prices = bookingData.getPriceData();
		double result = 0;
		double dailyPrice = 0;
		for(Price p:prices) {
			if(clb.getCategory().equalsIgnoreCase(p.getCategory()) && (clb.getNumDays() >= p.getDaysFrom() && clb.getNumDays() <= p.getDaysTo())) {
				dailyPrice = p.getDailyPrice();
			}
		}
		result = clb.getNumDays() * dailyPrice;
		return result;
	}
	
	public String reformatDate(String date) {
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		String day = date.substring(8, 10);
		String hour = date.substring(11, 13);
		String minutes = date.substring(14, 16);
		StringBuilder sb = new StringBuilder();
		sb.append(year);
		sb.append("-");
		sb.append(month);
		sb.append("-");
		sb.append(day);
		sb.append(" ");
		sb.append(hour);
		sb.append(":");
		sb.append(minutes);
		sb.append(":00");
		String result = sb.toString();
		return result;
	}
	
	public int officeToInt(String office) {
		int result = 0;
		switch(office) {
		case "Belgrade Airport, Belgrade": 
			result = 1;
			break;
		case "Belgrade Terazije, Belgrade":
			result = 2;
			break;
		case "Novi Sad Center, Novi Sad":
			result = 3;
			break;
		case "Subotica West, Subotica":
			result = 4;
			break;
		case "London Heathrow, London":
			result = 5;
			break;
		case "London Stansted, London":
			result = 6;
			break;
		case "London City, London":
			result = 7;
			break;
		case "Manchester City, Manchester":
			result = 8;
			break;
		}
		return result;
	}
	
	public int categoryToInt(String cat) {
		int result = 0;
		switch(cat) {
		case "A":
			result = 1;
			break;
		case "B":
			result = 2;
			break;
		case "C":
			result = 3;
			break;
		case "D":
			result = 4;
			break;
		case "E":
			result = 5;
			break;
		case "F":
			result = 6;
			break;
		}
		return result;
	}
}
