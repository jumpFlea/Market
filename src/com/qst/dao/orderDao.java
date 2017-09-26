package com.qst.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.qst.model.Goods_item;
import com.qst.model.OrderGoods;

public interface orderDao {

	public int creatorder(@Param("u_id") int u_id, @Param("ordernumber") long ordernumber);

	public int creatorder_good(@Param("ordernumber") long ordernumber, @Param("g_id") int g_id,
			@Param("prince") float prince, @Param("og_num") int og_num);

	public ArrayList<Integer> getgid(long getOrderItem);

	public ArrayList<OrderGoods> getorder_goods(long ordernumber);

	public Goods_item getgoods_item(@Param("ordernumber") long ordernumber, @Param("g_id") int g_id);

	public float getSumprince(long ordernumber);

}
