package com.qst.action;

import com.qst.serviceImpl.ShopCarService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AddInShopCarAction {
	private final ShopCarService shopCarService;

	@Autowired
	public AddInShopCarAction(ShopCarService shopCarService) {
		this.shopCarService = shopCarService;
	}

	public String addInshopcar() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int uid;
		try {
			uid = (int) session.getAttribute("uid");
		} catch (NullPointerException e) {
			return "login";
		}
		int gid = Integer.parseInt(request.getParameter("goodId"));
		int a = shopCarService.addInshopcar(uid, gid);
		if (a != 0) {
			return "success";
		}
		return "error";
	}

}
