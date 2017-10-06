package com.qst.serviceImpl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.GoodsOrderDao;
import com.qst.model.GoodsOrder;

@Service
public class GoodsOrderService {
	@Resource
	GoodsOrderDao goodsOrderDao;
	
	public ArrayList<GoodsOrder> getGoodOrderByu_id(int u_id,int pay_type,int a,int b) {
		return goodsOrderDao.getGoodOrderByu_id(u_id, pay_type, a, b);
	}
}
