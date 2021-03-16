package com.example.jetty_jersey.ws;
import java.time.Duration;
import java.util.ArrayList;
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
import com.example.jetty_jersey.dao.*;


@Path("/Pilote")
public class PilotResource {
	DAO daopilot;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilotName")
	public String getPilotName(@PathParam("id")String id) {
		for(Pilot p:daopilot.totalPilots) {
			if(daopilot.getPilotId(p).equals(id)) {
				return daopilot.getname(p);
			}
		}
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilotSurname")
	public String getPassengerSurname(@PathParam("id")String id) {
		for(Pilot p:daopilot.totalPilots) {
			if(daopilot.getPilotId(p).equals(id)) {
				return daopilot.getsurname(p);
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPassengerEmail")
	public String getPassengerEmail(@PathParam("id")String id) {
		for(Pilot p:daopilot.totalPilots) {
			if(daopilot.getPilotId(p).equals(id)) {
				return daopilot.getemail(p);
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilotPhonenumber")
	public String getPilotPhonenumber(@PathParam("id")String id) {
		for(Pilot p:daopilot.totalPilots) {
			if(daopilot.getPilotId(p).equals(id)) {
				return daopilot.getphoneNumber(p);
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilotDateofBirth")
	public Date getPilotDateofBirth(@PathParam("id")String id) {
		for(Pilot p:daopilot.totalPilots) {
			if(daopilot.getPilotId(p).equals(id)) {
				return daopilot.getdateOfBirth(p);
			}
		}
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilotStartingDate")
	public Date getPilotStartingDate(@PathParam("id")String id) {
		for(Pilot p:daopilot.totalPilots) {
			if(daopilot.getPilotId(p).equals(id)) {
				return daopilot.getstartingDate(p);
			}
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilotExperience")
	public Duration getPilotExperience(@PathParam("id")String id) {
		for(Pilot p:daopilot.totalPilots) {
			if(daopilot.getPilotId(p).equals(id)) {
				return daopilot.getexperience(p);
			}
		}
		return null;
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilote2")
	public void retrievePilot(Pilot pilot) {
		System.out.println(daopilot.getPilotId(pilot));

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot3")
	public void retrieveDetailPilot (Pilot pilot) { 
		List<Object> pilots= new ArrayList<Object>();
		pilots.add(daopilot.getPilotId(pilot));
		pilots.add(daopilot.getname(pilot));
		pilots.add(daopilot.getsurname(pilot));
		pilots.add(daopilot.getdateOfBirth(pilot));
		pilots.add(daopilot.getexperience(pilot));
		pilots.add(daopilot.getphoneNumber(pilot));
		pilots.add(daopilot.getemail(pilot));
		pilots.add(daopilot.getstartingDate(pilot));

	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Pilot4")
	public void putPilot(Pilot pilot) {
		System.out.println(daopilot.getPilotId(pilot));

	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot5")
	public void deleteExample(Pilot pilot) {

		System.out.println("Pilot deleted");
	}

}
