package com.example.jetty_jersey.ws;
import java.util.ArrayList;
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
	@Path("/{id}")
	public List<Object> getDetailsofflight(Flight flight, @PathParam("id") String id) {
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
		return fleet;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response retrieveDetailflight (Flight flight, @PathParam("id") String id) { 
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
	@Path("/flight")
	public Response retrieveflight(Flight flight) {
		System.out.println(daoflight.getId(flight));
		return Response.ok().build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/flight")
	public Response putflight(Flight flight) {
		System.out.println(daoflight.getId(flight));
		return Response.ok().build();
	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/flight")
	public void deleteflight(Flight flight) {
		flight.id="";
		System.out.println("Flight deleted");
	}
}
