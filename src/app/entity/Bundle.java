package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "bundle")
public class Bundle {
	public Long getBundleId() {
		return bundleId;
	}

	public void setBundleId(Long bundleId) {
		this.bundleId = bundleId;
	}

	public Long getBundleCutId() {
		return bundleCutId;
	}

	public void setBundleCutId(Long bundleCutId) {
		this.bundleCutId = bundleCutId;
	}

	public Long getBundleCutSizeId() {
		return bundleCutSizeId;
	}

	public void setBundleCutSizeId(Long bundleCutSizeId) {
		this.bundleCutSizeId = bundleCutSizeId;
	}

	public Integer getBundleNumber() {
		return bundleNumber;
	}

	public void setBundleNumber(Integer bundleNumber) {
		this.bundleNumber = bundleNumber;
	}

	public Integer getBundleSize() {
		return bundleSize;
	}

	public void setBundleSize(Integer bundleSize) {
		this.bundleSize = bundleSize;
	}

	public Integer getBundleQuantity() {
		return bundleQuantity;
	}

	public void setBundleQuantity(Integer bundleQuantity) {
		this.bundleQuantity = bundleQuantity;
	}

	public List<CutBundle> getCutBundle() {
		return cutBundle;
	}

	public void setCutBundle(List<CutBundle> cutBundle) {
		this.cutBundle = cutBundle;
	}

	public List<EmployeeBundle> getEmployeeBundle() {
		return employeeBundle;
	}

	public void setEmployeeBundle(List<EmployeeBundle> employeeBundle) {
		this.employeeBundle = employeeBundle;
	}

	public CIF getCif() {
		return cif;
	}

	public void setCif(CIF cif) {
		this.cif = cif;
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
	private Long bundleId;
	
//	@NotNull(message = "Bundle Cut ID Required ")
	@Column
	private Long bundleCutId;
	
//	@NotNull(message = "Bundle CutSize ID Required")
	@Column
	private Long bundleCutSizeId;
	
	@NotNull(message = "Bundle Number Required")
	@Column
	private Integer bundleNumber;
	
	@NotNull(message = "Bundle Size Required")
	@Column
	private Integer bundleSize;
	
	@NotNull(message = "Bundle Quantity Required")
	@Column
	private Integer bundleQuantity;
	
	@NotNull(message = "Bundle Gender Required")
	@Column
	private String bundleGender;
	
	public String getBundleGender() {
		return bundleGender;
	}

	public void setBundleGender(String bundleGender) {
		this.bundleGender = bundleGender;
	}

	@OneToMany(mappedBy = "bundle", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<CutBundle> cutBundle;
	
	@OneToMany(mappedBy = "bundle", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<EmployeeBundle> employeeBundle;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "cif_id")
	private CIF cif;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "posting_sheet_id")
	private PostingSheet postingSheet;
	
	public Bundle(CIF cif, PostingSheet postingSheet) {
		this.cif = cif;
		this.postingSheet = postingSheet;
		
		this.cutBundle = new ArrayList<>();
		this.employeeBundle = new ArrayList<>();
	}
	
	public Bundle(CIF cif, PostingSheet postingSheet, Integer bundleNumber,
				  Integer bundleSize, Integer bundleQuantity, String bundleGender) {
		this.cif = cif;
		this.postingSheet = postingSheet;
//		this.bundleCutId = bundleCutId;
//		this.bundleCutSizeId = bundleCutSizeId;
		this.bundleNumber = bundleNumber;
		this.bundleSize = bundleSize;
		this.bundleQuantity = bundleQuantity;
		this.bundleGender = bundleGender;
		
		this.cutBundle = new ArrayList<>();
		this.employeeBundle = new ArrayList<>(); 
	}
}
