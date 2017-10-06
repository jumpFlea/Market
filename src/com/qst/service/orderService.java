package com.qst.service;

import java.util.ArrayList;

import com.qst.model.Adress;
import com.qst.model.GoodsOrder;
import com.qst.model.Goods_item;
import com.qst.model.OrderGoods;


public interface orderService {
	
	int creatorder(int u_id,long ordernumber);//创建订单
	
	int creatorder_good(long ordernumber,int g_id,float prince, int og_num);//创建order_good表

	ArrayList<Integer> getgid(long ordernumber);
	
	ArrayList<OrderGoods> getorder_goods(long ordernumber);
	
	Goods_item getgoods_item(long ordernumber,int g_id);
	
	float getSumprince(long ordernumber);
	
	int setOrderType( long ordernumber);
	
	ArrayList<Long> getOrdernumByUid(int uid);
	
	ArrayList<Integer> getG_idByOrdernum(long ordernumber); 
	
	ArrayList<Integer> getG_idByUid(int uid);
	
	ArrayList<Long> getOrderNumber(int u_id);
	
	ArrayList<GoodsOrder>  getOrderItemByOrdernumber(long ordernumber);
	
	int delOrderInorder(long ordernumber);
	
	int delOrderInorder_goods(long ordernumber);
	
	Adress getAdressByOrdernumber(long ordernumber);
	
	float getOrderSumPrince(long ordernumber);
	
	int UpdateGoodsRestnum(int g_id);
	
	int setOrderByOrdernumber(int ad_id,String message,long ordernumber);
}
