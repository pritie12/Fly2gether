package com.fly2gether.jetty_jersey.ws;
import java.time.Duration;
import java.time.LocalDateTime;

import java.util.Date;
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


import com.fly2gether.jetty_jersey.dao.*;
import com.fly2gether.jetty_jersey.database.Database;



@Path("/Flight")
public class FlightResource implements flightDao {
	List<Flight> flights=Database.getFlightList();
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPilot")
	public Pilot getPilot(@PathParam("id")String id) {
		return DAO.getFlightDao().getPilot(id);		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAircraft")
	public Aircraft getAircraft(@PathParam("id")String id) {
		return DAO.getFlightDao().getAircraft(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPrice")
	public int getPrice(@PathParam("id")String id) {
		return DAO.getFlightDao().getPrice(id);		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPassengers")
	public List<String> getPassengers(@PathParam("id")String id) {
		return DAO.getFlightDao().getPassengers(id);		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAvailableSeats")
	public int getAvailableSeats(@PathParam("id")String id) {
		return DAO.getFlightDao().getAvailableSeats(id);		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAppointmentDescription")
	public String getAppointmentDescription(@PathParam("id")String id) {
		return DAO.getFlightDao().getAppointmentDescription(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureDate")
	public Date getdepartureDate(@PathParam("id")String id) {
		return DAO.getFlightDao().getdepartureDate(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureTime")
	public LocalDateTime getdepartureTime(@PathParam("id")String id) {
		return DAO.getFlightDao().getdepartureTime(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureAirport")
	public String getdepartureAirport(@PathParam("id")String id) {
		return DAO.getFlightDao().getdepartureAirport(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalDate")
	public Date getarrivalDate(@PathParam("id")String id) {
		return DAO.getFlightDao().getarrivalDate(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalTime")
	public LocalDateTime getarrivalTime(@PathParam("id")String id) {
		return DAO.getFlightDao().getarrivalTime(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalAirport")
	public String getarrivalAirport(@PathParam("id")String id) {
		return DAO.getFlightDao().getarrivalAirport(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDuration")
	public Duration getFlightDuration(@PathParam("id")String id) {
		return DAO.getFlightDao().getFlightDuration(id);	
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByPrice")
	public List<Flight> getFlights(@PathParam("maxprice")int maxprice,@PathParam("minprice")int minprice) {
		return DAO.getFlightDao().getFlights(maxprice,minprice);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByDeparture")
	public List<Flight> getFlights(@PathParam("DepartureTime")Date DepartureTime, @PathParam("DepartureAirport")String DepartureAirport) {
		return DAO.getFlightDao().getFlights(DepartureTime,DepartureAirport);
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsBySeats")
	public List<Flight> getFlights(@PathParam("seats")int seats) {
		return DAO.getFlightDao().getFlights(seats);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addFlight")
	public void addFlight(Flight flight) {
		DAO.getFlightDao().addFlight(flight);	
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{flight_id}/{passenger_id}/addFlight")
	public void addPassenger(@PathParam("passenger_id")String passenger_id,@PathParam("flight_id") String flight_id) {
		DAO.getFlightDao().addPassenger(passenger_id,flight_id);
		
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{flight_id}/deleteFlight")
	public void deleteFlight(@PathParam("flight_id")String flight_id) {
		DAO.getFlightDao().deleteFlight(flight_id);		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/{resa_id}/getFlightsBySeats")
	public void removePassenger(@PathParam("passenger_id")String passenger_id, @PathParam("flight_id")String flight_id) {
		DAO.getFlightDao().removePassenger(passenger_id, flight_id);
	}

}
