package com.qst.model;

public class User {
	private Integer id;
	private String username;
	private String psw;
	private String email;
	private Integer stateType;
	private String address;
	private Integer integral;



	public User() {
	}

	public User(Integer id, String username, String psw,String email, Integer stateType, String address, Integer integral) {
		this.id = id;
		this.username = username;
		this.psw = psw;
		this.email=email;
		this.stateType = stateType;
		this.address = address;
		this.integral = integral;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;

		User user = (User) o;

		if (!id.equals(user.id)) return false;
		if (username != null ? !username.equals(user.username) : user.username != null) return false;
		if (psw != null ? !psw.equals(user.psw) : user.psw != null) return false;
		if (email != null ? !psw.equals(user.psw) : user.psw != null) return false;
		if (stateType != null ? !stateType.equals(user.stateType) : user.stateType != null) return false;
		if (address != null ? !address.equals(user.address) : user.address != null) return false;
		return integral != null ? integral.equals(user.integral) : user.integral == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (psw != null ? psw.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (stateType != null ? stateType.hashCode() : 0);	
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + (integral != null ? integral.hashCode() : 0);
		return result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public Integer getStateType() {
		return stateType;
	}

	public void setStateType(Integer stateType) {
		this.stateType = stateType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
}
