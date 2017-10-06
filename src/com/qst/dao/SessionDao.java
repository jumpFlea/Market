package com.qst.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SessionDao {
	/*
	 * 插入一条session的评价
	 */
	@Insert("INSERT INTO `session`  SET evaluate=#{evaluate} ")
	public int setSession(@Param("evaluate")String evaluate  );
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
	public int setGoods_Session(int session_id,int g_id);
}
