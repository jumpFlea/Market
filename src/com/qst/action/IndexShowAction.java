package com.qst.action;
import java.util.HashSet;
import java.util.Set;

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
	private String attribute;
	/*int sum =0;*/

//	HttpServletRequest request = ServletActionContext.getRequest();


	
	public String indexShow(){
		HttpServletRequest request = ServletActionContext.getRequest();
		attribute =(String)request.getAttribute("type");
		Page<Goods> pageImage =indexShowService.indexShow(page,attribute);
		if(pageImage!=null){
			
			request.setAttribute("pImageList",pageImage);	
		    //实例化一个set集合
	        Set<String> attriSet = new HashSet<String>();
	        //遍历数组并存入集合,如果元素已存在则不会重复存入,把分类的属性找出来
	        for (int i=0;i<pageImage.getList().size();i++) {
	        	attriSet.add(pageImage.getList().get(i).getG_attribute());
	        }
	        request.setAttribute("attriSet",attriSet);	      
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
	
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
