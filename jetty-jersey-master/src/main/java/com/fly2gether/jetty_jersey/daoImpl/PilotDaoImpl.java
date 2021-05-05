package com.fly2gether.jetty_jersey.daoImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.mail.MessagingException;

import com.fly2gether.jetty_jersey.dao.*;
public class PilotDaoImpl implements pilotDao {
	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
	
	public PilotDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}	

	public String getUsername(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(Id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getUsername();
	}
	public String getPwd(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(Id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getPwd();
	}

	public String getname(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getName();
	}

	public String getsurname(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getSurname();
	}

	public Date getdateOfBirth(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getDateOfBirth();
	}

	public String getemail(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getEmail();
	}

	public String getphoneNumber(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getPhoneNumber();
	}

	public int getFlyingHours(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getFlyingHours();
	}

	@SuppressWarnings("unchecked")
	
	public List<Flight> getScheduledFlights(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Flight> scheduledFlights=new ArrayList<Flight>();
		List<Flight> detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Flight.class);
			q.declareParameters("Long id");
			q.setFilter("id ==  flightPilotId");
			
			q.setUnique(true);			
			scheduledFlights = (List<Flight>) q.execute(id);
			detached = (List<Flight>) pm.detachCopy(scheduledFlights);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	public void addPilot(Pilot pilot) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			pm.makePersistent(pilot);
			String mail=pilot.getEmail();
			try {
				new Email(mail,"Welcome to Fly2gether","Dear pilot,\n\nWelcome to our flightsharing service, we hope that your flights will be enjoyable and that you spend a quality time with us.\nBest regards,\nFly2gether Team");
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pilot> getPilots() {
		List<Pilot> pilots=null;
		List<Pilot> detached = new ArrayList<Pilot>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Pilot.class);
			pilots = (List<Pilot>) q.execute();
			detached = (List<Pilot>) pm.detachCopyAll(pilots);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	public void deletePilot(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Pilot.class, id);
            pm.deletePersistent(p);
    		String mail=DAO.getPilotDao().getPilot(id).getEmail();
    		try {
    			new Email(mail,"Welcome to Fly2gether", "Dear pilot,\n\nYour account will shortly be deleted from our database, we hope that this is not the end of our collaboration. Please let us know if something in our website inconvenienced you.\n\nBest regards,\nFly2gether Team");
    		} catch (MessagingException e) {
    			e.printStackTrace();
    		}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Pilot deleted from database");		
	}

	public Pilot getPilot(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("Long id");
			q.setFilter("id == pilot_id");
			q.setUnique(true);
			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}



	public void modifyUsername(Long id, String Username) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Pilot.class, id);
			for (Pilot pil:getPilots()){
				if(pil.getUsername().equals(Username)==false) {
		            p.setUsername(Username);
				}
				else {
					System.out.println("Username already taken");
				}			
			}
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}


	public void modifyPwd(Long id, String Pwd) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Pilot.class, id);
            p.setPwd(Pwd);
            pm.makePersistent(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
	}


	public Pilot Login(String username, String password) {
		Pilot pilot=getPilot(username);
		if(pilot==null) {
			System.out.println("Username not found");
			return null;
		}
		if(pilot.getPwd().equals(password)) {
			return pilot;
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	public Pilot getPilot(String username) {
        List<Pilot> result;
        Pilot pilot;

        PersistenceManager pm = pmf.getPersistenceManager();
        Query q = pm.newQuery(Pilot.class, "username.equals(\"" + username + "\")");
        result = (List<Pilot>) q.execute();
        try {
            pilot = (Pilot) result.iterator().next();
        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
        	System.out.println("user not found");
            return null;
        }
        q.close(result);

        return pilot;
	}




}
