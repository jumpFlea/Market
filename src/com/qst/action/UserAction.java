package com.qst.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.User;
import com.qst.service.UserService;

@Component
public class UserAction extends ActionSupport{
	
	@Resource
	private UserService userService;
	
	private User user;

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

	
	
	public String login(){
		System.out.println(user.getUsername());
		User u=userService.login(user);
		System.out.println(u);
		if(u!=null){
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	
}
