package com.qst.action;


import com.qst.model.GoodsOrder;
import com.qst.serviceImpl.GoodsService;
import com.qst.serviceImpl.OrderServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
public class OrderAction {
	private final OrderServiceImpl orderService;
	private final GoodsService goodsService;
	private Float[] price;
	private Integer[] gid;
	private Integer[] number;
	private Integer addressId;

	@Autowired
	public OrderAction(OrderServiceImpl orderService, GoodsService goodsService) {
		this.orderService = orderService;
		this.goodsService = goodsService;
	}

	/*
	 * 通过uid寻找所有的未完成订单  paytype为0
	 */
	public String getAllorder() {                         // 本用户的所有未完成订单信息
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		int u_id = (int) session.getAttribute("uid");
		ArrayList<Long> ordernumber_list = new ArrayList<Long>();
		ordernumber_list = orderService.getOrderNumber(u_id);
		request.setAttribute("ordernumber_list", ordernumber_list);
		ArrayList<GoodsOrder> goodsOrders2_list = new ArrayList<GoodsOrder>();
		for (Long ordernumber : ordernumber_list) {
			ArrayList<GoodsOrder> goodsOrders_list = orderService.getOrderItemByOrdernumber(ordernumber);
			for (GoodsOrder goodsOrder : goodsOrders_list) {
				goodsOrders2_list.add(goodsOrder);
			}

		}
		request.setAttribute("goodsOrders2_list", goodsOrders2_list);
		return "getorder";

	}

	public String pay() {
		HttpServletRequest request = ServletActionContext.getRequest();
		long ordernumber = Long.parseLong(request.getParameter("ordernumber"));
		orderService.setOrderType(ordernumber);//设置支付状态为1：已支付状态
		ArrayList<Integer> gid_list = orderService.getgid(ordernumber);
		for (Integer gid : gid_list) {                    //设置完成支付后  商品数量减1
			orderService.UpdateGoodsRestnum(gid);
		}
		return "pay";
	}

	/*
	 * 将留言和地址加入表order中
	 */
	public String payForOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int ad_id = Integer.parseInt(request.getParameter("Checkout"));
		long ordernumber = Long.parseLong(request.getParameter("ordernumber"));
		String message = request.getParameter("message");
		orderService.setOrderByOrdernumber(ad_id, message, ordernumber);

		return "payForOrder";
	}


    public String submitOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		if(uid != null){
			try {
				double count = 0;
				for (int i = 0; i < gid.length; i++){
					count = count + price[i] * number[i];
				}
				long id = orderService.createOrder(gid,number,price,uid,count,addressId);
				session.setAttribute("orderId", id);
				session.setAttribute("price", count);

				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "index";
			}
		}
		else {
			return "login";
		}
    }

	public void setPrice(Float[] price) {
		this.price = price;
	}

	public void setGid(Integer[] gid) {
		this.gid = gid;
	}

	public void setNumber(Integer[] number) {
		this.number = number;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
}
