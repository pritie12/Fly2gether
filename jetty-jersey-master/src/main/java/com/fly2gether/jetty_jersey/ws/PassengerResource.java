package com.fly2gether.jetty_jersey.ws;
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

import com.fly2gether.jetty_jersey.dao.*;
import com.fly2gether.jetty_jersey.database.Database;



@Path("/Passenger")
public class PassengerResource implements passengerDao {
	
	List<Passenger> passengers=Database.getTotalPassengers();
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengers")
	public List<Passenger> getPassengers() {
		return passengers;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassenger")
	public Passenger getPassenger(@PathParam("id")String id) {
		for(Passenger p:passengers) {
			if(p.getPassengerId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerName")
	public String getname(@PathParam("id")String id) {
		for(Passenger p:passengers) {
			if(p.getPassengerId().equals(id)) {
				return p.getName();
			}
		}
		return null;
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerSurname")
	public String getsurname(@PathParam("id")String id) {
		for(Passenger p:passengers) {
			if(p.getPassengerId().equals(id)) {
				return p.getSurname();
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerDateofBirth")
	public Date getdateOfBirth(@PathParam("id")String id) {
		for(Passenger p:passengers) {
			if(p.getPassengerId().equals(id)) {
				return p.getDateOfBirth();
			}
		}
		return null;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerEmail")
	public String getemail(@PathParam("id")String id) {
		for(Passenger p:passengers) {
			if(p.getPassengerId().equals(id)) {
				return p.getEmail();
			}
		}
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerPhoneNumber")
	public String getphoneNumber(@PathParam("id")String id) {
		for(Passenger p:passengers) {
			if(p.getPassengerId().equals(id)) {
				return p.getPhoneNumber();
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerReservations")
	public List<Reservation> getpassengerBookingList(@PathParam("id")String id) {
		for(Passenger p:passengers) {
			if(p.getPassengerId().equals(id)) {
				return p.getPassengerBookingList();
			}
		}
		return null;
	}

	public void addPassenger() {
		// TODO Auto-generated method stub
		
	}

	public void addReservation(String passenger_id, String resa_id) {
		// TODO Auto-generated method stub
		
	}

	public void removeReservation(String passenger_id, String resa_id) {
		// TODO Auto-generated method stub
		
	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/DeletePassenger")
	public void deletePassenger(@PathParam("id")String id) {
		System.out.println("Passenger deleted");
	}
}