package com.qst.service;

import java.util.List;

import com.qst.model.Image;

public interface IndexShowService {
	public List<Image> indexShow(int currentPage);
	public int findImageNum();
}
