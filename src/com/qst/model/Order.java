package com.qst.model;

/**
 * Created by tomatofrommars on 9/20/17.
 * Email: tomatofrommars@gmail.com
 */
public class Order {
	private Integer o_id;
	private Integer u_id;
	private Integer pay_type;
	private String message;
	private String evaluate;
	private String reply;
	private long ordernumber;
	
	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ", u_id=" + u_id + ", pay_type=" + pay_type + ", message=" + message
				+ ", evaluate=" + evaluate + ", reply=" + reply + ", ordernumber=" + ordernumber + "]";
	}

	
	public Order() {
	}


	public Integer getO_id() {
		return o_id;
	}

	public void setO_id(Integer o_id) {
		this.o_id = o_id;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Integer getPay_type() {
		return pay_type;
	}

	public void setPay_type(Integer pay_type) {
		this.pay_type = pay_type;
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

	public Order(Integer o_id, Integer u_id, Integer pay_type, String message, String evaluate, String reply,
			Integer ordernumber) {
		super();
		this.o_id = o_id;
		this.u_id = u_id;
		this.pay_type = pay_type;
		this.message = message;
		this.evaluate = evaluate;
		this.reply = reply;
		this.ordernumber = ordernumber;
	}

	public long getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}


}
