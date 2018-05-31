package app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roll")
public class Roll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long rollId;
	
	@NotNull(message = "Roll Color Required")
	@Column
	private String rollColor;
	
	@NotNull(message = "Roll Yard Required")
	@Column
	private Integer rollYard;
	
	@NotNull(message = "Roll Layer Required")
	@Column
	private Integer rollLayer;
	
	@NotNull(message = "Roll Layer Used Requred")
	@Column
	private Integer rollLayerUsed;
	
	@NotNull(message = "Roll Remnants Required")
	@Column
	private Integer rollRemnant;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "report_id")
    private Report report;
	
	public Roll(Report report) {
		this.report = report;
	}
	
	public Roll(Report report, String color, Integer yard, Integer layer, Integer layerUsed, Integer remnant) {
		this.report = report;
		this.rollColor = color;
		this.rollYard = yard;
		this.rollLayer = layer;
		this.rollLayerUsed = layerUsed;
		this.rollRemnant = remnant;
	}
	
	public Long getRollId() {
		return rollId;
	}

	public void setRollId(Long rollId) {
		this.rollId = rollId;
	}

	public String getRollColor() {
		return rollColor;
	}

	public void setRollColor(String rollColor) {
		this.rollColor = rollColor;
	}

	public Integer getRollYard() {
		return rollYard;
	}

	public void setRollYard(Integer rollYard) {
		this.rollYard = rollYard;
	}

	public Integer getRollLayer() {
		return rollLayer;
	}

	public void setRollLayer(Integer rollLayer) {
		this.rollLayer = rollLayer;
	}

	public Integer getRollLayerUsed() {
		return rollLayerUsed;
	}

	public void setRollLayerUsed(Integer rollLayerUsed) {
		this.rollLayerUsed = rollLayerUsed;
	}

	public Integer getRollRemnant() {
		return rollRemnant;
	}

	public void setRollRemnant(Integer rollRemnant) {
		this.rollRemnant = rollRemnant;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
}
