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

import app.entity.PostingSheet;
import app.repositories.PostingSheetRepository;

public class PostingSheetController {
	@Autowired
	private PostingSheetRepository postingSheetRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PostingSheet> index() {
		return postingSheetRepository.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("bundleNumber") Integer bundleNumber,
					   @FormParam("layerNumber") Integer layerNumber) {
		PostingSheet postingSheet =  new PostingSheet(bundleNumber, layerNumber);
		postingSheetRepository.saveAndFlush(postingSheet);
	}

	@GET
	@Path("/{id}/show")
	@Produces(MediaType.APPLICATION_JSON)
	public PostingSheet show(@PathParam("id") Long id) {
	    return postingSheetRepository.findOne(id);
	}

	@PUT
	@Path("/{id}/update")
	public void update(@PathParam("id") Long id, @FormParam("bundleNumber") Integer bundleNumber,
					   @FormParam("layerNumber") Integer layerNumber) { 
		PostingSheet postingSheet = postingSheetRepository.findOne(id);	
		postingSheet.setPostingSheetBundleNumber(bundleNumber);
		postingSheet.setPostingSheetLayerNumber(layerNumber);
		postingSheetRepository.saveAndFlush(postingSheet);
	}

	@DELETE
	@Path("/{id}/destroy")
	public void destroy(@PathParam("id") Long id){
		postingSheetRepository.delete(id);
	}
}
