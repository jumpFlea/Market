package com.qst.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.User;
import com.qst.service.UserService;

import sun.print.resources.serviceui;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class UserAction extends ActionSupport {
	@Resource
	private UserService userService;

	private User user;
	private User user1;
	private String loginResult;
	
	
/*	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}*/

	public User getUser1() { 
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	
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

	public void login() {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		String jsonString;
		try {
			out = response.getWriter();
			User u = userService.login(user);
			if (u != null) {
				jsonString = "yes";
			} else {
				jsonString = "no";
			}

		} catch (IOException e) {
			jsonString = "no";
			e.printStackTrace();
		}

		if (out != null) {
			out.println(jsonString);
			out.flush();
			out.close();
		}
	}

	public void signup() {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		String jsonString;
		try {
			out = response.getWriter();
			User u = userService.add(user);
			if (u != null) {
				jsonString = "yes";
			} else {
				jsonString = "no";
			}

		} catch (IOException e) {
			jsonString = "no";
			e.printStackTrace();
		}

		if (out != null) {
			out.println(jsonString);
			out.flush();
			out.close();
		}
	}

	// 根据用户登录时的名字显示个人信息，（此处功能需要待添加判读用户是否登录）
	public String showUserInfor(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User u = userService.ShowUserInfor(user);
		if (u != null) {
			session.setAttribute("u2", u);
			return SUCCESS;
		}
		return ERROR;
	}

	// 个人信息修改，存session会话域是为了后续的修改
	public String updateUserInfor() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username=((User)session.getAttribute("u2")).getUsername();
		int id = userService.findIdByName(username);
		user1.setUid(id);
		int re = userService.updateUserInfor(user1);
		if(re!=0){
			User u = userService.ShowUserInfor(user1);
			session.setAttribute("u2", u);
			return SUCCESS;
		}
		return ERROR;
		
	}

}
