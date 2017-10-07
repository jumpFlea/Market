package com.qst.model;

public class GoodsSession { 
	private int gdse_id;
	private int g_id;
	private int session_id;
	private Session session;
	
	
	public GoodsSession(){
		
	}
	
	public GoodsSession(int gdse_id,int g_id,int session_id,Session session){
		this.gdse_id=gdse_id;
		this.g_id=g_id;
		this.session_id=session_id;
		this.session=session;
	} 
	
	public int getGdse_id() {
		return gdse_id;
	}
	public void setGdse_id(int gdse_id) {
		this.gdse_id = gdse_id;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public int getSession_id() {
		return session_id;
	}
	public void setSession_id(int session_id) {
		this.session_id = session_id;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}
