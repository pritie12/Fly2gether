import java.util.List;


public interface aircraftDao {
	
	List<Aircraft> getAircrafts();

	
	public String getTailNumber(Aircraft aircraft);
	
	void addAircraft(Aircraft aircraft);
	void removeAircraft(Aircraft aircraft);
}
