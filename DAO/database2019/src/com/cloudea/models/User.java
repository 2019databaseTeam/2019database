package com.cloudea.models;

public class User {
	 private int u_id;
	 private String u_type;
	 private String u_mailbox;
	 private String adm;
	 private String pawd;
	 
	public User() {
		super();
	}
	public User(int u_id, String u_type, String u_mailbox, String adm, String pawd) {
		super();
		this.u_id = u_id;
		this.u_type = u_type;
		this.u_mailbox = u_mailbox;
		this.adm = adm;
		this.pawd = pawd;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_type() {
		return u_type;
	}
	public void setU_type(String u_type) {
		this.u_type = u_type;
	}
	public String getU_mailbox() {
		return u_mailbox;
	}
	public void setU_mailbox(String u_mailbox) {
		this.u_mailbox = u_mailbox;
	}
	public String getAdm() {
		return adm;
	}
	public void setAdm(String adm) {
		this.adm = adm;
	}
	public String getPawd() {
		return pawd;
	}
	public void setPawd(String pawd) {
		this.pawd = pawd;
	}

}





	 


