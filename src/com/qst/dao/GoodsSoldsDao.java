package com.qst.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qst.model.GoodsOrder;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import sun.util.logging.resources.logging;

public interface GoodsSoldsDao {
	@Select("SELECT DISTINCT a.g_name, a.g_id,a.g_price,a.image_zhanshi,b.message,d.`name`,d.phone,d.region,d.street,b.ordernumber FROM goods AS a,`order` AS b,order_goods AS c ,adress AS d\r\n"
			+ "WHERE a.u_id=#{u_id} AND a.g_id=c.g_id AND b.pay_type=#{pay_type} AND b.ad_id=d.ad_id ORDER BY c.ordernumber LIMIT #{a},#{b}")
	public List<GoodsOrder> getSoldGoodsByU_id(@Param("u_id") int u_id, @Param("pay_type") int pay_type,
			@Param("a") int a, @Param("b") int b);

	@Select("SELECT COUNT(*)  FROM  (SELECT DISTINCT a.g_id,a.g_price,a.image_zhanshi,b.message,d.`name`,d.phone,d.region,d.street,b.ordernumber FROM goods AS a,`order` AS b,order_goods AS c ,adress AS d\r\n"
			+ "WHERE a.u_id=#{u_id} AND a.g_id=c.g_id AND b.pay_type=#{pay_type} AND b.ad_id=d.ad_id ORDER BY c.ordernumber ) AS a")
	public int getCountGoodsOrder(@Param("u_id") int u_id, @Param("pay_type") int pay_type);

	@Update("UPDATE `order` SET pay_type =#{pay_type} WHERE ordernumber=#{ordernumber}")
	public int SetOrderType(@Param("pay_type") int pay_type, @Param("ordernumber") long ordernumber);

	/*
	 * 得到 此用户卖出的所有订单
	 */
	@Select("SELECT DISTINCT a.ordernumber FROM order_goods AS a,goods AS b,`order` AS c WHERE a.g_id=b.g_id AND b.u_id=#{u_id} AND c.ordernumber=a.ordernumber AND c.pay_type=#{pay_type} LIMIT #{a},#{b}")
	public ArrayList<Long> getOrdernumber(@Param("u_id") int u_id, @Param("pay_type") int pay_type, @Param("a") int a,
			@Param("b") int b);

	/*
	 * 得到 此用户 卖出订单的总数
	 */
	@Select("SELECT COUNT(*) FROM   (SELECT DISTINCT a.ordernumber FROM order_goods AS a,goods AS b,`order` AS c WHERE a.g_id=b.g_id AND b.u_id=2 AND c.ordernumber=a.ordernumber AND c.pay_type=1) AS c\r\n"
			+ "")
	public int getCountOrdernumber(@Param("u_id") int u_id, @Param("pay_type") int pay_type);

	/*
	 * 得到 此用户 卖出的 某个订单的所有商品
	 */
	@Select("SELECT DISTINCT * FROM goods AS a,order_goods AS c WHERE c.ordernumber=#{ordernumber} AND a.g_id=c.g_id  ")
	public List<GoodsOrder> getGoodsOrder(@Param("ordernumber") long ordernumber);
		
	
}
