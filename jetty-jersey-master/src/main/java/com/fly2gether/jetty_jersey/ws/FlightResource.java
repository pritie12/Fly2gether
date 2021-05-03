package com.fly2gether.jetty_jersey.ws;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
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
import com.fly2gether.jetty_jersey.daoImpl.AircraftDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.FlightDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.PassengerDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.PilotDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.ReservationDaoImpl;


@Path("/Flight")
public class FlightResource  implements flightDao {

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPilot")
	public Long getPilot(@PathParam("id")Long id) {
		return DAO.getFlightDao().getPilot(id);		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAircraft")
	public Long getAircraft(@PathParam("id")Long id) {
		return DAO.getFlightDao().getAircraft(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPrice")
	public int getPrice(@PathParam("id")Long id) {
		return DAO.getFlightDao().getPrice(id);		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightPassengers")
	public List<Long> getPassengersList(@PathParam("id")Long id) {
		return DAO.getFlightDao().getPassengersList(id);		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAvailableSeats")
	public int getAvailableSeats(@PathParam("id")Long id) {
		return DAO.getFlightDao().getAvailableSeats(id);		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightAppointmentDescription")
	public String getAppointmentDescription(@PathParam("id")Long id) {
		return DAO.getFlightDao().getAppointmentDescription(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureDate")
	public Date getdepartureDate(@PathParam("id")Long id) {
		return DAO.getFlightDao().getdepartureDate(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureTime")
	public LocalDateTime getdepartureTime(@PathParam("id")Long id) {
		return DAO.getFlightDao().getdepartureTime(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDepartureAirport")
	public String getdepartureAirport(@PathParam("id")Long id) {
		return DAO.getFlightDao().getdepartureAirport(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalDate")
	public Date getarrivalDate(@PathParam("id")Long id) {
		return DAO.getFlightDao().getarrivalDate(id);	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalTime")
	public LocalDateTime getarrivalTime(@PathParam("id")Long id) {
		return DAO.getFlightDao().getarrivalTime(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightArrivalAirport")
	public String getarrivalAirport(@PathParam("id")Long id) {
		return DAO.getFlightDao().getarrivalAirport(id);	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/getFlightDuration")
	public Duration getFlightDuration(@PathParam("id")Long id) {
		return DAO.getFlightDao().getFlightDuration(id);	
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlights")
	public List<Flight> getFlights() {
		return DAO.getFlightDao().getFlights();	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByPrice")
	public List<Flight> getFlights(@QueryParam("maxprice")int maxprice,@QueryParam("minprice")int minprice) {
		return DAO.getFlightDao().getFlights(maxprice,minprice);	
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsBySeats")
	public List<Flight> getFlights(@QueryParam("seats")int seats) {
		return DAO.getFlightDao().getFlights(seats);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addFlightTest")
	public void addFlightTest(Flight flight) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
		flightDao flightDao = new FlightDaoImpl(pmf);
		aircraftDao aircraftDao=new AircraftDaoImpl(pmf);
		pilotDao pilotDao=new PilotDaoImpl(pmf);
		passengerDao passengerDao=new PassengerDaoImpl(pmf);
		reservationDao reservationDao=new ReservationDaoImpl(pmf);
		
		Aircraft aircraft1 =new Aircraft("LEARJET40","Boeing",10,(long) 1520);
		Aircraft aircraft2 =new Aircraft("PHOENIX40","Boeing",10,(long) 4213);
		Long aircraftId1=aircraft1.getTailNumber();
		Long aircraftId2=aircraft2.getTailNumber();

		Pilot pilot1=new Pilot("Rayan","Gosling","rayan@mail.fr","07XXX",new Date(1980,03,16),200);
		Pilot pilot2=new Pilot("Harry","Potter","potter@mail.fr","07XXX",new Date(1988,12,16),200);
		Pilot pilot3=new Pilot("Scarlett","Johanson","sjohan@mail.fr","07XXX",new Date(1983,12,16),200);
		
		Passenger passenger1=new Passenger("Hiba","SOUBER","hiba@mail.fr","06XXX",new Date(1999,06,12));
		Passenger passenger2=new Passenger("Othmane","SOUBER","othmane@mail.fr","07XXX",new Date(1996,02,8));
		Passenger passenger3=new Passenger("Saadia","SOUBER","saadia@mail.fr","08XXX",new Date(1971,06,10));
		Passenger passenger4=new Passenger("Quentin","TARANTINO","quentin@mail.fr","03XXX",new Date(1963,03,27));
		Passenger passenger5=new Passenger("Stanley","KUBRICK","stan@mail.fr","09XXX",new Date(1928,07,26));
		
		
		pilotDao.addPilot(pilot1);
		pilotDao.addPilot(pilot2);
		pilotDao.addPilot(pilot3);
		
		passengerDao.addPassenger(passenger5);
		passengerDao.addPassenger(passenger4);
		passengerDao.addPassenger(passenger3);
		passengerDao.addPassenger(passenger2);
		passengerDao.addPassenger(passenger1);

		Flight flight1 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",150,37,pilot1.getPilotId(),aircraft1.getTailNumber());	
		Flight flight2 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",30,48,pilot2.getPilotId(),aircraft2.getTailNumber());		
		Flight flight3 = new Flight(new Date(2021,04,16),LocalDateTime.of(2021,04,16,18,20,0), "Aerodrome 1",new Date(2021,04,16),LocalDateTime.of(2021,04,16,20,50,0),"Aerodrom2",150,59,pilot3.getPilotId(),aircraft1.getTailNumber());
		Flight flight4 = new Flight(new Date(2021,04,16),LocalDateTime.of(2021,04,16,15,20,0), "Aerodrome 1",new Date(2021,04,16),LocalDateTime.of(2021,04,16,20,50,0),"Aerodrom2",30,59,pilot1.getPilotId(),aircraft1.getTailNumber());

		flightDao.addFlight(flight1);	
		flightDao.addFlight(flight2);
		flightDao.addFlight(flight3);
		flightDao.addFlight(flight4);
		
		flightDao.addPassenger((long)0, (long) 0);
        flightDao.addPassenger((long)1, (long) 0);
        flightDao.addPassenger((long)2, (long) 0);
        flightDao.addPassenger((long)3, (long) 0);
		
		Reservation resa1=new Reservation(passenger1.getPassengerId(),flight1.getId(),3);
		Reservation resa2=new Reservation(passenger4.getPassengerId(),flight1.getId(),2);
		Reservation resa3=new Reservation(passenger5.getPassengerId(),flight1.getId(),5);
		
		System.out.println("passenger id:" + passenger1.getPassengerId());
		
		reservationDao.addReservation(resa1);
		reservationDao.addReservation(resa2);
		reservationDao.addReservation(resa3);
		
		//DAO.getFlightDao().addFlight(flight);	
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addFlight")
	public void addFlight(Flight flight) {
		DAO.getFlightDao().addFlight(flight);
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{flight_id}/{passenger_id}/addFlight")
	public void addPassenger(@PathParam("passenger_id")Long passenger_id,@PathParam("flight_id") Long flight_id) {
		DAO.getFlightDao().addPassenger(passenger_id,flight_id);
		
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{flight_id}/deleteFlight")
	public void deleteFlight(@PathParam("flight_id")Long flight_id) {
		DAO.getFlightDao().deleteFlight(flight_id);		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{passenger_id}/{resa_id}/getFlightsBySeats")
	public void removePassenger(@PathParam("passenger_id")Long passenger_id, @PathParam("flight_id")Long flight_id) {
		DAO.getFlightDao().removePassenger(passenger_id, flight_id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setPilot")
	public void setPilot(@PathParam("id")Long id,@PathParam("Pilot") Long Pilot) {
		DAO.getFlightDao().setPilot(id,Pilot);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setAircraft")
	public void setAircraft(@PathParam("id")Long id,@PathParam("Aircraft") Long Aircraft) {
		DAO.getFlightDao().setAircraft(id,Aircraft);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setPrice")
	public void setPrice(@PathParam("id")Long id,@PathParam("Price") int Price) {
		DAO.getFlightDao().setPrice(id,Price);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setPassengers")
	public void setPassengers(@PathParam("id")Long id,@PathParam("Passengers") List<Long> Passengers) {
		DAO.getFlightDao().setPassengers(id,Passengers);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setAvailableSeats")
	public void setAvailableSeats(@PathParam("id")Long id,@PathParam("AvailableSeats") int AvailableSeats) {
		DAO.getFlightDao().setAvailableSeats(id,AvailableSeats);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setAppointmentDescription")
	public void setAppointmentDescription(@PathParam("id")Long id,@PathParam("AppointmentDescription") String AppointmentDescription) {
		DAO.getFlightDao().setAppointmentDescription(id,AppointmentDescription);
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setdepartureDate")
	public void setdepartureDate(@PathParam("id")Long id, Date DepartureDate) {
		DAO.getFlightDao().setdepartureDate(id,DepartureDate);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setarrivalDate")
	public void setarrivalDate(@PathParam("id")Long id, Date ArrivalDate) {
		DAO.getFlightDao().setarrivalDate(id,ArrivalDate);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/setFlightDuration")
	public void setFlightDuration(@PathParam("id")Long id, Duration FlightDuration) {
		DAO.getFlightDao().setFlightDuration(id,FlightDuration);
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/modifyFlight")
	public void modifyFlight(@PathParam("id")Long id, @PathParam("DepartureTime")String DepartureTime, 
			@PathParam("DepartureAirport")String DepartureAirport, @PathParam("ArrivalTime")String ArrivalTime,
			@PathParam("ArrivalAirport")String ArrivalAirport) {
		
		DAO.getFlightDao().modifyFlight(id,DepartureTime,DepartureAirport,ArrivalTime,ArrivalAirport);		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getFlightsByDeparture")
	public List<Flight> getFlights(@QueryParam("DepartureMin")String DepartureMin,
			@QueryParam("DepartureMax")String DepartureMax, @QueryParam("DepartureAirport")String DepartureAirport) {
		return DAO.getFlightDao().getFlights(DepartureMin,DepartureMax,DepartureAirport);
	}

}
