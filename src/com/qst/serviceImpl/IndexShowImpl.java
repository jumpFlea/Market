package com.qst.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.IndexShowDao;
import com.qst.model.Image;
import com.qst.model.Page;
import com.qst.service.IndexShowService;

@Service
public class IndexShowImpl implements IndexShowService{
	
	@Resource
	private IndexShowDao indexDao;
	@Override
	public List<Image> indexShow(int currentPage) {
		
		// TODO Auto-generated method stub
		Page p = new Page();
		//将当前的页面设置到page中
		int page = currentPage;
		p.setCurrentPage(page);
		//设置每页显示的条数
		int limit = 20;
		p.setLimitPage(limit);
		//获取当前的总记录数，并设置到page里面对应的属性
		int count= indexDao.findImageNum();
		p.setSumNumPage(count);
		if(count%limit==0){
			
		}
		return indexDao.indexShow(p);
	}
	
	@Override
	public int findImageNum() {
		// TODO Auto-generated method stub
		return indexDao.findImageNum();
	}



}
