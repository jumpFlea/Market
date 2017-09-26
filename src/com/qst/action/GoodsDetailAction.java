package com.qst.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.Goods;
import com.qst.service.GoodsDetailService;

@Component
public class GoodsDetailAction extends ActionSupport {

	@Resource
	GoodsDetailService gds;
	// 得到index中传来的goodId的值

	int goodId;

	
	public String showGoods() {
		Goods good = new Goods();
		/*System.out.println(goodId);*/
		good = gds.showGoods(goodId);
		if (good != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("good", good);
			return SUCCESS;
		}else
			return ERROR;
	}
	
	
	public GoodsDetailService getGds() {
		return gds;
	}

	public void setGds(GoodsDetailService gds) {
		this.gds = gds;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

}
