package com.fly2gether.jetty_jersey.ws;
import java.util.Date;
import java.util.List;

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
	
	//List<Pilot> pilots=Database.getToTalPilots();
	List<Pilot> pilots=new Database("test").getToTalPilots();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getPilots")
	public List<Pilot> getPilots() {
		return pilots;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getPilot")
	public Pilot getPilot(@PathParam("id")String id) {
		for(Pilot p:pilots) {
			if(p.getPilotId().equals(id)) {
				return p;
			}
		}
		return null;
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
	@Path("/addPilot")
	public void addPilot(Pilot pilot) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pilots.add(pilot);
			pm.makePersistent(pilot);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
		
	}


