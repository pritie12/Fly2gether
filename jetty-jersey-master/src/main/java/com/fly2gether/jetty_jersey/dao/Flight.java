package com.fly2gether.jetty_jersey.dao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Flight {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
	 private Long id;
	
	 private String appointmentDescription;	
	 private Date departureDate;
	 @Persistent
	 private LocalDateTime departureTime;
	 private String departureAirport;	
	 private Date arrivalDate;
	 @Persistent
	 private LocalDateTime arrivalTime;
	 private String arrivalAirport;	
	 private Duration flightDuration;
	 private int availablesSeats;
	 private int price; 
	 @Persistent
	 private List<Long> passengersList;
	 @Persistent
	 private Long id_pilot;
	 @Persistent
	 private Long aircraft_tailnumber;
	 
	 
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
		 this.passengersList=new ArrayList<Long>();
		 this.id_pilot= (long) 0;
		 this.aircraft_tailnumber=(long) 0;

	 }
	 
	 public Flight(Date departureDate,LocalDateTime departureTime,String departureAirport,Date arrivalDate, LocalDateTime arrivalTime ,
			 String arrivalAirport,int availablesSeats, int price, Long pilot, Long aircraft) {
		 this.appointmentDescription="";
		 this.departureDate=departureDate;
		 this.departureAirport=departureAirport;
		 this.departureTime=departureTime;
		 this.arrivalDate=arrivalDate;
		 this.arrivalAirport="";
		 this.arrivalTime=arrivalTime;
		 this.id_pilot= pilot;
		 this.aircraft_tailnumber=aircraft;
		 this.flightDuration=Duration.between(this.departureTime, this.arrivalTime);
		 this.availablesSeats=availablesSeats;
		 this.price=price;
		 this.passengersList=new ArrayList<Long>();

	 }
	
	 /* GETTERS */
	 public Long getId() {
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
	 public Long getFlightPilot() {
		 return this.id_pilot;
	 }
	 public Long getFlightAircraft() {
		 return this.aircraft_tailnumber;
	 }
	 public int getPrice() {
		 return this.price;
	 }
	 public int getAvailableSeats() {
		 return this.availablesSeats;
	 }
	 public List<Long> getPassengersList(){
		 return this.passengersList;
	 }
	 public Duration getFlightDuration() {
		 //return Duration.between(this.departureTime,this.arrivalTime); not possible for now because of jet lag
		 return this.flightDuration;
	 }
	 
	 /* SETTERS */
	 public void setId(Long id) {
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
	 public void setFlightPilot(Long pilot) {
		 this.id_pilot=pilot;
	 }
	 public void setFlightAircraft(Long aircraft) {
		 this.aircraft_tailnumber=aircraft;
	 }
	 public void setPrice(int price) {
		 this.price=price;
	 }
	 public void setAvailableSeats(int availableSeats) {
		 this.availablesSeats=availableSeats;
	 }
	 public void setPassengersList(List<Long> passengersList){
		 this.passengersList=passengersList;
	 }
	 public void setFlightDuration(Duration flightDuration) {
		 this.flightDuration=flightDuration;
	 }
		public void display() {
			System.out.println("Departure from: "+this.departureAirport+" at: "+this.departureTime+" with "+this.id_pilot+" and "+this.availablesSeats+" seats in aircraft: "+this.aircraft_tailnumber);
		}	
}
