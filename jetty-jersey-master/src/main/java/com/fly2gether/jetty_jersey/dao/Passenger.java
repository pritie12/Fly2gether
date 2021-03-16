package com.fly2gether.jetty_jersey.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Passenger extends User {
	private String passenger_id;
	
	private List<Reservation> passengerBookingList;
	
	/* CONSTRUCTORS */
	public Passenger() {
		super();
		this.passenger_id="";
		this.passengerBookingList=new ArrayList<Reservation>();
	}
	
	public Passenger(String name, String surname, String email, String phoneNumber, Date DOfBirth) {
		super(name,surname,email,phoneNumber,DOfBirth);
	}
	
	/* GETTERS */
	public String getPassengerId() {
		return this.passenger_id;
	}
	public List<Reservation> getPassengerBookingList(){
		return this.passengerBookingList;
	}
	
	/* SETTERS */
	public void setPassengerId(String passenger_id) {
		this.passenger_id=passenger_id;
	}
	public void setPassengerBookingList(List<Reservation> passengerBookingList){
		this.passengerBookingList=passengerBookingList;
	}
}
