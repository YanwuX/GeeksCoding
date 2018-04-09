package leanTaas.pms.api;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import leanTaas.pms.dao.Reservation;
import leanTaas.pms.repo.PmsRepository;
@Path("")
public class SimpleAPI implements SimpleAPIInterface {
	
	private PmsRepository repo = PmsRepository.getRepository();
	
	@GET
	@Path("projectors")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<String> getProjector() {
		for (String s : repo.getProjects()) {
			System.out.println(s);
		}
		return repo.getProjects();
	}
	
	@POST
	@Path("reservation")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public String postReservation(Reservation reservation) {
		return repo.postReservation(reservation);
	}
	
	@GET
	@Path("projectors/{id}")
    @Produces(MediaType.TEXT_PLAIN)
	@Override
	public String getReservation(@PathParam("id") String id) {
		return repo.getReservation(id);
	}
	
	@DELETE
	@Path("reservation/{id}")
    @Produces(MediaType.TEXT_PLAIN)
	@Override
	public String cancelReservation(@PathParam("id") String id) {
		return repo.cancelReservation(id);
	}
}
	
