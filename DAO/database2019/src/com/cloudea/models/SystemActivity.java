package com.cloudea.models;

public class SystemActivity {
	int sa_id;
	String sa_name,sa_start_time,sa_lap1_end_time,sa_lap2_end_time;
	public SystemActivity(int sa_id, String sa_name, String sa_start_time, String sa_lap1_end_time,
			String sa_lap2_end_time) {
		super();
		this.sa_id = sa_id;
		this.sa_name = sa_name;
		this.sa_start_time = sa_start_time;
		this.sa_lap1_end_time = sa_lap1_end_time;
		this.sa_lap2_end_time = sa_lap2_end_time;
	}
	public int getSa_id() {
		return sa_id;
	}
	public void setSa_id(int sa_id) {
		this.sa_id = sa_id;
	}
	public String getSa_name() {
		return sa_name;
	}
	public void setSa_name(String sa_name) {
		this.sa_name = sa_name;
	}
	public String getSa_start_time() {
		return sa_start_time;
	}
	public void setSa_start_time(String sa_start_time) {
		this.sa_start_time = sa_start_time;
	}
	public String getSa_lap1_end_time() {
		return sa_lap1_end_time;
	}
	public void setSa_lap1_end_time(String sa_lap1_end_time) {
		this.sa_lap1_end_time = sa_lap1_end_time;
	}
	public String getSa_lap2_end_time() {
		return sa_lap2_end_time;
	}
	public void setSa_lap2_end_time(String sa_lap2_end_time) {
		this.sa_lap2_end_time = sa_lap2_end_time;
	}
	public SystemActivity(){
	}
	
}
