package com.fly2gether.jetty_jersey.dao;
import java.util.Date;

public abstract class User {

	private String name;
	private String surname;
	private Date dateOfBirth;
	private String email;
	private String phoneNumber;
	
	/* CONSTRUCTORS */
	public User() {
		this.name="";
		this.surname="";
		this.email="";
		this.phoneNumber="";
		this.dateOfBirth=new Date();
	}
	public User(String name, String surname, String email, String phoneNumber, Date DOfBirth) {
		this.name=name;
		this.surname=surname;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.dateOfBirth=DOfBirth;
	}
	
	/* GETTERS */
	
	public String getName() {
		return this.name;
	}
	public String getSurname() {
		return this.surname;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	/* SETTERS */
	
	public void setName(String name) {
		this.name=name;
	}
	public void setSurname(String surname) {
		this.surname=surname;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth=dateOfBirth;
	}
	
}
