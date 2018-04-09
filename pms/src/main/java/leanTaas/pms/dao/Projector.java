/**
 * 
 */
package leanTaas.pms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import leanTaas.pms.util.Pair;

/**
 * @author Yanwu_Alienware
 *
 */
public class Projector {
		
	private final String pName;
	private int id = 0;
	private HashMap<String, Pair<Date>> reservations;
	
	public Projector(String pName) {
		this.pName = pName;
		this.reservations = new HashMap<String, Pair<Date>>();
	}
	
	public String getProjectName() {
		return pName;
	}
	
	public HashMap<String, Pair<Date>> getReservations() {
		return reservations;
	}

	public boolean isConflict(Date startDate, Date endDate) {
		Collection<Pair<Date>> list = reservations.values();
		for (Pair<Date> period : list ) {
//			Date pstart = period.getO1();
			Date pend = period.getO2();
			if (startDate.before(pend)) {
				return true;
			} 
		};
		return false;
	}
	
	public String addReservations(Date startDate, Date endDate) {
		if (!isConflict(startDate, endDate)) {
			String id = getID();
			reservations.put(id, new Pair<Date>(startDate, endDate));
			return id;
		}
		return "";
	}
	
	@Override
	public boolean equals(Object other) {		
		return other instanceof Projector && pName.equalsIgnoreCase(((Projector) other).pName);
	}

	public boolean cancelReservations(String rid) {
		if (reservations.containsKey(rid)) {
			reservations.remove(rid);
			return true;
		}
		return false;
	}
	
	private synchronized String getID() {
		StringBuilder sb = new StringBuilder();
		++id;
		sb.append(pName);
		sb.append(id);
		return sb.toString();
	}
	
}
