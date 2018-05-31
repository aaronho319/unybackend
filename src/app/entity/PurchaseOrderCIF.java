package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PurchaseOrderCIF {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long purchaseOrderCIFId;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "purchase_order_id")
	private PurchaseOrder purchaseOrder;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "cif_id")
	private CIF cif;

	public PurchaseOrderCIF() {}

	public PurchaseOrderCIF(PurchaseOrder purchaseOrder, CIF cif) {
		this.purchaseOrder = purchaseOrder;
		this.cif = cif;
	}
	
	public Long getPurchaseOrderCIFId() {
		return purchaseOrderCIFId;
	}

	public void setPurchaseOrderCIFId(Long purchaseOrderCIFId) {
		this.purchaseOrderCIFId = purchaseOrderCIFId;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public CIF getCif() {
		return cif;
	}

	public void setCif(CIF cif) {
		this.cif = cif;
	}

}


