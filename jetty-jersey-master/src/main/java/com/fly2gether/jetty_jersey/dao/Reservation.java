package com.fly2gether.jetty_jersey.dao;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reservation {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.NATIVE)
	private int resa_id;
	private Passenger bookingUser;
	private Flight flight;
	private int desiredSeats;
	private boolean status;
	
	/* CONSTRUCTORS */
	public Reservation() {
		this.resa_id=0;
		this.bookingUser=new Passenger();
		this.flight=new Flight();
		this.desiredSeats=0;
		this.status=true;
				
	}
	public Reservation(Passenger bookingUser, Flight flight, int desiredSeats) {
		this.bookingUser=bookingUser;
		this.flight=flight;
		this.desiredSeats=desiredSeats;
		this.setStatus(true);
	}
	
	/* GETTERS */
	public Passenger getBookingUser() {
		return this.bookingUser;
	}
	public int getReservationId() {
		return this.resa_id;
	}
	public Flight getFlight() {
		return this.flight;
	}
	public int getDesiredSeats() {
		return this.desiredSeats;
	}
	public boolean getStatus() {
		return this.status;
	}	
	/* SETTERS */
	public void setBookingUser(Passenger bookingUser) {
		this.bookingUser=bookingUser;
	}
	public void setReservationId(int resa_id) {
		this.resa_id=resa_id;
	}
	public void setFlight(Flight flight) {
		this.flight=flight;
	}
	public void setDesiredSeats(int desiredSeats) {
		this.desiredSeats=desiredSeats;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
