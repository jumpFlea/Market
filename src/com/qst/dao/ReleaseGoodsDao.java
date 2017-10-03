package com.qst.dao;

import com.qst.model.Goods;
import com.qst.model.UserGoods;

public interface ReleaseGoodsDao {
	
	void releaseGood(Goods goods);
	
	void saveUserGoods(UserGoods userGoods);
}
