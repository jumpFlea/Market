package com.qst.model;

public class GoodsOrder {
	private int g_id;
	private String g_name;
	private float g_price;
	private long ordernumber;
	private String image_zhanshi;
	private String message;
	private String name;
	private String phone;
	private String region;
	private String street;

	
	public String getMeassage() {
		return message;
	}
	public void setMeassage(String meassage) {
		this.message = meassage;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
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
	public void setG_price(float g_price) {
		this.g_price = g_price;
	}
	public long getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(long ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getImage_zhanshi() {
		return image_zhanshi;
	}
	public void setImage_zhanshi(String image_zhanshi) {
		this.image_zhanshi = image_zhanshi;
	}
	@Override
	public String toString() {
		return "GoodsOrder [g_id=" + g_id + ", g_name=" + g_name + ", g_price=" + g_price + ", ordernumber="
				+ ordernumber + ", image_zhanshi=" + image_zhanshi + ", message=" + message + ", name=" + name
				+ ", phone=" + phone + ", region=" + region + ", street=" + street + "]";
	}


	
}
