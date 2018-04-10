package pms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import leanTaas.pms.dao.Reservation;
import leanTaas.pms.repo.PmsRepository;
import leanTaas.pms.repo.PmsRepositoryService;
/***
 * Test class for PmsRepositoryService
 * @author Yanwu_Alienware
 *
 */
public class PmsRepositoryServiceTest {
	
	PmsRepositoryService prs = new PmsRepositoryService();
	
	long t1 = 1523269093420L;
	long t2 = 1523269693420L;
	
	/***
	 * Test if PmsRepository is exist 
	 */
	@Test
	public void testGetPmsRepository() {
		assertEquals(prs.getPmsRepository(), PmsRepository.getRepository());
	}
	
	/***
	 * Test projectors are properly acquired
	 */
	@Test
	public void testGetProjects() {
		List<String> prsl =prs.getProjects();
		List<String> prl = PmsRepository.getRepository().getProjects();
		assertEquals(prsl.size(), prl.size());
		for (int i = 0; i < prsl.size(); ++i) {
			assertEquals(prsl.get(i), prl.get(i));
		}
	}

	/***
	 * Test if reservations are properly made
	 */
	@Test
	public void testPostReservation() {
		Reservation r1 = new Reservation("p1", new Date(t1), new Date(t2));
		assertTrue(!prs.postReservation(r1).isEmpty());
		assertEquals(prs.getReservation("p11"), "p11, Mon Apr 09 03:18:13 PDT 2018, Mon Apr 09 03:28:13 PDT 2018.");
		assertEquals(prs.postReservation(r1), "Projector is not available projector:  p2 p3 p4 p5 p6 is(are) available on the same time projector:  p1 p2 p3 p4 p5 p6 is(are) available on the next day.");
		Reservation r2 = new Reservation("p5", new Date(t1), new Date(t2));
		assertEquals(prs.postReservation(r2), "Success Reservation: p51, p5, Mon Apr 09 03:18:13 PDT 2018, Mon Apr 09 03:28:13 PDT 2018 has been made successfully.");
		assertEquals(prs.postReservation(r1), "Projector is not available projector:  p2 p3 p4 p6 is(are) available on the same time projector:  p1 p2 p3 p4 p5 p6 is(are) available on the next day.");
	}

	/***
	 * Test if reservation is exist
	 */
	@Test
	public void testGetReservation() {
		Reservation r1 = new Reservation("p1", new Date(t1), new Date(t2));
		assertTrue(!prs.postReservation(r1).isEmpty());
		assertEquals(prs.getReservation("p11"), "p11, Mon Apr 09 03:18:13 PDT 2018, Mon Apr 09 03:28:13 PDT 2018.");
		assertEquals(prs.postReservation(r1), "Projector is not available projector:  p2 p3 p4 p6 is(are) available on the same time projector:  p1 p2 p3 p4 p5 p6 is(are) available on the next day.");
	}

	/***
	 * Test reservation can be properly canceled
	 */
	@Test
	public void testCancelReservation() {
		Reservation r1 = new Reservation("p1", new Date(t1), new Date(t2));
		assertTrue(!prs.postReservation(r1).isEmpty());
		assertEquals(prs.getReservation("p11"), "p11, Mon Apr 09 03:18:13 PDT 2018, Mon Apr 09 03:28:13 PDT 2018.");
		assertEquals(prs.cancelReservation("p11"), "Success");
		assertEquals(prs.getReservation("p11"), "Unable to find information");
	}

}
