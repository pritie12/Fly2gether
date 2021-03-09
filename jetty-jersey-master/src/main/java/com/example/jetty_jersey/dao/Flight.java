package com.example.jetty_jersey.dao;
import java.util.Date;
import java.util.List;



public class Flight {
	
	 String id;
	
	 String appointmentDescription;
	
	 Date departureDateTime;
	 String departureAirport;
	
	 Date arrivalDateTime;
	 String arrivalAirport;// Location 
	
	 int availablesSeats;
	 int price; // by seats
	 List<Passenger> passengers;
	 Pilote pilot;
	 Aircraft aircraft;
		
	
}
