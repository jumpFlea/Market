package com.qst.model;

public class Goods_Session {
	private int g_id ;
	private String evaluate;
	private String g_name;
	private float g_price;
	private String image_zhanshi;
	private float market_price;
	private String session_data;
	
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public float getG_price() {
		return g_price;
	}
	public void setG_price(float g_price) {
		this.g_price = g_price;
	}
	public String getImage_zhanshi() {
		return image_zhanshi;
	}
	public void setImage_zhanshi(String image_zhanshi) {
		this.image_zhanshi = image_zhanshi;
	}
	public float getMarket_price() {
		return market_price;
	}
	public void setMarket_price(float market_price) {
		this.market_price = market_price;
	}
	public String getSession_data() {
		return session_data;
	}
	public void setSession_data(String session_data) {
		this.session_data = session_data;
	}
	
	@Override
	public String toString() {
		return "Goods_Session [g_id=" + g_id + ", evaluate=" + evaluate + ", g_name=" + g_name + ", g_price=" + g_price
				+ ", image_zhanshi=" + image_zhanshi + ", market_price=" + market_price + ", session_data="
				+ session_data + "]";
	}
}
