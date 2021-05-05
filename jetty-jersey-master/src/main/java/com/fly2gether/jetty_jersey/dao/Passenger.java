package com.fly2gether.jetty_jersey.dao;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Passenger  {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long passenger_id;
	
	@Persistent(defaultFetchGroup = "true")	
	private List<Long> passengerBookingList; // Id of reservations
	
	private String username;
	private String pwd;
	
	private String name;
	private String surname;
	private Date dateOfBirth;
	private String email;
	private String phoneNumber;	

	
	/* CONSTRUCTORS */
	public Passenger() {
		this.passenger_id=(long) 0;
		this.passengerBookingList=new ArrayList<Long>();
	}
	
	public Passenger(String name, String surname, String email, String phoneNumber, Date DOfBirth) {
		this.name=name;
		this.surname=surname;
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setDateOfBirth(DOfBirth);
		this.passenger_id=(long) 0;
		this.passengerBookingList=new ArrayList<Long>();
	}
	
	/* GETTERS */
	public Long getPassengerId() {
		return this.passenger_id;
	}
	public List<Long> getPassengerBookingList(){
		return this.passengerBookingList;
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
	public void setPassengerId(Long passenger_id) {
		this.passenger_id=passenger_id;
	}
	public void setPassengerBookingList(List<Long> passengerBookingList){
		this.passengerBookingList=passengerBookingList;
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
		System.out.println("Passenger  "+this.getName()+" "+this.getSurname()+" with "+this.passengerBookingList.size()+" reservations");
	}

}
