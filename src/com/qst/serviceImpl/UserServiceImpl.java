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
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return dao.login(user);
	}

	@Override
	public User add(User user) {
		User exist = dao.findByName(user.getUsername());
		if( exist == null ){
			user.setStateType(0);
			user.setIntegral(0);
			dao.add(user);
			return dao.findByName(user.getUsername());
		}
		else {
			return null;
		}
	}

}
