package com.qst.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.dao.orderDao;
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

	public int creatorder_good(long ordernumber,int g_id,float prince, int og_num) {
		return orderDao.creatorder_good(ordernumber,g_id,prince,og_num);
	}

	public ArrayList<Integer> getgid(long ordernumber) {
		
		return orderDao.getgid(ordernumber);
	}




}
