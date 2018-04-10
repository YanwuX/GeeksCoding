package pms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;

import org.junit.Test;

import leanTaas.pms.dao.Projector;
import leanTaas.pms.dao.ProjectorService;
import leanTaas.pms.repo.PmsRepository;

/***
 * Test class for ProjectorService
 * @author Yanwu_Alienware
 *
 */
public class ProjectorServiceTest {
	
	PmsRepository repo = PmsRepository.getRepository();
	HashMap<String, Projector> pm = repo.getData();

	long t1 = 1523269093420L; // Mon Apr 09 03:18:13 PDT 2018
	long t2 = 1523269693420L; // Mon Apr 09 03:28:13 PDT 2018
	
	/***
	 * Test if projector can be properly acquired
	 */
	@Test
	public void testProjectorService() {
		HashMap<String, Projector> pm = repo.getData();
		ProjectorService ps = new ProjectorService(pm.get("p1"));
		assertEquals(ps.getProjector(), pm.get("p1"));
		
	}

	/***
	 * Test to get desired projector
	 */
	@Test
	public void testGetProjector() {
		ProjectorService ps3 = new ProjectorService(pm.get("p3"));

		assertEquals(ps3.getProjector(), pm.get("p3"));
	}

	/***
	 * Test if the reservation conflicts with another
	 */
	@Test
	public void testIsConflict() {
		ProjectorService ps3 = new ProjectorService(pm.get("p3"));

		assertTrue(!ps3.isConflict(new Date(t1), new Date(t2)));
		assertTrue(ps3.isConflict(new Date(t2), new Date(t1)));
		assertTrue(!ps3.isConflict(new Date(t1 - 60000), new Date(t2 + 90000)));
	}

	/***
	 * Test if reservation can be properly added
	 */
	@Test
	public void testAddReservations() {
		ProjectorService ps3 = new ProjectorService(pm.get("p3"));

		assertEquals(ps3.addReservations(new Date(t1), new Date(t2)), "p32");
		assertEquals(ps3.addReservations(new Date(t1 + 50), new Date(t2 + 10000)), "");
		assertEquals(ps3.addReservations(new Date(t2), new Date(t1)), "");
		assertEquals(ps3.addReservations(new Date(t2), new Date(t1 + 80000)), "");
		
		ProjectorService ps6 = new ProjectorService(pm.get("p6"));

		assertEquals(ps6.addReservations(new Date(t1), new Date(t2)), "p61");
		assertEquals(ps6.addReservations(new Date(t1 + 50), new Date(t2 + 10000)), "");
		assertEquals(ps6.addReservations(new Date(t2), new Date(t1)), "");
		assertEquals(ps6.addReservations(new Date(t1 + 1000000), new Date(t2 + 1800000)), "p62");
	}

	/***
	 * Test if reservation can be properly canceled
	 */
	@Test
	public void testCancelReservations() {
		ProjectorService ps3 = new ProjectorService(pm.get("p3"));

		assertTrue(ps3.cancelReservations("p31"));
		
		ProjectorService ps6 = new ProjectorService(pm.get("p6"));
		
		assertTrue(ps6.cancelReservations("p61"));
		assertTrue(!ps6.cancelReservations("p63"));

	}

}
