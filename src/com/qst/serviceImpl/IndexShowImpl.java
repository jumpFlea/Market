package com.qst.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.IndexShowDao;
import com.qst.model.Image;
import com.qst.model.Page;
import com.qst.service.IndexShowService;

@Service
public class IndexShowImpl implements IndexShowService {

	@Resource
	private IndexShowDao indexDao;

	@Override
	public Page<Image> indexShow(int currentPage) {

		// TODO Auto-generated method stub
		Page<Image> p = new Page<Image>();
		// 将当前的页面设置到page中
		int page = currentPage;
		p.setCurrentPage(page);
		// 设置每页显示的条数
		int limit = 20;
		p.setLimitPage(limit);
		// 获取当前的总记录数，并设置到page里面对应的属性,总页数
		int count = indexDao.findImageNum();
		/*System.out.println(count);*/
		if (count%limit == 0) {
			count = count / limit;
			p.setCountPage(count);
		} else {
			count = (count / limit) + 1;
			/*System.out.println(count);*/
			p.setCountPage(count);
		}

		// 设置开始显示记录的第一条的值
		int begin = (page - 1) * limit;
		p.setBegin(begin);

		// 获取图片的信息，存于page中
		List<Image> imageList = new ArrayList<Image>();
		imageList = indexDao.indexShow(p);
		p.setList(imageList);
		return p;
	}

	@Override
	public int findImageNum() {
		// TODO Auto-generated method stub
		return indexDao.findImageNum();
	}

}
