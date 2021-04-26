package com.fly2gether.jetty_jersey.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fly2gether.jetty_jersey.dao.DAO;
import com.fly2gether.jetty_jersey.dao.Flight;
import com.fly2gether.jetty_jersey.dao.Passenger;
import com.fly2gether.jetty_jersey.dao.Reservation;
import com.fly2gether.jetty_jersey.dao.reservationDao;


public class ReservationResource implements reservationDao {


	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getReservations")
	public List<Reservation> getReservations(){
		return DAO.getReservationDao().getReservations();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{Resa_ID}/getbookingUser")
	public Passenger getbookingUser(@PathParam("Resa_ID")int resa_id) {
		return DAO.getReservationDao().getbookingUser(resa_id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{Resa_ID}/getdesiredSeats")
	public int getdesiredSeats(@PathParam("Resa_ID")int resa_id) {
		return DAO.getReservationDao().getdesiredSeats(resa_id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{Resa_ID}/getFlight")
	public Flight getFlight(@PathParam("Resa_ID")int resa_id) {
		return DAO.getReservationDao().getFlight(resa_id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/getFlight")
	public List<Integer> getReservations(@PathParam("passenger_id")int passenger_id) {
		return DAO.getReservationDao().getReservations(passenger_id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{reservation_id}/getReservation")
	public Reservation getReservation(int reservation_id) {	
		return DAO.getReservationDao().getReservation(reservation_id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{reservation_id}/changeNumberOfSeats")
	public void changeNumberOfSeats(int seats,@PathParam("reservation_id")int reservation_id) {
		DAO.getReservationDao().changeNumberOfSeats(seats,reservation_id);		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addReservation")
	public void addReservation(Reservation reservation) {
		DAO.getReservationDao().addReservation(reservation);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/deleteReservation")
	public void deleteReservation(int id) {
		DAO.getReservationDao().deleteReservation(id);		
	}

}
