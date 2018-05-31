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

import app.entity.Report;
import app.entity.Roll;
import app.repositories.ReportRepository;
import app.repositories.RollRepository;

public class RollController {
	@Autowired
	private RollRepository rollRepository;
	
	@Autowired
	private ReportRepository reportRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Roll> index() {
		return rollRepository.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("report-id") Long reportId, @FormParam("color") String color,
					   @FormParam("yard") Integer yard, @FormParam("layer") Integer layer,
					   @FormParam("layerUsed") Integer layerUsed, @FormParam("remnant") Integer remnant) {
		Report report = reportRepository.findOne(reportId);
		Roll roll =  new Roll(report, color, yard, layer, layerUsed, remnant);
		rollRepository.saveAndFlush(roll);
	}

	@GET
	@Path("/{id}/show")
	@Produces(MediaType.APPLICATION_JSON)
	public Roll show(@PathParam("id") Long id) {
	    return rollRepository.findOne(id);
	}

	@PUT
	@Path("/{id}/update")
	public void update(@PathParam("id") Long id, 
					   @FormParam("report-id") Long reportId, @FormParam("color") String color,
					   @FormParam("yard") Integer yard, @FormParam("layer") Integer layer,
					   @FormParam("layerUsed") Integer layerUsed, @FormParam("remnant") Integer remnant) { 
		Roll roll = rollRepository.findOne(id);
		roll.setRollColor(color);
		roll.setRollYard(yard);
		roll.setRollLayer(layer);
		roll.setRollLayerUsed(layerUsed);
		roll.setRollRemnant(remnant);
		rollRepository.saveAndFlush(roll);
	}

	@DELETE
	@Path("/{id}/destroy")
	public void destroy(@PathParam("id") Long id){
		rollRepository.delete(id);
	}
}
