package com.qst.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.dao.GoodsDao;
import com.qst.dao.UserGoodsDAO;
import com.qst.model.Goods;
import com.qst.model.GoodsSession;
import com.qst.model.Page;
import com.qst.model.User;
import com.qst.model.UserGoods;

/**
 * Created by tomatofrommars on 10/6/17.
 * Email: tomatofrommars@gmail.com
 */
@Service
public class GoodsService {
	private final GoodsDao goodsDao;
	private final UserGoodsDAO userGoodsDAO;
	
	@Autowired
	public GoodsService(GoodsDao goodsDao, UserGoodsDAO userGoodsDAO) {
		this.goodsDao = goodsDao;
		this.userGoodsDAO = userGoodsDAO;
	}

	public Goods showGoods(int goodId) {

		return goodsDao.showGoods(goodId);
	}

	public void releaseGoods(Goods goods) {
//		System.out.print(goods);
		goodsDao.releaseGood(goods);
	}

	public void saveUserGoods(UserGoods userGoods) {
		userGoodsDAO.saveUserGoods(userGoods);
	}


	public Goods getAllgoods(int g_id) {
		return goodsDao.getGoods(g_id);

	}


	public Page<Goods> indexShow(int currentPage, String type,String gname) {
		Page<Goods> p = new Page<Goods>();
		// 将当前的页面设置到page中
		p.setCurrentPage(currentPage);
		// 设置每页显示的条数
		int limit = 20;
		p.setLimitPage(limit);
		// 获取当前的总记录数，并设置到page里面对应的属性,设置总页数
		int count = goodsDao.findImageNum(type,gname);
		if (count%limit == 0) {
			count = count / limit;
			p.setCountPage(count);
		} else {
			count = (count / limit) + 1;
			p.setCountPage(count);
		}
		// 设置开始显示记录的第一条的值
		int begin = (currentPage - 1) * limit;
		p.setBegin(begin);
		p.setAttribute(type);
		p.setGname(gname);
		// 获取图片的信息，存于page中
		List<Goods> imageList = new ArrayList<Goods>();
		imageList = goodsDao.indexShow(p);
		p.setList(imageList);
		return p;
	}
	
	//查看本用户的发布商品的信息
	public Page<Goods> showReleaseGoods(int currentPage,int u_id){
		Page<Goods> show = new Page<Goods>();
		// 将当前的页面设置到page中
		show.setCurrentPage(currentPage);
		// 设置每页显示的条数
		int limit=4;
		show.setLimitPage(limit);
		// 获取当前的总记录数，并设置到page里面对应的属性,设置总页数
		int count = goodsDao.findReleaseGoodsNum(u_id);
		if (count%limit == 0) {
			count = count / limit;
			show.setCountPage(count);
		} else {
			count = (count / limit) + 1;
			show.setCountPage(count);
		}
		// 设置开始显示记录的第一条的值
		int begin = (currentPage - 1) * limit;
		show.setBegin(begin);
		show.setId(u_id);
		// 获取图片的信息，存于page中
		List<Goods> imageList = new ArrayList<Goods>();
		imageList = goodsDao.releaseGoods(show);
		show.setList(imageList);
		return show;
	}

	//根据类型找到数量
	public int findImageNum(String type,String gname) {
		return goodsDao.findImageNum(type,gname);
	}

	public String[] showAllAttri() {
		return goodsDao.showAllAttri();
	}
	
	//找到此商品的评价
	public List<GoodsSession> showEvaluate(int goodId){
		return goodsDao.showEvaluate(goodId);
	}
	
	public List<User> showUserInfo(int goodId){
		return goodsDao.showUserInfo(goodId);
	}
	
	//用户删除指定发布的商品信息
	public int deleteReleaseGood(int g_id){
			return goodsDao.deleteReleaseGood(g_id);
	}
	
	//用户更新指定发布的商品信息
		public int upadateReleaseGoods(Goods goods){
				return goodsDao.upadateReleaseGoods(goods);
		}
		
	
}
