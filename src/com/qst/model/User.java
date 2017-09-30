package com.qst.model;

public class User {
	private Integer uid;
	private String username;
	private String psw;
	private String email;
	private Integer state_type;
	private String adress;
	private Integer integral;
	private String u_image;
	



	public User() {
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", psw=" + psw + ", email=" + email + ", state_type="
				+ state_type + ", adress=" + adress + ", integral=" + integral + "]";
	}

	public User(Integer uid, String username, String psw, String email, Integer state_type, String adress,
			Integer integral,String u_image) {
		super();
		this.uid = uid;
		this.username = username;
		this.psw = psw;
		this.email = email;
		this.state_type = state_type;
		this.adress = adress;
		this.integral = integral;
		this.u_image=u_image;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getState_type() {
		return state_type;
	}

	public void setState_type(Integer state_type) {
		this.state_type = state_type;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	
	public String getU_image() {
		return u_image;
	}

	public void setU_image(String u_image) {
		this.u_image = u_image;
	}
}
