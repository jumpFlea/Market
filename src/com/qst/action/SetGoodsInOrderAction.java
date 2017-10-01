package com.qst.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.service.orderService;

@Component
public class SetGoodsInOrderAction {
	@Resource
	private orderService orderService;

	public orderService getOrderService() {
		return orderService;
	}

	public void setOrderService(orderService orderService) {
		this.orderService = orderService;
	}

	public String setgoodsinordre() { // 将某一项商品直接设置进入订单并跳转到订单表
		SimpleDateFormat dateFormater = new SimpleDateFormat("ddmmyyyyHHmmssSSS");
		Date date = new Date();
		long ordernumber = Long.parseLong(dateFormater.format(date)); // 生成唯一的订单号

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		request.setAttribute("ordernumber", ordernumber);
		int u_id = (int) session.getAttribute("uid");
		orderService.creatorder(u_id, ordernumber);
		int g_id = Integer.parseInt(request.getParameter("Goodid"));
		float prince = Float.parseFloat(request.getParameter("Goodprice"));
		int og_num = Integer.parseInt(request.getParameter("Goodsum"));
		orderService.creatorder_good(ordernumber, g_id, prince, og_num);
		orderService.setOrderType(ordernumber); // 将订单转台转化为1 待支付状态
		return "order";
	}
}
