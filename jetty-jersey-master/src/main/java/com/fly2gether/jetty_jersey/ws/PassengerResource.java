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
import javax.ws.rs.QueryParam;
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
	public Passenger getPassenger(@PathParam("id")Long id) {
		return DAO.getPassengerDao().getPassenger(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerUsername")
	public String getUsername(@PathParam("id")Long id) {
		return DAO.getPassengerDao().getUsername(id);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerPwd")
	public String getPwd(@PathParam("id")Long id) {
		return DAO.getPassengerDao().getPwd(id);
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerName")
	public String getname(@PathParam("id")Long id) {
		return DAO.getPassengerDao().getname(id);
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerSurname")
	public String getsurname(@PathParam("id")Long id) {
		return DAO.getPassengerDao().getsurname(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerDateofBirth")
	public Date getdateOfBirth(@PathParam("id")Long id) {
		return DAO.getPassengerDao().getdateOfBirth(id);

	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerEmail")
	public String getemail(@PathParam("id")Long id) {
		return DAO.getPassengerDao().getemail(id);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerPhoneNumber")
	public String getphoneNumber(@PathParam("id")Long id) {
		return DAO.getPassengerDao().getphoneNumber(id);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPassengerReservations")
	public List<Long> getpassengerBookingList(@PathParam("id")Long id) {
		return DAO.getPassengerDao().getpassengerBookingList(id);

	}
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassenger")
	public Passenger getPassenger(@PathParam("Username")String Username) {
		return DAO.getPassengerDao().getPassenger(Username);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/PassengerLogin")
	public Passenger Login(@QueryParam("username")String username,@QueryParam("password") String password) {
		System.out.println("usr: "+username+" pwd: "+ password );
		return DAO.getPassengerDao().Login(username,password);
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
	public void addReservation(@PathParam("passenger_id")Long passenger_id,@PathParam("resa_id") Long resa_id) {
		DAO.getPassengerDao().addReservation(passenger_id,resa_id);	
		
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/{resa_id}/removeReservation")
	public void cancelReservation(@PathParam("passenger_id")Long passenger_id,@PathParam("resa_id") Long resa_id) {
		DAO.getPassengerDao().cancelReservation(passenger_id, resa_id);
	}
			
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/DeletePassenger")
	public void deletePassenger(@PathParam("id")Long id) {
		DAO.getPassengerDao().deletePassenger(id);
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/modifyPassengerPwd")
	public void modifyPwd(@PathParam("id")Long id,@PathParam("Pwd") String Pwd) {
		DAO.getPassengerDao().modifyPwd(id,Pwd);		
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/modifyPassengerUsername")
	public void modifyUsername(@PathParam("id")Long id,@PathParam("Username") String Username) {
		DAO.getPassengerDao().modifyUsername(id,Username);
		
	}	

}
