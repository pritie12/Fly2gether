package com.fly2gether.jetty_jersey.dao;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Pilot {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long pilot_id;
	
	private String username;
	private String pwd;
	
	private String name;
	private String surname;
	private Date dateOfBirth;
	private String email;
	private String phoneNumber;
	private int flyingHours;
	
	/* CONSTRUCTORS */
	public Pilot() {
		this.flyingHours=0;
		pilot_id=(long) 0;
	}
	
	public Pilot(String name, String surname, String email, String phoneNumber, Date DOfBirth, int flyingHours) {
		//super(name,surname,email,phoneNumber,DOfBirth);
		this.name=name;
		this.surname=surname;
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setDateOfBirth(DOfBirth);
		this.flyingHours=flyingHours;
		this.pilot_id=(long)0;
	}
	
	/* GETTERS */
	public Long getPilotId() {
		return this.pilot_id;
	}
	public int getFlyingHours() {
		return this.flyingHours;
	}
	public String getUsername() {
		return username;
	}
	public String getPwd() {
		return pwd;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	
	/* SETTERS */
	public void setPilotId(Long pilot_id) {
		this.pilot_id=pilot_id;
	}
	public void setFlyingHours(int flyingHours) {
		this.flyingHours=flyingHours;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/* DISPLAY */
	public void display() {
		System.out.println("Pilot  "+this.name+" "+this.surname+", id° :"+this.pilot_id+" username: "+this.username+" pwd: "+this.pwd);
	}

}
