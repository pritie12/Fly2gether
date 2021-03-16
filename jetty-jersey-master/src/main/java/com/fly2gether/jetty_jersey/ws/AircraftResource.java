package com.fly2gether.jetty_jersey.ws;
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

import com.fly2gether.jetty_jersey.dao.*;



@Path("/Aircraft")
public class AircraftResource {
	DAO daoaircraft;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraft")
	public Aircraft getAircraft( @PathParam("TailNumber")String TailNumber) {
		System.out.println("getAircraft");
		for(Aircraft a:daoaircraft.fleet) {
			if(daoaircraft.getTailNumber(a).equals(TailNumber)) {
				return a;
				}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFleet")
	public List<Aircraft> getFleet() {		
		return daoaircraft.fleet;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraftCompany")
	public String getAircraftCompany( @PathParam("TailNumber")String TailNumber) {	
		System.out.println("getAircraftCompany");
		for(Aircraft a:daoaircraft.fleet) {
			if(daoaircraft.getTailNumber(a).equals(TailNumber)) {
				return daoaircraft.getCompany(a);
				}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getNbSeats")
	public int getNbSeats(@PathParam("TailNumber")String TailNumber) {	
		System.out.println("getNbSeats");
		for(Aircraft a:daoaircraft.fleet) {
			if(daoaircraft.getTailNumber(a).equals(TailNumber)) {
				return daoaircraft.getNumberOfSeats(a);
				}
		}
		return 0;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraftModel")
	public String getAircraftModel(@PathParam("TailNumber")String TailNumber) {		
		for(Aircraft a:daoaircraft.fleet) {
			if(daoaircraft.getTailNumber(a).equals(TailNumber)) {
				return daoaircraft.getModel(a);
				}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraftFlyingHours")
	public int getAircraftFlyingHours(@PathParam("TailNumber")String TailNumber) {		
		for(Aircraft a:daoaircraft.fleet) {
			if(daoaircraft.getTailNumber(a).equals(TailNumber)) {
				return daoaircraft.getFlyingHours(a);
				}
		}
		return 0;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/retrieveDetailAircraft")
	public void retrieveDetailAircraft (Aircraft aircraft) { 
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
	@Path("/retrieveAircraft")
	public void retrieveAircraft(Aircraft aircraft) {
		System.out.println(daoaircraft.getTailNumber(aircraft));

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/putAircraft")
	public void putAircraft(Aircraft aircraft) {
		System.out.println(daoaircraft.getTailNumber(aircraft));

	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteAircraft")
	public void deleteAircraft(Aircraft aircraft) {
		System.out.println("Aircraft deleted");
	}


}