package leanTaas.pms.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.glassfish.jersey.internal.guava.Lists;

import leanTaas.pms.dao.Projector;
import leanTaas.pms.dao.ProjectorService;


public class PmsRepository {

	private HashMap<String, Projector> pm;
	private static PmsRepository repo;
	
	public final static String SUCCESS_MSG = "Success";
	public final static String POST_NOT_AVAL_MSG = "Projector is not available";
	public final static String ERROR_MSG = "Unable to find information";

	private PmsRepository() {

		pm = new HashMap<String, Projector>();

		Projector p1 = new Projector("p1");
		Projector p2 = new Projector("p2");
		Projector p3 = new Projector("p3");
		Projector p4 = new Projector("p4");
		Projector p5 = new Projector("p5");
		Projector p6 = new Projector("p6");

		pm.put(p1.getProjectName(), p1);
		pm.put(p2.getProjectName(), p2);
		pm.put(p3.getProjectName(), p3);
		pm.put(p4.getProjectName(), p4);
		pm.put(p5.getProjectName(), p5);
		pm.put(p6.getProjectName(), p6);

		ProjectorService p2s = new ProjectorService(p2);
		ProjectorService p3s = new ProjectorService(p3);
		ProjectorService p4s = new ProjectorService(p4);
		
		p2s.addReservations(new Date(new Date().getTime()), new Date(new Date().getTime()+15000));
		p3s.addReservations(new Date(new Date().getTime()), new Date(new Date().getTime()+15000));
		p4s.addReservations(new Date(new Date().getTime()), new Date(new Date().getTime()+15000));
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
	
	public HashMap<String, Projector> getData() {
		return pm;
	}
}
