/**
 * 
 */
package leanTaas.pms.dao;

import java.util.Date;
import java.util.HashMap;

import leanTaas.pms.util.Pair;

/**
 * Projector class contains projector information
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
	
	@Override
	public boolean equals(Object other) {		
		return other instanceof Projector && pName.equalsIgnoreCase(((Projector) other).pName);
	}

	/***
	 * Get the reservation ID
	 * @return reservation ID
	 */
	public synchronized String getID() {
		StringBuilder sb = new StringBuilder();
		++id;
		sb.append(pName);
		sb.append(id);
		return sb.toString();
	}
	
}
