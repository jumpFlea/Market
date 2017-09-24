package com.qst.serviceImpl;

import com.qst.dao.UserDao;
import com.qst.model.User;
import com.qst.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {

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

}
