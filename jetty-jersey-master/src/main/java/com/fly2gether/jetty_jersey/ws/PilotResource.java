package com.fly2gether.jetty_jersey.ws;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
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
	public void addPilot(Pilot pilot) {
		String mail=pilot.getEmail();
		DAO.getPilotDao().addPilot(pilot);
		try {
			new Email(mail,"Welcome to Fly2gether","Dear pilot,\nWelcome to our flightsharing service, we hope that your flights will be enjoyable and that you spend a quality time with us.\nBest regards,\nFly2gether Team");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/deletePilot")
	public void deletePilot(@PathParam("id")Long id) {
		String mail=DAO.getPilotDao().getPilot(id).getEmail();
		try {
			new Email(mail,"Welcome to Fly2gether", "Dear pilot,\nYour account will shortly be deleted from our database, we hope that this is not the end of our collaboration. Please let us know if something in our website inconvenienced you.\nBest regards,\nFly2gether Team");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DAO.getPilotDao().deletePilot(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/PilotLogin")
	public long Login(@QueryParam("username")String username,@QueryParam("pwd") String password) {
		System.out.println(username + " " + password );
		if(DAO.getPilotDao().getPilot(username)!=null) {
			System.out.println("Logged in successfully");
		return DAO.getPilotDao().Login(username,password);
		}
		return -1;
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


