package com.fly2gether.jetty_jersey.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Passenger extends User {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
	private String passenger_id;
	private List<String> passengerBookingList; // Id of reservations
	
	private static int nbPassengers=0; // permits to give an unique id
	
	/* CONSTRUCTORS */
	public Passenger() {
		super();
		nbPassengers++;
		this.passenger_id="PA"+nbPassengers;
		this.passengerBookingList=new ArrayList<String>();
	}
	
	public Passenger(String name, String surname, String email, String phoneNumber, Date DOfBirth) {
		super(name,surname,email,phoneNumber,DOfBirth);
		nbPassengers++;
		this.passenger_id="PA"+nbPassengers;
	}
	
	/* GETTERS */
	public String getPassengerId() {
		return this.passenger_id;
	}
	public List<String> getPassengerBookingList(){
		return this.passengerBookingList;
	}
	
	/* SETTERS */
	public void setPassengerId(String passenger_id) {
		this.passenger_id=passenger_id;
	}
	public void setPassengerBookingList(List<String> passengerBookingList){
		this.passengerBookingList=passengerBookingList;
	}
}
