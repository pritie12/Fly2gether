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
	@Path("/addPilotTest")
	public void addPilotTest() {
		Pilot pilot1=new Pilot("Rayan","Gosling","rayan@mail.fr","07XXX",new Date(1980,03,16),200);
		Pilot pilot2=new Pilot("Harry","Potter","rayan@mail.fr","07XXX",new Date(1980,03,16),200);
		pilot1.setUsername("rayan");
		pilot2.setUsername("harry");
		//System.out.println(pilot.getName());
		DAO.getPilotDao().addPilot(pilot1);
		DAO.getPilotDao().addPilot(pilot2);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPilot")
	public void addPilot(Pilot p) {
		
		//Pilot pilot = new Pilot(p.getName(),p.getSurname(),p.getEmail(),p.getPhoneNumber(),p.getDateOfBirth(),p.getFlyingHours());
		System.out.println(p.getName());
		DAO.getPilotDao().addPilot(p);
	}

	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/deletePilot")
	public void deletePilot(@PathParam("id")Long id) {
		DAO.getPilotDao().deletePilot(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/PilotLogin")
	public Pilot Login(@QueryParam("username")String username,@QueryParam("pwd") String password) {
		System.out.println(username + " " + password );
		return DAO.getPilotDao().Login(username,password);
	}
	
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilot/{usrName}")
	public Pilot getPilot(@PathParam("usrName")String username) {
		return DAO.getPilotDao().getPilot(username);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/modifyPilotUsername")
	public void modifyUsername(@PathParam("id")Long id,@PathParam("Username") String Username) {
		DAO.getPilotDao().modifyUsername(id,Username);
		
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/modifyPilotPwd")
	public void modifyPwd(@PathParam("id")Long id,@PathParam("Pwd") String Pwd) {
		DAO.getPilotDao().modifyPwd(id,Pwd);	
	}
	
}


