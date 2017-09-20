package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class Order {
	private Integer id;
	private Integer userId;
	private Integer payType;

	public Order() {
	}

	public Order(Integer id, Integer userId, Integer payType) {
		this.id = id;
		this.userId = userId;
		this.payType = payType;
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

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Order)) return false;

		Order order = (Order) o;

		if (!id.equals(order.id)) return false;
		if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
		return payType != null ? payType.equals(order.payType) : order.payType == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (payType != null ? payType.hashCode() : 0);
		return result;
	}
}
