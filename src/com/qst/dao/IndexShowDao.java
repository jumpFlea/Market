package com.qst.dao;

import java.util.List;

import com.qst.model.Goods;
import com.qst.model.Page;

public interface IndexShowDao {
	public List<Goods> indexShow(Page<Goods> page);
	public int findImageNum();
	public String[] showAllAttri();
}
