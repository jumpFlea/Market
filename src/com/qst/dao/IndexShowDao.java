package com.qst.dao;

import java.util.List;

import com.qst.model.Image;

public interface IndexShowDao {
	public List<Image> indexShow(int page);
	public int findImageNum();
}
