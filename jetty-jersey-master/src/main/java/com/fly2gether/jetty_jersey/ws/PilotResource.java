package com.fly2gether.jetty_jersey.ws;
import java.util.Date;
import java.util.List;
import java.util.Map;

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


@Path("/Pilote")
public class PilotResource implements pilotDao{
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilots")
	public List<Pilot> getPilots() {
		return DAO.getPilotDao().getPilots();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilot")
	public Pilot getPilot(@PathParam("id")String id) {
		return DAO.getPilotDao().getPilot(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getLoginInfo")	
	public Map<String, String> getLoginInfo(String id) {
		return DAO.getPilotDao().getLoginInfo(id);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotName")
	public String getname(@PathParam("id")String id) {
		return DAO.getPilotDao().getname(id);
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotSurname")
	public String getsurname(@PathParam("id")String id) {
		return DAO.getPilotDao().getsurname(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotDateofBirth")
	public Date getdateOfBirth(@PathParam("id")String id) {
		return DAO.getPilotDao().getdateOfBirth(id);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotEmail")
	public String getemail(@PathParam("id")String id) {
		return DAO.getPilotDao().getemail(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotPhoneNumber")
	public String getphoneNumber(@PathParam("id")String id) {
		return DAO.getPilotDao().getphoneNumber(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotFlyingHours")
	public int getFlyingHours(String id) {
		return DAO.getPilotDao().getFlyingHours(id);
	}
	


	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPilot")
	public void addPilot(Pilot pilot) {
		DAO.getPilotDao().addPilot(pilot);
	}

	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/deletePilot")
	public void deletePilot(String id) {
		DAO.getPilotDao().deletePilot(id);
	}
	
}


