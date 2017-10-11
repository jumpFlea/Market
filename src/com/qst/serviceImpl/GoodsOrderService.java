package com.qst.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.GoodsDao;
import com.qst.dao.GoodsOrderDao;
import com.qst.model.Goods;
import com.qst.model.GoodsOrder;
import com.qst.model.Page;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

@Service
public class GoodsOrderService {
	@Resource
	GoodsOrderDao goodsOrderDao;
	
	public List<GoodsOrder> getGoodOrderByu_id(int u_id,int pay_type,int a,int b) {
		return goodsOrderDao.getGoodOrderByu_id(u_id, pay_type, a, b);
	}
	
	public List<GoodsOrder> getEvaluteGoods(int u_id,int pay_type,int a,int b){
		return goodsOrderDao.getCompleted_EvaluationOrder(u_id, pay_type, a, b);
	}
	
	public int getCountFromGoodOrderByu_id(int u_id,int pay_type ) {
		return goodsOrderDao.getCountFromGoodOrderByu_id(u_id, pay_type);
	}
	public int getCountCompleted_EvaluationOrder(int u_id,int pay_type) {
		return goodsOrderDao.getCountCompleted_EvaluationOrder(u_id, pay_type);
	}
}
