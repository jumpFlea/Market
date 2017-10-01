package com.qst.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.GoodsDetailDao;
import com.qst.model.Goods;
import com.qst.model.Image;
import com.qst.service.GoodsDetailService;

@Service
public class GoodsDetailImpl implements GoodsDetailService {
	@Resource
	private GoodsDetailDao gdd;
	@Override
	public Goods showGoods(int goodId) {
	
		return gdd.showGoods(goodId);
	}
	
	@Override
	public Image showSmallPic(int gooId) {
		// TODO Auto-generated method stub
		return gdd.showSmallPic(gooId);
	}

}
