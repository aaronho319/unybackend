package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OperationEmployee {
	public Long getOperationEmployeeId() {
		return operationEmployeeId;
	}

	public void setOperationEmployeeId(Long operationEmployeeId) {
		this.operationEmployeeId = operationEmployeeId;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long operationEmployeeId;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "operation_id")
	private Operation operation;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public OperationEmployee() {}

	public OperationEmployee(Operation operation, Employee employee) {
		this.operation = operation;
		this.employee = employee;
	}
}
