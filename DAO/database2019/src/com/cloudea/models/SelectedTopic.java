package com.cloudea.models;

public class SelectedTopic {
  private int stu_id;
  private int pl_id;
  String select_time;
  public SelectedTopic(int a,int b,String select_time)
  {
	  stu_id=a;
	  pl_id=b;
	  this.select_time=select_time;
  }
  public String getSelect_time() {
	return select_time;
}
public void setSelect_time(String select_time) {
	this.select_time = select_time;
}
public SelectedTopic() {}
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
  
}
