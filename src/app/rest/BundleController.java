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

import app.entity.Bundle;
import app.entity.CIF;
import app.entity.PostingSheet;
import app.repositories.BundleRepository;
import app.repositories.CIFRepository;
import app.repositories.PostingSheetRepository;

@Component
@Path("bundles")
public class BundleController {
	@Autowired
	private BundleRepository bundleRepository;
	
	@Autowired
	private CIFRepository cifRepository;
	 
	@Autowired
	private PostingSheetRepository postingSheetRepository;
	   
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bundle> index() {
		return bundleRepository.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("cif-id") Long cifId, @FormParam("posting-sheet-id") Long postingSheetId) {
		CIF cif = cifRepository.findOne(cifId);
		PostingSheet postingSheet = postingSheetRepository.findOne(postingSheetId);
		Bundle bundle = new Bundle(cif, postingSheet);
		bundleRepository.saveAndFlush(bundle);
	}
	
	@PUT
	@Path("/{id}/update")
	public void update(@PathParam("id") Long id, @FormParam("bundleNumber") Integer bundleNumber,
			  		   @FormParam("bundleSize") Integer bundleSize, @FormParam("bundleQuantity") Integer bundleQuantity, 
			  		   @FormParam("bundleGender") String bundleGender) { 
		
		Bundle bundle = bundleRepository.findOne(id);
		bundle.setBundleNumber(bundleNumber);
		bundle.setBundleSize(bundleSize);
		bundle.setBundleQuantity(bundleQuantity);
		bundle.setBundleGender(bundleGender);
		bundleRepository.saveAndFlush(bundle);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bundle show(@PathParam("id") Long id) {
	    return bundleRepository.findOne(id);
	}

	@DELETE
	@Path("/{id}")
	public void destroy(@PathParam("id") Long id) {
	    bundleRepository.delete(id);
	}
		
}
	
