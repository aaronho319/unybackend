package app.rest;

import app.entity.Professor;
import app.entity.Student;
import app.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    ChikkaComponent chikka;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> index() {
        return studentRepository.findAll();
    }
    
    @POST
	@Path("/{id}/mobile_student_detail")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String send(@FormParam("id") Long id,
					   @FormParam("number") String number, 
					   @FormParam("message") String message) {
    	
		try{
			return chikka.send(id, studentRepository.findOne(id).getNumber().toString(),  studentRepository.findOne(id).toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "Bad";
	}

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(@FormParam("name") String name, @FormParam("email") String email,
                       @FormParam("course") String course, @FormParam("year") Integer year,
                       @FormParam("number") Integer number) {
        Student student = new Student(name, email, course, year, number);
        studentRepository.saveAndFlush(student);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student show(@PathParam("id") Long id) {
        return studentRepository.findOne(id);
    }

    @GET
    @Path("/{id}/edit")
    @Produces(MediaType.APPLICATION_JSON)
    public Student edit(@PathParam("id") Long id) {
        return studentRepository.findOne(id);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, @FormParam("name") String name, @FormParam("email") String email,
                       @FormParam("course") String course, @FormParam("year") Integer year,
                       @FormParam("number") Integer number) {
        Student student = studentRepository.findOne(id);
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);
        student.setYear(year);
        student.setNumber(number);
        studentRepository.saveAndFlush(student);
    }

    @DELETE
    @Path("/{id}")
    public void destroy(@PathParam("id") Long id) {
        studentRepository.delete(id);
    }
}
