package com.qst.service;

import java.util.ArrayList;
import java.util.List;

import com.qst.model.Goods;

public interface goodsService {
	int setInShopcar(int g_id, int u_id);

	ArrayList<Integer> get_gid(int u_id);

	Goods getAllgoods(int g_id);

	ArrayList<String> getImageUrl(int image_id);
}
