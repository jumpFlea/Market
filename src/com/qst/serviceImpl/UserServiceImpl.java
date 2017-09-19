package com.qst.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.UserDao;
import com.qst.model.User;
import com.qst.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao dao;
	
	//ÓÃ»§µÇÂ¼
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return dao.login(user);
	}

}
