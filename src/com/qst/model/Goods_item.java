package com.qst.model;

public class Goods_item {
	private String g_name;
	private float prince;
	private int og_num;
	private String image_zhanshi;

	public String getG_name() {
		return g_name;
	}    
	
	
	

	@Override
	public String toString() {
		return "Goods_iteam [g_name=" + g_name + ", prince=" + prince + ", og_num=" + og_num + "]";
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public float getPrince() {
		return prince;
	}
	public void setPrince(float prince) {
		this.prince = prince;
	}
	public int getOg_num() {
		return og_num;
	}
	public void setOg_num(int og_num) {
		this.og_num = og_num;
	}

	public String getImage_zhanshi() {
		return image_zhanshi;
	}

	public void setImage_zhanshi(String image_zhanshi) {
		this.image_zhanshi = image_zhanshi;
	}
}
