package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class Session {
	private Integer id;
	private String message;
	private String evaluate;
	private String reply;

	public Session(Integer id, String message, String evaluate, String reply) {
		this.id = id;
		this.message = message;
		this.evaluate = evaluate;
		this.reply = reply;
	}

	public Session() {

	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (!(o instanceof Session)) return false;

		Session session = (Session) o;

		if (!id.equals(session.id)) return false;
		if (message != null ? !message.equals(session.message) : session.message != null) return false;
		if (evaluate != null ? !evaluate.equals(session.evaluate) : session.evaluate != null) return false;
		return reply != null ? reply.equals(session.reply) : session.reply == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + (message != null ? message.hashCode() : 0);
		result = 31 * result + (evaluate != null ? evaluate.hashCode() : 0);
		result = 31 * result + (reply != null ? reply.hashCode() : 0);
		return result;
	}
}
