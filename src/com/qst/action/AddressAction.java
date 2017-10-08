package com.qst.action;

import com.qst.model.Adress;
import com.qst.serviceImpl.AddressServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AddressAction {
	@Resource
	private AddressServiceImpl addressService;

	public String setAdress() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		String name = request.getParameter("name");
		String phone = request.getParameter("tel");
		String region = request.getParameter("region");
		String street = request.getParameter("street");
		addressService.setAdress(name, phone, region, street);
		int ad_id = addressService.getMaxAd_id();
		int a = addressService.setUs_Ad(uid, ad_id);
		if (a > 0) {
			return "success";
		} else {
			return "error";
		}
	}

	public String editAdress() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String phone = request.getParameter("tel");
		String region = request.getParameter("region");
		String street = request.getParameter("street");
		int adid = Integer.parseInt(request.getParameter("ad_id"));
		System.out.println("-------------->" + phone);
		int a = addressService.editAdress(adid, name, phone, region, street);
		if (a > 0) {
			return "success";
		} else {
			return "error";
		}
	}

	// 得到用户所有的地址
	public String showAllAddress() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		ArrayList<Integer> adid_list = new ArrayList<Integer>();
		Adress adress = new Adress();
		ArrayList<Adress> adress_list = new ArrayList<Adress>();
		adid_list = addressService.getAlladid(uid);
		if (adid_list != null) {
			for (Integer ad_id : adid_list) {
				adress = addressService.getAdress(ad_id);
				adress_list.add(adress);
			}
			request.setAttribute("adress_list", adress_list);
			return "success";
		}else
			return "error";

	}

}
