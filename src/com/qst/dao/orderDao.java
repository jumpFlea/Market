package com.qst.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface orderDao {
	
	public int  creatorder(@Param("u_id") int u_id,@Param("ordernumber") long ordernumber);
	
	public int creatorder_good(@Param("ordernumber") long ordernumber,@Param("g_id") int g_id,@Param("prince") float prince, @Param("og_num") int og_num);
	
	public ArrayList<Integer> getgid(long getOrderItem);

}
