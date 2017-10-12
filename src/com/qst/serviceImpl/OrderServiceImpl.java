package com.qst.serviceImpl;

import com.qst.dao.GoodsOrderDao;
import com.qst.dao.ShopCarDAO1;
import com.qst.dao.orderDao;
import com.qst.model.Adress;
import com.qst.model.GoodsOrder;
import com.qst.model.Goods_item;
import com.qst.model.OrderGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Consumer;

@Service
public class OrderServiceImpl{
	private final orderDao orderDao;
	private final ShopCarDAO1 shopCarDAO1;
	private final GoodsOrderDao goodsOrderDao;

	@Autowired
	public OrderServiceImpl(orderDao orderDao, ShopCarDAO1 shopCarDAO1, GoodsOrderDao goodsOrderDao) {
		this.orderDao = orderDao;
		this.shopCarDAO1 = shopCarDAO1;
		this.goodsOrderDao = goodsOrderDao;
	}

	public int creatorder(int u_id, long ordernumber) {
		return orderDao.creatorder(u_id, ordernumber);
	}

	public int addGoodsToOrder(long ordernumber, Integer g_id, Float prince, Integer og_num) {
		return orderDao.creatorder_good(ordernumber, g_id, prince, og_num);
	}

	public ArrayList<Integer> getgid(long ordernumber) {
		return orderDao.getgid(ordernumber);
	}

	public ArrayList<OrderGoods> getorder_goods(long ordernumber) {
		return orderDao.getorder_goods(ordernumber);
	}

	public Goods_item getgoods_item(long ordernumber, int g_id) {
		return orderDao.getgoods_item(ordernumber, g_id);
	}

	public float getSumprince(long ordernumber) {
		return orderDao.getSumprince(ordernumber);
	}

	public int setOrderType(long ordernumber) {

		return orderDao.setOrderType(ordernumber);
	}

	public ArrayList<Long> getOrdernumByUid(int uid) {
		return orderDao.getOrdernumByUid(uid);
	}

	public ArrayList<Integer> getG_idByOrdernum(long ordernumber) {
		return orderDao.getG_idByOrdernum(ordernumber);
	}


	public ArrayList<Integer> getG_idByUid(int uid) {
		return orderDao.getG_idByUid(uid);
	}

	public ArrayList<Long> getOrderNumber(int u_id,int a,int b) {
		return orderDao.getOrderNumber(u_id, a, b);
	}
	
	public int getCountOrdernumber(int u_id) {
		return orderDao.getCountOrdernumber(u_id);
	}


	public ArrayList<GoodsOrder> getOrderItemByOrdernumber(long ordernumber) {
		return orderDao.getOrderItemByOrdernumber(ordernumber);
	}

	public int delOrderInorder(long ordernumber) {
			return orderDao.delOrderInorder(ordernumber);
	}

	public Adress getAdressByOrdernumber(long ordernumber) {
		return orderDao.getAdressByOrdernumber(ordernumber);
	}


	public float getOrderSumPrince(long ordernumber) {
		return orderDao.getOrderSumPrince(ordernumber);
	}

	public int UpdateGoodsRestnum(int g_id) {
		return orderDao.UpdateGoodsRestnum(g_id);
	}

	public int setOrderByOrdernumber(int ad_id, String message, long ordernumber) {
		return orderDao.setOrderByOrdernumber(ad_id, message, ordernumber);
	}

	public long createOrder(Integer[] gid, Integer[] number, Float[] price, Integer uid,double count,int addressId) throws Exception{
		SimpleDateFormat dateFormater = new SimpleDateFormat("ddmmyyyyHHmmssSSS");
		long id = Long.parseLong(dateFormater.format(new Date()));

		orderDao.createOrder(uid, id, count, addressId);
		for (int i = 0;i < gid.length;i++) {
			addGoodsToOrder(id,gid[i],price[i],number[i]);
			shopCarDAO1.deleteShopcarGoodByid(uid,gid[i]);
		}
		return id;
	}

	public ArrayList<HashMap> getOrderByUser(int uid) throws Exception{
		ArrayList<HashMap> orders = orderDao.getOrderByUser(uid);
		orders.forEach(new Consumer<HashMap>() {
			@Override
			public void accept(HashMap hashMap) {
				ArrayList<HashMap> goodsList = goodsOrderDao.getGoodsByOrder((Long) hashMap.get("id"));
				hashMap.put("goodsList",goodsList);
			}
		});
		return orders;
	}
}
