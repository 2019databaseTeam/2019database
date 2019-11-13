package com.cloudea.models;

public class ReportType {

	private int rept_id;
	private String report_type;
	public ReportType() {
		super();
	}
	public ReportType(int rept_id, String report_type) {
		super();
		this.rept_id = rept_id;
		this.report_type = report_type;
	}
	public int getRept_id() {
		return rept_id;
	}
	public void setRept_id(int rept_id) {
		this.rept_id = rept_id;
	}
	public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
}
