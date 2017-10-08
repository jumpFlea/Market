package com.qst.dao;

import com.qst.model.ShopCartGoods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tomatofrommars on 10/6/17.
 * Email: tomatofrommars@gmail.com
 */
@Component
public interface ShopCarDAO1 {
	int addToCart(ShopCartGoods shopCartGoods);		//将商品设置进入购物车

	ArrayList<HashMap> getGoodsByUserId(int id);	//通过用户id得到他购物车中商品的所有id

	@Delete("DELETE  FROM shopcar_goods WHERE u_id=#{uid} and g_id=#{gid} ")
	int deleteShopcarGoodByid(@Param("uid") int uid,@Param("gid") int gid);//在购物车中删除某一个商品

	Integer ifExist(ShopCartGoods shopCartGoods);

	void update(ShopCartGoods shopCartGoods);

    int getCountByUser(int uid);
}
