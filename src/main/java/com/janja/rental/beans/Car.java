package com.janja.rental.beans;

import org.springframework.stereotype.Component;

@Component
public class Car {
	
	public String carModel;
	
	public String carclass;
	
	public String categoryDesc;
	
	public String manufacturer;
	
	public String status;
	
	public String regNumber;
	
	public int doors;
	
	public int seats;
	
	public int volume;
	
	public int power;
	
	public String city;
	
	public String fuelType;
	
	public String transmission;
	
	public String getModel() {
		return carModel;
	}

	public void setModel(String model) {
		this.carModel = model;
	}

	public String getCarclass() {
		return carclass;
	}

	public void setCarclass(String carclass) {
		this.carclass = carclass;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	
	
}
