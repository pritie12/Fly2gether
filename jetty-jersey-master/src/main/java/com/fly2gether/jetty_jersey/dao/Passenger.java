package com.fly2gether.jetty_jersey.dao;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Passenger extends User {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
	private Long passenger_id;
	private List<Long> passengerBookingList; // Id of reservations
	

	
	/* CONSTRUCTORS */
	public Passenger() {
		super();

		this.passenger_id=(long) 0;
		this.passengerBookingList=new ArrayList<Long>();
	}
	
	public Passenger(String name, String surname, String email, String phoneNumber, Date DOfBirth) {
		super(name,surname,email,phoneNumber,DOfBirth);

		this.passenger_id=(long) 0;
	}
	
	/* GETTERS */
	public Long getPassengerId() {
		return this.passenger_id;
	}
	public List<Long> getPassengerBookingList(){
		return this.passengerBookingList;
	}
	
	/* SETTERS */
	public void setPassengerId(Long passenger_id) {
		this.passenger_id=passenger_id;
	}
	public void setPassengerBookingList(List<Long> passengerBookingList){
		this.passengerBookingList=passengerBookingList;
	}
	public void display() {
		System.out.println("Passenger  "+this.getName()+" "+this.getSurname());
	}
}
