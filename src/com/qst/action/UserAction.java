package com.qst.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.User;
import com.qst.serviceImpl.UserServiceImpl;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Controller
public class UserAction extends ActionSupport {
	private final UserServiceImpl userService;

	private User user;
	private User user1;
	private String loginResult;



	//变量名字固定写法
	private File upload;
	private String uploadFileName;

	@Autowired
	public UserAction(UserServiceImpl userService) {
		this.userService = userService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public void login() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter out = null;
		String jsonString;
		try {
			out = response.getWriter();
			User u = userService.login(user);
			if (u != null) {
				jsonString = "yes";
				session.setAttribute("user", u);
				int uid = userService.findIdByName(u.getUsername());
				session.setAttribute("uid", uid);
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

	public String validateUsername(){
		if(user == null || user.getUsername() == null){
			return "index";
		}
		else {
			if (userService.validate(user.getUsername())) {
				return "success";
			}
			else {
				return "index";
			}
		}
	}

	// 根据用户登录时的名字显示个人信息，（此处功能需要待添加判读用户是否登录）
	public String showUserInfor() {
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
	public String updateUserInfor() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username = ((User) session.getAttribute("u2")).getUsername();
		if (upload != null) {
			String savePath = ServletActionContext.getServletContext().getRealPath("/images/upload");
			//随机产生一个文件名
			String fileName = UUID.randomUUID().toString() + "_" + uploadFileName;
			File file = new File(savePath + fileName);
			FileUtils.copyFile(upload, file);
			user1.setU_image("images" + File.separator + "upload" + fileName);
		}
		int re = userService.updateUserInfor(user1);
		if (re != 0) {
			User u = userService.ShowUserInfor(user1);
			session.setAttribute("u2", u);
			return SUCCESS;
		}
		return ERROR;

	}

}
