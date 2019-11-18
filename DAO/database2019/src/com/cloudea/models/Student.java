package com.cloudea.models;

public class Student {
   private int stu_id;
   private int u_id;
   private String SN;
   private int mjr_id;
   public Student() {}
   public Student(int a,int b,String c,int d)
   {
	   stu_id=a;
	   u_id=b;
	   SN=c;
	   mjr_id=d;
   }
   
public int getStu_id() {
	return stu_id;
}
public void setStu_id(int stu_id) {
	this.stu_id = stu_id;
}
public int getU_id() {
	return u_id;
}
public void setU_id(int u_id) {
	this.u_id = u_id;
}
public String getSN() {
	return SN;
}
public void setSN(String sN) {
	SN = sN;
}
public int getMjr_id() {
	return mjr_id;
}
public void setMjr_id(int mjr_id) {
	this.mjr_id = mjr_id;
}
   
}
