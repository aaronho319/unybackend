package app.rest;

import app.entity.Course;
import app.entity.Professor;
import app.entity.ProfessorCourse;
import app.repositories.CourseRepository;
import app.repositories.ProfessorCourseRepository;
import app.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("professor-courses")
public class ProfessorCourseController {
    @Autowired
    ProfessorCourseRepository professorCourseRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    CourseRepository courseRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfessorCourse> index() {
        return professorCourseRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(@FormParam("professor-id") Long professorId, @FormParam("course-id") Long courseId) {
        Professor professor = professorRepository.findOne(professorId);
        Course course = courseRepository.findOne(courseId);
        ProfessorCourse professorCourse = new ProfessorCourse();
        professorCourse.setProfessor(professor);
        professorCourse.setCourse(course);
        professorCourseRepository.saveAndFlush(professorCourse);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfessorCourse show(@PathParam("id") Long id) {
        return professorCourseRepository.findOne(id);
    }

    @DELETE
    @Path("/{id}")
    public void destroy(@PathParam("id") Long id) {
        professorCourseRepository.delete(id);
    }
}
