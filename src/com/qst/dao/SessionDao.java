package com.qst.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qst.model.Goods_Session;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

@Component
public interface SessionDao {
	/*
	 * 插入一条session的评价
	 */
	@Insert("INSERT INTO `session`  SET evaluate=#{evaluate},u_id =#{u_id},ordernumber=#{ordernumber} ")
	public int setSession(@Param("evaluate")String evaluate ,@Param("u_id") int u_id ,@Param("ordernumber") long ordernumber);
	/*
	 * 得到session的最大值id
	 */
	@Select("SELECT MAX(session_id) FROM `session`")
	public int getMaxFromSession();
	/*
	 *
	 * 插入一条数据到goods_sessio中
	 */
	@Insert("INSERT INTO goods_session (session_id,g_id) VALUES (#{session_id},#{g_id});  ")
	public int setGoods_Session(@Param("session_id")int session_id,@Param("g_id")int g_id);
	
	/*
	 * 通过用户id找到 用户所有卖出去的商品  （还未 回复）
	 */
	@Select("SELECT a.g_id,b.evaluate,a.g_name,a.g_price,a.image_zhanshi,a.market_price ,b.session_data,b.u_id,d.username FROM  goods AS a ,`session` AS b , goods_session AS c , usertable AS d WHERE a.u_id=#{u_id} AND\r\n" + 
			"c.session_id=b.session_id AND c.g_id=a.g_id AND b.reply IS NULL AND d.uid=b.u_id")
	public Goods_Session getGoodsSession(@Param("u_id")int u_id);
	
	
	
}
