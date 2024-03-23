package org.opd.module;

public class CollegeModule extends UniversityModule {
	private int cid;
	private String cname;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getNaccgrade() {
		return naccgrade;
	}

	public void setNaccgrade(String naccgrade) {
		this.naccgrade = naccgrade;
	}

	private String naccgrade;
}
