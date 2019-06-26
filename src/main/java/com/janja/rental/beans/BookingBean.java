package com.janja.rental.beans;

public class BookingBean {
	
	private String name;
	
	private int age;
	
	private String phoneNum;
	
	private String eMail;
	
	private int category;
	
	private int pickupOffice;
	
	private int dropoffOffice;
	
	private String pickupdate;
	
	private String dropoffdate;
	
	private int status;
	
	private double totalPrice;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getPickupOffice() {
		return pickupOffice;
	}

	public void setPickupOffice(int pickupOffice) {
		this.pickupOffice = pickupOffice;
	}

	public int getDropoffOffice() {
		return dropoffOffice;
	}

	public void setDropoffOffice(int dropoffOffice) {
		this.dropoffOffice = dropoffOffice;
	}

	public String getPickupdate() {
		return pickupdate;
	}

	public void setPickupdate(String pickupdate) {
		this.pickupdate = pickupdate;
	}

	public String getDropoffdate() {
		return dropoffdate;
	}

	public void setDropoffdate(String dropoffdate) {
		this.dropoffdate = dropoffdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	} 
	
	
}
