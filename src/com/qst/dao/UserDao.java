package com.qst.dao;

import com.qst.model.User;

public interface UserDao {
	User login(User user);

	void add(User user);

	User findByName(String username);
	
	User findByID(Integer uid);
	
	User showUserInfor(User user);
	
	int findIdByName(String username);
	
	int updateUserInfor(User user1);
}
