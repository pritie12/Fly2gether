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
import com.fly2gether.jetty_jersey.dao.Email;
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
	@Path("/{resa_id}/getbookingUser")
	public Long getbookingUser(@PathParam("resa_id")Long resa_id) {
		return DAO.getReservationDao().getbookingUser(resa_id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{resa_id}/getdesiredSeats")
	public int getdesiredSeats(@PathParam("resa_id")Long resa_id) {
		return DAO.getReservationDao().getdesiredSeats(resa_id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{resa_id}/getFlight")
	public Long getFlight(@PathParam("resa_id")Long resa_id) {
		return DAO.getReservationDao().getFlight(resa_id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{resa_id}/getStatus")
	public boolean getStatus(@PathParam("resa_id")Long resa_id) {
		return DAO.getReservationDao().getStatus(resa_id);
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/getFlight")
	public List<Long> getReservations(@PathParam("passenger_id")Long passenger_id) {
		return DAO.getReservationDao().getReservations(passenger_id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{reservation_id}/getReservation")
	public Reservation getReservation(@PathParam("reservation_id")Long reservation_id) {	
		return DAO.getReservationDao().getReservation(reservation_id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{reservation_id}/changeNumberOfSeats")
	public void changeNumberOfSeats(@PathParam("seats")int seats,@PathParam("reservation_id")Long reservation_id) {
		DAO.getReservationDao().changeNumberOfSeats(seats,reservation_id);		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{reservation_id}/denyReservation")
	public void denyReservation(@PathParam("reservation_id")Long reservation_id) {
		Long bookingUser=DAO.getReservationDao().getReservation(reservation_id).getBookingUser();
		new Email(DAO.getPassengerDao().getPassenger(bookingUser).getEmail(),"Reservation denied","Hello,\nWe are sorry to inform you that your reservation has been denied.\nContact us on this address if you have any complaints.\n\nBest regards,\nFly2gether Team");
		DAO.getReservationDao().denyReservation(reservation_id);			
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
	public void deleteReservation(Long id) {
		DAO.getReservationDao().deleteReservation(id);		
	}

}
