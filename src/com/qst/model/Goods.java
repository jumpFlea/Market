package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17. Email: tomatofrommars@gmail.com
 */
public class Goods {

	private Integer g_id;
	private Double g_price;
	private String g_name;
	private String g_attribute;
	private Integer image_id;
	private Integer u_id;
	private Integer restnum;
	private String introduce;
	private long goodsnumber;
	private String image_zhanshi;
	private Double market_price;
	private String g_content;

	public Goods() {
	}

	public Goods(Integer g_id, Double g_price, String g_name, String g_attribute, Integer u_id, Integer restnum, String introduce, String image_zhanshi, Double market_price, String g_content) {
		super();
		this.g_id = g_id;
		this.g_price = g_price;
		this.g_name = g_name;
		this.g_attribute = g_attribute;
		this.u_id = u_id;
		this.restnum = restnum;
		this.introduce = introduce;
		this.image_zhanshi = image_zhanshi;
		this.market_price = market_price;
		this.g_content = g_content;
	}

	public String toString() {
		return "Goods [g_id=" + g_id + ", g_price=" + g_price + ", g_name=" + g_name + ", g_attribute=" + g_attribute + ",u_id=" + u_id + ", restnum=" + restnum + ",introduce=" + introduce + ", image_zhanshi=" + image_zhanshi + "market_price=" + market_price + ", g_content=" + g_content + "]";
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

	public long getGoodsnumber() {
		return goodsnumber;
	}

	public void setGoodsnumber(long goodsnumber) {
		this.goodsnumber = goodsnumber;
	}

	public String getImage_zhanshi() {
		return image_zhanshi;
	}

	public void setImage_zhanshi(String image_zhanshi) {
		this.image_zhanshi = image_zhanshi;
	}

	public Double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public String getG_content() {
		return g_content;
	}

	public Integer getImage_id() {
		return image_id;
	}

	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}

	public void setG_content(String g_content) {
		this.g_content = g_content;
	}

}
