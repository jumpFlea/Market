package com.qst.action;

import com.qst.model.Adress;
import com.qst.model.GoodsOrder;
import com.qst.serviceImpl.OrderServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class OutstandingOrderAction {

	@Autowired
	private OrderServiceImpl orderService;

	/*
	 * 继续支付某一个订单
	 *
	 */

	public String continuePayment() {
		HttpServletRequest request = ServletActionContext.getRequest();
		long ordernumber = Long.parseLong(request.getParameter("ordernumber"));
		Adress adress = orderService.getAdressByOrdernumber(ordernumber);
		ArrayList<GoodsOrder> goods_list = new ArrayList<GoodsOrder>();
		goods_list = orderService.getOrderItemByOrdernumber(ordernumber);
		float sumprince = orderService.getOrderSumPrince(ordernumber);
		request.setAttribute("goodsorder_list", goods_list);
		request.setAttribute("Adress", adress);
		request.setAttribute("ordernumber", ordernumber);
		request.setAttribute("sumprince", sumprince);
		return "continuePayment";
	}

	/*
	 * 删除完成订单 中的某一个订单
	 */
	public String cancellationOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		long ordernumber = Long.parseLong(request.getParameter("ordernumber"));
		orderService.delOrderInorder_goods(ordernumber);    //先删除order_goods表中的数据！
		orderService.delOrderInorder(ordernumber);            //删除order表中的数据
		return "delOrder";
	}


}
