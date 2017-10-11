package com.qst.dao;

import com.qst.model.Goods;
import com.qst.model.GoodsSession;
import com.qst.model.Page;
import com.qst.model.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface GoodsDao {

	Goods getGoods(int g_id);

	void releaseGood(Goods goods);

	Goods showGoods(int goodId);

	public List<Goods> indexShow(Page<Goods> page);
	
	public List<Goods> releaseGoods(Page<Goods> page);

	public int findImageNum(@Param("type") String type,@Param("gname")String gname);
	
	public int findReleaseGoodsNum(@Param("id") int id);

	public String[] showAllAttri();
	
	public List<GoodsSession> showEvaluate(int goodId);
	
	public List<User> showUserInfo(int goodId);
	
	public int deleteReleaseGood(@Param("goodId") int goodId);
	
	public int upadateReleaseGoods(Goods goods);
	
}
