package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "operation_breakdown")
public class OperationBreakdown {
	public Long getOperationBreakdownId() {
		return operationBreakdownId;
	}

	public void setOperationBreakdownId(Long operationBreakdownId) {
		this.operationBreakdownId = operationBreakdownId;
	}

	public Long getOperationBreakdownPurchaseOrderId() {
		return operationBreakdownPurchaseOrderId;
	}

	public void setOperationBreakdownPurchaseOrderId(Long operationBreakdownPurchaseOrderId) {
		this.operationBreakdownPurchaseOrderId = operationBreakdownPurchaseOrderId;
	}

	public String getOperationBreakdownDescription() {
		return operationBreakdownDescription;
	}

	public void setOperationBreakdownDescription(String operationBreakdownDescription) {
		this.operationBreakdownDescription = operationBreakdownDescription;
	}

	public Integer getOperationBreakdownQuantity() {
		return operationBreakdownQuantity;
	}

	public void setOperationBreakdownQuantity(Integer operationBreakdownQuantity) {
		this.operationBreakdownQuantity = operationBreakdownQuantity;
	}

	public String getOperationBreakdownDate() {
		return operationBreakdownDate;
	}

	public void setOperationBreakdownDate(String operationBreakdownDate) {
		this.operationBreakdownDate = operationBreakdownDate;
	}

	public List<PurchaseOrderOperationBreakdown> getPurchaseOrderOperationBreakdown() {
		return purchaseOrderOperationBreakdown;
	}

	public void setPurchaseOrderOperationBreakdown(List<PurchaseOrderOperationBreakdown> purchaseOrderOperationBreakdown) {
		this.purchaseOrderOperationBreakdown = purchaseOrderOperationBreakdown;
	}

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long operationBreakdownId;
	
	@Column
	private Long operationBreakdownPurchaseOrderId;
	
	@NotNull(message = "OB Description Required")
	@Column
	private String operationBreakdownDescription;
	
	@NotNull(message = "OB Quantity Required")
	@Column
	private Integer operationBreakdownQuantity;
	
	@NotNull(message = "OB Date Required")
	@Column
	private String operationBreakdownDate;
	
	@OneToMany(mappedBy = "operation_breakdown", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderOperationBreakdown> purchaseOrderOperationBreakdown;
	
	@OneToMany(mappedBy = "operation_breakdown", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Operation> operation;
	
	public OperationBreakdown() {
		this.purchaseOrderOperationBreakdown = new ArrayList<>();
		this.operation = new ArrayList<>(); 
	}
	
	public OperationBreakdown(String description,Integer quantity, String date) {
		this.operationBreakdownDescription = description;
		this.operationBreakdownQuantity = quantity;
		this.operationBreakdownDate = date;
		
		this.purchaseOrderOperationBreakdown = new ArrayList<>();
		this.operation = new ArrayList<>(); 
	}
	
}
