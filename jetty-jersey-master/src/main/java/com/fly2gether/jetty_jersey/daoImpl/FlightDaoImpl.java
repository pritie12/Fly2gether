package com.fly2gether.jetty_jersey.daoImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.fly2gether.jetty_jersey.dao.*;


public class FlightDaoImpl implements flightDao {
	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
	
	public FlightDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getFlights(){
		List<Flight> flights=null;
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			flights = (List<Flight>) q.execute();
			detached = (List<Flight>) pm.detachCopyAll(flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached;
	}
	public Pilot getPilot(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached.getFlightPilot();
	}

	public Aircraft getAircraft(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached.getFlightAircraft();
	}

	public int getPrice(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached.getPrice();
	}

	public List<Integer> getPassengers(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached.getPassengersList();
	}

	public int getAvailableSeats(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getAvailableSeats();
	}

	public String getAppointmentDescription(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getAppointmentDescription();
	}

	public Date getdepartureDate(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getDepartureDate();
	}

	public LocalDateTime getdepartureTime(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getDepartureTime();
	}

	public String getdepartureAirport(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getDepartureAirport();
	}

	public Date getarrivalDate(int identifier) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getArrivalDate();
	}

	public LocalDateTime getarrivalTime(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getArrivalTime();
	}

	public String getarrivalAirport(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getArrivalAirport();
	}

	public Duration getFlightDuration(int identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int identifier");
			q.setFilter("identifier == id");
			q.setUnique(true);
			
			f = (Flight) q.execute(identifier);
			detached = (Flight) pm.detachCopy(f);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getFlightDuration();
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getFlights(int minPrice, int maxPrice) {
		List<Flight> flights=null;
		List<Flight> detached = new ArrayList<Flight>();

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("int minPrice,maxPrice");
			q.setFilter("price < maxPrice && price > minPrice");
			q.setUnique(true);

			flights = (List<Flight>) q.execute();
			detached = (List<Flight>) pm.detachCopyAll(flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getFlights(Date DepartureDate, String DepartureAirport) {
		List<Flight> search_result = null;
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q=pm.newQuery(Flight.class);
			q.declareParameters("org.joda.time.Date DepartureDate,String DepartureAirport");
			q.setFilter(" DepartureDate.isAfter(departureDate) && departureAirport == DepartureAirport && availablesSeats != 0 ");
			q.setUnique(true);
			search_result = (List<Flight>) q.execute();
			detached = (List<Flight>) pm.detachCopyAll(search_result);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
		return detached;
	}


	@SuppressWarnings("unchecked")
	public List<Flight> getFlights(int availableSeats) {
		List<Flight> flights=null;
		List<Flight> detached = new ArrayList<Flight>();

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("int availableSeats");
			q.setFilter("availableSeats == availablesSeats");
			q.setUnique(true);

			flights = (List<Flight>) q.execute();
			detached = (List<Flight>) pm.detachCopyAll(flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	public void addFlight(Flight flight) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(flight);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
		
	}

	public void addPassenger(int passenger_id, int flight_id) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Flight f = pm.getObjectById(Flight.class, flight_id);
			if(f.getPassengersList().contains(passenger_id)) {
				f.getPassengersList().add(passenger_id);
			}
			
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
		}
		System.out.println("Passenger added to this flight");
		
	}
		

	public void deleteFlight(int id) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);
            pm.deletePersistent(f);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
		
	}

	public void removePassenger(int passenger_id, int flight_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Flight f = pm.getObjectById(Flight.class, flight_id);
			if(f.getPassengersList().contains(passenger_id)) {
				f.getPassengersList().remove(passenger_id);
			}
			
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
		}
		System.out.println("Passenger removed from this flight");
		
	}

}
