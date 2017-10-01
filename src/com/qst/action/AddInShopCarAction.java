package com.qst.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.serviceImpl.AddIntoCarImpl;

@Component
public class AddInShopCarAction {
	@Resource
	private AddIntoCarImpl addIntoCarImpl;

	public AddIntoCarImpl getAddIntoCarImpl() {
		return addIntoCarImpl;
	}

	public void setAddIntoCarImpl(AddIntoCarImpl addIntoCarImpl) {
		this.addIntoCarImpl = addIntoCarImpl;
	}

	public void addInshopcar() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		int gid = Integer.parseInt(request.getParameter("gid"));
		addIntoCarImpl.addInshopcar(uid, gid);
	}

}
