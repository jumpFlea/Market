package com.qst.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.qst.dao.ReleaseGoodsDao;
import com.qst.model.Goods;
import com.qst.model.UserGoods;
import com.qst.service.ReleaseGoodsService;

@Service
public class ReleaseGoodsImpl implements ReleaseGoodsService{

	@Resource
	public ReleaseGoodsDao rgDao;
	
	@Override
	public void releaseGoods(Goods goods) {
		// TODO Auto-generated method stub
//		System.out.print(goods);
		 rgDao.releaseGood(goods);
	}

	@Override
	public void saveUserGoods(UserGoods userGoods) {
		// TODO Auto-generated method stub
		 rgDao.saveUserGoods(userGoods);
	}

}
