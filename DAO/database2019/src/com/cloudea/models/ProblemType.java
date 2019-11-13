package com.cloudea.models;

public class ProblemType  {
	private int plt_id;
	private String pl_type;
	public ProblemType() {}
	public ProblemType(int plt_id,String pl_type) {
		this.plt_id=plt_id;
		this.pl_type=pl_type;
	}
	public int getPlt_id() {
		return plt_id;
	}
	public void setPlt_id(int plt_id) {
		this.plt_id = plt_id;
	}
	public String getPl_type() {
		return pl_type;
	}
	public void setPl_type(String pl_type) {
		this.pl_type = pl_type;
	}
	
}
