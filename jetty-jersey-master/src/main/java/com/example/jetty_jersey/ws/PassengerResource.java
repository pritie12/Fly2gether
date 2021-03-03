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



@Path("/Passenger")
public class PassengerResource {
	DAO daopassenger;
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/passenger1")
	public List<Object> getDetailsofpassenger(Passenger passenger) {
		List<Object> passengers= new ArrayList<Object>();
		passengers.add(daopassenger.getPassengerId(passenger));
		passengers.add(daopassenger.getname(passenger));
		passengers.add(daopassenger.getsurname(passenger));
		passengers.add(daopassenger.getdateOfBirth(passenger));
		passengers.add(daopassenger.getphoneNumber(passenger));
		passengers.add(daopassenger.getemail(passenger));
		passengers.add(daopassenger.getpassengerBookingList(passenger));
		return (List<Object>) Response.ok().build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/passenger2")
	public void retrievepassenger(Passenger passenger) {
		System.out.println(daopassenger.getPassengerId(passenger));

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/passenger3")
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
		passenger.id="";
		System.out.println("Passenger deleted");
	}
}
