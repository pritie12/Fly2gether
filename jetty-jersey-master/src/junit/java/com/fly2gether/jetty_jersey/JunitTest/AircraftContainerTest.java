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
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Aicrafts");
		Long containerId = null;

		// Save a container with 3 aircrafts
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			Aircraft aircraft1 =new Aircraft("LEARJET40","Boeing",10);
			Aircraft aircraft2 =new Aircraft("LEARJET45","Boeing",28);
			Aircraft aircraft3 =new Aircraft("LEARJET70","Boeing",50);

			AircraftContainer container = new AircraftContainer();
			container.getFleet().add(aircraft1);
			container.getFleet().add(aircraft2);
			container.getFleet().add(aircraft3);

			container = pm.makePersistent(container);
			containerId = container.getId();
			pm.close();
		}
		// Retrieve this container
				{
					PersistenceManager pm = pmf.getPersistenceManager();

					AircraftContainer container = pm.getObjectById(AircraftContainer.class, containerId);
					Assert.assertEquals(3, container.getFleet().size());

					pm.close();
				}

				pmf.close();
	}
}
