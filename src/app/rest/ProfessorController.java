package app.rest;

import app.entity.Course;
import app.entity.Professor;
import app.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("professors")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> index() {
        return professorRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(@FormParam("name") String name) {
        Professor professor = new Professor(name);
        professorRepository.saveAndFlush(professor);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor show(@PathParam("id") Long id) {
        return professorRepository.findOne(id);
    }

    @GET
    @Path("/{id}/edit")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor edit(@PathParam("id") Long id) {
        return professorRepository.findOne(id);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, @FormParam("name") String name) {
        Professor professor = professorRepository.findOne(id);
        professor.setName(name);
        professorRepository.saveAndFlush(professor);
    }

    @DELETE
    @Path("/{id}")
    public void destroy(@PathParam("id") Long id) {
        professorRepository.delete(id);
    }
}
