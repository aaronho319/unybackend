package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "operation")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long operationId;

	@NotNull(message = "Operation Number Required")
	@Column
	private Integer operationNumber;
	
	@NotNull(message = "Operatio Name Required")
	@Column
	private String operationName;
	
	@NotNull(message = "Operation Date Required")
	@Column
	private String operationDate;
	
	@NotNull(message = "Operation Cost Required")
	@Column
	private Integer operationCost;
	
	@NotNull(message = "Operation Pieces Required")
	@Column
	private Integer operationPiece;
	
	@OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<OperationBundle> operationBundle;
	
	@OneToMany(mappedBy = "operation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<OperationEmployee> operationEmployee;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "operation_breakdown_id")
	private OperationBreakdown operationBreakdown;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "posting_sheet_id")
	private PostingSheet postingSheet;
	
	public Operation(OperationBreakdown operationBreakdown, PostingSheet postingSheet) {
		this.operationBreakdown = operationBreakdown;
		this.postingSheet = postingSheet;
		this.operationBundle = new ArrayList<>();
		this.operationEmployee = new ArrayList<>();
	}
	
	public Operation(OperationBreakdown operationBreakdown, PostingSheet postingSheet, Integer number, String name, 
					 String date, Integer cost, Integer piece) {
		this.operationBreakdown = operationBreakdown;
		this.postingSheet = postingSheet;
		this.operationNumber = number;
		this.operationName = name;
		this.operationDate = date;
		this.operationCost = cost;
		this.operationPiece = piece;
		
		this.operationBundle = new ArrayList<>();
		this.operationEmployee = new ArrayList<>();
	}
	
	
	public Long getOperationId() {
		return operationId;
	}

	public void setOperationId(Long operationId) {
		this.operationId = operationId;
	}

	public Integer getOperationNumber() {
		return operationNumber;
	}

	public void setOperationNumber(Integer operationNumber) {
		this.operationNumber = operationNumber;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	public Integer getOperationCost() {
		return operationCost;
	}

	public void setOperationCost(Integer operationCost) {
		this.operationCost = operationCost;
	}

	public Integer getOperationPiece() {
		return operationPiece;
	}

	public void setOperationPiece(Integer operationPiece) {
		this.operationPiece = operationPiece;
	}

	public List<OperationBundle> getOperationBundle() {
		return operationBundle;
	}

	public void setOperationBundle(List<OperationBundle> operationBundle) {
		this.operationBundle = operationBundle;
	}

	public List<OperationEmployee> getOperationEmployee() {
		return operationEmployee;
	}

	public void setOperationEmployee(List<OperationEmployee> operationEmployee) {
		this.operationEmployee = operationEmployee;
	}

	public OperationBreakdown getOperationBreakdown() {
		return operationBreakdown;
	}

	public void setOperationBreakdown(OperationBreakdown operationBreakdown) {
		this.operationBreakdown = operationBreakdown;
	}

	public PostingSheet getPostingSheet() {
		return postingSheet;
	}

	public void setPostingSheet(PostingSheet postingSheet) {
		this.postingSheet = postingSheet;
	}
	
}
