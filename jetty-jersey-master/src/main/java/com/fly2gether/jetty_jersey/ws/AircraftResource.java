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


@Path("/Aircraft")
public class AircraftResource implements aircraftDao{

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getAircraft")
	public Aircraft getAircraft( @PathParam("id")Long id) {
		return DAO.getAircraftDao().getAircraft(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFleet")
	public List<Aircraft> getFleet() {		
		return DAO.getAircraftDao().getFleet();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getAircraftModel")
	public String getModel(@PathParam("id")Long id) {
		return DAO.getAircraftDao().getModel(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getAircraftCompany")
	public String getCompany(@PathParam("id")Long id) {
		return DAO.getAircraftDao().getCompany(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getAircraftNumberOfSeats")
	public int getNumberOfSeats(@PathParam("id")Long id) {
		return DAO.getAircraftDao().getNumberOfSeats(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{tailNumber}/getAircraftId")
	public long getAircraftId(@PathParam("tailNumber")Long tailNumber) {
		return DAO.getAircraftDao().getAircraftId(tailNumber);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addAircraft")
	public void addAircraft(Aircraft aircraft) {
		DAO.getAircraftDao().addAircraft(aircraft);
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/deleteAircraft")
	public void deleteAircraft(@PathParam("id")Long id) {
		DAO.getAircraftDao().deleteAircraft(id);		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setModel")
	public void setModel(@PathParam("id")Long id,@PathParam("Model") String Model) {
		DAO.getAircraftDao().setModel(id,Model);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setCompany")
	public void setCompany(@PathParam("id")Long id,@PathParam("Company") String Company) {
		DAO.getAircraftDao().setCompany(id,Company);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setNumberOfSeats")
	public void setNumberOfSeats(@PathParam("id")Long id,@PathParam("NumberOf") int NumberOfSeats) {
		DAO.getAircraftDao().setNumberOfSeats(id,NumberOfSeats);	
	}
	
}


