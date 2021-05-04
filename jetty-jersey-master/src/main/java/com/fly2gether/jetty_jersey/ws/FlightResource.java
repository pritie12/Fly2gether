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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.fly2gether.jetty_jersey.dao.*;


@Path("/Flight")
public class FlightResource  implements flightDao {

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlight")
	public Flight getFlight(@PathParam("id")Long id) {
		return DAO.getFlightDao().getFlight(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPilot")
	public Long getPilot(@PathParam("id")Long id) {
		return DAO.getFlightDao().getPilot(id);		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAircraft")
	public Long getAircraft(@PathParam("id")Long id) {
		return DAO.getFlightDao().getAircraft(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPrice")
	public int getPrice(@PathParam("id")Long id) {
		return DAO.getFlightDao().getPrice(id);		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPassengers")
	public List<Long> getPassengersList(@PathParam("id")Long id) {
		return DAO.getFlightDao().getPassengersList(id);		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAvailableSeats")
	public int getAvailableSeats(@PathParam("id")Long id) {
		return DAO.getFlightDao().getAvailableSeats(id);		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAppointmentDescription")
	public String getAppointmentDescription(@PathParam("id")Long id) {
		return DAO.getFlightDao().getAppointmentDescription(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureDate")
	public Date getdepartureDate(@PathParam("id")Long id) {
		return DAO.getFlightDao().getdepartureDate(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureTime")
	public LocalDateTime getdepartureTime(@PathParam("id")Long id) {
		return DAO.getFlightDao().getdepartureTime(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureAirport")
	public String getdepartureAirport(@PathParam("id")Long id) {
		return DAO.getFlightDao().getdepartureAirport(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalDate")
	public Date getarrivalDate(@PathParam("id")Long id) {
		return DAO.getFlightDao().getarrivalDate(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalTime")
	public LocalDateTime getarrivalTime(@PathParam("id")Long id) {
		return DAO.getFlightDao().getarrivalTime(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalAirport")
	public String getarrivalAirport(@PathParam("id")Long id) {
		return DAO.getFlightDao().getarrivalAirport(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDuration")
	public Duration getFlightDuration(@PathParam("id")Long id) {
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
	public List<Flight> getFlights(@QueryParam("maxprice")int maxprice,@QueryParam("minprice")int minprice) {
		return DAO.getFlightDao().getFlights(maxprice,minprice);	
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsBySeats")
	public List<Flight> getFlights(@QueryParam("seats")int seats) {
		return DAO.getFlightDao().getFlights(seats);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/SearchFlight")	
	public List<Flight> SearchFlight(@QueryParam("seats")int seats,@QueryParam("maxprice")int maxprice,@QueryParam("minprice")int minprice,
			@QueryParam("DepartureMin")String DepartureMin,@QueryParam("DepartureMax")String DepartureMax, @QueryParam("DepartureAirport")String DepartureAirport) {
		/*List<Flight> searchBySeats=DAO.getFlightDao().getFlights(seats);
		List<Flight> searchByPrice=DAO.getFlightDao().getFlights(minprice,maxprice);
		List<Flight> searchByDeparture=DAO.getFlightDao().getFlights(DepartureMin,DepartureMax,DepartureAirport);
		List<Flight> finalSearch=new ArrayList<Flight>();
		finalSearch=(List<Flight>) searchBySeats.stream().filter(searchByPrice::contains).filter(searchByDeparture::contains)
				.collect(Collectors.toList());
		return finalSearch;*/
		return DAO.getFlightDao().SearchFlight(seats,maxprice,minprice,DepartureMin,DepartureMax,DepartureAirport);
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
	public void addPassenger(@PathParam("passenger_id")Long passenger_id,@PathParam("flight_id") Long flight_id) {
		DAO.getFlightDao().addPassenger(passenger_id,flight_id);
		
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{flight_id}/deleteFlight")
	public void deleteFlight(@PathParam("flight_id")Long flight_id) {
		DAO.getFlightDao().deleteFlight(flight_id);		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/{resa_id}/getFlightsBySeats")
	public void removePassenger(@PathParam("passenger_id")Long passenger_id, @PathParam("flight_id")Long flight_id) {
		DAO.getFlightDao().removePassenger(passenger_id, flight_id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setPilot")
	public void setPilot(@PathParam("id")Long id,@PathParam("Pilot") Long Pilot) {
		DAO.getFlightDao().setPilot(id,Pilot);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setAircraft")
	public void setAircraft(@PathParam("id")Long id,@PathParam("Aircraft") Long Aircraft) {
		DAO.getFlightDao().setAircraft(id,Aircraft);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setPrice")
	public void setPrice(@PathParam("id")Long id,@PathParam("Price") int Price) {
		DAO.getFlightDao().setPrice(id,Price);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setPassengers")
	public void setPassengers(@PathParam("id")Long id,@PathParam("Passengers") List<Long> Passengers) {
		DAO.getFlightDao().setPassengers(id,Passengers);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setAvailableSeats")
	public void setAvailableSeats(@PathParam("id")Long id,@PathParam("AvailableSeats") int AvailableSeats) {
		DAO.getFlightDao().setAvailableSeats(id,AvailableSeats);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setAppointmentDescription")
	public void setAppointmentDescription(@PathParam("id")Long id,@PathParam("AppointmentDescription") String AppointmentDescription) {
		DAO.getFlightDao().setAppointmentDescription(id,AppointmentDescription);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setdepartureDate")
	public void setdepartureDate(@PathParam("id")Long id, Date DepartureDate) {
		DAO.getFlightDao().setdepartureDate(id,DepartureDate);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setarrivalDate")
	public void setarrivalDate(@PathParam("id")Long id, Date ArrivalDate) {
		DAO.getFlightDao().setarrivalDate(id,ArrivalDate);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setFlightDuration")
	public void setFlightDuration(@PathParam("id")Long id, Duration FlightDuration) {
		DAO.getFlightDao().setFlightDuration(id,FlightDuration);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/modifyFlight")
	public void modifyFlight(@PathParam("id")Long id, @PathParam("DepartureTime")String DepartureTime, 
			@PathParam("DepartureAirport")String DepartureAirport, @PathParam("ArrivalTime")String ArrivalTime,
			@PathParam("ArrivalAirport")String ArrivalAirport) {
		
		DAO.getFlightDao().modifyFlight(id,DepartureTime,DepartureAirport,ArrivalTime,ArrivalAirport);		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByDeparture")
	public List<Flight> getFlights(@QueryParam("DepartureMin")String DepartureMin,
			@QueryParam("DepartureMax")String DepartureMax, @QueryParam("DepartureAirport")String DepartureAirport) {
		return DAO.getFlightDao().getFlights(DepartureMin,DepartureMax,DepartureAirport);
	}


}
