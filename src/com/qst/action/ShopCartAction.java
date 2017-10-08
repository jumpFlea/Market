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

	private Integer goodsId;
	private Integer uid;
	private Integer goodsNum;
	private Double goodsPrice;

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
		session.setAttribute("goodsList", goodsList);
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
		String login="login.html";
		if (uid == null){
			return "login";
		}
		else if(goodsId == null){
			return "index";
		}
		else {
			ShopCartGoods shopCartGood = new ShopCartGoods();
			shopCartGood.setuId(uid);
			shopCartGood.setgId( goodsId );
			shopCartGood.setGoods_number(goodsNum);
			shopCartGood.setPrice(goodsPrice);
			shopCarService.addToCart(shopCartGood);
			return "success";
		}
	}

	/*
	 * 删除购物车里的某一个商品
	 */
	public String delGoodsShopCart() {
		if (uid == null){
			return "login";
		}
		else if(goodsId == null) {
			return "index";
		}
		else {
			shopCarService.deleteShopcarGoodByid(uid, goodsId);
			return "del";
		}
	}

	public void cartCount(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter out = null;
		int uid = ((User) session.getAttribute("user")).getUid();
		int jsonString;
		try {
			out = response.getWriter();
			jsonString = shopCarService.getCountByUser(uid);
		} catch (IOException e) {
			jsonString = -1;
			e.printStackTrace();
		}

		if (out != null) {
			out.println(jsonString);
			out.flush();
			out.close();
		}
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
}
