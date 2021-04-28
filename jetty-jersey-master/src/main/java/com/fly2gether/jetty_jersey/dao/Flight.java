package com.fly2gether.jetty_jersey.dao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Flight {
	
	 private String id;	
	 private String appointmentDescription;	
	 private Date departureDate;
	 private LocalDateTime departureTime;
	 private String departureAirport;	
	 private Date arrivalDate;
	 private LocalDateTime arrivalTime;
	 private String arrivalAirport;	
	 private Duration flightDuration;
	 private int availablesSeats;
	 private int price; 
	 private List<Passenger> passengersList;
	 private Pilot pilot;
	 private Aircraft aircraft;
	 
	 private static int nbFlights=0;// permit to give an unique id
	 
	 /* Constructors */
	 public Flight() {
		 this.appointmentDescription="";
		 this.departureDate=new Date();
		 this.departureAirport="";
		 this.departureTime=LocalDateTime.now();
		 this.arrivalDate=new Date();
		 this.arrivalAirport="";
		 this.arrivalTime=LocalDateTime.now();
		 this.flightDuration=Duration.between(this.departureTime, this.arrivalTime);
		 this.availablesSeats=0;
		 this.price=0;
		 this.passengersList=new ArrayList<Passenger>();
		 this.pilot= new Pilot();
		 this.aircraft=new Aircraft();
		 nbFlights ++;
		 id="FL"+nbFlights;
	 }
	 
	 public Flight(Date departureDate,LocalDateTime departureTime,String departureAirport,Date arrivalDate, LocalDateTime arrivalTime ,
			 String arrivalAirport,int price, Pilot pilot, Aircraft aircraft) {
		 this.appointmentDescription="";
		 this.departureDate=departureDate;
		 this.departureAirport=departureAirport;
		 this.departureTime=departureTime;
		 this.arrivalDate=arrivalDate;
		 this.arrivalAirport="";
		 this.arrivalTime=arrivalTime;
		 this.pilot= pilot;
		 this.aircraft=aircraft;
		 this.flightDuration=Duration.between(this.departureTime, this.arrivalTime);
		 this.availablesSeats=aircraft.getNumberOfSeats();
		 this.price=price;
		 this.passengersList=new ArrayList<Passenger>();
		 nbFlights ++;
		 id="FL"+nbFlights;
	 }
	
	 /* GETTERS */
	 public String getId() {
		 return this.id;
	 }
	 public String getAppointmentDescription() {
		 return this.appointmentDescription;
	 }
	 public Date getDepartureDate() {
		 return this.departureDate;
	 }
	 public Date getArrivalDate() {
		 return this.arrivalDate;
	 }
	 public String getDepartureAirport() {
		 return this.departureAirport;
	 }
	 public String getArrivalAirport() {
		 return this.arrivalAirport;
	 }
	 public LocalDateTime getDepartureTime() {
		 return this.departureTime;
	 }
	 public LocalDateTime getArrivalTime() {
		 return this.arrivalTime;
	 }
	 public Pilot getFlightPilot() {
		 return this.pilot;
	 }
	 public Aircraft getFlightAircraft() {
		 return this.aircraft;
	 }
	 public int getPrice() {
		 return this.price;
	 }
	 public int getAvailableSeats() {
		 return this.availablesSeats;
	 }
	 public List<Passenger> getPassengersList(){
		 return this.passengersList;
	 }
	 public Duration getFlightDuration() {
		 //return Duration.between(this.departureTime,this.arrivalTime);
		 return this.flightDuration;
	 }
	 
	 /* SETTERS */
	 public void setId(String id) {
		 this.id=id;
	 }
	 public void setAppointmentDescription(String appointmentDescription) {
		 this.appointmentDescription=appointmentDescription;
	 }
	 public void setDepartureDate(Date departureDate) {
		 this.departureDate=departureDate;
	 }
	 public void setArrivalDate(Date arrivalDate) {
		 this.arrivalDate=arrivalDate;
	 }
	 public void setDepartureAirport(String departureAirport) {
		 this.departureAirport=departureAirport;
	 }
	 public void setArrivalAirport(String arrivalAirport) {
		 this.arrivalAirport=arrivalAirport;
	 }
	 public void setDepartureTime(LocalDateTime departureTime) {
		 this.departureTime=departureTime;
	 }
	 public void setArrivalTime(LocalDateTime arrivalTime) {
		 this.arrivalTime=arrivalTime;
	 }
	 public void setFlightPilot(Pilot pilot) {
		 this.pilot=pilot;
	 }
	 public void setFlightAircraft(Aircraft aircraft) {
		 this.aircraft=aircraft;
	 }
	 public void setPrice(int price) {
		 this.price=price;
	 }
	 public void setAvailableSeats(int availableSeats) {
		 this.availablesSeats=availableSeats;
	 }
	 public void setPassengersList(List<Passenger> passengersList){
		 this.passengersList=passengersList;
	 }
	 public void setFlightDuration(Duration flightDuration) {
		 this.flightDuration=flightDuration;
	 }
	
}
