package com.cloudea.models;

public class LogIn {
	private int log_id;
	private int u_id;
	private String in_time;
	private String out_time;
	
	public LogIn() {
		super();
	}
	public LogIn(int log_id, int u_id, String in_time, String out_time) {
		super();
		this.log_id = log_id;
		this.u_id = u_id;
		this.in_time = in_time;
		this.out_time = out_time;
	}
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getIn_time() {
		return in_time;
	}
	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}
	public String getOut_time() {
		return out_time;
	}
	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}
	

}
