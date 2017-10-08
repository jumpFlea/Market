package com.qst.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

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
}
