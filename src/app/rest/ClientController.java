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

import app.entity.Client;
import app.repositories.ClientRepository;

@Component
@Path("clients")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> index() {
		return clientRepository.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("id") Long id, @FormParam("name") String name,
					   @FormParam("description") String description) {
		Client client =  new Client(id, name, description);
		clientRepository.saveAndFlush(client);
	}
	
	@GET
	@Path("/{id}/show")
	@Produces(MediaType.APPLICATION_JSON)
	public Client show(@PathParam("id") Long id) {
	    return clientRepository.findOne(id);
	}
	
	@PUT
	@Path("/{id}/update")
	public void update(@PathParam("id") Long id, @FormParam("name") String name,
					   @FormParam("description") String description) { 
		Client client = clientRepository.findOne(id);
		client.setClientName(name);
		client.setClientDescription(description);
		clientRepository.saveAndFlush(client);
	}
	
	@DELETE
	@Path("/{id}/destroy")
	public void destroy(@PathParam("id") Long id){
		clientRepository.delete(id);
	}
}



