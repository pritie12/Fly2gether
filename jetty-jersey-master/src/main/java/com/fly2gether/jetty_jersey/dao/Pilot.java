package com.fly2gether.jetty_jersey.dao;

import java.util.Date;

public class Pilot extends User{
	private String pilot_id;
	private static int nbPilots=0;// permit to give an uniqui id for each pilots
	private int flyingHours;
	
	/* CONSTRUCTORS */
	public Pilot() {
		super();
		this.flyingHours=0;
		nbPilots++;
		pilot_id="PI"+nbPilots;
	}
	
	public Pilot(String name, String surname, String email, String phoneNumber, Date DOfBirth, int flyingHours) {
		super(name,surname,email,phoneNumber,DOfBirth);
		this.flyingHours=flyingHours;
		nbPilots++;
		pilot_id="PI"+nbPilots;
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
