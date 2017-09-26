package com.qst.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.GoodsDetailDao;
import com.qst.model.Goods;
import com.qst.service.GoodsDetailService;

@Service
public class GoodsDetailImpl implements GoodsDetailService {
	@Resource
	private GoodsDetailDao gdd;
	@Override
	public Goods showGoods(int goodId) {
		// TODO Auto-generated method stub
		return gdd.showGoods(goodId);
	}

}
