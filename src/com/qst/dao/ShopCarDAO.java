package com.qst.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by tomatofrommars on 10/6/17.
 * Email: tomatofrommars@gmail.com
 */
public interface ShopCarDAO {
	int addintocar(int u_id,int g_id);

	int setInShopcar(int g_id,int u_id);		//将商品设置进入购物车

	ArrayList<Integer> get_gid(int u_id);		//通过用户id得到他购物车中商品的所有id

	@Delete("DELETE  FROM shopcar_goods WHERE u_id=#{uid} and g_id=#{gid} ")
	int deleteShopcarGoodByid(@Param("uid") int uid,@Param("gid") int gid);//在购物车中删除某一个商品
}
