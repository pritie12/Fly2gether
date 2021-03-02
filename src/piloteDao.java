import java.time.Duration;
import java.util.List;

public interface piloteDao {
	
	List<Pilote> getPilotes();
	
	public int getPilotId(Pilote pilot);
	
	/**
	 * @return this list of pilots whose experience exceeds the duration in the parameters
	 */
	List<Pilote> getPilotes(Duration experience);
	
	void addPilot(Pilote pilot);
	void deletePilot(Pilote pilot);
}
