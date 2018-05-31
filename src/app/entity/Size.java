package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pattern_cut_sizes")
public class Size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long patternCutSizeId;
	
	@NotNull(message = "Size Name Required")
	@Column
	private String patternCutSizeName;
	
	@NotNull(message = "Size Quantity Required")
	@Column
	private Integer patternCutSizeQuantity;
	
//	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
//	@JoinColumn(name = "pattern_id")
//	private List<Pattern> pattern;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "pattern_report_cut_id")
	private List<Cut> patternReportCut;
	
	public Size() {
//		this.pattern = new ArrayList<>();
		this.patternReportCut = new ArrayList<>();
	}
	
	public Size(String name, Integer quantity) {
		this.patternCutSizeName = name;
		this.patternCutSizeQuantity = quantity;
//		this.pattern = new ArrayList<>();
		this.patternReportCut = new ArrayList<>();
	}
	
	public Long getId() {
		return patternCutSizeId;
	}

	public void setId(Long id) {
		this.patternCutSizeId = id;
	}

	public String getName() {
		return patternCutSizeName;
	}

	public void setName(String name) {
		this.patternCutSizeName = name;
	}

	public Integer getQuantity() {
		return patternCutSizeQuantity;
	}

	public void setQuantity(Integer quantity) {
		this.patternCutSizeQuantity = quantity;
	}

}


