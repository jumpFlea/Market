package com.qst.action;

import com.qst.model.GoodsOrder;
import com.qst.service.goodsService;
import com.qst.service.orderService;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Component
public class OrderAction {
	@Resource
	private orderService orderService;
	@Resource
	private goodsService goodsService;
	public goodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(goodsService goodsService) {
		this.goodsService = goodsService;
	}

	public orderService getOrderService() {
		return orderService;
	}

	public void setOrderService(orderService orderService) {
		this.orderService = orderService;
	}
	/*
	 * 通过uid寻找所有的未完成订单  paytype为0
	 */
	public String getAllorder() {						 // 本用户的所有未完成订单信息
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		int u_id = (int) session.getAttribute("uid");
		ArrayList<Long> ordernumber_list =new ArrayList<Long>();
		ordernumber_list= orderService.getOrderNumber(u_id);
		request.setAttribute("ordernumber_list", ordernumber_list);
		ArrayList<GoodsOrder> goodsOrders2_list=new ArrayList<GoodsOrder>();
		for(Long ordernumber :ordernumber_list)
		{
			ArrayList<GoodsOrder> goodsOrders_list=orderService.getOrderItemByOrdernumber(ordernumber);
			for(GoodsOrder goodsOrder :goodsOrders_list)
			{
				goodsOrders2_list.add(goodsOrder);
			}

		}
		request.setAttribute("goodsOrders2_list", goodsOrders2_list);
		return "getorder";

	}
	
	public String pay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		long ordernumber =Long.parseLong(request.getParameter("ordernumber")) ;
		orderService.setOrderType(ordernumber);//设置支付状态为1：已支付状态
		return "pay";
	}





}
