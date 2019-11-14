package com.cloudea.models;

public class Material {
   private int m_id;
   private int stu_id;
   private String m_text;
   private String m_proof;
   public String getM_proof() {
	return m_proof;
}
public void setM_proof(String m_proof) {
	this.m_proof = m_proof;
}
public Material(int a,int b,String c,String d)
   {
	   m_id=a;
	   stu_id=b;
	   m_text=c;
	   m_proof=d;
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
