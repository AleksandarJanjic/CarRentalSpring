package com.janja.rental.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.janja.rental.beans.BookingBean;
import com.janja.rental.beans.BookingInfoBean;
import com.janja.rental.beans.PriceCalculationBean;
import com.janja.rental.data.BookingData;
import com.janja.rental.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	BookingData bookingData;
	
	@RequestMapping(value="/booking/create", method=RequestMethod.POST)
	public String createBooking(
			@RequestParam(defaultValue="") String name,
			@RequestParam(defaultValue="") String phone,
			@RequestParam(defaultValue="") int age,
			@RequestParam(defaultValue="") String email,
			@RequestParam(defaultValue="") String category,
			@RequestParam(defaultValue="") String pickupOffice,
			@RequestParam(defaultValue="") String pickuptime,
			@RequestParam(defaultValue="") String dropoffO,
			@RequestParam(defaultValue="") String dropofftime,
			@RequestParam(defaultValue="") double price
	){
		String pickup = bookingService.reformatDate(pickuptime);
		String dropoff = bookingService.reformatDate(dropofftime);
		int pickupOfficeint = bookingService.officeToInt(pickupOffice);
		int dropoffOffice = bookingService.officeToInt(dropoffO);
		int cat = bookingService.categoryToInt(category);
		System.out.println(pickuptime);
		System.out.println(pickupOffice);
		BookingBean bb = new BookingBean();
		bb.setName(name);
		bb.setPhoneNum(phone);
		bb.setAge(age);
		bb.seteMail(email);
		bb.setPickupdate(pickup);
		bb.setDropoffdate(dropoff);
		bb.setStatus(2);
		bb.setTotalPrice(price);
		bb.setPickupOffice(pickupOfficeint);
		bb.setDropoffOffice(dropoffOffice);
		bb.setCategory(cat);
		String response = bookingData.createBooking(bb);
		return response;
	}
	
	@RequestMapping(value="/booking/info", method=RequestMethod.GET)
	public BookingInfoBean getInfo() {
		BookingInfoBean result = bookingService.getInfo();
		return result;
	}
	
	@RequestMapping(value="/booking/totalPrice", method=RequestMethod.GET)
	public double getTotalPrice(
			@RequestParam(defaultValue="") String category,
			@RequestParam(defaultValue="") int numdays
			) {
		PriceCalculationBean calcBean = new PriceCalculationBean();
		calcBean.setCategory(category);
		calcBean.setNumDays(numdays);
		double result = bookingService.getTotalPrice(calcBean);
		return result;
	}
}
