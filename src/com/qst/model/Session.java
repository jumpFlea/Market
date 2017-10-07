package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class Session {
	private Integer session_id;
	private String evaluate;
	private String reply;

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
		return "Session [session_id=" + session_id + ", evaluate=" + evaluate + ", reply=" + reply + "]";
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
