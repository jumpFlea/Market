package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class Goods {
	private Integer g_id;
	private Double g_price;
	private String g_name;
	private String g_attribute;
	private Integer u_id;
	private Integer image_id;
	private Integer restnum;
	private String introduce;
	
	public Goods() {
	}



	
	public Goods(Integer g_id, Double g_price, String g_name, String g_attribute, Integer u_id, Integer image_id,
			Integer restnum, String introduce) {
		super();
		this.g_id = g_id;
		this.g_price = g_price;
		this.g_name = g_name;
		this.g_attribute = g_attribute;
		this.u_id = u_id;
		this.image_id = image_id;
		this.restnum = restnum;
		this.introduce = introduce;
	}




	public Integer getG_id() {
		return g_id;
	}




	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}




	public Double getG_price() {
		return g_price;
	}




	public void setG_price(Double g_price) {
		this.g_price = g_price;
	}




	public String getG_name() {
		return g_name;
	}




	public void setG_name(String g_name) {
		this.g_name = g_name;
	}




	public String getG_attribute() {
		return g_attribute;
	}




	public void setG_attribute(String g_attribute) {
		this.g_attribute = g_attribute;
	}




	public Integer getU_id() {
		return u_id;
	}




	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}




	public Integer getImage_id() {
		return image_id;
	}




	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}




	public Integer getRestnum() {
		return restnum;
	}




	public void setRestnum(Integer restnum) {
		this.restnum = restnum;
	}




	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
