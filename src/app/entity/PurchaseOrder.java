package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
	
	@Id
	@Column
	private Long purchaseOrderId;
	
	@NotNull(message = "Date Required")
	@Column
	private String purchaseOrderDate;
	
	@NotNull(message = "Description Required")
	@Column
	private String purchaseOrderDescription;
	
	@NotNull(message = "Quantity Required")
	@Column
	private Integer purchaseOrderQuantity;
	
	@NotNull(message = "Order SIZE Number Required")
	@Column
	private Integer purchaseOrderSizeNumber;
	
	@NotNull(message = "Order Done Required")
	@Column
	private Boolean purchaseOrderIsDone;
	
	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(String purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

	public String getPurchaseOrderDescription() {
		return purchaseOrderDescription;
	}

	public void setPurchaseOrderDescription(String purchaseOrderDescription) {
		this.purchaseOrderDescription = purchaseOrderDescription;
	}

	public Integer getPurchaseOrderQuantity() {
		return purchaseOrderQuantity;
	}

	public void setPurchaseOrderQuantity(Integer purchaseOrderQuantity) {
		this.purchaseOrderQuantity = purchaseOrderQuantity;
	}

	public Integer getPurchaseOrderSizeNumber() {
		return purchaseOrderSizeNumber;
	}

	public void setPurchaseOrderSizeNumber(Integer purchaseOrderSizeNumber) {
		this.purchaseOrderSizeNumber = purchaseOrderSizeNumber;
	}

	public Boolean getPurchaseOrderIsDone() {
		return purchaseOrderIsDone;
	}

	public void setPurchaseOrderIsDone(Boolean purchaseOrderIsDone) {
		this.purchaseOrderIsDone = purchaseOrderIsDone;
	}

	public List<PurchaseOrderClient> getPurchaseOrderClient() {
		return purchaseOrderClient;
	}

	public void setPurchaseOrderClient(List<PurchaseOrderClient> purchaseOrderClient) {
		this.purchaseOrderClient = purchaseOrderClient;
	}

	public List<PurchaseOrderPattern> getPurchaseOrderPattern() {
		return purchaseOrderPattern;
	}

	public void setPurchaseOrderPattern(List<PurchaseOrderPattern> purchaseOrderPattern) {
		this.purchaseOrderPattern = purchaseOrderPattern;
	}

	public List<PurchaseOrderReport> getPurchaseOrderReport() {
		return purchaseOrderReport;
	}

	public void setPurchaseOrderReport(List<PurchaseOrderReport> purchaseOrderReport) {
		this.purchaseOrderReport = purchaseOrderReport;
	}

	public List<PurchaseOrderCIF> getPurchaseOrderCIF() {
		return purchaseOrderCIF;
	}

	public void setPurchaseOrderCIF(List<PurchaseOrderCIF> purchaseOrderCIF) {
		this.purchaseOrderCIF = purchaseOrderCIF;
	}

	public List<PurchaseOrderOperationBreakdown> getPurchaseOrderOperationBreakdown() {
		return purchaseOrderOperationBreakdown;
	}

	public void setPurchaseOrderOperationBreakdown(List<PurchaseOrderOperationBreakdown> purchaseOrderOperationBreakdown) {
		this.purchaseOrderOperationBreakdown = purchaseOrderOperationBreakdown;
	}

	public List<PurchaseOrderPostingSheet> getPurchaseOrderPostingSheet() {
		return purchaseOrderPostingSheet;
	}

	public void setPurchaseOrderPostingSheet(List<PurchaseOrderPostingSheet> purchaseOrderPostingSheet) {
		this.purchaseOrderPostingSheet = purchaseOrderPostingSheet;
	}

	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderClient> purchaseOrderClient;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderPattern> purchaseOrderPattern;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderReport> purchaseOrderReport;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderCIF> purchaseOrderCIF;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderOperationBreakdown> purchaseOrderOperationBreakdown;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderPostingSheet> purchaseOrderPostingSheet;
	
	public PurchaseOrder() {
		this.purchaseOrderClient			 = new ArrayList<>();
		this.purchaseOrderPattern 			 = new ArrayList<>();
		this.purchaseOrderReport			 = new ArrayList<>();
		this.purchaseOrderCIF 				 = new ArrayList<>();
		this.purchaseOrderOperationBreakdown = new ArrayList<>();
		this.purchaseOrderPostingSheet		 = new ArrayList<>();
	}
	
	public PurchaseOrder(Long id, String description, String date, Integer quantity, Integer size, Boolean isDone) {
		this.purchaseOrderId 			= id;
		this.purchaseOrderDescription 	= description;
		this.purchaseOrderDate 			= date;
		this.purchaseOrderQuantity 		= quantity;
		this.purchaseOrderSizeNumber 	= size;
		this.purchaseOrderIsDone		= isDone;
		
		this.purchaseOrderClient			 = new ArrayList<>();
		this.purchaseOrderPattern 			 = new ArrayList<>();
		this.purchaseOrderReport			 = new ArrayList<>();
		this.purchaseOrderCIF 				 = new ArrayList<>();
		this.purchaseOrderOperationBreakdown = new ArrayList<>();
		this.purchaseOrderPostingSheet		 = new ArrayList<>();
	}
	
	public Long getId() {
		return purchaseOrderId;
	}

	public void setId(Long id) {
		this.purchaseOrderId = id;
	}

	public String getDate() {
		return purchaseOrderDate;
	}

	public void setDate(String date) {
		this.purchaseOrderDate = date;
	}

	public String getDescription() {
		return purchaseOrderDescription;
	}

	public void setDescription(String description) {
		this.purchaseOrderDescription = description;
	}

	public Integer getQuantity() {
		return purchaseOrderQuantity;
	}

	public void setQuantity(Integer quantity) {
		this.purchaseOrderQuantity = quantity;
	}

	public Integer getSize() {
		return purchaseOrderSizeNumber;
	}

	public void setSize(Integer size) {
		this.purchaseOrderSizeNumber = size;
	}

}


