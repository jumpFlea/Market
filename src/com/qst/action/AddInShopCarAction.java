package com.qst.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.service.goodsService;
import com.qst.serviceImpl.AddIntoCarImpl;

@Component
public class AddInShopCarAction {
	@Resource
	private AddIntoCarImpl addIntoCarImpl;
	@Resource
	private goodsService goodsService;

	public goodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(goodsService goodsService) {
		this.goodsService = goodsService;
	}

	public AddIntoCarImpl getAddIntoCarImpl() {
		return addIntoCarImpl;
	}

	public void setAddIntoCarImpl(AddIntoCarImpl addIntoCarImpl) {
		this.addIntoCarImpl = addIntoCarImpl;
	}

	public String addInshopcar() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		int gid = Integer.parseInt(request.getParameter("goodId"));
		int a= addIntoCarImpl.addInshopcar(uid, gid);
		if(a!=0) {
			return "success";
		}
		return "error";
	}

}
