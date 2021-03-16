package com.fly2gether.jetty_jersey.dao;

import java.util.Date;

public class Pilot extends User{
	private String pilot_id;
	
	private int flyingHours;
	
	/* CONSTRUCTORS */
	public Pilot() {
		super();
		this.flyingHours=0;
	}
	
	public Pilot(String name, String surname, String email, String phoneNumber, Date DOfBirth, int flyingHours) {
		super(name,surname,email,phoneNumber,DOfBirth);
		this.flyingHours=flyingHours;
	}
	
	/* GETTERS */
	public String getPilotId() {
		return this.pilot_id;
	}
	public int getFlyingHours() {
		return this.flyingHours;
	}
	
	/* SETTERS */
	public void setPilotId(String pilot_id) {
		this.pilot_id=pilot_id;
	}
	public void setFlyingHours(int flyingHours) {
		this.flyingHours=flyingHours;
	}
}
