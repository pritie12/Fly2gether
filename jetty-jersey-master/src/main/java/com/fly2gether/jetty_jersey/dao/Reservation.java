package com.fly2gether.jetty_jersey.dao;


public class Reservation {
	
	private String resa_id;
	private Passenger bookingUser;
	private Flight flight;
	private int desiredSeats;
	
	/* CONSTRUCTORS */
	public Reservation() {
		this.resa_id="";
		this.bookingUser=new Passenger();
		this.flight=new Flight();
		this.desiredSeats=0;
				
	}
	public Reservation(Passenger bookingUser, Flight flight, int desiredSeats) {
		this.bookingUser=bookingUser;
		this.flight=flight;
		this.desiredSeats=desiredSeats;
	}
	
	/* GETTERS */
	Passenger getBookingUser() {
		return this.bookingUser;
	}
	String getReservationId() {
		return this.resa_id;
	}
	Flight getFlight() {
		return this.flight;
	}
	int getDesiredSeats() {
		return this.desiredSeats;
	}
	
	/* SETTERS */
	void setBookingUser(Passenger bookingUser) {
		this.bookingUser=bookingUser;
	}
	void setReservationId(String resa_id) {
		this.resa_id=resa_id;
	}
	void setFlight(Flight flight) {
		this.flight=flight;
	}
	void setDesiredSeats(int desiredSeats) {
		this.desiredSeats=desiredSeats;
	}
}
