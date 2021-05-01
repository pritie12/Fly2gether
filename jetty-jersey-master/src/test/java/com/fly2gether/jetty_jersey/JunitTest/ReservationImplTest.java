package com.fly2gether.jetty_jersey.JunitTest;

import java.time.LocalDateTime;
import java.util.Date;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Test;

import com.fly2gether.jetty_jersey.dao.Aircraft;
import com.fly2gether.jetty_jersey.dao.Flight;
import com.fly2gether.jetty_jersey.dao.Passenger;
import com.fly2gether.jetty_jersey.dao.Pilot;
import com.fly2gether.jetty_jersey.dao.Reservation;
import com.fly2gether.jetty_jersey.dao.aircraftDao;
import com.fly2gether.jetty_jersey.dao.flightDao;
import com.fly2gether.jetty_jersey.dao.passengerDao;
import com.fly2gether.jetty_jersey.dao.pilotDao;
import com.fly2gether.jetty_jersey.dao.reservationDao;
import com.fly2gether.jetty_jersey.daoImpl.AircraftDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.FlightDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.PassengerDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.PilotDaoImpl;
import com.fly2gether.jetty_jersey.daoImpl.ReservationDaoImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ReservationImplTest {

	@SuppressWarnings({ "unused" })
	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
		flightDao flightDao = new FlightDaoImpl(pmf);
		aircraftDao aircraftDao=new AircraftDaoImpl(pmf);
		pilotDao pilotDao=new PilotDaoImpl(pmf);
		reservationDao reservationDao=new ReservationDaoImpl(pmf);
		passengerDao passengerDao=new PassengerDaoImpl(pmf);
		
		Aircraft aircraft1 =new Aircraft("LEARJET40","Boeing",10,(long) 1520);
		Passenger passenger1=new Passenger("Hiba","SOUBER","hiba@mail.fr","06XXX",new Date(1999,06,12));
		Passenger passenger2=new Passenger("Othmane","SOUBER","othmane@mail.fr","07XXX",new Date(1996,02,8));
		Passenger passenger3=new Passenger("Saadia","SOUBER","saadia@mail.fr","08XXX",new Date(1971,06,10));
		Passenger passenger4=new Passenger("Quentin","TARANTINO","quentin@mail.fr","03XXX",new Date(1963,03,27));
		Passenger passenger5=new Passenger("Stanley","KUBRICK","stan@mail.fr","09XXX",new Date(1928,07,26));
		Pilot pilot1=new Pilot("Rayan","Gosling","rayan@mail.fr","07XXX",new Date(1980,03,16),200);
		Pilot pilot2=new Pilot("Harry","Potter","potter@mail.fr","07XXX",new Date(1988,12,16),200);
		Long pilotId1=pilot1.getPilotId();
		Long pilotId2=pilot2.getPilotId();
		Long aircraftId1=aircraft1.getTailNumber();
		Flight flight1 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",20,37,pilotId1,aircraftId1);		
		Flight flight2 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",30,48,pilotId2,aircraftId1);		

		Reservation resa1=new Reservation(passenger1.getPassengerId(),flight1.getId(),3);
		Reservation resa2=new Reservation(passenger4.getPassengerId(),flight1.getId(),2);
		Reservation resa3=new Reservation(passenger5.getPassengerId(),flight1.getId(),5);
		resa3.display();
		flightDao.addFlight(flight1);
		flightDao.addFlight(flight2);
		reservationDao.addReservation(resa1);
		reservationDao.addReservation(resa2);
		reservationDao.addReservation(resa3);
		
		Assert.assertEquals(3, reservationDao.getReservations().size());
		flight1.display();
		flight2.display();
		System.out.println(reservationDao.getReservations().get(0).getFlight());
		reservationDao.getReservations().get(1).display();
		//Assert.assertEquals(10, reservationDao.getReservations().get(0).getFlight().getAvailableSeats());
	}
}