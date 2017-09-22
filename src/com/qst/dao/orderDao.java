package com.qst.dao;

import org.apache.ibatis.annotations.Param;

public interface orderDao {
	
	public int  creatorder(@Param("u_id") int u_id,@Param("ordernumber") long ordernumber);
	
	public int creatorder_good(@Param("ordernumber") long ordernumber,@Param("g_id") int g_id,@Param("prince") float prince, @Param("og_num") int og_num);
	
	public int getoid(int u_id);//通過用戶id得到訂單id
	

}
