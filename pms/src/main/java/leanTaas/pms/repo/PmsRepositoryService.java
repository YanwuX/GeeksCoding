package leanTaas.pms.repo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;

import leanTaas.pms.dao.Projector;
import leanTaas.pms.dao.ProjectorService;
import leanTaas.pms.dao.Reservation;
import leanTaas.pms.util.Pair;

public class PmsRepositoryService {
	
	private PmsRepository repo = PmsRepository.getRepository();
	HashMap<String, Projector> pm = repo.getData();
	
	public PmsRepository getPmsRepository() {
		return repo;
	}
	
	public ArrayList<String> getProjects() {
		return repo.getProjects();
	}

	public String postReservation(Reservation reservation) {
		String pid = reservation.getId();
		Date startDate = reservation.getStartDate();
		Date endDate = reservation.getEndDate();
		
		StringBuilder sb = new StringBuilder();
		
		if (pm.containsKey(pid)) {
			Projector p = pm.get(pid);
			ProjectorService ps = new ProjectorService(p);
			String resvID = ps.addReservations(startDate, endDate);
			if (resvID.isEmpty()) {
				sb.append(PmsRepository.POST_NOT_AVAL_MSG);
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
				sb.append(PmsRepository.SUCCESS_MSG);
				sb.append(" Reservation: ");
				sb.append(resvID);
				sb.append(", " + pid);
				sb.append(", " + startDate);
				sb.append(", " + endDate);
				sb.append(" has been made successfully.");
				return sb.toString();
			}
		}
		return PmsRepository.ERROR_MSG;
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
		return PmsRepository.ERROR_MSG;
	}
	
	public String cancelReservation(String pid) {
		List<Projector> projectors = Lists.newArrayList(pm.values());
		for (Projector p : projectors) {
			if(p.getReservations().containsKey(pid)) {
				ProjectorService ps = new ProjectorService(p);
				ps.cancelReservations(pid);
				return PmsRepository.SUCCESS_MSG;
			}
		}
		return PmsRepository.ERROR_MSG;
	}
	
	private List<Projector> isAvailable(Date startDate, Date endDate) {
		List<Projector> avals = new ArrayList<Projector>();
		List<Projector> projectors = Lists.newArrayList(pm.values());
		for (Projector p : projectors) {
			ProjectorService ps = new ProjectorService(p);
			if(!ps.isConflict(startDate, endDate)) {
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
