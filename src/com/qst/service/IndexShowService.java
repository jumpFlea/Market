package com.qst.service;

import com.qst.model.Image;
import com.qst.model.Page;

public interface IndexShowService {
	public Page<Image> indexShow(int currentPage);
	public int findImageNum();
}
