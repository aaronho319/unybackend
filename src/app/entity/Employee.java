package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@Column
	private Long employeeId;
	
	@NotNull(message = "Name Required")
	@Column
	private String employeeName;
	
	@NotNull(message = "Gender Required")
	@Column
	private String employeeGender;
	
	@NotNull(message = "Birthday Required")
	@Column
	private String employeeBirthday;
	
	@NotNull(message = "Address Required")
	@Column
	private String employeeAddress;
	
	@NotNull(message = "SSS Required")
	@Column
	private Long employeeSSS;
	
	@NotNull(message = "Tin Required")
	@Column
	private Integer employeeTin;
	
	@NotNull(message = "Image Required")
	@Column
	private String employeeImage;
	
	@NotNull(message = "Department Required")
	@Column
	private String employeeDepartment;
	
	@NotNull(message = "Designation Required")
	@Column
	private String employeeDesignation;
	
	@NotNull(message = "Position Required")
	@Column
	private String employeePosition;
	
	@NotNull(message = "Wage Required")
	@Column
	private String employeeWage;
	
	@NotNull(message = "Employment Start Required")
	@Column
	private String employmentStart;
	
	@NotNull(message = "Employment End Required")
	@Column
	private String employmentEnd;
	
	@NotNull(message = "Work Day Start Required")
	@Column
	private String workDayStart;
	
	@NotNull(message = "Work Day End Required")
	@Column
	private String workDayEnd;
	
	@NotNull(message = "Time Start Required")
	@Column
	private String timeStart;
	
	@NotNull(message = "Time End Required")
	@Column
	private String timeEnd;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<EmployeeBundle> employeeBundle;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<OperationEmployee> operationEmployee;
	
	public Employee() {
		this.employeeBundle = new ArrayList<>();
		this.operationEmployee = new ArrayList<>();
	}
	
	public Employee(Long id, String name, String gender, String birthday, String address, Long sss, Integer tin, String image,
					String department, String designation, String position, String wage, String employmentStart, String employmentEnd,
					String workDayStart, String workDayEnd, String timeStart, String timeEnd) {
		this.employeeId = id;
		this.employeeName = name;
		this.employeeBirthday = birthday;
		this.employeeAddress = address;
		this.employeeSSS = sss;
		this.employeeTin = tin;
		this.employeeImage = image;
		this.employeeDepartment = department;
		this.employeeDesignation = designation;
		this.employeePosition = position;
		this.employeeWage = wage;
		this.employmentStart = employmentStart;
		this.employmentEnd = employmentEnd;
		this.workDayStart = workDayStart;
		this.workDayEnd = workDayEnd;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		
		this.employeeBundle = new ArrayList<>();
		this.operationEmployee = new ArrayList<>();
	}
	
	public Long getId() {
		return employeeId;
	}

	public void setId(Long id) {
		this.employeeId = id;
	}

	public String getName() {
		return employeeName;
	}

	public void setName(String name) {
		this.employeeName = name;
	}

	public String getGender() {
		return employeeGender;
	}

	public void setGender(String gender) {
		this.employeeGender = gender;
	}

	public String getBirthday() {
		return employeeBirthday;
	}

	public void setBirthday(String birthday) {
		this.employeeBirthday = birthday;
	}

	public String getAddress() {
		return employeeAddress;
	}

	public void setAddress(String address) {
		this.employeeAddress = address;
	}

	public Long getSss() {
		return employeeSSS;
	}

	public void setSss(Long sss) {
		this.employeeSSS = sss;
	}

	public Integer getTin() {
		return employeeTin;
	}

	public void setTin(Integer tin) {
		this.employeeTin = tin;
	}

	public String getImage() {
		return employeeImage;
	}

	public void setImage(String image) {
		this.employeeImage = image;
	}

	public String getDepartment() {
		return employeeDepartment;
	}

	public void setDepartment(String department) {
		this.employeeDepartment = department;
	}

	public String getDesignation() {
		return employeeDesignation;
	}

	public void setDesignation(String designation) {
		this.employeeDesignation = designation;
	}

	public String getPosition() {
		return employeePosition;
	}

	public void setPosition(String position) {
		this.employeePosition = position;
	}

	public String getWage() {
		return employeeWage;
	}

	public void setWage(String wage) {
		this.employeeWage = wage;
	}

	public String getEmploymentStart() {
		return employmentStart;
	}

	public void setEmploymentStart(String employmentStart) {
		this.employmentStart = employmentStart;
	}

	public String getEmploymentEnd() {
		return employmentEnd;
	}

	public void setEmploymentEnd(String employmentEnd) {
		this.employmentEnd = employmentEnd;
	}

	public String getWorkDayStart() {
		return workDayStart;
	}

	public void setWorkDayStart(String workDayStart) {
		this.workDayStart = workDayStart;
	}

	public String getWorkDayEnd() {
		return workDayEnd;
	}

	public void setWorkDayEnd(String workDayEnd) {
		this.workDayEnd = workDayEnd;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

}


