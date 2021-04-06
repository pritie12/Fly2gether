package com.fly2gether.jetty_jersey.dao;

import com.fly2gether.jetty_jersey.daoImpl.*;

public class DAO {
	
	
	public static aircraftDao getAircraftDao() {
		return new AircraftDaoImpl();
	}
	public static flightDao getFlightDao() {
		return new FlightDaoImpl();
	}
	public static passengerDao getPassengerDao() {
		return new PassengerDaoImpl();
	}
	public static pilotDao getPilotDao() {
		return new PilotDaoImpl();
	}
	public static reservationDao getReservationDao() {
		return new ReservationDaoImpl();
	}

}
