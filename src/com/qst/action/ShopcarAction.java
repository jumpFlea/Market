
package com.qst.action;

import com.qst.model.Adress;
import com.qst.model.Goods;
import com.qst.model.Goods_item;
import com.qst.service.AdressService;
import com.qst.service.goodsService;
import com.qst.service.orderService;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Component
public class ShopcarAction {
	@Resource
	private goodsService goodsService;
	@Resource
	private orderService orderService;
	@Resource
	private AdressService adressService;

	public AdressService getAdressService() {
		return adressService;
	}

	public void setAdressService(AdressService adressService) {
		this.adressService = adressService;
	}

	public orderService getOrderService() {
		return orderService;
	}

	public void setOrderService(orderService orderService) {
		this.orderService = orderService;
	}

	public goodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(goodsService goodsService) {
		this.goodsService = goodsService;
	}

	/*
	 * 此类的功能为将商品设置进入订单,
	 */
	
	public String setGoodinOrder() { // 此功能为将购物车里面的商品设置进入订单
		SimpleDateFormat dateFormater = new SimpleDateFormat("ddmmyyyyHHmmssSSS");
		Date date = new Date();
		long ordernumber = Long.parseLong(dateFormater.format(date)); // 生成唯一的订单号

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		request.setAttribute("ordernumber", ordernumber);
		int u_id = (int) session.getAttribute("uid");
		String[] price = request.getParameterValues("newslist");
		String[] goodsnum = request.getParameterValues("text_box1");
		String[] gid = request.getParameterValues("gid");
		System.out.println(price.length);
		float Fprice[] = new float[price.length];
		int Fgoodsum[] = new int[goodsnum.length];
		int Fgid[] = new int[gid.length];
		for (int i = 0; i < price.length; i++) {
			Fprice[i] = Float.parseFloat(price[i]);
			Fgoodsum[i] = Integer.parseInt(goodsnum[i]);
			Fgid[i] = Integer.parseInt(gid[i]);
			orderService.creatorder(u_id, ordernumber); // 创建订单表
			orderService.creatorder_good(ordernumber, Fgid[i], Fprice[i], Fgoodsum[i]); // 创建商品连接表
		}
		return "order";
	}

	/*
	 * 得到购物车里面的商品
	 */
	public String getshopcargoods() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		ArrayList<Integer> arrayList;
		arrayList = goodsService.get_gid(uid);
		ArrayList<Goods> arrayList2 = new ArrayList<Goods>();
		Goods goods;
		for (Integer integer : arrayList) {
			goods = goodsService.getAllgoods(integer);
			arrayList2.add(goods);
		}
		session.setAttribute("goodlist", arrayList2);
		return "diao";
	}

	/*
	 * 得到订单的每一行商品信息
	 */
	public String getOrderItem() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		long ordernumber = (long) request.getAttribute("ordernumber");
		int uid = (int) session.getAttribute("uid");

		ArrayList<Integer> gid_list = orderService.getgid(ordernumber);
		ArrayList<Goods_item> goods_itemslist = new ArrayList<Goods_item>();
		ArrayList<Integer> adid_list = new ArrayList<Integer>();

		float sumprince = orderService.getSumprince(ordernumber);
		Goods_item goods_item;
		Adress adress;
		ArrayList<Adress> adress_list = new ArrayList<Adress>();
		adid_list = adressService.getAlladid(uid);

		for (Integer ad_id : adid_list) {
			adress = adressService.getAdress(ad_id);
			adress_list.add(adress);
		}

		for (Integer gid : gid_list) {
			goods_item = orderService.getgoods_item(ordernumber, gid);
			goods_itemslist.add(goods_item);
		}

		request.setAttribute("sumprince", sumprince);
		request.setAttribute("goods_items_list", goods_itemslist);
		request.setAttribute("adress_list", adress_list);
		return "dyj";
	}

	
		/*
		 * 删除购物车里的某一个商品
		 */
	public String delGoodsShopCar()		
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int uid =(int)session.getAttribute("uid");
		int gid =Integer.parseInt(request.getParameter("goodsid"));
		goodsService.deleteShopcarGoodByid(uid, gid);
		return "del";
		
	}
}
