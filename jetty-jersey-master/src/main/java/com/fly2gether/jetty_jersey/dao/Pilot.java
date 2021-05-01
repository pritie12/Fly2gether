package com.fly2gether.jetty_jersey.dao;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Pilot extends User{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
	private Long pilot_id;

	private int flyingHours;
	
	/* CONSTRUCTORS */
	public Pilot() {
		super();
		this.flyingHours=0;
		pilot_id=(long) 0;
	}
	
	public Pilot(String name, String surname, String email, String phoneNumber, Date DOfBirth, int flyingHours) {
		super(name,surname,email,phoneNumber,DOfBirth);
		this.flyingHours=flyingHours;
		pilot_id=(long) 0;
	}
	
	/* GETTERS */
	public Long getPilotId() {
		return this.pilot_id;
	}
	public int getFlyingHours() {
		return this.flyingHours;
	}
	
	/* SETTERS */
	public void setPilotId(Long pilot_id) {
		this.pilot_id=pilot_id;
	}
	public void setFlyingHours(int flyingHours) {
		this.flyingHours=flyingHours;
	}
	public void display() {
		System.out.println("Pilot  "+this.getName()+" "+this.getSurname());
	}
}
