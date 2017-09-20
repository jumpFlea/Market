package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class UserGoods {
	private Integer id;
	private Integer goodsId;
	private Integer userId;
	private String date;

	public UserGoods() {
	}

	public UserGoods(Integer id, Integer goodsId, Integer userId, String date) {
		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserGoods)) return false;

		UserGoods userGoods = (UserGoods) o;

		if (!id.equals(userGoods.id)) return false;
		if (goodsId != null ? !goodsId.equals(userGoods.goodsId) : userGoods.goodsId != null) return false;
		if (userId != null ? !userId.equals(userGoods.userId) : userGoods.userId != null) return false;
		return date != null ? date.equals(userGoods.date) : userGoods.date == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (date != null ? date.hashCode() : 0);
		return result;
	}
}
