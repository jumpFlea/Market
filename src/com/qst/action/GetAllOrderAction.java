package com.qst.action;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.model.Goods;
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
		ArrayList<Integer> gid_list = new ArrayList<Integer>();
		ArrayList<Goods> goods_list =new ArrayList<Goods>();
		gid_list=orderService.getG_idByUid(u_id);
		Goods goods;
		for (Integer gid : gid_list) {
			goods= goodsService.getAllgoods(gid);
			goods_list.add(goods);
		}
		request.setAttribute("goods_list",goods_list );
		return "getorder";

	}
}
