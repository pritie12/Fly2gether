package com.fly2gether.jetty_jersey.ws;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
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
	


	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/flight5")
	public void deleteflight(Flight flight) {
		System.out.println("Flight deleted");
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPilot")
	public Pilot getPilot(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getFlightPilot();
			}
		}
		return null;	
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAircraft")
	public Aircraft getAircraft(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getFlightAircraft();
			}
		}
		return null;	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPrice")
	public int getPrice(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getPrice();
			}
		}
		return 0;	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPassengers")
	public List<String> getPassengers(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getPassengersList();
			}
		}
		return null;	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAvailableSeats")
	public int getAvailableSeats(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getAvailableSeats();
			}
		}
		return 0;	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAppointmentDescription")
	public String getAppointmentDescription(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getAppointmentDescription();
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureDate")
	public Date getdepartureDate(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getDepartureDate();
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureTime")
	public LocalDateTime getdepartureTime(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getDepartureTime();
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureAirport")
	public String getdepartureAirport(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getDepartureAirport();
			}
		}
		return null;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalDate")
	public Date getarrivalDate(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getArrivalDate();
			}
		}
		return null;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalTime")
	public LocalDateTime getarrivalTime(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getArrivalTime();
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalAirport")
	public String getarrivalAirport(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getDepartureAirport();
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDuration")
	public Duration getFlightDuration(@PathParam("id")String id) {
		for (Flight f:flights) {
			if(f.getId().equals(id)) {
				return f.getFlightDuration();
			}
		}
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByPrice")
	public List<Flight> getFlights(@PathParam("maxprice")int maxprice,@PathParam("minprice")int minprice) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flights) {
				if(f.getPrice()>=minprice&&f.getPrice()<=maxprice)
					fli.add(f);
		}
		return fli;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByDeparture")
	public List<Flight> getFlights(@PathParam("DepartureTime")Date DepartureTime, @PathParam("DepartureAirport")String DepartureAirport) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flights) {
				if(f.getDepartureDate().equals(DepartureTime)&&f.getDepartureAirport().equals(DepartureAirport))
					fli.add(f);
		}
		return fli;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByDepartureArrival")
	public List<Flight> getFlights(@PathParam("DepartureTime")Date DepartureTime, @PathParam("DepartureAirport")String DepartureAirport,
			@PathParam("ArrivalTime")Date ArrivalTime, @PathParam("ArrivalAirport")String ArrivalAirport) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flights) {
				if(f.getDepartureDate().equals(DepartureTime)&&f.getDepartureAirport().equals(DepartureAirport)
						&&f.getArrivalDate().equals(ArrivalTime)&&f.getArrivalAirport().equals(ArrivalAirport))
					fli.add(f);
		}
		return fli;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsBySeats")
	public List<Flight> getFlights(@PathParam("seats")int seats) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flights) {
			if(f.getAvailableSeats()>=seats) {
				fli.add(f);
			}
		}
		return fli;
	}

	public void addFlight(Flight flight) {
		DAO.getFlightDao().addFlight(flight);	
	}

	public void addPassenger(String passenger_id, String flight_id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFlight(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/{resa_id}/getFlightsBySeats")
	public void removePassenger(@PathParam("passenger_id")String passenger_id, @PathParam("flight_id")String flight_id) {
		DAO.getFlightDao().removePassenger(passenger_id, flight_id);
	}



}
