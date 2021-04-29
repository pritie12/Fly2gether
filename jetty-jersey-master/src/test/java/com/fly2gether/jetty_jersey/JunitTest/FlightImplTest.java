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
		
		Aircraft aircraft1 =new Aircraft("LEARJET40","Boeing",10,1520);
		Passenger passenger1=new Passenger("Hiba","SOUBER","hiba@mail.fr","06XXX",new Date(1999,06,12));
		Pilot pilot1=new Pilot("Rayan","Gosling","rayan@mail.fr","07XXX",new Date(1980,03,16),200);
		Pilot pilot2=new Pilot("Harry","Potter","rayan@mail.fr","07XXX",new Date(1980,03,16),200);
		Flight flight1 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",20,37,pilot1,aircraft1);		
		Flight flight2 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",30,48,pilot1,aircraft1);		
		Flight flight3 = new Flight(new Date(2021,04,16),LocalDateTime.of(2021,04,16,18,20,0), "Aerodrome 1",new Date(2021,04,16),LocalDateTime.of(2021,04,16,20,50,0),"Aerodrom2",40,59,pilot1,aircraft1);
		Flight flight4 = new Flight(new Date(2021,04,16),LocalDateTime.of(2021,04,16,15,20,0), "Aerodrome 1",new Date(2021,04,16),LocalDateTime.of(2021,04,16,20,50,0),"Aerodrom2",40,59,pilot1,aircraft1);
		flightDao.addFlight(flight1);
		flightDao.addFlight(flight2);
		flightDao.addFlight(flight3);
		flightDao.addFlight(flight4);
		Assert.assertEquals(4, flightDao.getFlights().size());

		Assert.assertEquals(1,  flightDao.getFlights(30).size());
		//Assert.assertEquals(2,  flightDao.getFlights(LocalDateTime.of(2021,04,16,13,0,0),LocalDateTime.of(2021,04,16,23,0,0),"Aerodrome 1").size());
		Assert.assertEquals(2,  flightDao.getFlights(30,50).size());

	}
}
