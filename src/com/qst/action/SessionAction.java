package com.qst.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.qst.serviceImpl.SessionService;
import com.sun.org.apache.regexp.internal.recompile;

@Component
public class SessionAction {
	@Resource
	SessionService sessionService;
	public String setEvalueInSession()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session =request.getSession();
		int uid =(int) session.getAttribute("uid");
		long ordernumber =Long.parseLong(request.getParameter("ordernumber"));
		int g_id = Integer.parseInt(request.getParameter("g_id"));
		String evaluate =(String) request.getParameter("evaluate");
		sessionService.setSession(evaluate,uid,ordernumber);
		int session_id =sessionService.getMaxFromSession();
		sessionService.setGoods_Session(session_id, g_id);
		request.setAttribute("flag", 1);
		request.setAttribute("pay_type", 1);
		return "evaluate";
	}
}
