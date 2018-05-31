//package app.rest;
//
//import java.util.List;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.FormParam;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import app.entity.CIF;
//import app.repositories.CIFRepository;
//
//public class CIFController {
//	@Autowired
//	private CIFRepository cifRepository;
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<CIF> index() {
//		return cifRepository.findAll();
//	}
//
//	@POST
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	public void create(@FormParam("description") String description,
//					   @FormParam("quantity") Integer quantity, @FormParam("date") String date) {
//		CIF cif =  new CIF(description, quantity, date);
//		cifRepository.saveAndFlush(cif);
//	}
//
//	@GET
//	@Path("/{id}/show")
//	@Produces(MediaType.APPLICATION_JSON)
//	public CIF show(@PathParam("id") Long id) {
//	    return cifRepository.findOne(id);
//	}
//
//	@PUT
//	@Path("/{id}/update")
//	public void update(@PathParam("id") Long id, @FormParam("description") String description,
//					   @FormParam("quantity") Integer quantity, @FormParam("date") String date) { 
//		CIF cif = cifRepository.findOne(id);
//		cif.setCIFDescription(description);
//		cif.setCIFQuantity(quantity);
//		cif.setCIFDate(date);
//		cifRepository.saveAndFlush(cif);
//	}
//
//	@DELETE
//	@Path("/{id}/destroy")
//	public void destroy(@PathParam("id") Long id){
//		cifRepository.delete(id);
//	}
//}	
