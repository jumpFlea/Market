package com.qst.action;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.model.Goods;
import com.qst.model.GoodsOrder;
import com.qst.model.Page;
import com.qst.serviceImpl.GoodsOrderService;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@Component
public class GoodsOrderAction {
	@Resource
	private GoodsOrderService goodsorderservice;
	int page=1;
	public GoodsOrderService getGoodsorderservice() {
		return goodsorderservice;
	}

	public void setGoodsorderservice(GoodsOrderService goodsorderservice) {
		this.goodsorderservice = goodsorderservice;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/*
	 * 已完成未评价订单的分页查找 首页查找
	 */
	public String comletedOrderIndex() {
		Page<GoodsOrder> goodsorder =new Page<GoodsOrder>();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int a=6*(page-1);
		int b=5;
		int u_id = (int) session.getAttribute("uid");
		int pay_type=1;
		java.util.List<GoodsOrder> goodsOrders_list = new ArrayList<GoodsOrder>();
		goodsOrders_list = goodsorderservice.getGoodOrderByu_id(u_id, pay_type, a, b);
		int count=goodsorderservice.getCountFromGoodOrderByu_id(u_id, pay_type);
		if (count%6 == 0) {
			count = count / 6;
			goodsorder.setCountPage(count);
		} else {
			count = (count / 6) + 1;
			goodsorder.setCountPage(count);
		}
		goodsorder.setList(goodsOrders_list);
		goodsorder.setCountPage(count);
		request.setAttribute("goodsorder", goodsorder);
		return "comletedOrderIndex";
	}


	/*
	 * 已评价订单的首页查找
	 */

	public String evaluaedOrderIndex() {
		Page<GoodsOrder> goodsorder =new Page<GoodsOrder>();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int u_id = (int) session.getAttribute("uid");
		int pay_type=1;
		java.util.List<GoodsOrder> goodsOrders_list = new ArrayList<GoodsOrder>();
		int a=6*(page-1);
		int b=5;
		goodsOrders_list=goodsorderservice.getEvaluteGoods(u_id, pay_type, a, b);
		int count=goodsorderservice.getCountCompleted_EvaluationOrder(u_id, pay_type);
		if (count%6 == 0) {
			count = count / 6;
			goodsorder.setCountPage(count);
		} else {
			count = (count / 6) + 1;
			goodsorder.setCountPage(count);
		}
		goodsorder.setList(goodsOrders_list);
		goodsorder.setCountPage(count);
		request.setAttribute("goodsorder", goodsorder);
		return "evaluaedOrderIndex";
	}
}
