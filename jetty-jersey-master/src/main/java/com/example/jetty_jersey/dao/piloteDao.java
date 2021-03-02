package com.example.jetty_jersey.dao;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public interface piloteDao {
	
	List<Pilote> getPilotes();
	
	public String getPilotId(Pilote pilot);
	public String getname(Pilote pilot);
	public String getsurname(Pilote pilot);
	public Date getdateOfBirth(Pilote pilot);
	public String getemail(Pilote pilot);
	public String getphoneNumber(Pilote pilot);
	public Date getstartingDate(Pilote pilot);
	public Duration getexperience(Pilote pilot);
	
	/**
	 * @return this list of pilots whose experience exceeds the duration in the parameters
	 */
	List<Pilote> getPilotes(Duration experience);
	
	void addPilot(Pilote pilot);
	void deletePilot(Pilote pilot);
}
