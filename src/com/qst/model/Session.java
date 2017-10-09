package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class Session {
	private Integer session_id;
	private String evaluate;
	private String reply;
	private int u_id;
	private long ordernumber;

	public int getU_id() {
		return u_id;
	}



	public void setU_id(int u_id) {
		this.u_id = u_id;
	}



	public long getOrdernumber() {
		return ordernumber;
	}



	public void setOrdernumber(long ordernumber) {
		this.ordernumber = ordernumber;
	}



	public Session() {

	}



	public Integer getSession_id() {
		return session_id;
	}



	public void setSession_id(Integer session_id) {
		this.session_id = session_id;
	}

	@Override
	public String toString() {
		return "Session [session_id=" + session_id + ", evaluate=" + evaluate + ", reply=" + reply + ", u_id=" + u_id
				+ ", ordernumber=" + ordernumber + "]";
	}



	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}


}
