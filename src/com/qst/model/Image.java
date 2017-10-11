package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17. Email: tomatofrommars@gmail.com
 */
public class Image {
	private Integer image_id;
	private String url1;
	private String url2;
	private String url3;
	private String url4;
	private String gid;

	private long goodsnumber;

	public Image() {
	}

	public Image(Integer image_id, String url1, String url2, String url3, String url4, long goodsnumber) {
		super();
		this.image_id = image_id;
		this.url1 = url1;
		this.url2 = url2;
		this.url3 = url3;
		this.url4 = url4;
		this.goodsnumber = goodsnumber;
	}

	public Integer getId() {
		return image_id;
	}

	public void setId(Integer id) {
		this.image_id = id;
	}

	public String getUrl1() {
		return url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getUrl3() {
		return url3;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

	public String getUrl4() {
		return url4;
	}

	public void setUrl4(String url4) {
		this.url4 = url4;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public Integer getImage_id() {
		return image_id;
	}

	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Image))
			return false;

		Image image = (Image) o;

		if (!image_id.equals(image.image_id))
			return false;
		if (url1 != null ? !url1.equals(image.url1) : image.url1 != null)
			return false;
		if (url2 != null ? !url2.equals(image.url2) : image.url2 != null)
			return false;
		if (url3 != null ? !url3.equals(image.url3) : image.url3 != null)
			return false;
		return url4 != null ? url4.equals(image.url4) : image.url4 == null;
	}

	@Override
	public int hashCode() {
		int result = image_id.hashCode();
		result = 31 * result + (url1 != null ? url1.hashCode() : 0);
		result = 31 * result + (url2 != null ? url2.hashCode() : 0);
		result = 31 * result + (url3 != null ? url3.hashCode() : 0);
		result = 31 * result + (url4 != null ? url4.hashCode() : 0);
		return result;
	}

	public long getGoodsnumber() {
		return goodsnumber;
	}

	public void setGoodsnumber(long goodsnumber) {
		this.goodsnumber = goodsnumber;
	}
}
