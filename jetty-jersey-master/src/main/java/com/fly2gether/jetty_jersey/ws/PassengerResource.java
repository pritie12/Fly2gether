package com.fly2gether.jetty_jersey.ws;
import java.util.Date;
import java.util.List;
import java.util.Map;


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



@Path("/Passenger")
public class PassengerResource implements passengerDao {
	

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengers")
	public List<Passenger> getPassengers() {
		return DAO.getPassengerDao().getPassengers();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassenger")
	public Passenger getPassenger(@PathParam("id")String id) {
		return DAO.getPassengerDao().getPassenger(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getLoginInfo")
	public Map<String, String> getLoginInfo(String id) {
		return DAO.getPassengerDao().getLoginInfo(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerName")
	public String getname(@PathParam("id")String id) {
		return DAO.getPassengerDao().getname(id);
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerSurname")
	public String getsurname(@PathParam("id")String id) {
		return DAO.getPassengerDao().getsurname(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerDateofBirth")
	public Date getdateOfBirth(@PathParam("id")String id) {
		return DAO.getPassengerDao().getdateOfBirth(id);

	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerEmail")
	public String getemail(@PathParam("id")String id) {
		return DAO.getPassengerDao().getemail(id);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerPhoneNumber")
	public String getphoneNumber(@PathParam("id")String id) {
		return DAO.getPassengerDao().getphoneNumber(id);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerReservations")
	public List<String> getpassengerBookingList(@PathParam("id")String id) {
		return DAO.getPassengerDao().getpassengerBookingList(id);

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPassenger")
	public void addPassenger(Passenger passenger) {
		DAO.getPassengerDao().addPassenger(passenger);		
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/{resa_id}/addPassenger")
	public void addReservation(@PathParam("passenger_id")String passenger_id,@PathParam("resa_id") String resa_id) {
		DAO.getPassengerDao().addReservation(passenger_id,resa_id);	
		
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/{resa_id}/removeReservation")
	public void removeReservation(@PathParam("passenger_id")String passenger_id,@PathParam("resa_id") String resa_id) {
		DAO.getPassengerDao().removeReservation(passenger_id, resa_id);
	}
		
	
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/DeletePassenger")
	public void deletePassenger(@PathParam("id")String id) {
		DAO.getPassengerDao().deletePassenger(id);
	}
}
