package com.fly2gether.jetty_jersey.JunitTest;

import java.time.LocalDateTime;
import java.util.Date;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.fly2gether.jetty_jersey.dao.Aircraft;
import com.fly2gether.jetty_jersey.dao.Flight;
import com.fly2gether.jetty_jersey.dao.Passenger;
import com.fly2gether.jetty_jersey.dao.Pilot;
import com.fly2gether.jetty_jersey.dao.aircraftDao;
import com.fly2gether.jetty_jersey.dao.flightDao;
import com.fly2gether.jetty_jersey.dao.passengerDao;
import com.fly2gether.jetty_jersey.dao.pilotDao;
import com.fly2gether.jetty_jersey.daoImpl.AircraftDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.FlightDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.PassengerDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.PilotDaoImpl;

public class FlightImplTest {
	
	@SuppressWarnings({ "unused", "deprecation" })
	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
		flightDao flightDao = new FlightDaoImpl(pmf);
		aircraftDao aircraftDao=new AircraftDaoImpl(pmf);
		pilotDao pilotDao=new PilotDaoImpl(pmf);
		passengerDao passengerDao=new PassengerDaoImpl(pmf);
		
		Aircraft aircraft1 =new Aircraft("LEARJET40","Boeing",10,(long) 1520);
		Aircraft aircraft2 =new Aircraft("PHOENIX40","Boeing",10,(long) 4213);
		Long aircraftId1=aircraft1.getTailNumber();
		Long aircraftId2=aircraft2.getTailNumber();
		Passenger passenger1=new Passenger("Hiba","SOUBER","hiba@mail.fr","06XXX",new Date(1999,06,12));
		Pilot pilot1=new Pilot("Rayan","Gosling","rayan@mail.fr","07XXX",new Date(1980,03,16),200);
		Pilot pilot2=new Pilot("Harry","Potter","potter@mail.fr","07XXX",new Date(1988,12,16),200);
		Pilot pilot3=new Pilot("Scarlett","Johanson","sjohan@mail.fr","07XXX",new Date(1983,12,16),200);
		Long pilotId1=pilot1.getPilotId();
		Long pilotId2=pilot2.getPilotId();
		Flight flight1 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",20,37,pilotId1,aircraftId1);	
		Flight flight2 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",30,48,pilotId2,aircraftId2);		
		Flight flight3 = new Flight(new Date(2021,04,16),LocalDateTime.of(2021,04,16,18,20,0), "Aerodrome 1",new Date(2021,04,16),LocalDateTime.of(2021,04,16,20,50,0),"Aerodrom2",40,59,pilot3.getPilotId(),aircraftId1);
		Flight flight4 = new Flight(new Date(2021,04,16),LocalDateTime.of(2021,04,16,15,20,0), "Aerodrome 1",new Date(2021,04,16),LocalDateTime.of(2021,04,16,20,50,0),"Aerodrom2",40,59,pilotId1,aircraftId2);

		flightDao.addFlight(flight1);
		flightDao.addFlight(flight2);
		flightDao.addFlight(flight3);
		flightDao.addFlight(flight4);
		flightDao.getFlights().get(0).display();
		flightDao.getFlights().get(1).display();
		flightDao.getFlights().get(2).display();
		flightDao.getFlights().get(3).display();

		
		Assert.assertEquals(4, flightDao.getFlights().size());
		Assert.assertEquals(2,  flightDao.getFlights(30).size());
		Assert.assertEquals(2,  flightDao.getFlights("2021-04-16 13:30","2021-04-16 23:30","Aerodrome 1").size());
		Assert.assertEquals(2,  flightDao.getFlights(30,50).size());

	}
}
