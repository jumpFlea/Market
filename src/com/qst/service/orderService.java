package com.qst.service;

import java.util.ArrayList;import com.qst.model.Goods;
import com.qst.model.Goods_item;
import com.qst.model.OrderGoods;

public interface orderService {
	
	int creatorder(int u_id,long ordernumber);//创建订单
	
	int creatorder_good(long ordernumber,int g_id,float prince, int og_num);//创建order_good表

	//void creatorder_good(Long ordernumber, int g_id, float prince, int og_num);
	ArrayList<Integer> getgid(long ordernumber);
	
	ArrayList<OrderGoods> getorder_goods(long ordernumber);
	
	Goods_item getgoods_item(long ordernumber,int g_id);
	
	float getSumprince(long ordernumber);
}
