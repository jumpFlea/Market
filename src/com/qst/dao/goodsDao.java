package com.qst.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.qst.model.Goods;
import com.qst.model.Image;
import com.qst.model.OrderGoods;

public interface goodsDao {

	 int setInShopcar(int g_id,int u_id);		//将商品设置进入购物车
	
	 ArrayList<Integer> get_gid(int u_id);		//通过用户id得到他购物车中商品的所有id
	
	 Goods getAllgoods(int g_id);				//
	
	 ArrayList<String> getImageUrl(int image_id);			
	 
	 Image getImage(long goodsnumber);
	 
	 @Delete("DELETE  FROM shopcar_goods WHERE u_id=#{uid} and g_id=#{gid} ")
	 int deleteShopcarGoodByid(@Param("uid") int uid,@Param("gid") int gid);//在购物车中删除某一个商品
	 
}
