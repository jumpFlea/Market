package com.qst.dao;

import com.qst.model.Goods;
import com.qst.model.GoodsOrder;
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
	/*
	 * 通过uid找到用户所有的订单的商品id;
	 */
	@Select("SELECT  b.g_id FROM  `order` AS a,order_goods AS b WHERE a.u_id=#{uid} AND a.ordernumber=b.ordernumber AND pay_type=0")
	public ArrayList<Integer> getG_idByUid(@Param("uid") int uid);
	
	/*
	 * 通过uid找到所有的订单号
	 */
	@Select("SELECT  DISTINCT b.ordernumber FROM  `order` AS a,order_goods AS b WHERE a.u_id=#{u_id} AND a.ordernumber=b.ordernumber AND pay_type=0")
	public ArrayList<Long> getOrderNumber(@Param("u_id")int u_id);
	
	/*
	 * 通过订单号 找到每个订单的所有商品
	 */
	@Select("SELECT a.g_name,a.g_price,b.ordernumber FROM goods AS a,order_goods AS b WHERE ordernumber=#{ordernumber} AND a.g_id=b.g_id")
	public ArrayList<GoodsOrder> getOrderItemByOrdernumber(@Param("ordernumber")long ordernumber);
	
}
