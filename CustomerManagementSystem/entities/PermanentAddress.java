package com.CustomerManagementSystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PermanentAddress {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int houseno;
	private String street;
	private String landmark;
	private String city;
	private String state;
	private int pin;

	public PermanentAddress() {
		
	}
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}



	@Override
	public String toString() {
		return "PermanentAddress [houseno=" + houseno + ", street=" + street + ", landmark=" + landmark + ", city="
				+ city + ", state=" + state + ", pin=" + pin + "]";
	}



	public PermanentAddress(int houseno, String street, String landmark, String city, String state, int pin) {
		super();
		this.houseno = houseno;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}
	
	
	
}
