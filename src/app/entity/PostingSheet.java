package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "posting_sheet")
public class PostingSheet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long postingSheetId;
	
//	@NotNull(message = "Posting Sheet PO ID Required")
	@Column
	private Long postingSheetPurchaseOrderId;
	
	@NotNull(message = "Posting Sheet Bundle Number Required")
	@Column
	private Integer postingSheetBundleNumber;
	
	@NotNull(message = "Posting Sheet Layer Number Required")
	@Column
	private Integer postingSheetLayerNumber;
	
//	@NotNull(message = "Posting Sheet Operation Breakdown ID Required")
	@Column
	private Long postingSheetOperationBreakdownId;
	
//	@NotNull(message = "Posting Sheet CIF ID Required")
	@Column
	private Long postingSheetCIFId;
	
//	@NotNull(message = "Posting Sheet Operation ID Required")
	@Column
	private Long postingSheetOperationId;
	
	public Long getPostingSheetOperationId() {
		return postingSheetOperationId;
	}

	public void setPostingSheetOperationId(Long postingSheetOperationId) {
		this.postingSheetOperationId = postingSheetOperationId;
	}

	@OneToMany(mappedBy = "posting_sheet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Bundle> bundle;
	
	@OneToMany(mappedBy = "posting_sheet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderPostingSheet> purchaseOrderPostingSheet;
	
	@OneToMany(mappedBy = "posting_sheet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Operation> operation;
	
	public PostingSheet() {
		this.bundle = new ArrayList<>();
		this.purchaseOrderPostingSheet = new ArrayList<>();
		this.operation = new ArrayList<>();
	}
	
	public PostingSheet(Integer bundleNumber,Integer layerNumber) {
//		this.postingSheetPurchaseOrderId = purchaseOrderId;
//		this.postingSheetOperationBreakdownId = operationBreakdownId;
//		this.postingSheetCIFId = CIFId;
		this.postingSheetBundleNumber = bundleNumber;
		this.postingSheetLayerNumber = layerNumber;
		
		this.bundle = new ArrayList<>();
		this.purchaseOrderPostingSheet = new ArrayList<>();
		this.operation = new ArrayList<>();
	}
	
	public Long getPostingSheetId() {
		return postingSheetId;
	}

	public void setPostingSheetId(Long postingSheetId) {
		this.postingSheetId = postingSheetId;
	}

	public Long getPostingSheetPurchaseOrderId() {
		return postingSheetPurchaseOrderId;
	}

	public void setPostingSheetPurchaseOrderId(Long postingSheetPurchaseOrderId) {
		this.postingSheetPurchaseOrderId = postingSheetPurchaseOrderId;
	}

	public Integer getPostingSheetBundleNumber() {
		return postingSheetBundleNumber;
	}

	public void setPostingSheetBundleNumber(Integer postingSheetBundleNumber) {
		this.postingSheetBundleNumber = postingSheetBundleNumber;
	}

	public Integer getPostingSheetLayerNumber() {
		return postingSheetLayerNumber;
	}

	public void setPostingSheetLayerNumber(Integer postingSheetLayerNumber) {
		this.postingSheetLayerNumber = postingSheetLayerNumber;
	}

	public Long getPostingSheetOperationBreakdownId() {
		return postingSheetOperationBreakdownId;
	}

	public void setPostingSheetOperationBreakdownId(Long postingSheetOperationBreakdownId) {
		this.postingSheetOperationBreakdownId = postingSheetOperationBreakdownId;
	}

	public Long getPostingSheetCIFId() {
		return postingSheetCIFId;
	}

	public void setPostingSheetCIFId(Long postingSheetCIFId) {
		this.postingSheetCIFId = postingSheetCIFId;
	}

	public List<Bundle> getBundle() {
		return bundle;
	}

	public void setBundle(List<Bundle> bundle) {
		this.bundle = bundle;
	}

	public List<PurchaseOrderPostingSheet> getPurchaseOrderPostingSheet() {
		return purchaseOrderPostingSheet;
	}

	public void setPurchaseOrderPostingSheet(List<PurchaseOrderPostingSheet> purchaseOrderPostingSheet) {
		this.purchaseOrderPostingSheet = purchaseOrderPostingSheet;
	}

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

}
