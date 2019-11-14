package com.cloudea.models;

public class Administrator {
	int u_id;
	String ad_name;
	public Administrator() {
	}
	public Administrator(int u_id, String ad_name) {
		super();
		this.u_id = u_id;
		this.ad_name = ad_name;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	
}
