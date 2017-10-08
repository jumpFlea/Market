package com.qst.serviceImpl;

import com.qst.dao.ShopCarDAO1;
import com.qst.dao.UserDao;
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
	private final UserDao userDao;

	@Autowired
	public ShopCarService(ShopCarDAO1 shopCarDAO1, UserDao userDao) {
		this.shopCarDAO1 = shopCarDAO1;
		this.userDao = userDao;
	}

	public int addToCart(ShopCartGoods shopCartGoods) {
		Integer result = shopCarDAO1.ifExist(shopCartGoods);
		if (result == null) {
			return shopCarDAO1.addToCart(shopCartGoods);
		}
		else {
			shopCartGoods.setId(result);
			shopCarDAO1.update(shopCartGoods);
			return 0;
		}
	}

	public ArrayList<HashMap> getGoodsByUserId(int id) {
		ArrayList<HashMap> goodsIds = shopCarDAO1.getGoodsByUserId(id);

		return goodsIds;
	}

	public int removeCartGoods(ShopCartGoods item) {
		return shopCarDAO1.deleteShopcarGoodByid(item.getUid(), item.getGid());
	}

	public int getCountByUser(int uid) {
		return shopCarDAO1.getCountByUser(uid);
	}

	public void addFavorite(ShopCartGoods item) {
		userDao.addFavorite(item);
	}
}
