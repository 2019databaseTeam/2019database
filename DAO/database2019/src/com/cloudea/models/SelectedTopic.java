package com.cloudea.models;

public class SelectedTopic {
  private int stu_id;
  private int pl_id;
  public SelectedTopic(int a,int b)
  {
	  stu_id=a;
	  pl_id=b;
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
