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

import app.entity.Cut;
import app.entity.Pattern;
import app.entity.Report;
import app.repositories.CutRepository;
import app.repositories.PatternRepository;
import app.repositories.ReportRepository;

@Component
@Path("cuts")
public class CutController {
	@Autowired
	private CutRepository cutRepository;
	
	@Autowired
	private PatternRepository patternRepository;
	 
	@Autowired
	private ReportRepository reportRepository;
	   
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cut> index() {
		return cutRepository.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("pattern-id") Long patternId, @FormParam("report-id") Long reportId) {
		Pattern pattern = patternRepository.findOne(patternId);
		Report report = reportRepository.findOne(reportId);
		Cut cut = new Cut(pattern, report);
		cutRepository.saveAndFlush(cut);
	}
	
	@PUT
	@Path("/{id}/update")
	public void update(@PathParam("id") Long id, @FormParam("cutName") String cutName, 
					   @FormParam("cutLay") Integer cutLay, @FormParam("sizeCount") Integer sizeCount, 
					   @FormParam("totalYard") Integer totalYard) { 
		
		Cut cut = cutRepository.findOne(id);
		cut.setCutName(cutName);
		cut.setCutLay(cutLay);
		cut.setCutSizeCount(sizeCount);
		cut.setCutTotalYard(totalYard);
		cutRepository.saveAndFlush(cut);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cut show(@PathParam("id") Long id) {
	    return cutRepository.findOne(id);
	}

	@DELETE
	@Path("/{id}")
	public void destroy(@PathParam("id") Long id) {
	    cutRepository.delete(id);
	}
		
}
	
