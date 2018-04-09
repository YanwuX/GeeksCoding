package leanTaas.pms.repo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;

import leanTaas.pms.dao.Projector;
import leanTaas.pms.dao.Reservation;
import leanTaas.pms.util.Pair;

public class PmsRepository {

	private HashMap<String, Projector> pm;
	private static PmsRepository repo;
	
	private final String SUCCESS_MSG = "Success";
	private final String POST_NOT_AVAL_MSG = "Projector is not available";
	private final String ERROR_MSG = "Unable to find information";

	private PmsRepository() {

		pm = new HashMap<String, Projector>();

		Projector p1 = new Projector("p1");
		Projector p2 = new Projector("p2");
		Projector p3 = new Projector("p3");
		Projector p4 = new Projector("p4");
		Projector p5 = new Projector("p5");
		Projector p6 = new Projector("p6");
		
		System.out.println(p2.addReservations(new Date(new Date().getTime()), new Date(new Date().getTime()+15000)));
		System.out.println(p3.addReservations(new Date(new Date().getTime()), new Date(new Date().getTime()+15000)));
		System.out.println(p4.addReservations(new Date(new Date().getTime()), new Date(new Date().getTime()+15000)));
		
		pm.put(p1.getProjectName(), p1);
		pm.put(p2.getProjectName(), p2);
		pm.put(p3.getProjectName(), p3);
		pm.put(p4.getProjectName(), p4);
		pm.put(p5.getProjectName(), p5);
		pm.put(p6.getProjectName(), p6);

	}

	public static PmsRepository getRepository() {
		if (repo == null) {
			synchronized (PmsRepository.class) {
				repo = new PmsRepository();
			}
		}
		return repo;
	}
	
	public ArrayList<String> getProjects() {
		return Lists.newArrayList(pm.keySet());
	}
	
	public String postReservation(Reservation reservation) {
		String pid = reservation.getId();
		Date startDate = reservation.getStartDate();
		Date endDate = reservation.getEndDate();
		StringBuilder sb = new StringBuilder();
		if (pm.containsKey(pid)) {
			Projector p = pm.get(pid);
			String resvID = p.addReservations(startDate, endDate);
			if (resvID.isEmpty()) {
				sb.append(POST_NOT_AVAL_MSG);
				sb.append(" projector: ");
				List<Projector> aval = isAvailable(startDate, endDate);
				for (Projector pn : aval) {
					sb.append(" " + pn.getProjectName());
				}
				sb.append(" is(are) available on the same time");
				sb.append(" projector: ");
				List<Projector> avalnd = isAvailable(addOneDay(startDate), addOneDay(endDate));
				for (Projector pn : avalnd) {
					sb.append(" " + pn.getProjectName());
				}
				sb.append(" is(are) available on the next day.");
				
				return sb.toString();
			} else {
				sb.append(SUCCESS_MSG);
				sb.append(" Reservation: ");
				sb.append(resvID);
				sb.append(", " + pid);
				sb.append(", " + startDate);
				sb.append(", " + endDate);
				sb.append(" has been made successfully.");
				return sb.toString();
			}
		}
		return ERROR_MSG;
	}
	
	public String getReservation(String pid) {
		List<Projector> projectors = Lists.newArrayList(pm.values());
		for (Projector p : projectors) {
			if(p.getReservations().containsKey(pid)) {
				Pair<Date> period = p.getReservations().get(pid);
				StringBuilder sb = new StringBuilder();
				sb.append(pid + ", ");
				sb.append(period.getO1().toString() + ", ");
				sb.append(period.getO2().toString() + ".");
				return sb.toString();
			}
		}
		return ERROR_MSG;
	}
	
	public String cancelReservation(String pid) {
		List<Projector> projectors = Lists.newArrayList(pm.values());
		for (Projector p : projectors) {
			if(p.getReservations().containsKey(pid)) {
				p.cancelReservations(pid);
				return SUCCESS_MSG;
			}
		}
		return ERROR_MSG;
	}
	
	private List<Projector> isAvailable(Date startDate, Date endDate) {
		List<Projector> avals = new ArrayList<Projector>();
		List<Projector> projectors = Lists.newArrayList(pm.values());
		for (Projector p : projectors) {
			if(!p.isConflict(startDate, endDate)) {
				avals.add(p);
			}
		}
		return avals;
	}
	
	private Date addOneDay(Date date) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}
}
