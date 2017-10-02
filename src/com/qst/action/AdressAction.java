package com.qst.action;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.service.AdressService;

import net.sf.json.JSONObject;


@Component
public class AdressAction {
@Resource
	private AdressService adressService;

	public AdressService getAdressService() {
		return adressService;
	}

	public void setAdressService(AdressService adressService) {
		this.adressService = adressService;
	}
	
	public void setAdress()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		int uid=(int)session.getAttribute("uid");		
		String name =request.getParameter("name");
		String phone =request.getParameter("tel"); 	
		String region=request.getParameter("region");
		String street =request.getParameter("street");
		adressService.setAdress(name, phone, region, street);
		int ad_id=adressService.getMaxAd_id();
		int a =adressService.setUs_Ad(uid, ad_id);
		if (a>0) {
			
		}
	}
	
	public String  editAdress()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		String name=request.getParameter("name");
		String phone=request.getParameter("tel");
		String region=request.getParameter("region");
		String street=request.getParameter("street");
		int adid=Integer.parseInt( request.getParameter("ad_id"));
		System.out.println("-------------->"+phone);
		int a=adressService.editAdress(adid, name, phone, region, street);
		if(a>0)
		{
			return "success";
		}else {
			return "error";
		}
	}


	
}
