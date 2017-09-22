package com.qst.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Component;

import com.qst.model.Goods;
import com.qst.service.goodsService;
import com.qst.service.orderService;
import com.qst.serviceImpl.goodsServiceImpl;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import sun.text.resources.cldr.om.FormatData_om;
import sun.util.logging.resources.logging;

@Component
public class shopcarAction {
	@Resource
	private goodsService goodsService;
	@Resource
	private orderService orderService;

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

	public void setGoodinOrder() {
		SimpleDateFormat dateFormater = new SimpleDateFormat("ddmmyyyyHHmmssSSS");
		Date date=new Date();
		long  ordernumber =Long.parseLong(dateFormater.format(date)) ;	//生成唯一的订单号
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
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
	//	System.out.println(arrayList2.size());
		session.setAttribute("goodlist", arrayList2);
		return "diao";
	}

}
