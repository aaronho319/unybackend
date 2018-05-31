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
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "cut")
public class Cut {

	public long getCutId() {
		return cutId;
	}

	public void setCutId(long cutId) {
		this.cutId = cutId;
	}

	public String getCutName() {
		return cutName;
	}

	public void setCutName(String cutName) {
		this.cutName = cutName;
	}

	public Integer getCutNumber() {
		return cutNumber;
	}

	public void setCutNumber(Integer cutNumber) {
		this.cutNumber = cutNumber;
	}

	public Integer getCutLay() {
		return cutLay;
	}

	public void setCutLay(Integer cutLay) {
		this.cutLay = cutLay;
	}

	public Integer getCutSizeCount() {
		return cutSizeCount;
	}

	public void setCutSizeCount(Integer cutSizeCount) {
		this.cutSizeCount = cutSizeCount;
	}

	public Integer getCutMarkerLength() {
		return cutMarkerLength;
	}

	public void setCutMarkerLength(Integer cutMarkerLength) {
		this.cutMarkerLength = cutMarkerLength;
	}

	public Integer getCutTotalYard() {
		return cutTotalYard;
	}

	public void setCutTotalYard(Integer cutTotalYard) {
		this.cutTotalYard = cutTotalYard;
	}

	public List<CutBundle> getCutBundle() {
		return cutBundle;
	}

	public void setCutBundle(List<CutBundle> cutBundle) {
		this.cutBundle = cutBundle;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long cutId;
	
	@NotNull(message = "Cut Name Required") 
	@Column
	private String cutName;
	
	@NotNull(message = "Cut Number Required")
	@Column
	private Integer cutNumber;

	@NotNull(message = "Cut Lays Required")
	@Column
	private Integer cutLay;
	
	@NotNull(message = "Cut Size Count Required")
	@Column
	private Integer cutSizeCount;
	
	@NotNull(message = "Cut Marker Length Required") 
	@Column
	private Integer cutMarkerLength;
	
	@NotNull(message = "Cut Total Yard Required")
	@Column
	private Integer cutTotalYard;
	
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "pattern_id")
    private Pattern pattern;
    
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "report_id")
    private Report report;

    @OneToMany(mappedBy = "Cut", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Size> size;
    
    @OneToMany(mappedBy = "Cut", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<CutBundle> cutBundle;

    public Cut(Pattern pattern, Report report) {
    	this.pattern = pattern;
    	this.report = report;
    	
    	this.size = new ArrayList<>();
    	this.cutBundle = new ArrayList<>();
    }
    
    public Cut(Pattern pattern, Report report, String cutName, Integer cutLays, Integer sizeCount, Integer totalYard) {
    	this.pattern = pattern;
    	this.report = report;
    	this.cutName = cutName;
    	this.cutLay = cutLays;
    	this.cutSizeCount = sizeCount;
    	this.cutTotalYard = totalYard; 
    	
    	this.size = new ArrayList<>();
    	this.cutBundle = new ArrayList<>();
    }
    
    
	public long getId() {
		return cutId;
	}

	public void setId(long id) {
		this.cutId = id;
	}

	public String getName() {
		return cutName;
	}

	public void setName(String name) {
		this.cutName = name;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public List<Size> getSize() {
		return size;
	}

	public void setSize(List<Size> size) {
		this.size = size;
	}

}
