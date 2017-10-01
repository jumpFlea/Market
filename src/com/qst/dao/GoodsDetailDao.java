package com.qst.dao;

import com.qst.model.Goods;
import com.qst.model.Image;

public interface GoodsDetailDao {
	public Goods showGoods(int goodId);
	
	public Image showSmallPic(int goodId);
}
