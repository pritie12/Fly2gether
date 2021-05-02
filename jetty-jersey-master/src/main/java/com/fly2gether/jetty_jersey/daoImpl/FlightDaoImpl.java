package com.fly2gether.jetty_jersey.daoImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
		tx.setRetainValues(true);
		
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
	public Long getPilot(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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
		return detached.getFlightPilotId();
	}

	public Long getAircraft(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public int getPrice(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public List<Long> getPassengers(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public int getAvailableSeats(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public String getAppointmentDescription(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public Date getdepartureDate(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public LocalDateTime getdepartureTime(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public String getdepartureAirport(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public Date getarrivalDate(Long identifier) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public LocalDateTime getarrivalTime(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public String getarrivalAirport(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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

	public Duration getFlightDuration(Long identifier) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f = null;
		Flight detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long identifier");
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
		tx.setRetainValues(true);
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
		System.out.println(detached.size()+" flights found ranging between "+maxPrice+" and "+minPrice+" !");
		return detached;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Flight> getFlights(String DepartureMin,String DepartureMax, String DepartureAirport) {
		List<Flight> flights=null;
		List<Flight> detached = new ArrayList<Flight>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
        LocalDateTime dMin = LocalDateTime.parse(DepartureMin,formatter);
        LocalDateTime dMax = LocalDateTime.parse(DepartureMax,formatter);

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			Query q = pm.newQuery(Flight.class);
            flights= (List<Flight>) q.execute();

            flights=(List<Flight>) flights.stream().filter(f->f.getDepartureAirport().toUpperCase().equals(DepartureAirport.toUpperCase()))
            		.filter(f->f.getDepartureTime().isAfter(dMin)).filter(f->f.getDepartureTime().isBefore(dMax))
            		.filter(f->f.getAvailableSeats()!=0).collect(Collectors.toList());

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
		tx.setRetainValues(true);
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
		System.out.println(detached.size()+" flights found with "+Seats+" seats!");
		return detached;
	}

	public void addFlight(Flight flight) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			pm.makePersistent(flight);
			flight.display();
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	public void addPassenger(Long passenger_id, Long flight_id) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
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
		

	public void deleteFlight(Long id) {

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

	public void removePassenger(Long passenger_id, Long flight_id) {
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

	public void setPilot(Long id, Long Pilot) {
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

	public void setAircraft(Long id, Long Aircraft) {
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

	public void setPrice(Long id, int Price) {
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

	public void setPassengers(Long id, List<Long> Passengers) {
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

	public void setAvailableSeats(Long id, int AvailableSeats) {
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

	public void setAppointmentDescription(Long id, String AppointmentDescription) {
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

	public void setdepartureDate(Long id, Date DepartureDate) {
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
	
	public void setarrivalDate(Long id, Date ArrivalDate) {
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

	

	public void setFlightDuration(Long id, Duration FlightDuration) {
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


	public void modifyFlight(Long id, String DepartureTime, String DepartureAirport, String ArrivalTime,
			String ArrivalAirport) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
        LocalDateTime DTime= LocalDateTime.parse(DepartureTime,formatter);
        LocalDateTime ATime = LocalDateTime.parse(ArrivalTime,formatter);

		Flight f=null;
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, id);
			f.setDepartureAirport(DepartureAirport);
			
			f.setDepartureTime(DTime);
			f.setArrivalTime(ATime);
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


