package com.example.jetty_jersey.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Flight {
	
	 private String id;	
	 private String appointmentDescription;	
	 private Date departureDateTime;
	 private String departureAirport;	
	 private Date arrivalDateTime;
	 private String arrivalAirport;	
	 private int availablesSeats;
	 private int price; 
	 private List<Passenger> passengers;
	 private Pilot pilot;
	 private Aircraft aircraft;
	 
	 public Flight() {
		 this.appointmentDescription="";
		 this.departureDateTime=new Date();
		 this.departureAirport="";
		 this.arrivalDateTime=new Date();
		 this.arrivalAirport="";
		 this.availablesSeats=0;
		 this.price=0;
		 this.passengers=new ArrayList<Passenger>();
		 this.pilot= new Pilot();
		 this.aircraft=new Aircraft();
	 }
		
	
}
