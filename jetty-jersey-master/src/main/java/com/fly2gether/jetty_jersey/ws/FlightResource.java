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


@Path("/Flight")
public class FlightResource  implements flightDao {

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPilot")
	public Pilot getPilot(@PathParam("id")int id) {
		return DAO.getFlightDao().getPilot(id);		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAircraft")
	public Aircraft getAircraft(@PathParam("id")int id) {
		return DAO.getFlightDao().getAircraft(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPrice")
	public int getPrice(@PathParam("id")int id) {
		return DAO.getFlightDao().getPrice(id);		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPassengers")
	public List<Integer> getPassengers(@PathParam("id")int id) {
		return DAO.getFlightDao().getPassengers(id);		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAvailableSeats")
	public int getAvailableSeats(@PathParam("id")int id) {
		return DAO.getFlightDao().getAvailableSeats(id);		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAppointmentDescription")
	public String getAppointmentDescription(@PathParam("id")int id) {
		return DAO.getFlightDao().getAppointmentDescription(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureDate")
	public Date getdepartureDate(@PathParam("id")int id) {
		return DAO.getFlightDao().getdepartureDate(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureTime")
	public LocalDateTime getdepartureTime(@PathParam("id")int id) {
		return DAO.getFlightDao().getdepartureTime(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureAirport")
	public String getdepartureAirport(@PathParam("id")int id) {
		return DAO.getFlightDao().getdepartureAirport(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalDate")
	public Date getarrivalDate(@PathParam("id")int id) {
		return DAO.getFlightDao().getarrivalDate(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalTime")
	public LocalDateTime getarrivalTime(@PathParam("id")int id) {
		return DAO.getFlightDao().getarrivalTime(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalAirport")
	public String getarrivalAirport(@PathParam("id")int id) {
		return DAO.getFlightDao().getarrivalAirport(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDuration")
	public Duration getFlightDuration(@PathParam("id")int id) {
		return DAO.getFlightDao().getFlightDuration(id);	
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlights")
	public List<Flight> getFlights() {
		return DAO.getFlightDao().getFlights();	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByPrice")
	public List<Flight> getFlights(@PathParam("maxprice")int maxprice,@PathParam("minprice")int minprice) {
		return DAO.getFlightDao().getFlights(maxprice,minprice);	
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
	public void addPassenger(@PathParam("passenger_id")int passenger_id,@PathParam("flight_id") int flight_id) {
		DAO.getFlightDao().addPassenger(passenger_id,flight_id);
		
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{flight_id}/deleteFlight")
	public void deleteFlight(@PathParam("flight_id")int flight_id) {
		DAO.getFlightDao().deleteFlight(flight_id);		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/{resa_id}/getFlightsBySeats")
	public void removePassenger(@PathParam("passenger_id")int passenger_id, @PathParam("flight_id")int flight_id) {
		DAO.getFlightDao().removePassenger(passenger_id, flight_id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setPilot")
	public void setPilot(@PathParam("id")int id, Pilot Pilot) {
		DAO.getFlightDao().setPilot(id,Pilot);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setAircraft")
	public void setAircraft(@PathParam("id")int id, Aircraft Aircraft) {
		DAO.getFlightDao().setAircraft(id,Aircraft);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setPrice")
	public void setPrice(@PathParam("id")int id, int Price) {
		DAO.getFlightDao().setPrice(id,Price);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setPassengers")
	public void setPassengers(@PathParam("id")int id, List<Integer> Passengers) {
		DAO.getFlightDao().setPassengers(id,Passengers);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setAvailableSeats")
	public void setAvailableSeats(@PathParam("id")int id, int AvailableSeats) {
		DAO.getFlightDao().setAvailableSeats(id,AvailableSeats);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setAppointmentDescription")
	public void setAppointmentDescription(@PathParam("id")int id, String AppointmentDescription) {
		DAO.getFlightDao().setAppointmentDescription(id,AppointmentDescription);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setdepartureDate")
	public void setdepartureDate(@PathParam("id")int id, Date DepartureDate) {
		DAO.getFlightDao().setdepartureDate(id,DepartureDate);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setarrivalDate")
	public void setarrivalDate(@PathParam("id")int id, Date ArrivalDate) {
		DAO.getFlightDao().setarrivalDate(id,ArrivalDate);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setFlightDuration")
	public void setFlightDuration(@PathParam("id")int id, Duration FlightDuration) {
		DAO.getFlightDao().setFlightDuration(id,FlightDuration);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/modifyFlight")
	public void modifyFlight(@PathParam("id")int id, @PathParam("DepartureTime")String DepartureTime, 
			@PathParam("DepartureAirport")String DepartureAirport, @PathParam("ArrivalTime")String ArrivalTime,
			@PathParam("ArrivalAirport")String ArrivalAirport) {
		
		DAO.getFlightDao().modifyFlight(id,DepartureTime,DepartureAirport,ArrivalTime,ArrivalAirport);		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByDeparture")
	public List<Flight> getFlights(@PathParam("DepartureMin")String DepartureMin,@PathParam("DepartureMax")String DepartureMax, @PathParam("DepartureAirport")String DepartureAirport) {
		return DAO.getFlightDao().getFlights(DepartureMin,DepartureMax,DepartureAirport);
	}

}
