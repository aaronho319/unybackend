package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "cif")
public class CIF {
	
	public Long getCifId() {
		return cifId;
	}

	public void setCifId(Long cifId) {
		this.cifId = cifId;
	}

	public Long getCifPurchaseOrderId() {
		return cifPurchaseOrderId;
	}

	public void setCifPurchaseOrderId(Long cifPurchaseOrderId) {
		this.cifPurchaseOrderId = cifPurchaseOrderId;
	}

	public Integer getCifCutNumber() {
		return cifCutNumber;
	}

	public void setCifCutNumber(Integer cifCutNumber) {
		this.cifCutNumber = cifCutNumber;
	}

	public String getCifColor() {
		return cifColor;
	}

	public void setCifColor(String cifColor) {
		this.cifColor = cifColor;
	}

	public List<Bundle> getBundle() {
		return bundle;
	}

	public void setBundle(List<Bundle> bundle) {
		this.bundle = bundle;
	}

	public List<PurchaseOrderCIF> getPurchaseOrderCIF() {
		return purchaseOrderCIF;
	}

	public void setPurchaseOrderCIF(List<PurchaseOrderCIF> purchaseOrderCIF) {
		this.purchaseOrderCIF = purchaseOrderCIF;
	}

	public List<ReportCIF> getReportCIF() {
		return reportCIF;
	}

	public void setReportCIF(List<ReportCIF> reportCIF) {
		this.reportCIF = reportCIF;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long cifId;
	
//	@NotNull(message = "CIF PO Number Required")
	@Column
	private Long cifPurchaseOrderId;
	
	@NotNull(message = "CIF Cut Numbers Required")
	@Column
	private Integer cifCutNumber;
	
	@NotNull(message = "CIF Color Required")
	@Column
	private String cifColor;
	
	@OneToMany(mappedBy = "cif", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Bundle> bundle;
	
	@OneToMany(mappedBy = "cif", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderCIF> purchaseOrderCIF;
	
	@OneToMany(mappedBy = "cif", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<ReportCIF> reportCIF;
	
	public CIF() {
		this.bundle = new ArrayList<>();
		this.purchaseOrderCIF = new ArrayList<>();
		this.reportCIF = new ArrayList<>();	
	}
}
