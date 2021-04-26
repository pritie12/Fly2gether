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

import com.fly2gether.jetty_jersey.dao.*;
import com.fly2gether.jetty_jersey.database.Database;



@Path("/Aircraft")
public class AircraftResource implements aircraftDao{
	List<Aircraft> aircrafts=Database.getFleet();
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraft")
	public Aircraft getAircraft( @PathParam("TailNumber")int TailNumber) {
		return DAO.getAircraftDao().getAircraft(TailNumber);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFleet")
	public List<Aircraft> getFleet() {		
		return DAO.getAircraftDao().getFleet();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraftModel")
	public String getModel(@PathParam("TailNumber")int TailNumber) {
		return DAO.getAircraftDao().getModel(TailNumber);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraftCompany")
	public String getCompany(@PathParam("TailNumber")int TailNumber) {
		return DAO.getAircraftDao().getCompany(TailNumber);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraftNumberOfSeats")
	public int getNumberOfSeats(@PathParam("TailNumber")int TailNumber) {
		return DAO.getAircraftDao().getNumberOfSeats(TailNumber);
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addAircraft")
	public void addAircraft(Aircraft aircraft) {
		DAO.getAircraftDao().addAircraft(aircraft);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/deleteAircraft")
	public void deleteAircraft(int TailNumber) {
		DAO.getAircraftDao().deleteAircraft(TailNumber);		
	}
	
}


