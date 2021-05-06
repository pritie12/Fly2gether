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
public class PassengerDaoImpl implements passengerDao{

	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
	
	public PassengerDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	/* GET */
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
		}
		return detached;
	}
	
	public Passenger getPassenger(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			p = pm.getObjectById(Passenger.class, id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}
	public String getUsername(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
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
		}
		return detached.getUsername();
	}
	public String getPwd(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			p = pm.getObjectById(Passenger.class, Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getPwd();
	}
	public String getname(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
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
		}
		return detached.getName();
	}

	public String getsurname(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
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
		}
		return detached.getSurname();
	}

	public Date getdateOfBirth(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
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
		}
		return detached.getDateOfBirth();
	}

	public String getemail(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
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

		}
		return detached.getEmail();
	}

	public String getphoneNumber(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
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
		}
		return detached.getPhoneNumber();
	}

	public List<Long> getpassengerBookingList(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			p = pm.getObjectById(Passenger.class, Id);
			detached = (Passenger) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getPassengerBookingList();
	}
/*	public Passenger Login(String username, String password) {
		Passenger passenger=getPassenger(username);
		if(passenger==null) {
			System.out.println("Username not found");
			return null;
		}
		if(passenger.getPwd().equals(password)) {
			return passenger;
		}
		return null;
	}*/

	@SuppressWarnings("unchecked")
	public Passenger getPassenger(String username) {
        List<Passenger> result;
        Passenger passenger;

        PersistenceManager pm = pmf.getPersistenceManager();

        Query q = pm.newQuery(Passenger.class, "username.equals(\"" + username + "\")");

        result = (List<Passenger>) q.execute();
        try {
            passenger = (Passenger) result.iterator().next();
        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
        	System.out.println("user not found");
            return null;
        }
        q.close(result);

        return passenger;
	}

	/* PUT */ 
	public void addPassenger(Passenger passenger) {
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			String mail=passenger.getEmail();
			String uname=passenger.getUsername();
			System.out.println(getPassengers().size());
			if(getPassengers().size()==0 ) {
				try {
					System.out.println("avant new email");
					new Email(mail,"Welcome to Fly2gether","Dear passenger,\n\nWelcome to our flightsharing service, we hope that your flights will be enjoyable and that you spend a quality time with us.\nBest regards,\nFly2gether Team");
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				pm.makePersistent(passenger);
				System.out.println("Passenger added to database");
				
			}
			for(Passenger p:getPassengers()) {
				
				if(p.getEmail().equals(mail)==false&&p.getUsername().equals(uname)==false) {
					
					try {
						System.out.println("avant new email");
						new Email(mail,"Welcome to Fly2gether","Dear passenger,\n\nWelcome to our flightsharing service, we hope that your flights will be enjoyable and that you spend a quality time with us.\nBest regards,\nFly2gether Team");
					} catch (MessagingException e) {
						e.printStackTrace();
					}
					pm.makePersistent(passenger);
					System.out.println("Passenger added to database");
				}
				else {
					System.out.println("Email address or username already in use");
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

	public void addReservation(Long passenger_id, Long resa_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			
			Passenger p = pm.getObjectById(Passenger.class, passenger_id);
			if(p. getPassengerBookingList().contains(resa_id)==false) {
				p.getPassengerBookingList().add(resa_id);
			}
			
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
		}
		System.out.println("Reservation added");
		
	}

	/* DELETE */
	
	public void cancelReservation(Long passenger_id, Long resa_id) {
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
		System.out.println("Reservation canceled");
		
	}

	public void deletePassenger(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Passenger.class, id);
            pm.deletePersistent(p);
    		String mail=DAO.getPassengerDao().getPassenger(id).getEmail();	
    		try {
    			new Email(mail,"Account deletion","Dear passenger,\n\nYour account will shortly be deleted from our database, we hope that this is not the end of our collaboration. Please let us know if something in our website inconvenienced you.\n\nBest regards,\nFly2gether Team");
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
		System.out.println("Passenger deleted from database");
		
	}

	public long Login(String username, String password) {
		Passenger passenger=getPassenger(username);
		if(passenger==null) {
			System.out.println("Username not found");
			return -1;
		}
		if(passenger.getPwd().equals(password)) {
			return passenger.getPassengerId();
		}
		return -1;
	}

	/*@SuppressWarnings("unchecked")
	public Passenger getPassenger(String username) {
        List<Passenger> result;
        Passenger passenger;

        PersistenceManager pm = pmf.getPersistenceManager();

        Query q = pm.newQuery(Passenger.class, "username.equals(\"" + username + "\")");

        result = (List<Passenger>) q.execute();
        try {
            passenger = (Passenger) result.iterator().next();
        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
        	System.out.println("user not found");
            return null;

        }
        q.close(result);

        return passenger;
	}*/

	/* POST */
	public void modifyUsername(Long id, String Username) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Passenger.class, id);
			for (Passenger pass:getPassengers()){
				if(pass.getUsername().equals(Username)==false) {
		            p.setUsername(Username);
				}
				else {
					System.out.println("Username already taken");
				}			
			}
            p.setUsername(Username);
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
		Passenger p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Passenger.class, id);
            p.setPwd(Pwd);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
	}


}
