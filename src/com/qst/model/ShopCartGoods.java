package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class ShopCartGoods {
	private Integer sgId;
	private Integer uId;
	private Integer gId;
	private Integer goods_number;
	private Double price;

	public ShopCartGoods() {
	}

	public ShopCartGoods(Integer sgId, Integer uId, Integer gId, Integer goods_number, Double price) {
		this.sgId = sgId;
		this.uId = uId;
		this.gId = gId;
		this.goods_number = goods_number;
		this.price = price;
	}

	public Integer getSgId() {
		return sgId;
	}

	public void setSgId(Integer sgId) {
		this.sgId = sgId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getgId() {
		return gId;
	}

	public void setgId(Integer gId) {
		this.gId = gId;
	}

	public Integer getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(Integer goods_number) {
		this.goods_number = goods_number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ShopCartGoods)) return false;

		ShopCartGoods that = (ShopCartGoods) o;

		if (!sgId.equals(that.sgId)) return false;
		if (uId != null ? !uId.equals(that.uId) : that.uId != null) return false;
		if (gId != null ? !gId.equals(that.gId) : that.gId != null) return false;
		if (goods_number != null ? !goods_number.equals(that.goods_number) : that.goods_number != null) return false;
		return price != null ? price.equals(that.price) : that.price == null;
	}

	@Override
	public int hashCode() {
		int result = sgId.hashCode();
		result = 31 * result + (uId != null ? uId.hashCode() : 0);
		result = 31 * result + (gId != null ? gId.hashCode() : 0);
		result = 31 * result + (goods_number != null ? goods_number.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}
}
