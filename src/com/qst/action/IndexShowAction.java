package com.qst.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.Goods;
import com.qst.model.Page;
import com.qst.serviceImpl.GoodsService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexShowAction extends ActionSupport {

	@Autowired
	
	private GoodsService goodsService;
	private String attribute;
	private String gname;
	int page = 1;
	/*int sum =0;*/

//	HttpServletRequest request = ServletActionContext.getRequest();


	public String indexShow() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取前台界面传过来的类型
		attribute = (String) request.getParameter("type");
		Page<Goods> pageImage = goodsService.indexShow(page, attribute,gname);
		//从数据库中查询所有的类型出来
		String attri[] = goodsService.showAllAttri();
		if (pageImage != null) {
			request.setAttribute("pImageList", pageImage);
			request.setAttribute("attri", attri);
			//类型不为空值，设置到前台页面,便于类型下面分页的寻找
			if(attribute!=null){
				request.setAttribute("type", attribute);
			}
			return SUCCESS;
		} else
			return ERROR;
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
	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}
}
