package com.qst.serviceImpl;

import com.qst.dao.GoodsDao;
import com.qst.dao.ShopCarDAO1;
import com.qst.model.ShopCartGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tomatofrommars on 10/6/17.
 * Email: tomatofrommars@gmail.com
 */
@Service
public class ShopCarService {
	private final ShopCarDAO1 shopCarDAO1;
	private final GoodsDao goodsDao;

	@Autowired
	public ShopCarService(ShopCarDAO1 shopCarDAO1, GoodsDao goodsDao) {
		this.shopCarDAO1 = shopCarDAO1;
		this.goodsDao = goodsDao;
	}

	public int addToCart(ShopCartGoods shopCartGoods) {
		Integer result = shopCarDAO1.ifExist(shopCartGoods);
		if (result == null) {
			return shopCarDAO1.addToCart(shopCartGoods);
		}
		else {
			shopCartGoods.setSgId(result);
			shopCarDAO1.update(shopCartGoods);
			return 0;
		}
	}

	public ArrayList<HashMap> getGoodsByUserId(int id) {
		ArrayList<HashMap> goodsIds = shopCarDAO1.getGoodsByUserId(id);

		return goodsIds;
	}

	public int deleteShopcarGoodByid(int uid, int gid) {
		return shopCarDAO1.deleteShopcarGoodByid(uid, gid);
	}

	public int getCountByUser(int uid) {
		return shopCarDAO1.getCountByUser(uid);
	}
}
