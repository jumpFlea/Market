package com.qst.dao;

import java.util.List;

import com.qst.model.Goods;
import com.qst.model.Image;
import com.qst.model.Page;

public interface IndexShowDao {
	public List<Goods> indexShow(Page<Image> page);
	public int findImageNum();
}
