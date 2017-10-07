package com.qst.action;

import com.qst.model.ShopCartGoods;
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
		ShopCartGoods shopCartGood = new ShopCartGoods();
		try {
			shopCartGood.setuId( (int) session.getAttribute("uid"));
		} catch (NullPointerException e) {
			return "login";
		}
		shopCartGood.setgId( Integer.parseInt(request.getParameter("goodId")) );
		int a = shopCarService.addToCart(shopCartGood);

		return "success";
	}

}
