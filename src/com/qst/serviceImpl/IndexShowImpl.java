package com.qst.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.IndexShowDao;
import com.qst.model.Image;
import com.qst.service.IndexShowService;

@Service
public class IndexShowImpl implements IndexShowService{
	
	@Resource
	private IndexShowDao indexDao;
	@Override
	public List<Image> indexShow(int page) {
		// TODO Auto-generated method stub
		return indexDao.indexShow(page);
	}
	
	@Override
	public int findImageNum() {
		// TODO Auto-generated method stub
		return indexDao.findImageNum();
	}

}
