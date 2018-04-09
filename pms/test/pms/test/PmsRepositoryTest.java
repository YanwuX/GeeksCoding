package pms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.logging.Logger;

import org.junit.Test;

import leanTaas.pms.dao.Reservation;
import leanTaas.pms.repo.PmsRepository;

public class PmsRepositoryTest {
	
//	private static Logger log = Logger.getLogger(LoggingObject.class);
	
	PmsRepository repo = PmsRepository.getRepository();
	
	@Test
	public void testGetRepository() {
		assertTrue(repo != null);
		assertTrue(!repo.getProjects().isEmpty());
		assertTrue(!repo.getReservation("p21").isEmpty());
	}

	@Test
	public void testGetProjects() {
		assertEquals(repo.getProjects().size(), 6);
		assertEquals(repo.getProjects().get(0), "p1");
		assertEquals(repo.getProjects().get(1), "p2");
		assertEquals(repo.getProjects().get(2), "p3");
	}

	@Test
	public void testPostReservation() {
		long t1 = 1523269093420L;
		long t2 = 1523269693420L;
		Reservation r1 = new Reservation("p1", new Date(t1), new Date(t2));
		assertTrue(!repo.postReservation(r1).isEmpty());
		assertEquals(repo.getReservation("p11"), "p11, Mon Apr 09 03:18:13 PDT 2018, Mon Apr 09 03:28:13 PDT 2018.");
		
		assertEquals(repo.postReservation(r1), "Projector is not available projector:  p5 p6 is(are) available on the same time projector:  p1 p2 p3 p4 p5 p6 is(are) available on the next day.");
		Reservation r2 = new Reservation("p5", new Date(t1), new Date(t2));
		assertEquals(repo.postReservation(r2), "Success Reservation: p51, p5, Mon Apr 09 03:18:13 PDT 2018, Mon Apr 09 03:28:13 PDT 2018 has been made successfully.");
		assertEquals(repo.postReservation(r1), "Projector is not available projector:  p6 is(are) available on the same time projector:  p1 p2 p3 p4 p5 p6 is(are) available on the next day.");
		
	}

	@Test
	public void testGetReservation() {
		long t1 = 1523269093420L;
		long t2 = 1523269693420L;
		Reservation r1 = new Reservation("p1", new Date(t1), new Date(t2));
		assertTrue(!repo.postReservation(r1).isEmpty());
		assertEquals(repo.getReservation("p11"), "p11, Mon Apr 09 03:18:13 PDT 2018, Mon Apr 09 03:28:13 PDT 2018.");
		
		assertEquals(repo.postReservation(r1), "Projector is not available projector:  p6 is(are) available on the same time projector:  p1 p2 p3 p4 p5 p6 is(are) available on the next day.");
	}

	@Test
	public void testCancelReservation() {
		long t1 = 1523269093420L;
		long t2 = 1523269693420L;
		Reservation r1 = new Reservation("p1", new Date(t1), new Date(t2));
		assertTrue(!repo.postReservation(r1).isEmpty());
		assertEquals(repo.getReservation("p11"), "p11, Mon Apr 09 03:18:13 PDT 2018, Mon Apr 09 03:28:13 PDT 2018.");
		
		assertEquals(repo.cancelReservation("p11"), "Success");
		assertEquals(repo.getReservation("p11"), "Unable to find information");
	}

}
