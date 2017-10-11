package com.qst.serviceImpl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.qst.dao.GoodsSoldsDao;
import com.qst.model.GoodsOrder;

@Service
public class GoodsSoldsService {
	@Resource
	GoodsSoldsDao goodsSoldsDao;

	public List<GoodsOrder> getSoldGoodsByU_id(int u_id, int pay_type, int a, int b) {
		return goodsSoldsDao.getSoldGoodsByU_id(u_id, pay_type, a, b);
	}
	
	public int getCountGoodsOrder(int u_id, int pay_type, int a, int b) {
		return goodsSoldsDao.getCountGoodsOrder(u_id, pay_type);
	}
}
