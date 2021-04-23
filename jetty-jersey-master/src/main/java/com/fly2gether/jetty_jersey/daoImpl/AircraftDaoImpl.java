package com.fly2gether.jetty_jersey.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.fly2gether.jetty_jersey.dao.*;

public class AircraftDaoImpl implements aircraftDao{

	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Aircraft");
	
	public AircraftDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aircraft> getFleet() {	
		List<Aircraft> aircrafts=null;
		List<Aircraft> detached = new ArrayList<Aircraft>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);

			aircrafts = (List<Aircraft>) q.execute();
			detached = (List<Aircraft>) pm.detachCopyAll(aircrafts);

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
	
	
	
	public String getModel(String TailNumber) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a = null;
		Aircraft detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String TailNumber");
			q.setFilter("TailNumber == tailNumber");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(TailNumber);
			detached = (Aircraft) pm.detachCopy(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getModel();
	}
	
	
	public String getCompany(String TailNumber) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a = null;
		Aircraft detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String TailNumber");
			q.setFilter("TailNumber == tailNumber");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(TailNumber);
			detached = (Aircraft) pm.detachCopy(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getConstructorCompany();
	}

	public int getNumberOfSeats(String TailNumber) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a = null;
		Aircraft detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String TailNumber");
			q.setFilter("TailNumber == tailNumber");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(TailNumber);
			detached = (Aircraft) pm.detachCopy(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getNumberOfSeats();
	}

	public void addAircraft(Aircraft aircraft) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(aircraft);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}		
	}



	public void deleteAircraft(String TailNumber) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a=null;
		try {
			tx.begin();
			a = pm.getObjectById(Aircraft.class, TailNumber);
            pm.deletePersistent(a);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}		
		
	}



	public Aircraft getAircraft(String TailNumber) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a = null;
		Aircraft detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("String TailNumber");
			q.setFilter("TailNumber == tailNumber");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(TailNumber);
			detached = (Aircraft) pm.detachCopy(a);

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
}
