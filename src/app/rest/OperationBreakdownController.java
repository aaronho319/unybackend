package app.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.OperationBreakdown;
import app.repositories.OperationBreakdownRepository;

@Component
public class OperationBreakdownController {
	@Autowired
	private OperationBreakdownRepository operationBreakdownRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OperationBreakdown> index() {
		return operationBreakdownRepository.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("description") String description,
					   @FormParam("quantity") Integer quantity, @FormParam("date") String date) {
		OperationBreakdown operationBreakdown =  new OperationBreakdown(description, quantity, date);
		operationBreakdownRepository.saveAndFlush(operationBreakdown);
	}

	@GET
	@Path("/{id}/show")
	@Produces(MediaType.APPLICATION_JSON)
	public OperationBreakdown show(@PathParam("id") Long id) {
	    return operationBreakdownRepository.findOne(id);
	}

	@PUT
	@Path("/{id}/update")
	public void update(@PathParam("id") Long id, @FormParam("description") String description,
					   @FormParam("quantity") Integer quantity, @FormParam("date") String date) { 
		OperationBreakdown operationBreakdown = operationBreakdownRepository.findOne(id);
		operationBreakdown.setOperationBreakdownDescription(description);
		operationBreakdown.setOperationBreakdownQuantity(quantity);
		operationBreakdown.setOperationBreakdownDate(date);
		operationBreakdownRepository.saveAndFlush(operationBreakdown);
	}

	@DELETE
	@Path("/{id}/destroy")
	public void destroy(@PathParam("id") Long id){
		operationBreakdownRepository.delete(id);
	}
}