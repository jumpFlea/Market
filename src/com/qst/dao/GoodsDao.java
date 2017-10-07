package com.qst.dao;

import com.qst.model.Goods;
import com.qst.model.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface GoodsDao {

	Goods getGoods(int g_id);

	void releaseGood(Goods goods);

	Goods showGoods(int goodId);

	public List<Goods> indexShow(Page<Goods> page);

	public int findImageNum(@Param("type") String type);

	public String[] showAllAttri();
}
