import java.util.List;

public interface aircraftDao {
	
	List<Aircraft> getAircrafts();
	/**
	 * @return this list of aicrafts with a number of flying hours inferior to that in the parameters
	 */

	List<Aircraft> getAircrafts(int flyingHour);
	/**
	 * @return this list of aicrafts of a certain company
	 */
	List<Aircraft> getAircrafts(String Company);
}
