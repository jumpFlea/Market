package com.qst.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.User;
import com.qst.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
//kaid
public class UserAction extends ActionSupport{
//aeouth1123123212213
	@Resource
	private UserService userService;

	private User user;
	private String loginResult;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public void login(){
		HttpServletResponse response= ServletActionContext.getResponse();
		PrintWriter out = null;
		String jsonString;
		try {
			out = response.getWriter();
			User u=userService.login(user);
			if(u!=null){
				jsonString="yes";
			}
			else {
				jsonString="no";
			}

		} catch (IOException e) {
			jsonString="no";
			e.printStackTrace();
		}

		if (out != null) {
			out.println(jsonString);
			out.flush();
			out.close();
		}
	}

	public void signup(){
		HttpServletResponse response= ServletActionContext.getResponse();
		PrintWriter out = null;
		String jsonString;
		try {
			out = response.getWriter();
			User u=userService.add(user);
			if(u!=null){
				jsonString="yes";
			}
			else {
				jsonString="no";
			}

		} catch (IOException e) {
			jsonString="no";
			e.printStackTrace();
		}

		if (out != null) {
			out.println(jsonString);
			out.flush();
			out.close();
		}
	}

}
