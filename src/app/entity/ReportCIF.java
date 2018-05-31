package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ReportCIF {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long reportCIFId;

	public Long getReportCIFId() {
		return reportCIFId;
	}

	public void setReportCIFId(Long reportCIFId) {
		this.reportCIFId = reportCIFId;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public CIF getCif() {
		return cif;
	}

	public void setCif(CIF cif) {
		this.cif = cif;
	}

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "report_id")
	private Report report;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "cif_id")
	private CIF cif;

	public ReportCIF() {}

	public ReportCIF(Report report, CIF cif) {
		this.report = report;
		this.cif = cif;
	}
}
