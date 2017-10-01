package com.qst.service;

import com.qst.model.Goods;
import com.qst.model.Image;

public interface GoodsDetailService {
	public Goods showGoods(int goodId);
	
	public Image showSmallPic(int gooId);
}
