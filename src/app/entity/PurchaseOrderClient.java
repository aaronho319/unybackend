package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_order_client")
public class PurchaseOrderClient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column 
	private Long purchaseOrderClientId;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "purchase_order_id")
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "client_id")
	private Client client;
	
	public PurchaseOrderClient() {}
	
	public PurchaseOrderClient(PurchaseOrder purchaseOrder, Client client) {
		this.purchaseOrder = purchaseOrder;
		this.client = client;
	}
	
	public Long getId() {
		return purchaseOrderClientId;
	}

	public void setId(Long id) {
		this.purchaseOrderClientId = id;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
