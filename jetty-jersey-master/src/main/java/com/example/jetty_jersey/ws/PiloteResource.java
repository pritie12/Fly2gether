package com.example.jetty_jersey.ws;
import java.util.ArrayList;
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
import javax.ws.rs.core.Response;
import com.example.jetty_jersey.dao.*;


@Path("/Pilote")
public class PiloteResource {
	DAO daopilot;
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pilot")
	public List<Object> getDetailsofPilot(Pilote pilot) {
		List<Object> pilots= new ArrayList<Object>();
		pilots.add(daopilot.getPilotId(pilot));
		pilots.add(daopilot.getname(pilot));
		pilots.add(daopilot.getsurname(pilot));
		pilots.add(daopilot.getdateOfBirth(pilot));
		pilots.add(daopilot.getexperience(pilot));
		pilots.add(daopilot.getphoneNumber(pilot));
		pilots.add(daopilot.getemail(pilot));
		pilots.add(daopilot.getstartingDate(pilot));
		return (List<Object>) Response.ok().build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilote")
	public void retrievePilot(Pilote pilot) {
		System.out.println(daopilot.getPilotId(pilot));

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot")
	public void retrieveDetailPilot (Pilote pilot) { 
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
	@Path("/Pilot")
	public void putPilot(Pilote pilot) {
		System.out.println(daopilot.getPilotId(pilot));

	}
	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/Pilot")
	public void deleteExample(Pilote pilot) {
		pilot.id="";
		System.out.println("Pilot deleted");
	}

}
