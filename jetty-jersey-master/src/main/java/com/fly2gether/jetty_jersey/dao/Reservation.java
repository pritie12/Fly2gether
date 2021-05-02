package com.fly2gether.jetty_jersey.dao;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reservation {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private Long resa_id;
	@Persistent
	private Long bookingUser;
	@Persistent
	private Long flight;
	private int desiredSeats;
	private boolean status;
	
	/* CONSTRUCTORS */
	public Reservation() {
		this.resa_id=(long) 0;
		this.bookingUser=(long) 0;
		this.flight=(long) 0;
		this.desiredSeats=0;
		this.status=true;
				
	}
	public Reservation(Long passenger1, Long flight, int desiredSeats) {
		this.bookingUser=passenger1;
		this.flight=flight;
		this.desiredSeats=desiredSeats;
		this.setStatus(true);
	}
	
	/* GETTERS */
	public Long getBookingUser() {
		return this.bookingUser;
	}
	public Long getReservationId() {
		return this.resa_id;
	}
	public Long getFlight() {
		return this.flight;
	}
	public int getDesiredSeats() {
		return this.desiredSeats;
	}
	public boolean getStatus() {
		return this.status;
	}
	
	/* SETTERS */
	public void setBookingUser(Long bookingUser) {
		this.bookingUser=bookingUser;
	}
	public void setReservationId(Long resa_id) {
		this.resa_id=resa_id;
	}
	public void setFlight(Long flight) {
		this.flight=flight;
	}
	public void setDesiredSeats(int desiredSeats) {
		this.desiredSeats=desiredSeats;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	/* DISPLAY */
	public void display() {
		System.out.println("Reservation made by passenger n° "+this.getBookingUser()+" in flight n°"+this.flight+" for "+this.desiredSeats+" seats");
	}
}
