package com.qst.action;

import com.qst.model.Adress;
import com.qst.model.Goods_item;
import com.qst.model.ShopCartGoods;
import com.qst.model.User;
import com.qst.serviceImpl.AddressServiceImpl;
import com.qst.serviceImpl.OrderServiceImpl;
import com.qst.serviceImpl.ShopCarService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller
public class ShopCartAction {
	private final OrderServiceImpl orderService;
	private final AddressServiceImpl addressService;
	private final ShopCarService shopCarService;

	private ShopCartGoods item;

	@Autowired
	public ShopCartAction(OrderServiceImpl orderService, AddressServiceImpl addressService, ShopCarService shopCarService) {
		this.orderService = orderService;
		this.addressService = addressService;
		this.shopCarService = shopCarService;
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
	public String getShopCartGoods() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("uid");
		ArrayList<HashMap> goodsList = shopCarService.getGoodsByUserId(id);
		if(goodsList.size() == 0){
			session.removeAttribute("goodsList");
		}
		else {
			session.setAttribute("goodsList", goodsList);
		}
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
		adid_list = addressService.getAlladid(uid);

		for (Integer ad_id : adid_list) {
			adress = addressService.getAdress(ad_id);
			adress_list.add(adress);
		}

		for (Integer gid : gid_list) {
			goods_item = orderService.getgoods_item(ordernumber, gid);
			goods_itemslist.add(goods_item);
		}

		request.setAttribute("sumprince", sumprince);
		request.setAttribute("ordernumber", ordernumber);
		request.setAttribute("goods_items_list", goods_itemslist);
		request.setAttribute("adress_list", adress_list);
		return "dyj";
	}


	/*
	 * 添加商品到与用户关联的购物车
	 */
	public String addToShopCart() {
		if (item == null || item.getUid() == null){
			return "login";
		}
		else {
			try {
				shopCarService.addToCart(item);
				return "success";
			} catch (Exception e) {
				return "index";
			}
		}
	}

	/*
	 * 删除购物车里的某一个商品
	 */
	public String delGoodsShopCart() {
		if (item == null || item.getUid() == null){
			return "login";
		}
		else {
			try {
				shopCarService.removeCartGoods(item);
				return "del";
			} catch (Exception e) {
				return "index";
			}
		}
	}

	public String addFavorite() {
		if (item == null || item.getUid() == null){
			return "login";
		}
		else {
			try {
				shopCarService.addFavorite(item);
				delGoodsShopCart();
				return "favorite";
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if(e.getMessage().contains("Duplicate")) {
					delGoodsShopCart();
					return "favorite";
				}
				else {
					return "index";
				}
			}
		}
	}

	public void cartCount(){
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		int uid = ((User) ServletActionContext.getRequest().getSession().getAttribute("user")).getUid();
		int result;
		try {
			out = response.getWriter();
			result = shopCarService.getCountByUser(uid) + 1;
		} catch (IOException e) {
			result = -1;
			e.printStackTrace();
		}

		if (out != null) {
			out.println(result);
			out.flush();
			out.close();

		}
	}

	public String quickBuy(){
		ServletActionContext.getRequest().getSession().setAttribute("goods",item);
		return "success";

	}

	public ShopCartGoods getItem() {
		return item;
	}

	public void setItem(ShopCartGoods item) {
		this.item = item;
	}
}
