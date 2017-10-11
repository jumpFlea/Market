package com.qst.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.model.GoodsOrder;
import com.qst.model.Page;
import com.qst.serviceImpl.GoodsSoldsService;

@Component
public class GoodsSoldAction {
	@Resource
	private GoodsSoldsService goodsSoldsService;
	int page=1;
	public GoodsSoldsService getGoodsSoldsService() {
		return goodsSoldsService;
	}

	public void setGoodsSoldsService(GoodsSoldsService goodsSoldsService) {
		this.goodsSoldsService = goodsSoldsService;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	/*
	 * 得到用户卖出的商品（还未发货的）分页查找
	 */
	

	
	public String getGoodsItems(){
		Page<GoodsOrder> GoodsOrder =new Page<GoodsOrder>();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int u_id=(int)session.getAttribute("uid");
		int pay_type=1;//已付款 未发货商品
		int a=6*(page-1);
		int b=5;
	    List<GoodsOrder> goodsOrders_list = new ArrayList<GoodsOrder>();
	    goodsOrders_list =goodsSoldsService.getSoldGoodsByU_id(u_id, pay_type, a, b);
		int count=goodsSoldsService.getCountOrdernumber(u_id, pay_type);
		if (count%6 == 0) {
			count = count / 6;
			GoodsOrder.setCountPage(count);
		} else {
			count = (count / 6) + 1;
			GoodsOrder.setCountPage(count);
		}
		GoodsOrder.setList(goodsOrders_list);
		GoodsOrder.setCountPage(count);
		request.setAttribute("goodsorder", GoodsOrder);
		return "goodsitems";
		
	}
	
	public String  setOrderpay_type() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		long ordernumber=  Long.parseLong(request.getParameter("ordernumber"));
		int pay_type=2;//已发货状态
		goodsSoldsService.SetOrderType(pay_type, ordernumber);
		
		return "setOrderpay_type";
	}
	
}
