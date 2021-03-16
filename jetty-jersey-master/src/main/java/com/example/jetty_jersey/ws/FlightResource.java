package com.example.jetty_jersey.ws;
import java.util.ArrayList;
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
import javax.ws.rs.core.Response;
import com.example.jetty_jersey.dao.*;



@Path("/Flight")
public class FlightResource {
	DAO daoflight;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightPilot")
	public Pilot getFlightPilot(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getPilot(f);
			}
		}
		return null;		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightAircraft")
	public Pilot getFlightAircraft(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getPilot(f);
			}
		}
		return null;		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightPrice")
	public int getFlightPrice(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getPrice(f);
			}
		}
		return 0;		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightAvailableSeats")
	public int getFlightAvailableSeats(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getAvailableSeats(f);
			}
		}
		return 0;		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightPassengers")
	public List<Passenger> getFlightPassengers(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getPassengers(f);
			}
		}
		return null;		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightDescription")
	public String getFlightDescription(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getAppointmentDescription(f);
			}
		}
		return null;		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightDepartureAirport")
	public String getFlightDepartureAirport(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getdepartureAirport(f);
			}
		}
		return null;		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightdepartureDateTime")
	public Date getFlightdepartureDateTime(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getdepartureDateTime(f);
			}
		}
		return null;		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightarrivalAirport")
	public String getFlightArrivalAirport(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getarrivalAirport(f);
			}
		}
		return null;		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightArrivalDateTime")
	public Date getFlightArrivalDateTime(@PathParam("id")String id) {
		for (Flight f:daoflight.flightList) {
			if(daoflight.getId(f).equals(id)) {
				return daoflight.getarrivalDateTime(f);
			}
		}
		return null;		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByPrice")
	public List<Flight> getFlightsByPrice(@PathParam("maxprice")int maxprice,@PathParam("minprice")int minprice) {
		return ((DAO) daoflight.flightList).getFlights(minprice,maxprice);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByDeparture")
	public List<Flight> getFlightsByDeparture(@PathParam("DepartureTime")Date DepartureTime, @PathParam("DepartureAirport")String DepartureAirport) {
		return ((DAO) daoflight.flightList).getFlights(DepartureTime,DepartureAirport);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByDepartureArrival")
	public List<Flight> getFlightsByDepartureArrival(@PathParam("DepartureTime")Date DepartureTime, @PathParam("DepartureAirport")String DepartureAirport,
			@PathParam("ArrivalTime")Date ArrivalTime, @PathParam("ArrivalAirport")String ArrivalAirport) {
		return ((DAO) daoflight.flightList).getFlights(DepartureTime,DepartureAirport,ArrivalTime,ArrivalAirport);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsBySeats")
	public List<Flight> getFlightsBySeats(@PathParam("seats")int seats) {
		return ((DAO) daoflight.flightList).getFlights(seats);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/flight2")
	public Response retrieveDetailflight (Flight flight) { 
		List<Object> fleet= new ArrayList<Object>();
		fleet.add(daoflight.getAppointmentDescription(flight));
		fleet.add(daoflight.getId(flight));
		fleet.add(daoflight.getdepartureDateTime(flight));
		fleet.add(daoflight.getdepartureAirport(flight));
		fleet.add(daoflight.getarrivalDateTime(flight));
		fleet.add(daoflight.getarrivalAirport(flight));
		fleet.add(daoflight.getPrice(flight));
		fleet.add(daoflight.getPilot(flight));
		fleet.add(daoflight.getAircraft(flight));
		fleet.add(daoflight.getPassengers(flight));
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/flight3")
	public Response retrieveflight(Flight flight) {
		System.out.println(daoflight.getId(flight));
		return Response.ok().build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight4")
	public Response putflight(Flight flight) {
		System.out.println(daoflight.getId(flight));
		return Response.ok().build();
	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/flight5")
	public void deleteflight(Flight flight) {
		System.out.println("Flight deleted");
	}
}
