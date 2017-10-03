package com.qst.action;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.model.Goods;
import com.qst.model.GoodsOrder;
import com.qst.service.goodsService;
import com.qst.service.orderService;

@Component
public class GetAllOrderAction {
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
	
	public String getAllorder() {				 // 本用户的所有未完成订单信息
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		int u_id = (int) session.getAttribute("uid");
		ArrayList<Long> ordernumber_list =new ArrayList<Long>();
		ordernumber_list= orderService.getOrderNumber(u_id);
		request.setAttribute("ordernumber_list", ordernumber_list);
		ArrayList<GoodsOrder> goodsOrders2_list=new ArrayList<GoodsOrder>();
//		orderService orderservice=new orderServiceImpl();
//		ArrayList<Long> ordernumber_list =(ArrayList<Long>)request.getAttribute("ordernumber_list");
		for(Long ordernumber :ordernumber_list)
		{
			ArrayList<GoodsOrder> goodsOrders_list=orderService.getOrderItemByOrdernumber(ordernumber);
			for(GoodsOrder goodsOrder :goodsOrders_list)
			{
				goodsOrders2_list.add(goodsOrder);
			}
			
		}
		request.setAttribute("goodsOrders2_list", goodsOrders2_list);
		
	//	System.out.println("------------------>"+goodsOrders2_list);
		return "getorder";

	}
}
