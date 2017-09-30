package com.qst.action;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.service.AdressService;

import net.sf.json.JSONObject;


@Component
public class AdressAction {

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
		String jsonString=request.getParameter("e");  
		System.out.println(jsonString);
	}


	
}
