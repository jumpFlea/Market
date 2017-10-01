package com.qst.service;

import java.util.ArrayList;import com.qst.model.Goods;
import com.qst.model.Goods_item;
import com.qst.model.OrderGoods;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public interface orderService {
	
	int creatorder(int u_id,long ordernumber);//创建订单
	
	int creatorder_good(long ordernumber,int g_id,float prince, int og_num);//创建order_good表

	//void creatorder_good(Long ordernumber, int g_id, float prince, int og_num);
	ArrayList<Integer> getgid(long ordernumber);
	
	ArrayList<OrderGoods> getorder_goods(long ordernumber);
	
	Goods_item getgoods_item(long ordernumber,int g_id);
	
	float getSumprince(long ordernumber);
	
	int setOrderType( long ordernumber);
	
	ArrayList<Long> getOrdernumByUid(int uid);
	
	ArrayList<Integer> getG_idByOrdernum(long ordernumber); 
	
	ArrayList<Integer> getG_idByUid(int uid);
	
}
