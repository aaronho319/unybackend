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

import app.entity.Employee;
import app.repositories.EmployeeRepository;

public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> index() {
		return employeeRepository.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("id") Long id, @FormParam("name") String name, @FormParam("gender")  String gender,
					   @FormParam("birthday") String birthday, @FormParam("address") String address, 
					   @FormParam("sss") Long sss, @FormParam("tin") Integer tin, 
					   @FormParam("image") String image, @FormParam("department") String department, 
					   @FormParam("designation") String designation, @FormParam("position") String position, 
					   @FormParam("wage") String wage, @FormParam("employmentStart") String employmentStart, 
					   @FormParam("employmentEnd") String employmentEnd, @FormParam("workDayStart") String workDayStart, 
					   @FormParam("workDayEnd") String workDayEnd, @FormParam("timeStart") String timeStart, 
					   @FormParam("timeEnd") String timeEnd) {
		Employee employee =  new Employee(id, name, gender, birthday, address, sss, tin, image, department,
										  designation, position, wage, employmentStart, employmentEnd, workDayStart, workDayEnd,
										  timeStart, timeEnd);
		employeeRepository.saveAndFlush(employee);
	}

	@GET
	@Path("/{id}/show")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee show(@PathParam("id") Long id) {
	    return employeeRepository.findOne(id);
	}

	@PUT
	@Path("/{id}/update")
	public void update(@PathParam("id") Long id, @FormParam("name") String name, @FormParam("gender")  String gender,
			   @FormParam("birthday") String birthday, @FormParam("address") String address, 
			   @FormParam("sss") Long sss, @FormParam("tin") Integer tin, 
			   @FormParam("image") String image, @FormParam("department") String department, 
			   @FormParam("designation") String designation, @FormParam("position") String position, 
			   @FormParam("wage") String wage, @FormParam("employmentStart") String employmentStart, 
			   @FormParam("employmentEnd") String employmentEnd, @FormParam("workDayStart") String workDayStart, 
			   @FormParam("workDayEnd") String workDayEnd, @FormParam("timeStart") String timeStart, 
			   @FormParam("timeEnd") String timeEnd) { 
		
		Employee employee = employeeRepository.findOne(id);
		employee.setName(name);
		employee.setGender(gender);
		employee.setBirthday(birthday);
		employee.setAddress(address);
		employee.setSss(sss);
		employee.setTin(tin);
		employee.setImage(image);
		employee.setDepartment(department);
		employee.setDesignation(designation);
		employee.setPosition(position);
		employee.setWage(wage);
		employee.setEmploymentStart(employmentStart);
		employee.setEmploymentEnd(employmentEnd);
		employee.setWorkDayStart(workDayStart);
		employee.setWorkDayEnd(workDayEnd);
		employee.setTimeStart(timeStart);
		employee.setTimeEnd(timeEnd);
		employeeRepository.saveAndFlush(employee);
	}

	@DELETE
	@Path("/{id}/destroy")
	public void destroy(@PathParam("id") Long id){
		employeeRepository.delete(id);
	}
}
