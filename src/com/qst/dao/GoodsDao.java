package com.qst.dao;

import com.qst.model.Goods;
import com.qst.model.Page;

import java.util.List;

public interface GoodsDao {

	Goods getAllgoods(int g_id);

	void releaseGood(Goods goods);

	Goods showGoods(int goodId);

	public List<Goods> indexShow(Page<Goods> page);
	public int findImageNum();
	public String[] showAllAttri();
}
