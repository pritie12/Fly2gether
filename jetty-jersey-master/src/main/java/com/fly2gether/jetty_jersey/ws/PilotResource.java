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
	public Pilot getPilot(@PathParam("id")Long id) {
		return DAO.getPilotDao().getPilot(id);
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotName")
	public String getname(@PathParam("id")Long id) {
		return DAO.getPilotDao().getname(id);
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotSurname")
	public String getsurname(@PathParam("id")Long id) {
		return DAO.getPilotDao().getsurname(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotDateofBirth")
	public Date getdateOfBirth(@PathParam("id")Long id) {
		return DAO.getPilotDao().getdateOfBirth(id);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotEmail")
	public String getemail(@PathParam("id")Long id) {
		return DAO.getPilotDao().getemail(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotPhoneNumber")
	public String getphoneNumber(@PathParam("id")Long id) {
		return DAO.getPilotDao().getphoneNumber(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotFlyingHours")
	public int getFlyingHours(@PathParam("id")Long id) {
		return DAO.getPilotDao().getFlyingHours(id);
	}
	


	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPilot")
	public void addPilot(Pilot pilot) {
		Pilot p = new Pilot ();
		DAO.getPilotDao().addPilot(p);
	}

	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/deletePilot")
	public void deletePilot(Long id) {
		DAO.getPilotDao().deletePilot(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{username}/PilotLogin")
	public Pilot Login(@PathParam("username")String username, String password) {
		return DAO.getPilotDao().Login(username,password);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilot")
	public Pilot getPilot(String Username) {
		return DAO.getPilotDao().getPilot(Username);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/modifyPilotUsername")
	public void modifyUsername(@PathParam("id")Long id, String Username) {
		DAO.getPilotDao().modifyUsername(id,Username);
		
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/modifyPilotPwd")
	public void modifyPwd(@PathParam("id")Long id, String Pwd) {
		DAO.getPilotDao().modifyPwd(id,Pwd);	
	}
	
}


