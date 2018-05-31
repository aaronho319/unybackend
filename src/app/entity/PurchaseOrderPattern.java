package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PurchaseOrderPattern {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long purchaseOrderPatternId;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "purchase_order_id")
	private PurchaseOrder purchaseOrder;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "pattern_id")
	private Pattern pattern;

	public Long getPurchaseOrderPatternId() {
		return purchaseOrderPatternId;
	}

	public void setPurchaseOrderPatternId(Long purchaseOrderPatternId) {
		this.purchaseOrderPatternId = purchaseOrderPatternId;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public PurchaseOrderPattern() {}

	public PurchaseOrderPattern(PurchaseOrder purchaseOrder, Pattern pattern) {
		this.purchaseOrder = purchaseOrder;
		this.pattern = pattern;
	}
}
