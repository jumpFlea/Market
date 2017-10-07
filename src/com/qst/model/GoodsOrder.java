package com.qst.model;

public class GoodsOrder {
	private int g_id;
	private String g_name;
	private float g_price;
	private long ordernumber;
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
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
	@Override
	public String toString() {
		return "GoodsOrder [g_id=" + g_id + ", g_name=" + g_name + ", g_price=" + g_price + ", ordernumber="
				+ ordernumber + "]";
	}
	public void setG_price(float g_price) {
		this.g_price = g_price;
	}
	public long getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(long ordernumber) {
		this.ordernumber = ordernumber;
	}

	
}
