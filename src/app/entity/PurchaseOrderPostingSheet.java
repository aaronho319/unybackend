package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PurchaseOrderPostingSheet {
	public Long getPurchaseOrderPostingSheetId() {
		return purchaseOrderPostingSheetId;
	}

	public void setPurchaseOrderPostingSheetId(Long purchaseOrderPostingSheetId) {
		this.purchaseOrderPostingSheetId = purchaseOrderPostingSheetId;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public PostingSheet getPostingSheet() {
		return postingSheet;
	}

	public void setPostingSheet(PostingSheet postingSheet) {
		this.postingSheet = postingSheet;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long purchaseOrderPostingSheetId;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "purchase_order_id")
	private PurchaseOrder purchaseOrder;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "posting_sheet_id")
	private PostingSheet postingSheet;

	public PurchaseOrderPostingSheet() {}

	public PurchaseOrderPostingSheet(PurchaseOrder purchaseOrder, PostingSheet postingSheet) {
		this.purchaseOrder = purchaseOrder;
		this.postingSheet = postingSheet;
	}

}
