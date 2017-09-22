package com.qst.dao;

import java.util.ArrayList;

import com.qst.model.Goods;

public interface goodsDao {

	 int setInShopcar(int g_id,int u_id);
	
	 ArrayList<Integer> get_gid(int u_id);
	
	 Goods getAllgoods(int g_id);
	
	 ArrayList<String> getImageUrl(int image_id);
	 
	 
}
