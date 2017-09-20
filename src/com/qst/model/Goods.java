package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class Goods {
	private Integer id;
	private Double price;
	private String name;
	private String attribute;
	private Integer userId;
	private Integer imageId;
	private Integer restNum;
	private String introduce;
	
	public Goods() {
	}



	public Goods(Integer id, Double price, String name, String attribute, Integer userId, Integer imageId,
			Integer restNum, String introduce) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.attribute = attribute;
		this.userId = userId;
		this.imageId = imageId;
		this.restNum = restNum;
		this.introduce = introduce;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getRestNum() {
		return restNum;
	}

	public void setRestNum(Integer restNum) {
		this.restNum = restNum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Goods)) return false;

		Goods goods = (Goods) o;

		if (!id.equals(goods.id)) return false;
		if (price != null ? !price.equals(goods.price) : goods.price != null) return false;
		if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
		if (attribute != null ? !attribute.equals(goods.attribute) : goods.attribute != null) return false;
		if (userId != null ? !userId.equals(goods.userId) : goods.userId != null) return false;
		if (imageId != null ? !imageId.equals(goods.imageId) : goods.imageId != null) return false;
		return restNum != null ? restNum.equals(goods.restNum) : goods.restNum == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (imageId != null ? imageId.hashCode() : 0);
		result = 31 * result + (restNum != null ? restNum.hashCode() : 0);
		return result;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
