package com.fly2gether.jetty_jersey.daoImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.fly2gether.jetty_jersey.dao.*;
public class PassengerDaoImpl implements passengerDao{

	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Passenger");
	
	public PassengerDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	@SuppressWarnings("unchecked")
	public List<Passenger> getPassengers(){
		List<Passenger> passengers=null;
		List<Passenger> detached = new ArrayList<Passenger>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);

			passengers = (List<Passenger>) q.execute();
			detached = (List<Passenger>) pm.detachCopyAll(passengers);

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
	
	public Passenger getPassenger(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String id");
			q.setFilter("id == passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(id);
			detached = (Passenger) pm.detachCopy(p);

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
	public Map<String, String> getLoginInfo(String Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getLoginInfo();
	}

	public String getname(String Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getName();
	}

	public String getsurname(String Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getSurname();
	}

	public Date getdateOfBirth(String Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getDateOfBirth();
	}

	public String getemail(String Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getEmail();
	}

	public String getphoneNumber(String Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getPhoneNumber();
	}

	public List<String> getpassengerBookingList(String Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getPassengerBookingList();
	}

	public void addPassenger(Passenger passenger) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(passenger);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}	
		System.out.println("Passenger added to database");
		
	}

	public void addReservation(String passenger_id, String resa_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Passenger p = pm.getObjectById(Passenger.class, passenger_id);
			if(p. getPassengerBookingList().contains(resa_id)) {
				p.getPassengerBookingList().add(resa_id);
			}
			
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		System.out.println("Reservation added");
		
	}

	public void removeReservation(String passenger_id, String resa_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Passenger p = pm.getObjectById(Passenger.class, passenger_id);
			if(p. getPassengerBookingList().contains(resa_id)) {
				p.getPassengerBookingList().remove(resa_id);
			}
			
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		System.out.println("Reservation removed");
		
	}

	public void deletePassenger(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Passenger.class, id);
            pm.deletePersistent(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		System.out.println("Passenger deleted from database");
		
	}

}
