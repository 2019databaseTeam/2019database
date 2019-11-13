package com.cloudea.models;

public class Problem {
	private int pl_id,tch_id,plt_id,max_person;
	private String pl_name,pl_degree,pl_need,pl_eva_mode;
	public Problem(){}
	public Problem(int pl_id,int tch_id, int plt_id, String pl_name,String pl_degree, String pl_need,String pl_eva_mode, int max_person)
	{
		this.setPl_id(pl_id);
		this.setTch_id(tch_id);
		this.setPlt_id(plt_id);
		this.setPl_name(pl_name);
		this.setPl_degree(pl_degree);
		this.setPl_need(pl_need);
		this.setPl_eva_mode(pl_eva_mode);
		this.setMax_person(max_person);
	}
	
	public int getPl_id() {
		return pl_id;
	}
	public void setPl_id(int pl_id) {
		this.pl_id = pl_id;
	}
	public int getTch_id() {
		return tch_id;
	}
	public void setTch_id(int tch_id) {
		this.tch_id = tch_id;
	}
	public int getPlt_id() {
		return plt_id;
	}
	public void setPlt_id(int plt_id) {
		this.plt_id = plt_id;
	}
	public int getMax_person() {
		return max_person;
	}
	public void setMax_person(int max_person) {
		this.max_person = max_person;
	}
	public String getPl_name() {
		return pl_name;
	}
	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
	}
	public String getPl_degree() {
		return pl_degree;
	}
	public void setPl_degree(String pl_degree) {
		this.pl_degree = pl_degree;
	}
	public String getPl_need() {
		return pl_need;
	}
	public void setPl_need(String pl_need) {
		this.pl_need = pl_need;
	}
	public String getPl_eva_mode() {
		return pl_eva_mode;
	}
	public void setPl_eva_mode(String pl_eva_mode) {
		this.pl_eva_mode = pl_eva_mode;
	}
	
}
