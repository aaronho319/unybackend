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

import app.entity.Pattern;
import app.repositories.PatternRepository;

public class PatternController {
	@Autowired
	private PatternRepository patternRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pattern> index() {
		return patternRepository.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("cutterName") String cutterName, @FormParam("date") String date,
					   @FormParam("description") String description, @FormParam("clientName") String clientName,
					   @FormParam("totalSize") Integer totalSize, @FormParam("totalQuantity") Integer totalQuantity,
					   @FormParam("totalYard") Integer totalYard) {
		Pattern Pattern =  new Pattern(cutterName, date, description, clientName, totalSize, totalQuantity, totalYard);
		patternRepository.saveAndFlush(Pattern);
	}

	@GET
	@Path("/{id}/show")
	@Produces(MediaType.APPLICATION_JSON)
	public Pattern show(@PathParam("id") Long id) {
	    return patternRepository.findOne(id);
	}

	@PUT
	@Path("/{id}/update")
	public void update(@PathParam("id") Long id, @FormParam("cutterName") String cutterName, 
					   @FormParam("date") String date, @FormParam("description") String description, 
					   @FormParam("clientName") String clientName, @FormParam("totalSize") Integer totalSize,
					   @FormParam("totalQuantity") Integer totalQuantity, @FormParam("totalYard") Integer totalYard) { 
		Pattern Pattern = patternRepository.findOne(id);	
		Pattern.setPatternCutterName(cutterName);
		Pattern.setPatternDate(date);
		Pattern.setPatternDescription(description);
		Pattern.setPatternClientName(clientName);
		Pattern.setPatternTotalSize(totalSize);
		Pattern.setPatternTotalQuantity(totalQuantity);
		Pattern.setPatternTotalYard(totalYard);
		patternRepository.saveAndFlush(Pattern);
	}

	@DELETE
	@Path("/{id}/destroy")
	public void destroy(@PathParam("id") Long id){
		patternRepository.delete(id);
	}
}
