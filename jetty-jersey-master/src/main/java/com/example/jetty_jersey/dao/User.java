package com.example.jetty_jersey.dao;
import java.util.Date;

public abstract class User {

	private String name;
	private String surname;
	private Date dateOfBirth;
	private String email;
	private String phoneNumber;
	
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
}
