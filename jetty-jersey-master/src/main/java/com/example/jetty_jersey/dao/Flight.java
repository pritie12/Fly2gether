package com.example.jetty_jersey.dao;
import java.util.Date;
import java.util.List;

import com.example.jetty_jersey.dao.Aircraft;

public class Flight {
	
	public String id;
	
	public String appointmentDescription;
	
	public Date departureDateTime;
	public String departureAirport;
	
	public Date arrivalDateTime;
	public String arrivalAirport;// Location 
	
	public int availablesSeats;
	public double price; // by seats
	public List<Passenger> passengers;
	public Pilote pilot;
	public Aircraft aircraft;
		
	
}
