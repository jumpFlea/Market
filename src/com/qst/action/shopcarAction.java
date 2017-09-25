package com.qst.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import com.qst.model.Goods;
import com.qst.model.Image;
import com.qst.model.User;
import com.qst.service.UserService;
import com.qst.service.goodsService;
import com.qst.service.orderService;


@Component
public class shopcarAction {
	@Resource
	private goodsService goodsService;
	@Resource
	private orderService orderService;
	@Resource
	private UserService userService;
	
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
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String  setGoodinOrder() {
		SimpleDateFormat dateFormater = new SimpleDateFormat("ddmmyyyyHHmmssSSS");
		Date date=new Date();
		long  ordernumber =Long.parseLong(dateFormater.format(date)) ;	//生成唯一的订单号
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		request.setAttribute("ordernumber", ordernumber);
		int u_id =(int)session.getAttribute("uid");
		String[] price = request.getParameterValues("newslist");
		String[] goodsnum = request.getParameterValues("text_box1");
		String[] gid = request.getParameterValues("gid");
		System.out.println(price.length);
		float Fprice[] = new float[price.length];
		int Fgoodsum[] = new int[goodsnum.length];
		int Fgid[] = new int[gid.length];
		for (int i = 0; i < price.length; i++) {
			Fprice[i]=Float.parseFloat(price[i]);
			Fgoodsum[i]=Integer.parseInt(goodsnum[i]);
			Fgid [i]=Integer.parseInt(gid[i]);
			orderService.creatorder(u_id, ordernumber);
			orderService.creatorder_good(ordernumber,Fgid[i],Fprice[i],Fgoodsum[i]);
		}
		return "order";
	}

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
	
	public String getOrderItem()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session =request.getSession();
		long ordernumber =(long) request.getAttribute("ordernumber");
		int uid=(int) session.getAttribute("uid");
		ArrayList<Integer> arrayList =orderService.getgid(ordernumber);
		ArrayList<Goods> arrayList2 = new ArrayList<Goods>();
		Goods goods;
		Image image;
		ArrayList<Image> imageslist =new ArrayList<Image>();
		for (Integer integer : arrayList) {
			goods=goodsService.getAllgoods(integer);
			arrayList2.add(goods);		
		}
		
		User user =userService.findUserbyID(uid);
		String  address=user.getAdress();
		request.setAttribute("goodlist1", arrayList2);
		request .setAttribute("User", user);
		return "dyj";
	}



}
