package com.example.jetty_jersey.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Passenger extends User {
	private String passenger_id;
	
	private List<Reservation> passengerBookingList;
	
	public Passenger() {
		super();
		this.passenger_id="";
		this.passengerBookingList=new ArrayList<Reservation>();
	}
	
	public Passenger(String name, String surname, String email, String phoneNumber, Date DOfBirth) {
		super(name,surname,email,phoneNumber,DOfBirth);
	}
}
