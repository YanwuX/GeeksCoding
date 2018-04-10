package leanTaas.pms.dao;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import leanTaas.pms.util.Pair;

/***
 * ProjectorService class contains the service handler for Projector
 * @author Yanwu_Alienware
 *
 */
public class ProjectorService {
	
	private Projector projector;
	private HashMap<String, Pair<Date>> reservations;
	
	public ProjectorService(Projector projector) {
		this.projector = projector;
		reservations = projector.getReservations();
	}
	
	public Projector getProjector() {
		return projector;
	}

	/***
	 * Check if the reservation time period conflicts with another
	 * @param startDate
	 * @param endDate
	 * @return true if conflict
	 */
	public boolean isConflict(Date startDate, Date endDate) {
		
		if (startDate.after(endDate)) {
			return true;
		}
		
		Collection<Pair<Date>> list = reservations.values();
		
		for (Pair<Date> period : list ) {
			Date pstart = period.getO1();
			Date pend = period.getO2();
			if (startDate.before(pend) && endDate.after(pstart)) {
				return true;
			} 
		};
		return false;
	}

	/***
	 * Add reservation to particular projector
	 * @param startDate
	 * @param endDate
	 * @return reservation ID if successfully added, empty ID if reservation has conflicts
	 */
	public String addReservations(Date startDate, Date endDate) {
		if (!isConflict(startDate, endDate)) {
			String id = projector.getID();
			reservations.put(id, new Pair<Date>(startDate, endDate));
			return id;
		}
		return "";
	}

	/***
	 * Cancel reservation
	 * @param rid
	 * @return true if reservation is canceled
	 */
	public boolean cancelReservations(String rid) {
		if (reservations.containsKey(rid)) {
			reservations.remove(rid);
			return true;
		}
		return false;
	}
	
}
