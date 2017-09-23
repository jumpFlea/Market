package com.qst.action;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.Image;
import com.qst.service.IndexShowService;

@Component
public class IndexShowAction extends ActionSupport{
	
	@Resource
	private IndexShowService indexShowService;
	int page=1;
	int sum =0;
	
//	HttpServletRequest request = ServletActionContext.getRequest();
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String indexShow(){
		List<Image> image =indexShowService.indexShow(page);
		sum=indexShowService.findImageNum();
		if(image!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("imageList",image);
			request.setAttribute("sumNum",sum);
			return SUCCESS;
		}else
			return ERROR;		
	}
	
/*	//得到图片总的数目，方便显示几页
	public String sumNum(){
		sum=indexShowService.findImageNum();
		if(sum!=0){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("sum",sum);
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}*/
	

	public IndexShowService getIndexShowService() {
		return indexShowService;
	}

	public void setIndexShowService(IndexShowService indexShowService) {
		this.indexShowService = indexShowService;
	}
}
