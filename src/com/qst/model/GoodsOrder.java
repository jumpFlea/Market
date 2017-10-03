package com.qst.model;

public class GoodsOrder {
	private String g_name;
	private float g_price;
	private long ordernumber;

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

	@Override
	public String toString() {
		return "GoodsOrder [g_name=" + g_name + ", g_price=" + g_price + ", ordernumber=" + ordernumber + "]";
	}

	public long getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(long ordernumber) {
		this.ordernumber = ordernumber;
	}
}
