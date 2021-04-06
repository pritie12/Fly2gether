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

	public Pilot getPilot(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getFlightPilot();
	}

	public Aircraft getAircraft(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getFlightAircraft();
	}

	public int getPrice(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getPrice();
	}

	public List<String> getPassengers(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getPassengersList();
	}

	public int getAvailableSeats(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getAvailableSeats();
	}

	public String getAppointmentDescription(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getAppointmentDescription();
	}

	public Date getdepartureDate(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getDepartureDate();
	}

	public LocalDateTime getdepartureTime(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getDepartureTime();
	}

	public String getdepartureAirport(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getDepartureAirport();
	}

	public Date getarrivalDate(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getArrivalDate();
	}

	public LocalDateTime getarrivalTime(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getArrivalTime();
	}

	public String getarrivalAirport(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getArrivalAirport();
	}

	public Duration getFlightDuration(String identifier) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String identifier");
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
			pmf.close();
		}
		return detached.getFlightDuration();
	}

	public List<Flight> getFlights(int minPrice, int maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Flight> getFlights(Date DepartureTime, String DepartureAirport) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Flight> getFlights(Date DepartureTime, String DepartureAirport, Date ArrivalTime,
			String ArrivalAirport) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getFlights(int availableSeats) {
		List<Flight> flights=null;
		List<Flight> detached = new ArrayList<Flight>();
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
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
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
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
			pmf.close();
		}		
		
	}

	public void addPassenger(String passenger_id, String flight_id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
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
			pmf.close();
		}
		System.out.println("Passenger added to this flight");
		
	}
		

	public void deleteFlight(String id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
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
			pmf.close();
		}		
		
	}

	public void removePassenger(String passenger_id, String flight_id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
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
			pmf.close();
		}
		System.out.println("Passenger removed from this flight");
		
	}

}
