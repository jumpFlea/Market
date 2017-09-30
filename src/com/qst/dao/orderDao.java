package com.qst.dao;

import com.qst.model.Goods_item;
import com.qst.model.OrderGoods;

import java.util.ArrayList;

public interface orderDao {

	public int creatorder(int u_id, long ordernumber);

	public int creatorder_good(long ordernumber, int g_id,float prince, int og_num);

	public ArrayList<Integer> getgid(long getOrderItem);

	public ArrayList<OrderGoods> getorder_goods(long ordernumber);

	public Goods_item getgoods_item(long ordernumber,int g_id);

	public float getSumprince(long ordernumber);

}
