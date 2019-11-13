package com.cloudea.models;

public class Major {
	private int mjr_id;
	private String mjr_name;
	public Major() {}
	public Major(int mjr_id,String mjr_name) {
		this.mjr_id=mjr_id;
		this.mjr_name=mjr_name;
	}
	public int getMajorId() {
		return mjr_id;
	}
	public void setMajorId(int mjr_id) {
		this.mjr_id=mjr_id;
	}
	
	public String getMajorName() {
		return mjr_name;
	}
	public void setMajorName(String mjr_name) {
		this.mjr_name=mjr_name;
	}
}
