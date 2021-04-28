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


@Path("/Pilote")
public class PilotResource implements pilotDao{
	
	//List<Pilot> pilots=Database.getToTalPilots();
	List<Pilot> pilots=Database.db.getToTalPilots();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilots")
	public List<Pilot> getPilots() {
		return pilots;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Pilot getPilot(@PathParam("{id}")String id) {
		for(Pilot p:pilots) {
			if(p.getPilotId().equals(id)) {
				return p;
			}
		}
		Date d= new Date();
		return new Pilot("RayanFail","Gosling","rayan@mai;.fr","07XXX",d,200);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotName")
	public String getname(@PathParam("id")String id) {
		for(Pilot p:pilots) {
			if(p.getPilotId().equals(id)) {
				return p.getName();
			}
		}
		return null;
	}


	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotSurname")
	public String getsurname(@PathParam("id")String id) {
		for(Pilot p:pilots) {
			if(p.getPilotId().equals(id)) {
				return p.getSurname();
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotDateofBirth")
	public Date getdateOfBirth(@PathParam("id")String id) {
		for(Pilot p:pilots) {
			if(p.getPilotId().equals(id)) {
				return p.getDateOfBirth();
			}
		}
		return null;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotEmail")
	public String getemail(@PathParam("id")String id) {
		for(Pilot p:pilots) {
			if(p.getPilotId().equals(id)) {
				return p.getEmail();
			}
		}
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilotPhoneNumber")
	public String getphoneNumber(@PathParam("id")String id) {
		for(Pilot p:pilots) {
			if(p.getPilotId().equals(id)) {
				return p.getPhoneNumber();
			}
		}
		return null;
	}
	
	public int getFlyingHours(String id) {
		for(Pilot p:pilots) {
			if(p.getPilotId().equals(id)) {
				return p.getFlyingHours();
			}
		}
		return 0;
	}
	
	

	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deletePilot")
	public void deletePilot(String id) {
		for(Pilot p:pilots) {
			if(p.getPilotId().equals(id)) {
				pilots.remove(p);
				System.out.println("Pilot deleted");
			}
		}
		System.out.println("Pilot not found");
	}



	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPilot1")
	public void addPilot(Pilot data) {
		System.out.println(" pilot");
		pilots.add(data);
		System.out.println(" pilot add:"+ data.getPilotId()+ " " + data.getDateOfBirth());

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPilot2")
	public String addPilot2() {
		Pilot p= new Pilot();
		return p.getPilotId();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addPilot")
	public void addPilot() {
		// TODO Auto-generated method stub
		System.out.println(" nor here");
	}

}
