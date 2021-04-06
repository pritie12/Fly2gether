package com.fly2gether.jetty_jersey.ws;

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



@Path("/Aircraft")
public class AircraftResource implements aircraftDao{
	List<Aircraft> aircrafts=Database.getFleet();
	


	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteAircraft")
	public void deleteAircraft(Aircraft aircraft) {
		System.out.println("Aircraft deleted");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraft")
	public Aircraft getAircraft( @PathParam("TailNumber")String TailNumber) {
		System.out.println("getAircraft");
		for(Aircraft a:aircrafts) {
			if(a.getTailNumber().equals(TailNumber)) {
				return a;
				}
		}
		return null;
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
	public String getModel(@PathParam("TailNumber")String TailNumber) {
		 for(Aircraft a:aircrafts) {
			 if(a.getTailNumber().equals(TailNumber)) {
				 return a.getModel();
			}
		 }
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraftCompany")
	public String getCompany(@PathParam("TailNumber")String TailNumber) {
		 for(Aircraft a:aircrafts) {
			 if(a.getTailNumber().equals(TailNumber)) {
				 return a.getConstructorCompany();
			}
		 }
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/getAircraftNumberOfSeats")
	public int getNumberOfSeats(@PathParam("TailNumber")String TailNumber) {
		 for(Aircraft a:aircrafts) {
			 if(a.getTailNumber().equals(TailNumber)) {
				 return a.getNumberOfSeats();
			}
		 }
		return 0;
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addAircraft")
	public void addAircraft(Aircraft aircraft) {
		DAO.getAircraftDao().addAircraft(aircraft);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{TailNumber}/deleteAircraft")
	public void deleteAircraft(String TailNumber) {
		DAO.getAircraftDao().deleteAircraft(TailNumber);
		
	}
	
}


