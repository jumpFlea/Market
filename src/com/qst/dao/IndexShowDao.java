package com.qst.dao;

import java.util.List;

import com.qst.model.Image;
import com.qst.model.Page;

public interface IndexShowDao {
	public List<Image> indexShow(Page page);
	public int findImageNum();
}
