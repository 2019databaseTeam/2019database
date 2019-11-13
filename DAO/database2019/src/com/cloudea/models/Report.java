package com.cloudea.models;

public class Report {
	private int rep_id;
	private int stu_id;
	private int pl_id;
	private int rept_id;
	private String time;
	private String content_report;
	public Report() {}
	public Report(int rep_id,int stu_id,int pl_id,int rept_id,String time,String content_report)
	{
		this.rep_id=rep_id;
		this.stu_id=stu_id;
		this.pl_id=pl_id;
		this.rept_id=rept_id;
		this.time=time;
		this.content_report=content_report;
	}
	public int getRep_id() {
		return rep_id;
	}
	public void setRep_id(int rep_id) {
		this.rep_id = rep_id;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public int getPl_id() {
		return pl_id;
	}
	public void setPl_id(int pl_id) {
		this.pl_id = pl_id;
	}
	public int getRept_id() {
		return rept_id;
	}
	public void setRept_id(int rept_id) {
		this.rept_id = rept_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent_report() {
		return content_report;
	}
	public void setContent_report(String content_report) {
		this.content_report = content_report;
	}
	
}
