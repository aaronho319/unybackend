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
import app.repositories.ReportRepository;

public class ReportController {
	@Autowired
	private ReportRepository reportRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Report> index() {
		return reportRepository.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("description") String description, @FormParam("date") String date,
					   @FormParam("reporterName") String reporterName, @FormParam("totalRoll") Integer totalRoll,
					   @FormParam("totalYard") Integer totalYard, @FormParam("totalLayer") Integer totalLayer,
					   @FormParam("totalActualYardUsed") Integer totalActualYardUsed, 
					   @FormParam("totalRemnant") Integer totalRemnant, @FormParam("totalCutQuantity") Integer totalCutQuantity) {
		Report report =  new Report(description, date, reporterName, totalRoll, totalYard, totalLayer, totalActualYardUsed, totalRemnant, totalCutQuantity);
		reportRepository.saveAndFlush(report);
	}

	@GET
	@Path("/{id}/show")
	@Produces(MediaType.APPLICATION_JSON)
	public Report show(@PathParam("id") Long id) {
	    return reportRepository.findOne(id);
	}

	@PUT
	@Path("/{id}/update")
	public void update(@PathParam("id") Long id, 
					   @FormParam("description") String description, @FormParam("date") String date,
					   @FormParam("reporterName") String reporterName, @FormParam("totalRoll") Integer totalRoll,
					   @FormParam("totalYard") Integer totalYard, @FormParam("totalLayer") Integer totalLayer,
					   @FormParam("totalActualYardUsed") Integer totalActualYardUsed, 
					   @FormParam("totalRemnant") Integer totalRemnant, @FormParam("totalCutQuantity") Integer totalCutQuantity) { 
		Report report = reportRepository.findOne(id);
		report.setReportDescription(description);
		report.setReportDate(date);
		report.setReporterName(reporterName);
		report.setReportTotalRoll(totalRoll);
		report.setReportTotalYard(totalYard);
		report.setReportTotalLayer(totalLayer);
		report.setReportTotalActualYardUsed(totalActualYardUsed);
		report.setReportTotalRemnant(totalRemnant);
		report.setReportTotalCutQuantity(totalCutQuantity);
		reportRepository.saveAndFlush(report);
	}

	@DELETE
	@Path("/{id}/destroy")
	public void destroy(@PathParam("id") Long id){
		reportRepository.delete(id);
	}
}
