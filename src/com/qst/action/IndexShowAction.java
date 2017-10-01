package com.qst.action;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.Goods;
import com.qst.model.Page;
import com.qst.service.IndexShowService;

@Component
public class IndexShowAction extends ActionSupport{

	@Resource
	private IndexShowService indexShowService;
	int page=1;
	/*int sum =0;*/

//	HttpServletRequest request = ServletActionContext.getRequest();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public String indexShow(){
		System.out.println(page);
		Page<Goods> pageImage =indexShowService.indexShow(page);
		if(pageImage!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("pImageList",pageImage);
			/*request.setAttribute("sumNum",sum);*/
			return SUCCESS;
		}else
			return ERROR;
	}




	public IndexShowService getIndexShowService() {
		return indexShowService;
	}

	public void setIndexShowService(IndexShowService indexShowService) {
		this.indexShowService = indexShowService;
	}
}
