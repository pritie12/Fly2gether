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
import com.example.jetty_jersey.dao.*;



@Path("/Passenger")
public class PassengerResource {
	DAO daopassenger;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengerName")
	public String getPassengerName(@PathParam("id")String id) {
		for(Passenger p:daopassenger.totalPassengers) {
			if(daopassenger.getPassengerId(p).equals(id)) {
				return daopassenger.getname(p);
			}
		}
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengerSurname")
	public String getPassengerSurname(@PathParam("id")String id) {
		for(Passenger p:daopassenger.totalPassengers) {
			if(daopassenger.getPassengerId(p).equals(id)) {
				return daopassenger.getsurname(p);
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengerEmail")
	public String getPassengerEmail(@PathParam("id")String id) {
		for(Passenger p:daopassenger.totalPassengers) {
			if(daopassenger.getPassengerId(p).equals(id)) {
				return daopassenger.getemail(p);
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengerPhonenumber")
	public String getPassengerPhonenumber(@PathParam("id")String id) {
		for(Passenger p:daopassenger.totalPassengers) {
			if(daopassenger.getPassengerId(p).equals(id)) {
				return daopassenger.getphoneNumber(p);
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengerDateofBirth")
	public Date getPassengerDateofBirth(@PathParam("id")String id) {
		for(Passenger p:daopassenger.totalPassengers) {
			if(daopassenger.getPassengerId(p).equals(id)) {
				return daopassenger.getdateOfBirth(p);
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengerBookingList")
	public List<Reservation> getPassengerBookingList(@PathParam("id")String id) {
		for(Passenger p:daopassenger.totalPassengers) {
			if(daopassenger.getPassengerId(p).equals(id)) {
				return daopassenger.getpassengerBookingList(p);
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengersinAirport")
	public List<Passenger> getPassengersinAirport(@PathParam("Time")Date Time,@PathParam("Airport") String Airport) {
		return daopassenger.getPassengers(Time,Airport);
	}
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/retrievepassenger")
	public void retrievepassenger(Passenger passenger) {
		System.out.println(daopassenger.getPassengerId(passenger));

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/retrieveDetailpassenger")
	public void retrieveDetailpassenger (Passenger passenger) { 
		List<Object> passengers= new ArrayList<Object>();
		passengers.add(daopassenger.getPassengerId(passenger));
		passengers.add(daopassenger.getname(passenger));
		passengers.add(daopassenger.getsurname(passenger));
		passengers.add(daopassenger.getdateOfBirth(passenger));
		passengers.add(daopassenger.getphoneNumber(passenger));
		passengers.add(daopassenger.getemail(passenger));
		passengers.add(daopassenger.getpassengerBookingList(passenger));
	
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/passenger4")
	public void putpassenger(Passenger passenger) {
		System.out.println(daopassenger.getPassengerId(passenger));
	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/passenger5")
	public void deleteExample(Passenger passenger) {
		System.out.println("Passenger deleted");
	}
}
