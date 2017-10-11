package com.qst.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.qst.model.GoodsOrder;

public interface GoodsSoldsDao {
	@Select("SELECT DISTINCT a.g_name, a.g_id,a.g_price,a.image_zhanshi,b.message,d.`name`,d.phone,d.region,d.street,b.ordernumber FROM goods AS a,`order` AS b,order_goods AS c ,adress AS d\r\n"
			+ "WHERE a.u_id=#{u_id} AND a.g_id=c.g_id AND b.pay_type=#{pay_type} AND b.ad_id=d.ad_id ORDER BY c.ordernumber LIMIT #{a},#{b}")
	public List<GoodsOrder> getSoldGoodsByU_id(@Param("u_id") int u_id, @Param("pay_type") int pay_type, @Param("a") int a,
			@Param("b") int b);
	
	@Select("SELECT COUNT(*)  FROM  (SELECT DISTINCT a.g_id,a.g_price,a.image_zhanshi,b.message,d.`name`,d.phone,d.region,d.street,b.ordernumber FROM goods AS a,`order` AS b,order_goods AS c ,adress AS d\r\n" + 
			"WHERE a.u_id=#{u_id} AND a.g_id=c.g_id AND b.pay_type=#{pay_type} AND b.ad_id=d.ad_id ORDER BY c.ordernumber ) AS a")
	public int  getCountGoodsOrder(@Param("u_id") int u_id, @Param("pay_type") int pay_type
			);
}
