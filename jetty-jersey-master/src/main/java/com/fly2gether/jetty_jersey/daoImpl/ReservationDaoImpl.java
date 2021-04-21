package com.fly2gether.jetty_jersey.daoImpl;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.fly2gether.jetty_jersey.dao.*;

public class ReservationDaoImpl implements reservationDao{

	public Passenger getbookingUser(String reservation_id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("String reservation_id");
			q.setFilter("reservation_id == resa_id");
			q.setUnique(true);
			
			r = (Reservation) q.execute(reservation_id);
			detached = (Reservation) pm.detachCopy(r);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getBookingUser();
	}

	public int getdesiredSeats(String reservation_id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("String reservation_id");
			q.setFilter("reservation_id == resa_id");
			q.setUnique(true);
			
			r = (Reservation) q.execute(reservation_id);
			detached = (Reservation) pm.detachCopy(r);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getDesiredSeats();
	}

	public Flight getFlight(String reservation_id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("String reservation_id");
			q.setFilter("reservation_id == resa_id");
			q.setUnique(true);
			
			r = (Reservation) q.execute(reservation_id);
			detached = (Reservation) pm.detachCopy(r);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getFlight();
	}

	public List<String> getReservations(String passenger_id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<String> passengers_reservations=null;
		List<String> detached=null;
		try {
			tx.begin();
			
			Passenger p = pm.getObjectById(Passenger.class, passenger_id);
			passengers_reservations=p.getPassengerBookingList();

			detached = (List<String>) pm.detachCopy(passengers_reservations);		
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		return detached;
	}

	public void changeNumberOfSeats(int seats,String reservation_id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Reservation r = pm.getObjectById(Reservation.class, reservation_id);
			r.setDesiredSeats(seats);		
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		System.out.println("Number of seats changed to: "+seats);
	}
	
	public void addReservation(Reservation reservation) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(reservation);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
	}

	@SuppressWarnings("unchecked")
	public List<Reservation> getReservations() {
		List<Reservation> reservations=null;
		List<Reservation> detached = new ArrayList<Reservation>();
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);

			reservations = (List<Reservation>) q.execute();
			detached = (List<Reservation>) pm.detachCopyAll(reservations);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	public Reservation getReservation(String reservation_id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("String reservation_id");
			q.setFilter("reservation_id == resa_id");
			q.setUnique(true);
			
			r = (Reservation) q.execute(reservation_id);
			detached = (Reservation) pm.detachCopy(r);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached;
	}

	public void deleteReservation(String id) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r=null;
		try {
			tx.begin();
			r = pm.getObjectById(Reservation.class, id);
            pm.deletePersistent(r);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		System.out.println("Reservation deleted from database");
		
	}

}
