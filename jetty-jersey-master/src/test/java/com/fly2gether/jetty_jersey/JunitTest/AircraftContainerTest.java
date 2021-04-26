package com.fly2gether.jetty_jersey.JunitTest;



import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.fly2gether.jetty_jersey.dao.Aircraft;



public class AircraftContainerTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
		Long containerId = null;

		// Save a container with 3 aircrafts
		{
			PersistenceManager pm = pmf.getPersistenceManager();
			
			Aircraft aircraft1 =new Aircraft("LEARJET40","Boeing",10,5482);
            Aircraft aircraft2 =new Aircraft("LEARJET45","Boeing",28,5987);
            Aircraft aircraft3 =new Aircraft("LEARJET70","Boeing",50,1582);
            Aircraft aircraft4 =new Aircraft("FLYFLY58","Airbus",100,1334);
            Aircraft aircraft5 =new Aircraft("MARSUPILAMI12","Lockheed Martin",70,1423);

			AircraftContainer container = new AircraftContainer();
			container.getFleet().add(aircraft1);
			container.getFleet().add(aircraft2);
			container.getFleet().add(aircraft3);
			container.getFleet().add(aircraft4);
			container.getFleet().add(aircraft5);
			
			System.out.println(container.getFleet().get(0).getModel());
			System.out.println(container.getFleet().get(0));
			System.out.println(container.getFleet().get(1).getConstructorCompany());
			System.out.println(container.getFleet().get(2).getTailNumber());
			System.out.println(container.getFleet().get(3).getTailNumber());
			container = pm.makePersistent(container);
			containerId = container.getId();
			pm.close();
		}

		// Retrieve this container
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			AircraftContainer container = pm.getObjectById(AircraftContainer.class, containerId);
			Assert.assertEquals(5, container.getFleet().size());
			Assert.assertEquals(28, container.getFleet().get(1).getNumberOfSeats());
			Assert.assertEquals("MARSUPILAMI12", container.getFleet().get(4).getModel());

			pm.close();
		}

		pmf.close();
	}

}
