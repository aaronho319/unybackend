package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PurchaseOrderOperationBreakdown {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long purchaseOrderOperationBreakdownId;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "purchase_order_id")
	private PurchaseOrder purchaseOrder;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "operationBreakdown_id")
	private OperationBreakdown operationBreakdown;

	public PurchaseOrderOperationBreakdown() {}

	public PurchaseOrderOperationBreakdown(PurchaseOrder purchaseOrder, OperationBreakdown operationBreakdown) {
		this.purchaseOrder = purchaseOrder;
		this.operationBreakdown = operationBreakdown;
	}
	
	public Long getPurchaseOrderOperationBreakdownId() {
		return purchaseOrderOperationBreakdownId;
	}

	public void setPurchaseOrderOperationBreakdownId(Long purchaseOrderOperationBreakdownId) {
		this.purchaseOrderOperationBreakdownId = purchaseOrderOperationBreakdownId;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public OperationBreakdown getOperationBreakdown() {
		return operationBreakdown;
	}

	public void setOperationBreakdown(OperationBreakdown operationBreakdown) {
		this.operationBreakdown = operationBreakdown;
	}

}
