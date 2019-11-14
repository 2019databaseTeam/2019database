package com.cloudea.models;

public class Selection {
    private int sec_id;
    private int stu_id;
    private int priority;
    private int pl_id;
    private int m_id;
    private int sa_id;
    public Selection(int a,int b,int c,int d,int e,int f)
    {
    	sec_id=a;
    	stu_id=b;
    	priority=c;
    	pl_id=d;
    	m_id=e;
    	sa_id=f;
    }
    public int getSa_id() {
		return sa_id;
	}
	public void setSa_id(int sa_id) {
		this.sa_id = sa_id;
	}
	public Selection(){}
	
	public int getSec_id() {
		return sec_id;
	}
	public void setSec_id(int sec_id) {
		this.sec_id = sec_id;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getPl_id() {
		return pl_id;
	}
	public void setPl_id(int pl_id) {
		this.pl_id = pl_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
    
}
