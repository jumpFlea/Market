package com.qst.service;

import com.qst.model.Goods;
import com.qst.model.Page;
import com.qst.model.UserGoods;

public interface ReleaseGoodsService {
	
	public void  releaseGoods(Goods goods);
	
	public void saveUserGoods(UserGoods userGoods);
}
