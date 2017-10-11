package com.qst.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.qst.dao.GoodsSoldsDao;
import com.qst.model.GoodsOrder;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

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
	
	public int SetOrderType(int pay_type,long ordernumber) {
		return goodsSoldsDao.SetOrderType(pay_type, ordernumber);
	}
	
	public ArrayList<Long> getOrdernumber(int u_id,int pay_type,int a,int b){
		return goodsSoldsDao.getOrdernumber(u_id, pay_type,a,b);
	}
	
	public int getCountOrdernumber(int u_id,int pay_type) {
		return goodsSoldsDao.getCountOrdernumber(u_id, pay_type);
	}
	
	public  List<GoodsOrder> getGoodsOrder(long ordernumber){
		return goodsSoldsDao.getGoodsOrder(ordernumber);
	}

}
