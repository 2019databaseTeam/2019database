package com.cloudea.models;

public class ChatRecord {
	private int mes_id;
	private int u_id_send;
	private int u_id_receive;
	private String time;
	private String text;
	public ChatRecord() {}
	public ChatRecord(int mes_id,int u_id_send,int u_id_receive,String time,String text)
	{
		this.mes_id=mes_id;
		this.u_id_send=u_id_send;
		this.u_id_receive=u_id_receive;
		this.time=time;
		this.text=text;
	}
	public int getMes_id() {
		return mes_id;
	}
	public void setMes_id(int mes_id) {
		this.mes_id = mes_id;
	}
	public int getU_id_send() {
		return u_id_send;
	}
	public void setU_id_send(int u_id_send) {
		this.u_id_send = u_id_send;
	}
	public int getU_id_receive() {
		return u_id_receive;
	}
	public void setU_id_receive(int u_id_receive) {
		this.u_id_receive = u_id_receive;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
