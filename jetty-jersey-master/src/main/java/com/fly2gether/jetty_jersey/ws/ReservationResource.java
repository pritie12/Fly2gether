package com.fly2gether.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fly2gether.jetty_jersey.dao.Flight;
import com.fly2gether.jetty_jersey.dao.Passenger;
import com.fly2gether.jetty_jersey.dao.Reservation;
import com.fly2gether.jetty_jersey.dao.reservationDao;
import com.fly2gether.jetty_jersey.database.Database;

public class ReservationResource implements reservationDao {

	List<Reservation> reservations=new Database("test").getTotalReservations();

		
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getbookingUser")
	public List<Reservation> getReservations(){
		return reservations;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{Resa_ID}/getbookingUser")
	public Passenger getbookingUser(@PathParam("Resa_ID")String resa_id) {
		for(Reservation r:reservations) {
			if(r.getReservationId().equals(resa_id)) {
				return r.getBookingUser();
			}
		}
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{Resa_ID}/getdesiredSeats")
	public int getdesiredSeats(@PathParam("Resa_ID")String resa_id) {
		for(Reservation r:reservations) {
			if(r.getReservationId().equals(resa_id)) {
				return r.getDesiredSeats();
			}
		}
		return 0;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{Resa_ID}/getFlight")
	public Flight getFlight(@PathParam("Resa_ID")String resa_id) {
		for(Reservation r:reservations) {
			if(r.getReservationId().equals(resa_id)) {
				return r.getFlight();
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/getFlight")
	public List<String> getReservations(@PathParam("passenger_id")String passenger_id) {
		for(Passenger p:Database.getTotalPassengers()) {
			if(p.getPassengerId().equals(passenger_id)){
				return p.getPassengerBookingList();
			}
		}
		return null;
	}

	public void changeNumberOfSeats(int seats) {
		// TODO Auto-generated method stub
		
	}

}
