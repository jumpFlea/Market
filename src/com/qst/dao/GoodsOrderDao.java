package com.qst.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.qst.model.GoodsOrder;

public interface GoodsOrderDao {
	/*
	 * 通过uid type 查找订单中的 还未评价的 商品和订单号
	 * 
	 * 进行分页操作 传入的是uid和order的属性 0：未完成订单，1：已经完成订单
	 */

	@Select("SELECT DISTINCT c.g_id,c.g_name,c.g_price,b.ordernumber FROM `order` AS a,order_goods AS b,goods AS c,`session` AS d,goods_session AS e WHERE a.ordernumber=b.ordernumber AND b.g_id=c.g_id AND a.u_id=#{u_id} AND a.pay_type=#{pay_type} AND c.g_id NOT IN(SELECT DISTINCT c.g_id FROM `order` AS a,order_goods AS b,goods AS c,`session` AS d,goods_session AS e WHERE a.ordernumber=b.ordernumber AND b.g_id=c.g_id AND a.u_id=#{u_id} AND a.pay_type=#{pay_type} AND c.g_id=e.g_id   )   ORDER BY a.ad_id LIMIT #{a},#{b}")
	public ArrayList<GoodsOrder> getGoodOrderByu_id(@Param("u_id") int u_id, @Param("pay_type") int pay_type,
			@Param("a") int a, @Param("b") int b);
	
	/*
	 * 通过uid type 查找订单中的 还已经评价的的 商品和订单号
	 * 
	 * 进行分页操作 传入的是uid和order的属性 0：未完成订单，1：已经完成订单
	 */
	@Select("SELECT DISTINCT c.g_id,c.g_name,c.g_price FROM `order` AS a,order_goods AS b,goods AS c,`session` AS d,goods_session AS e WHERE a.ordernumber=b.ordernumber AND b.g_id=c.g_id AND a.u_id=#{u_id} AND a.pay_type=#{pay_type}   ORDER BY a.ad_id LIMIT #{a},#{b}")
	public  ArrayList<GoodsOrder> getCompleted_EvaluationOrder(@Param("u_id") int u_id, @Param("pay_type") int pay_type,
			@Param("a") int a, @Param("b") int b);
}