package com.qst.service;

import com.qst.model.Goods;
import com.qst.model.Page;

public interface IndexShowService {
	public Page<Goods> indexShow(int currentPage,String type);
	public int findImageNum();
	public String[] showAllAttri();
}
