package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "clients")
public class Client {
	
	@Id
	@Column
	private Long clientId;
	
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientDescription() {
		return clientDescription;
	}

	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}

	public List<PurchaseOrderClient> getPurchaseOrderClient() {
		return purchaseOrderClient;
	}

	public void setPurchaseOrderClient(List<PurchaseOrderClient> purchaseOrderClient) {
		this.purchaseOrderClient = purchaseOrderClient;
	}

	@NotNull(message = "Client Name Required")
	@Column
	private String clientName;
	
	@NotNull(message = "Client Description Required")
	@Column
	private String clientDescription;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderClient> purchaseOrderClient;
	
	public Client() {
		this.purchaseOrderClient = new ArrayList<>();
	}
	
	public Client(Long id, String name, String description) {
		this.clientId = id;
		this.clientName = name;
		this.clientDescription = description;
		this.purchaseOrderClient = new ArrayList<>();
	}

}

