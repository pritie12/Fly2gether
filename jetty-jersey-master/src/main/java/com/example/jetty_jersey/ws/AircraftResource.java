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



@Path("/Aircraft")
public class AircraftResource {
	DAO daoaircraft;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public List<Object> getDetailsofAircraft(Aircraft aircraft, @PathParam("id") String id) {
		List<Object> fleet= new ArrayList<Object>();
		fleet.add(daoaircraft.getTailNumber(aircraft));
		fleet.add(daoaircraft.getNumberOfSeats(aircraft));
		fleet.add(daoaircraft.getModel(aircraft));
		fleet.add(daoaircraft.getCompany(aircraft));
		fleet.add(daoaircraft.getFlyingHours(aircraft));
		return fleet;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void retrieveDetailAircraft (Aircraft aircraft, @PathParam("id") String id) { 
		List<Object> fleet= new ArrayList<Object>();
		fleet.add(daoaircraft.getTailNumber(aircraft));
		fleet.add(daoaircraft.getNumberOfSeats(aircraft));
		fleet.add(daoaircraft.getModel(aircraft));
		fleet.add(daoaircraft.getCompany(aircraft));
		fleet.add(daoaircraft.getFlyingHours(aircraft));
		System.out.println(daoaircraft.getTailNumber(aircraft));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/aircraft")
	public void retrieveAircraft(Aircraft aircraft) {
		System.out.println(daoaircraft.getTailNumber(aircraft));

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aircraft")
	public void putAircraft(Aircraft aircraft) {
		System.out.println(daoaircraft.getTailNumber(aircraft));

	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/aircraft")
	public void deleteAircraft(Aircraft aircraft) {
		aircraft.tailNumber="";
		System.out.println("Aircraft deleted");
	}
	
}