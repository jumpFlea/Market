package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class OrderGoods {
	private Integer id;
	private Integer orderId;
	private Integer goodsId;
	private Double price;
	private Integer count;

	public OrderGoods() {
	}

	public OrderGoods(Integer id, Integer orderId, Integer goodsId, Double price, Integer count) {
		this.id = id;
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.price = price;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderGoods)) return false;

		OrderGoods that = (OrderGoods) o;

		if (!id.equals(that.id)) return false;
		if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
		if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
		if (price != null ? !price.equals(that.price) : that.price != null) return false;
		return count != null ? count.equals(that.count) : that.count == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
		result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (count != null ? count.hashCode() : 0);
		return result;
	}
}
