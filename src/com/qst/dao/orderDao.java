package com.qst.dao;

import com.qst.model.Adress;
import com.qst.model.GoodsOrder;
import com.qst.model.Goods_item;
import com.qst.model.OrderGoods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public interface orderDao {

	int creatorder(@Param("u_id") int u_id, @Param("ordernumber") long ordernumber);

	int creatorder_good(@Param("ordernumber") long ordernumber, @Param("g_id") int g_id,
			@Param("prince") float prince, @Param("og_num") int og_num);

	ArrayList<Integer> getgid(long getOrderItem);

	ArrayList<OrderGoods> getorder_goods(long ordernumber);

	Goods_item getgoods_item(@Param("ordernumber") long ordernumber, @Param("g_id") int g_id);

	float getSumprince(long ordernumber);

	/*
	 * 设置订单状态为1 ：提交未支付状态
	 */
	@Update("update `order` set pay_type=1 where ordernumber=#{ordernumber}")
	public int setOrderType(@Param("ordernumber") long ordernumber);// 设置订单状态为1 ：已经支付状态

	@Select("SELECT ordernumber FROM `order` where u_id=#{uid} GROUP BY ordernumber")
	public ArrayList<Long> getOrdernumByUid(@Param("uid") int uid); // 通过uid找到属于uid的所有订单号

	@Select("SELECT g_id FROM order_goods WHERE ordernumber=#{ordernumber}")
	public ArrayList<Integer> getG_idByOrdernum(@Param("ordernumber") long ordernumber);// 通过ordernumber找到对应的所有gid

	/*
	 * 通过uid找到用户所有的订单的商品id;
	 */
	@Select("SELECT  b.g_id FROM  `order` AS a,order_goods AS b WHERE a.u_id=#{uid} AND a.ordernumber=b.ordernumber AND pay_type=0")
	public ArrayList<Integer> getG_idByUid(@Param("uid") int uid);

	/*
	 * 通过uid找到所有的订单号(未支付订单)
	 */
	@Select("SELECT  DISTINCT b.ordernumber FROM  `order` AS a,order_goods AS b WHERE a.u_id=#{u_id} AND a.ordernumber=b.ordernumber AND pay_type=0 LIMIT #{a},#{b}")
	public ArrayList<Long> getOrderNumber(@Param("u_id") int u_id,@Param("a")int a,@Param("b")int b);
	
	/*
	 * 通过uid找到所有的订单号(未支付订单)  縂數量
	 */
	@Select("SELECT COUNT(*) FROM (SELECT  DISTINCT b.ordernumber FROM  `order` AS a,order_goods AS b WHERE a.u_id=#{u_id} AND a.ordernumber=b.ordernumber AND pay_type=0 ) AS c")
	public int getCountOrdernumber(@Param("u_id") int u_id);
	

	/*
	 * 通过订单号 找到每个订单的所有商品
	 */
	@Select("SELECT a.g_name,a.g_price,b.ordernumber FROM goods AS a,order_goods AS b WHERE ordernumber=#{ordernumber} AND a.g_id=b.g_id")
	public ArrayList<GoodsOrder> getOrderItemByOrdernumber(@Param("ordernumber") long ordernumber);
	
	
	/*
	 * 定位 order_goods表 删除订单
	 */
	@Delete("DELETE FROM order_goods  WHERE ordernumber=#{ordernumber} ")
	public int delOrderInorder_goods(@Param("ordernumber") long ordernumber);

	/*
	 * 定位 order表 删除订单
	 */
	@Delete("DELETE FROM `order`  WHERE ordernumber=#{ordernumber}")
	public int delOrderInorder(@Param("ordernumber") long ordernumber);

	/*
	 * 通过订单号 找到未完成订单的地址
	 */
	@Select(" SELECT * FROM adress AS a WHERE a.ad_id=(SELECT DISTINCT  a.ad_id  FROM `order` AS a,order_goods AS b  WHERE a.ordernumber=b.ordernumber AND a.ordernumber=#{ordernumber})")
	public Adress getAdressByOrdernumber(@Param("ordernumber") long ordernumber);

	/*
	 * 通过订单号  找到订单里面商品的总价值
	 */
	@Select("SELECT SUM(a.g_price) FROM goods AS a,order_goods AS b WHERE ordernumber=#{ordernumber} AND a.g_id=b.g_id")
	 public float getOrderSumPrince(@Param("ordernumber")long ordernumber);
	/*
	 * 更改订单的数量  点击一次 数量减一
	 */

	@Update("UPDATE goods SET restnum=restnum-1 WHERE g_id=#{g_id}")
	public int UpdateGoodsRestnum(int g_id);

	/*
	 * 将用户订单的 用户所选择的地址 和 留言 写入数据库 通过订单号 和地址id
	 */
	@Update("UPDATE `order` SET ad_id=#{ad_id},message=#{message} WHERE ordernumber=#{ordernumber}")
	public int setOrderByOrdernumber(@Param("ad_id")int ad_id,@Param("message")String message,@Param("ordernumber") long ordernumber);


    void createOrder(Integer uid, long id, double count, int addressId);

    ArrayList<HashMap> getOrderByUser(int uid);

	ArrayList<HashMap> countByUser();
}
