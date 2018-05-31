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
@Table(name = "patterns")
public class Pattern {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long patternId;
	
//	@NotNull(message = "Pattern PO ID Required")
	@Column
	private Long patternPurchaseOrderId;

	@NotNull(message = "Pattern Cutter Name Required")
	@Column
	private String patternCutterName;
	
	@NotNull(message = "Pattern Date Required")
	private String patternDate;
	
	@NotNull(message = "Pattern Description Required")
	private String patternDescription;
	
	@NotNull(message = "Pattern Client Name Required")
	private String patternClientName;
	
	@NotNull(message = "Pattern Total Size Required")
	private Integer patternTotalSize;
	
	@NotNull(message = "Pattern Total Quantity Required")
	private Integer patternTotalQuantity;
	
	@NotNull(message = "Pattern Total Yard Required")
	private Integer patternTotalYard;
	
//	@OneToMany(mappedBy = "pattern", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@Fetch(FetchMode.SUBSELECT)
//	@JsonManagedReference
//	private List<Size> patternCutSize;
	
	@OneToMany(mappedBy = "pattern", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Cut> patternReportCut;
	
	@OneToMany(mappedBy = "pattern", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderPattern> purchaseOrderPattern;
	
	public Long getPatternPurchaseOrderId() {
		return patternPurchaseOrderId;
	}

	public void setPatternPurchaseOrderId(Long patternPurchaseOrderId) {
		this.patternPurchaseOrderId = patternPurchaseOrderId;
	}
	
	
	public Long getPatternId() {
		return patternId;
	}

	public void setPatternId(Long patternId) {
		this.patternId = patternId;
	}

	public String getPatternCutterName() {
		return patternCutterName;
	}

	public void setPatternCutterName(String patternCutterName) {
		this.patternCutterName = patternCutterName;
	}

	public String getPatternDate() {
		return patternDate;
	}

	public void setPatternDate(String patternDate) {
		this.patternDate = patternDate;
	}

	public String getPatternDescription() {
		return patternDescription;
	}

	public void setPatternDescription(String patternDescription) {
		this.patternDescription = patternDescription;
	}

	public String getPatternClientName() {
		return patternClientName;
	}

	public void setPatternClientName(String patternClientName) {
		this.patternClientName = patternClientName;
	}

	public Integer getPatternTotalSize() {
		return patternTotalSize;
	}

	public void setPatternTotalSize(Integer patternTotalSize) {
		this.patternTotalSize = patternTotalSize;
	}

	public Integer getPatternTotalQuantity() {
		return patternTotalQuantity;
	}

	public void setPatternTotalQuantity(Integer patternTotalQuantity) {
		this.patternTotalQuantity = patternTotalQuantity;
	}

	public Integer getPatternTotalYard() {
		return patternTotalYard;
	}

	public void setPatternTotalYard(Integer patternTotalYard) {
		this.patternTotalYard = patternTotalYard;
	}

	public List<PurchaseOrderPattern> getPurchaseOrderPattern() {
		return purchaseOrderPattern;
	}

	public void setPurchaseOrderPattern(List<PurchaseOrderPattern> purchaseOrderPattern) {
		this.purchaseOrderPattern = purchaseOrderPattern;
	}

	public Pattern() {
//		this.patternCutSize = new ArrayList<>();
		this.patternReportCut = new ArrayList<>();
		this.purchaseOrderPattern = new ArrayList<>();
	}
	
	public Pattern(String cutterName, String date, String description, String clientName,
				   Integer size, Integer quantity, Integer yard) {
//		this.patternPurchaseOrderId 	= purchaseOrderId;
		this.patternCutterName 			= cutterName;
		this.patternDate 				= date;
		this.patternDescription 		= description;
		this.patternClientName 			= clientName;
		this.patternTotalSize 			= size;
		this.patternTotalQuantity 		= quantity;
		this.patternTotalYard 			= yard;
		
//		this.patternCutSize 	= new ArrayList<>();
		this.patternReportCut	= new ArrayList<>();
		this.purchaseOrderPattern = new ArrayList<>();
	}
	
	public Long getId() {
		return patternId;
	}

	public void setId(Long id) {
		this.patternId = id;
	}

	public String getCutterName() {
		return patternCutterName;
	}

	public void setCutterName(String cutterName) {
		this.patternCutterName = cutterName;
	}

	public String getDate() {
		return patternDate;
	}

	public void setDate(String date) {
		this.patternDate = date;
	}

	public String getDescription() {
		return patternDescription;
	}

	public void setDescription(String description) {
		this.patternDescription = description;
	}

	public String getClientName() {
		return patternClientName;
	}

	public void setClientName(String clientName) {
		this.patternClientName = clientName;
	}

	public Integer getSize() {
		return patternTotalSize;
	}

	public void setSize(Integer size) {
		this.patternTotalSize = size;
	}

	public Integer getQuantity() {
		return patternTotalQuantity;
	}

	public void setQuantity(Integer quantity) {
		this.patternTotalQuantity = quantity;
	}

	public Integer getYard() {
		return patternTotalYard;
	}

	public void setYard(Integer yard) {
		this.patternTotalYard = yard;
	}

//	public List<Size> getPatternCutSize() {
//		return patternCutSize;
//	}
//
//	public void setPatternCutSize(List<Size> patternCutSize) {
//		this.patternCutSize = patternCutSize;
//	}

	public List<Cut> getPatternReportCut() {
		return patternReportCut;
	}

	public void setPatternReportCut(List<Cut> patternReportCut) {
		this.patternReportCut = patternReportCut;
	}
}

