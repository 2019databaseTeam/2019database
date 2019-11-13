package com.cloudea.models;

public class ProblemProfession {
	private int pl_id,mjr_id;
	public ProblemProfession() {}
	public ProblemProfession(int pl_id,int mjr_id) {
		this.mjr_id=mjr_id;
		this.pl_id=pl_id;
	}
	public int getPl_id() {
		return pl_id;
	}
	public void setPl_id(int pl_id) {
		this.pl_id = pl_id;
	}
	public int getMjr_id() {
		return mjr_id;
	}
	public void setMjr_id(int mjr_id) {
		this.mjr_id = mjr_id;
	}
	

}
