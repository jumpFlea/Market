package com.qst.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.dao.orderDao;
import com.qst.model.Goods_item;
import com.qst.model.OrderGoods;
import com.qst.service.orderService;

@Service
public class orderServiceImpl implements orderService {
	@Autowired
	private orderDao orderDao;

	public orderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(orderDao orderDao) {
		this.orderDao = orderDao;
	}

	public int creatorder(int u_id, long ordernumber) {
		return orderDao.creatorder(u_id, ordernumber);
	}

	public int creatorder_good(long ordernumber, int g_id, float prince, int og_num) {
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

}
