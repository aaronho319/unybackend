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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "report")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long reportId;
	
//	@NotNull(message = "Report PO ID Required")
	@Column
	private Long reportPurchaseOrderId;

	public Long getReportPurchaseOrderId() {
		return reportPurchaseOrderId;
	}

	public void setReportPurchaseOrderId(Long reportPurchaseOrderId) {
		this.reportPurchaseOrderId = reportPurchaseOrderId;
	}

	public List<ReportCIF> getReportCIF() {
		return reportCIF;
	}

	public void setReportCIF(List<ReportCIF> reportCIF) {
		this.reportCIF = reportCIF;
	}

	@NotNull(message = "Report Description Required")
	@Column
	private String reportDescription;
	
	@NotNull(message = "Report Date Required")
	@Column
	private String reportDate;
	
	@NotNull(message = "Report Reporter Required")
	@Column
	private String reporterName;
	
	@NotNull(message = "Report Total Rolls Required")
	@Column
	private Integer reportTotalRoll;
	
	@NotNull(message = "Report Total Yards Required")
	@Column
	private Integer reportTotalYard;
	
	@NotNull(message = "Report Total Layers Required")
	@Column
	private Integer reportTotalLayer;
	
	@NotNull(message = "Report Total Actual Yards Used Required")
	@Column
	private Integer reportTotalActualYardUsed;
	
	@NotNull(message = "Report Total Remnants Required")
	@Column
	private Integer reportTotalRemnant;
	
	@NotNull(message = "Report Total Quantity Required")
	@Column
	private Integer reportTotalCutQuantity;
	
	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Roll> roll;
	
	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<PurchaseOrderReport> purchaseOrderReport;
	
	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<Cut> patternReportCut;
	
	@OneToMany(mappedBy = "report", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<ReportCIF> reportCIF;
	
	public List<PurchaseOrderReport> getPurchaseOrderReport() {
		return purchaseOrderReport;
	}

	public void setPurchaseOrderReport(List<PurchaseOrderReport> purchaseOrderReport) {
		this.purchaseOrderReport = purchaseOrderReport;
	}

	public List<Cut> getPatternReportCut() {
		return patternReportCut;
	}

	public void setPatternReportCut(List<Cut> patternReportCut) {
		this.patternReportCut = patternReportCut;
	}

	public Report() {
		this.roll = new ArrayList<>();
		this.purchaseOrderReport = new ArrayList<>();
		this.patternReportCut = new ArrayList<>();
		this.reportCIF = new ArrayList<>();
	}
	
	public Report(String description, String date, String reporterName, Integer totalRoll, Integer totalYard,
				  Integer totalLayer, Integer totalActualYardUsed, Integer totalRemnant, Integer totalCutQuantity) {
//		this.reportPurchaseOrderId = purchaseOrderId;
		this.reportDescription = description;
		this.reportDate = date;
		this.reporterName = reporterName;
		this.reportTotalRoll = totalRoll;
		this.reportTotalYard = totalYard;
		this.reportTotalLayer = totalLayer;
		this.reportTotalActualYardUsed = totalActualYardUsed;
		this.reportTotalRemnant = totalRemnant;
		this.reportTotalCutQuantity = totalCutQuantity;
		
		this.roll = new ArrayList<>();
		this.purchaseOrderReport = new ArrayList<>();
		this.patternReportCut = new ArrayList<>();
		this.reportCIF = new ArrayList<>();
	}
	
	
	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public String getReportDescription() {
		return reportDescription;
	}

	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public Integer getReportTotalRoll() {
		return reportTotalRoll;
	}

	public void setReportTotalRoll(Integer reportTotalRoll) {
		this.reportTotalRoll = reportTotalRoll;
	}

	public Integer getReportTotalYard() {
		return reportTotalYard;
	}

	public void setReportTotalYard(Integer reportTotalYard) {
		this.reportTotalYard = reportTotalYard;
	}

	public Integer getReportTotalLayer() {
		return reportTotalLayer;
	}

	public void setReportTotalLayer(Integer reportTotalLayer) {
		this.reportTotalLayer = reportTotalLayer;
	}

	public Integer getReportTotalActualYardUsed() {
		return reportTotalActualYardUsed;
	}

	public void setReportTotalActualYardUsed(Integer reportTotalActualYardUsed) {
		this.reportTotalActualYardUsed = reportTotalActualYardUsed;
	}

	public Integer getReportTotalRemnant() {
		return reportTotalRemnant;
	}

	public void setReportTotalRemnant(Integer reportTotalRemnant) {
		this.reportTotalRemnant = reportTotalRemnant;
	}

	public Integer getReportTotalCutQuantity() {
		return reportTotalCutQuantity;
	}

	public void setReportTotalCutQuantity(Integer reportTotalCutQuantity) {
		this.reportTotalCutQuantity = reportTotalCutQuantity;
	}

	public List<Roll> getRoll() {
		return roll;
	}

	public void setRoll(List<Roll> roll) {
		this.roll = roll;
	}
	
}
