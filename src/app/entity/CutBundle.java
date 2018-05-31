package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CutBundle {
	public Long getCutBundleId() {
		return cutBundleId;
	}

	public void setCutBundleId(Long cutBundleId) {
		this.cutBundleId = cutBundleId;
	}

	public Cut getCut() {
		return cut;
	}

	public void setCut(Cut cut) {
		this.cut = cut;
	}

	public Bundle getBundle() {
		return bundle;
	}

	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long cutBundleId;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "cut_id")
	private Cut cut;

	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "bundle_id")
	private Bundle bundle;

	public CutBundle() {}

	public CutBundle(Cut cut, Bundle bundle) {
		this.cut = cut;
		this.bundle = bundle;
	}
}
