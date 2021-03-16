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
	
	String getName() {
		return this.name;
	}
	String getSurname() {
		return this.surname;
	}
	String getEmail() {
		return this.email;
	}
	String getPhoneNumber() {
		return this.phoneNumber;
	}
	Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	/* SETTERS */
	
	void setName(String name) {
		this.name=name;
	}
	void setSurname(String surname) {
		this.surname=surname;
	}
	void setEmail(String email) {
		this.email=email;
	}
	void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth=dateOfBirth;
	}
	
}
