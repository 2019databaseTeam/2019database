package com.cloudea.models;

public class Teacher {

	private int tch_id,u_id;
	private String tch_name;
	public Teacher() {}
	public Teacher(int tch_id,int u_id,String tch_name) {
		this.tch_id=tch_id;
		this.u_id=u_id;
		this.tch_name=tch_name;
	}
	public int getTch_id() {
		return tch_id;
	}
	public void setTch_id(int tch_id) {
		this.tch_id = tch_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getTch_name() {
		return tch_name;
	}
	public void setTch_name(String tch_name) {
		this.tch_name = tch_name;
	}

}
