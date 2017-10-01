package com.qst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class AddInShopCarAction {
	
	public void  addInshopcar(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request =ServletActionContext.getRequest();
		HttpSession session =request.getSession();
		int uid =(int)session.getAttribute("uid");
		
	}
	
}
