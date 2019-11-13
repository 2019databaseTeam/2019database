package com.cloudea.models;

public class UserType{
	private int u_id;
	private String name;
	public UserType() {
		super();
	}
	public UserType(int u_id, String name) {
		super();
		this.u_id = u_id;
		this.name = name;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
} 