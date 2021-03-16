package com.fly2gether.jetty_jersey.dao;
import java.util.Date;


public interface pilotDao {
	
	/* GET */
	String getname(String id);
	String getsurname(String id);
	Date getdateOfBirth(String id);
	String getemail(String id);
	String getphoneNumber(String id);
	int getFlyingHours(String id);
	
	/* POST */
	/* no post requests here */
	
	/* ADD */
	void addPilot();
	
	/* DELETE */
	/* no delete requests here */

}
