package com.qst.service;

import com.qst.model.User;

public interface UserService {
	User login(User user);

	User add(User user);
	
	User findUserbyID(int uid);
}
