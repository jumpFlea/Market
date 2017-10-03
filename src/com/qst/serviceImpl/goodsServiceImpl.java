package com.qst.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.dao.goodsDao;
import com.qst.model.Goods;
import com.qst.model.Image;
import com.qst.service.goodsService;

@Service
public class goodsServiceImpl implements goodsService {
	@Autowired
	private goodsDao goodsDao;

	public int setInShopcar(int g_id, int u_id) {
		return goodsDao.setInShopcar(g_id, u_id);
	}

	public ArrayList<Integer> get_gid(int u_id) {
		return goodsDao.get_gid(u_id);
	}

	public Goods getAllgoods(int g_id) {
		return goodsDao.getAllgoods(g_id);

	}

	public ArrayList<String> getImageUrl(int image_id) {
		return goodsDao.getImageUrl(image_id);
	}

	public Image getImage(long goodsnumber) {
		return goodsDao.getImage(goodsnumber);
	}

	public int deleteShopcarGoodByid(int uid, int gid) {
		return goodsDao.deleteShopcarGoodByid(uid, gid);
	}
}
