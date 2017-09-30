package com.qst.model;


public class Adress {
	
	private String name;
	private String phone;
	private String region;
	private String street;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String toString() {
		return "Adress [name=" + name + ", phone=" + phone + ", region=" + region + ", street=" + street + "]";
	}

}
