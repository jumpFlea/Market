package com.qst.dao;

import com.qst.model.ShopCartGoods;
import com.qst.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

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


    void removeFavorite(ShopCartGoods item);

    ArrayList<HashMap> findMyFavorite(Integer id);

    ArrayList<HashMap> manageUser();

	void enableAuthority(Integer uid);

	void disableAuthority(Integer uid);

	void enableUser(Integer uid);

	void disableUser(Integer uid);

	void deleteUser(Integer uid);
}
