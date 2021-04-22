package com.fly2gether.jetty_jersey.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import com.fly2gether.jetty_jersey.daoImpl.*;

public class DAO {
	
	private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");	
	private static passengerDao PassengerDAO=null;
	private static pilotDao PilotDAO=null;
	private static aircraftDao AircraftDAO=null;
	private static flightDao FlightDAO=null;
	private static reservationDao ReservationDAO=null;
	
	public static aircraftDao getAircraftDao() {
		if(AircraftDAO==null) {
			AircraftDAO=new AircraftDaoImpl(pmf);
		}
		return AircraftDAO;
	}
	public static flightDao getFlightDao() {
		if(FlightDAO==null) {
			FlightDAO=new FlightDaoImpl(pmf);
		}
		return FlightDAO;
	}
	public static passengerDao getPassengerDao() {
		if(PassengerDAO==null) {
			PassengerDAO=new PassengerDaoImpl(pmf);
		}
		return PassengerDAO;
	}
	public static pilotDao getPilotDao() {
		if(PilotDAO==null) {
			PilotDAO=new PilotDaoImpl(pmf);
		}
		return PilotDAO;
	}
	public static reservationDao getReservationDao() {
		if(ReservationDAO==null) {
			ReservationDAO=new ReservationDaoImpl(pmf);
		}
		return ReservationDAO;
	}

}
