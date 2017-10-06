package com.qst.serviceImpl;

import com.qst.dao.ShopCarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by tomatofrommars on 10/6/17.
 * Email: tomatofrommars@gmail.com
 */
@Service
public class ShopCarService {
	@Autowired
	private ShopCarDAO shopCarDAO;

	public int setInShopcar(int g_id, int u_id) {
		return shopCarDAO.setInShopcar(g_id, u_id);
	}

	public ArrayList<Integer> get_gid(int u_id) {
		return shopCarDAO.get_gid(u_id);
	}

	public int deleteShopcarGoodByid(int uid, int gid) {
		return shopCarDAO.deleteShopcarGoodByid(uid, gid);
	}

	public int  addInshopcar(int u_id, int g_id) {
		return shopCarDAO.addintocar(u_id, g_id);
	}
}
