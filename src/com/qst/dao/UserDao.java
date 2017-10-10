package com.qst.dao;

import com.qst.model.ShopCartGoods;
import com.qst.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
	User login(User user);

	void add(User user);

	User findByName(String username);

	User findByID(Integer uid);

	User showUserInfor(User user);

	int findIdByName(String username);

	int updateUserInfor(User user1);

    void addFavorite(ShopCartGoods item);
    
    
}
