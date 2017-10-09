package com.qst.dao;

import com.qst.model.GoodsOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface GoodsOrderDao {
	/*
	 * 通过uid type 查找订单中的 还未评价的 商品和订单号
	 *
	 * 进行分页操作 传入的是uid和order的属性 0：未完成订单，1：已经完成订单
	 */

	@Select("SELECT DISTINCT c.g_id,c.g_name,c.g_price,b.ordernumber FROM `order` AS a ,order_goods AS b,goods AS c WHERE a.u_id=#{u_id} AND a.pay_type=#{pay_type} AND c.g_id=b.g_id AND c.g_id NOT IN(SELECT DISTINCT b.g_id FROM `session` AS a,goods_session AS b WHERE a.u_id=#{u_id} AND b.session_id=a.session_id ORDER BY b.g_id) ORDER BY c.g_id")
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
	
	/*
	 * 查找未评价订单商品的  数量
	 */
	
	@Select("SELECT COUNT(*) FROM(	SELECT DISTINCT  c.g_id,c.g_name,c.g_price,b.ordernumber FROM `order` AS a,order_goods AS b,goods AS c,`session` AS d,goods_session AS e WHERE a.ordernumber=b.ordernumber AND b.g_id=c.g_id AND a.u_id=#{u_id} AND a.pay_type=#{pay_type} AND c.g_id NOT IN(SELECT DISTINCT c.g_id FROM `order` AS a,order_goods AS b,goods AS c,`session` AS d,goods_session AS e WHERE a.ordernumber=b.ordernumber AND b.g_id=c.g_id AND a.u_id=#{u_id} AND a.pay_type=#{pay_type} AND c.g_id=e.g_id   )   ORDER BY a.ad_id ) AS h")
	public int getCountFromGoodOrderByu_id(@Param("u_id") int u_id, @Param("pay_type") int pay_type);
	
	/*
	 * 查找已评价订单的商品 数量
	 */
	
	@Select("SELECT COUNT(*) FROM( SELECT DISTINCT c.g_id,c.g_name,c.g_price FROM `order` AS a,order_goods AS b,goods AS c,`session` AS d,goods_session AS e WHERE a.ordernumber=b.ordernumber AND b.g_id=c.g_id AND a.u_id=#{u_id} AND a.pay_type=#{pay_type}   ORDER BY a.ad_id) AS H ")
	public int getCountCompleted_EvaluationOrder(@Param("u_id") int u_id, @Param("pay_type") int pay_type);
}
