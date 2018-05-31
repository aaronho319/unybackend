package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class EmployeeBundle {
	public Long getEmployeeBundleId() {
		return employeeBundleId;
	}

	public void setEmployeeBundleId(Long employeeBundleId) {
		this.employeeBundleId = employeeBundleId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Bundle getBundle() {
		return bundle;
	}

	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long employeeBundleId;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "bundle_id")
	private Bundle bundle;

	public EmployeeBundle() {}

	public EmployeeBundle(Employee employee, Bundle bundle) {
		this.bundle = bundle;
		this.employee = employee;
	}
}
