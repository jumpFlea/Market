package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class ShopCartGoods {
	private Integer id;
	private Integer uid;
	private Integer gid;
	private Integer goods_number;
	private Double price;

	public ShopCartGoods() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public ShopCartGoods(Integer id, Integer uid, Integer gid, Integer goods_number, Double price) {
		this.id = id;
		this.uid = uid;
		this.gid = gid;
		this.goods_number = goods_number;
		this.price = price;
	}

	public ShopCartGoods(Integer uid, Integer goodsId, Integer goodsNum, Double goodsPrice) {
		this.uid = uid;
		this.gid = goodsId;
		this.goods_number = goodsNum;
		this.price = goodsPrice;
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

		if (!id.equals(that.id)) return false;
		if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
		if (gid != null ? !gid.equals(that.gid) : that.gid != null) return false;
		if (goods_number != null ? !goods_number.equals(that.goods_number) : that.goods_number != null) return false;
		return price != null ? price.equals(that.price) : that.price == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (uid != null ? uid.hashCode() : 0);
		result = 31 * result + (gid != null ? gid.hashCode() : 0);
		result = 31 * result + (goods_number != null ? goods_number.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}
}
