package com.qst.action;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.model.GoodsOrder;
import com.qst.serviceImpl.GoodsOrderService;

@Component
public class GoodsOrderAction {
	@Resource
	private GoodsOrderService goodsorderservice;

	public GoodsOrderService getGoodsorderservice() {
		return goodsorderservice;
	}

	public void setGoodsorderservice(GoodsOrderService goodsorderservice) {
		this.goodsorderservice = goodsorderservice;
	}
/*
 * 已完成订单的分页查找  首页查找  
 */
	public String comletedOrderIndex() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int u_id = (int) session.getAttribute("uid");
		int pay_type = Integer.parseInt(request.getParameter("pay_type"));
		ArrayList<GoodsOrder> goodsOrders_list = new ArrayList<GoodsOrder>();
		goodsOrders_list= goodsorderservice.getGoodOrderByu_id(u_id, pay_type, 0, 5);
		session.setAttribute("goodsOrders_list", goodsOrders_list);
		return "comletedOrderIndex";
	}
	/*
	 * 已完成的订单分页查找  分页
	 */

	public String comletedOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int u_id = (int) session.getAttribute("uid");
		int pay_type=Integer.parseInt(request.getParameter("pay_type"));
		int pag=Integer.parseInt(request.getParameter("pag"));
		int a=(pag-1)*5;
		int b=pag*5-1;
		ArrayList<GoodsOrder> goodsOrders_list = new ArrayList<GoodsOrder>();
		goodsOrders_list= goodsorderservice.getGoodOrderByu_id(u_id, pay_type, a, b);
		session.setAttribute("goodsOrders_list", goodsOrders_list);
		return "comletedOrder";
	}
}
