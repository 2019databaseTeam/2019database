package com.cloudea.models;

public class Material {
   private int m_id;
   private int stu_id;
   private String m_text;
   public Material(int a,int b,String c)
   {
	   m_id=a;
	   stu_id=b;
	   m_text=c;
   }
   public Material(){}
public int getM_id() {
	return m_id;
}
public void setM_id(int m_id) {
	this.m_id = m_id;
}
public int getStu_id() {
	return stu_id;
}
public void setStu_id(int stu_id) {
	this.stu_id = stu_id;
}
public String getM_text() {
	return m_text;
}
public void setM_text(String m_text) {
	this.m_text = m_text;
}
   
   
	
}
