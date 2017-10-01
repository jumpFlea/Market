package com.qst.dao;

import com.qst.model.Goods_item;
import com.qst.model.OrderGoods;

import jdk.nashorn.internal.objects.annotations.Where;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface orderDao {

	public int creatorder(@Param("u_id") int u_id, @Param("ordernumber") long ordernumber);

	public int creatorder_good(  @Param("ordernumber")long ordernumber, @Param("g_id")int g_id,@Param("prince") float prince, @Param("og_num")int og_num);

	public ArrayList<Integer> getgid(long getOrderItem);

	public ArrayList<OrderGoods> getorder_goods(long ordernumber);

	public Goods_item getgoods_item(@Param("ordernumber")long ordernumber, @Param("g_id")int g_id);

	public float getSumprince(long ordernumber);
	
	@Update("update `order` set pay_type=1 where ordernumber=#{ordernumber}")
	public int setOrderType(@Param("ordernumber")long ordernumber);//设置订单状态为1 ：提交未支付状态
	
	@Select("SELECT ordernumber FROM `order` where u_id=#{uid} GROUP BY ordernumber")
	public ArrayList<Long> getOrdernumByUid(@Param("uid")int uid);		//通过uid找到属于uid的所有订单号

	@Select("SELECT g_id FROM order_goods WHERE ordernumber=#{ordernumber}")
	public ArrayList<Integer> getG_idByOrdernum(@Param("ordernumber") long ordernumber );//通过ordernumber找到对应的所有gid
}
