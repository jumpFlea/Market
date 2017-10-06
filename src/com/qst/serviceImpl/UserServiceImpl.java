package com.qst.serviceImpl;

import com.qst.dao.UserDao;
import com.qst.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl{

	@Resource
	private UserDao dao;

	//用户登录

	public User login(User user) {

		return dao.login(user);
	}


	public User add(User user) {
		User exist = dao.findByName(user.getUsername());
		if( exist == null ){
			user.setState_type(0);
			user.setIntegral(0);
			dao.add(user);
			return dao.findByName(user.getUsername());
		}
		else {
			return null;
		}
	}


	public User findUserbyID(int uid) {

		return dao.findByID(uid);
	}

	public User ShowUserInfor(User user) {
		return dao.showUserInfor(user);
	}

	public int updateUserInfor(User user1) {
		return dao.updateUserInfor(user1);
	}

	public int findIdByName(String name) {
		return dao.findIdByName(name);
	}

}
