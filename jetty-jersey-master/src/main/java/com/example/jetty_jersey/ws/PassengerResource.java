package com.example.jetty_jersey.ws;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
	@Path("/{id}")
	public List<Object> getDetailsofpassenger(Passenger passenger,Flight flight) {
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
	@Path("/passenger")
	public Response retrievepassenger(Passenger passenger) {
		System.out.println(daopassenger.getPassengerId(passenger));
		return Response.ok().build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response retrieveDetailpassenger (Passenger passenger, Flight flight) { 
		List<Object> passengers= new ArrayList<Object>();
		passengers.add(daopassenger.getPassengerId(passenger));
		passengers.add(daopassenger.getname(passenger));
		passengers.add(daopassenger.getsurname(passenger));
		passengers.add(daopassenger.getdateOfBirth(passenger));
		passengers.add(daopassenger.getphoneNumber(passenger));
		passengers.add(daopassenger.getemail(passenger));
		passengers.add(daopassenger.getpassengerBookingList(passenger));
		return Response.ok().build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/passenger")
	public Response putpassenger(Passenger passenger) {
		System.out.println(daopassenger.getPassengerId(passenger));
		return Response.ok().build();
	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/passenger")
	public void deleteExample(Passenger passenger) {
		passenger.id="";
		System.out.println("Passenger deleted");
	}
}
