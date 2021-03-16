package com.example.jetty_jersey.dao;

import java.util.Date;

public class Pilot extends User{
	private String pilot_id;
	
	private int flyingHours;
	
	public Pilot() {
		super();
		this.flyingHours=0;
	}
	
	public Pilot(String name, String surname, String email, String phoneNumber, Date DOfBirth, int flyingHours) {
		super(name,surname,email,phoneNumber,DOfBirth);
		this.flyingHours=flyingHours;
	}
}
