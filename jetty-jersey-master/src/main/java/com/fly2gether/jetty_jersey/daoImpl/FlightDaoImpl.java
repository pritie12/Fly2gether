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
			q.declareParameters("int minPrice,int maxPrice");
			q.setFilter("price < maxPrice && price > minPrice");

			flights = (List<Flight>) q.execute(minPrice,maxPrice);
			detached = (List<Flight>) pm.detachCopyAll(flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println(detached.size()+" flights found !");
		return detached;
	}

	@SuppressWarnings("unchecked")
	public List<Flight> getFlights(LocalDateTime DepartureMin,LocalDateTime DepartureMax, String DepartureAirport) {
		List<Flight> flights=null;
		List<Flight> detached = new ArrayList<Flight>();

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);

			q.declareParameters("java.util.LocalDateTime DepartureMin, String DepartureAirport,java.util.LocalDateTime DepartureMax");
			q.setFilter(" DepartureMax >= departureTime && DepartureMin <= departureTime && DepartureAirport==departureAirport && AvailablesSeats!=0");
			flights = (List<Flight>) q.execute(DepartureMin,DepartureAirport,DepartureMax);

			detached = (List<Flight>) pm.detachCopyAll(flights);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println(detached.size()+" flights found !");
		return detached;
	}


	@SuppressWarnings("unchecked")
	public List<Flight> getFlights(int Seats) {
		List<Flight> flights=null;
		List<Flight> detached = new ArrayList<Flight>();

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
			q.declareParameters("int Seats");
			q.setFilter("availablesSeats > Seats");

			flights = (List<Flight>) q.execute(Seats);
			detached = (List<Flight>) pm.detachCopyAll(flights);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println(detached.size()+" flights found !");
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
		System.out.println("Flight n°"+flight.getId()+" added to the system");
		
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

	public void setPilot(int id, Pilot Pilot) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);

            f.setFlightPilot(Pilot);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	public void setAircraft(int id, Aircraft Aircraft) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);

            f.setFlightAircraft(Aircraft);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	public void setPrice(int id, int Price) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);

            f.setPrice(Price);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	public void setPassengers(int id, List<Integer> Passengers) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);

            f.setPassengersList(Passengers);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	public void setAvailableSeats(int id, int AvailableSeats) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);

            f.setAvailableSeats(AvailableSeats);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	public void setAppointmentDescription(int id, String AppointmentDescription) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);

            f.setAppointmentDescription(AppointmentDescription);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	public void setdepartureDate(int id, Date DepartureDate) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);

            f.setDepartureDate(DepartureDate);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	
	public void setarrivalDate(int id, Date ArrivalDate) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);

            f.setArrivalDate(ArrivalDate);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	

	public void setFlightDuration(int id, Duration FlightDuration) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);
            f.setFlightDuration(FlightDuration);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}


	public void modifyFlight(int id, LocalDateTime DepartureTime, String DepartureAirport, LocalDateTime ArrivalTime,
			String ArrivalAirport) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);
			f.setDepartureAirport(DepartureAirport);
			f.setDepartureTime(DepartureTime);
			f.setArrivalTime(ArrivalTime);
            f.setArrivalAirport(ArrivalAirport);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

}


