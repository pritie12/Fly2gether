import java.time.Duration;
import java.util.List;

public interface piloteDao {
	
	List<Pilote> getPilotes();
	
	/**
	 * @return this list of pilots whose experience exceeds the duration in the parameters
	 */
	List<Pilote> getPilotes(Duration experience);
	
	void addPilot(int usr_id);
	void deletePilot(int usr_id);
}
