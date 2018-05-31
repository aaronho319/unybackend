package app.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchase_order_report")
public class PurchaseOrderReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long purchaseOrderReportId;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "purchase_order_id")
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "report_id")
	private Report report;
	
	public PurchaseOrderReport() {}
	
	public PurchaseOrderReport(PurchaseOrder purchaseOrder, Report report) {
		this.purchaseOrder = purchaseOrder;
		this.report = report;
	}
	
	public Long getPurchaseOrderReportId() {
		return purchaseOrderReportId;
	}

	public void setPurchaseOrderReportId(Long purchaseOrderReportId) {
		this.purchaseOrderReportId = purchaseOrderReportId;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
}
