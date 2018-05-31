package app.rest;

import app.entity.Course;
import app.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> index() {
        return courseRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(@FormParam("code") String code, @FormParam("title") String title) {
        Course course = new Course(code, title);
        courseRepository.saveAndFlush(course);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course show(@PathParam("id") Long id) {
        return courseRepository.findOne(id);
    }

    @GET
    @Path("/{id}/edit")
    @Produces(MediaType.APPLICATION_JSON)
    public Course edit(@PathParam("id") Long id) {
        return courseRepository.findOne(id);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, @FormParam("code") String code, @FormParam("title") String title) {
        Course course = courseRepository.findOne(id);
        course.setCode(code);
        course.setTitle(title);
        courseRepository.saveAndFlush(course);
    }

    @DELETE
    @Path("/{id}")
    public void destroy(@PathParam("id") Long id) {
        courseRepository.delete(id);
    }
}
