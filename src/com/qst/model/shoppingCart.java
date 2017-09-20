package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class shoppingCart {
	private Integer id;
	private Integer userId;
	private Integer goodsId;
	private Integer count;
	private Double price;

	public shoppingCart() {
	}

	public shoppingCart(Integer id, Integer userId, Integer goodsId, Integer count, Double price) {
		this.id = id;
		this.userId = userId;
		this.goodsId = goodsId;
		this.count = count;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
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
		if (!(o instanceof shoppingCart)) return false;

		shoppingCart that = (shoppingCart) o;

		if (!id.equals(that.id)) return false;
		if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
		if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
		if (count != null ? !count.equals(that.count) : that.count != null) return false;
		return price != null ? price.equals(that.price) : that.price == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
		result = 31 * result + (count != null ? count.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}
}
