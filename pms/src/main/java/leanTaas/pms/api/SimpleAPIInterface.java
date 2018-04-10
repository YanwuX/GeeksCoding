/**
 * 
 */
package leanTaas.pms.api;

import java.util.List;

import leanTaas.pms.dao.Reservation;

/**
 * SimpleAPI Interface
 * @author Yanwu_Alienware
 *
 */
public interface SimpleAPIInterface {

	public List<String> getProjector();
		
	public String postReservation(Reservation reservation);
	
	public String getReservation(String id);
	
	public String cancelReservation(String id);
}
