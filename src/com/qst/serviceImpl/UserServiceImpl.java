package com.qst.serviceImpl;

import com.qst.dao.*;
import com.qst.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Consumer;

@Service
public class UserServiceImpl{

	private final UserDao dao;
	private final orderDao orderDao1;
	private final GoodsOrderDao goodsOrderDao;
	private final UserGoodsDAO userGoodsDAO;
	private final SessionDao sessionDao;

	@Autowired
	public UserServiceImpl(UserDao dao, orderDao orderDao1, GoodsOrderDao goodsOrderDao, UserGoodsDAO userGoodsDAO, SessionDao sessionDao) {
		this.dao = dao;
		this.orderDao1 = orderDao1;
		this.goodsOrderDao = goodsOrderDao;
		this.userGoodsDAO = userGoodsDAO;
		this.sessionDao = sessionDao;
	}


	//用户登录

	public User login(User user) {
		return dao.login(user);
	}


	public User add(User user) {
		User exist = dao.findByName(user.getUsername());
		if( exist == null ){
			user.setState_type(0);
			user.setIntegral(0);
			user.setAuthority(0);
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

	public boolean validate(String username) {
		if (dao.findByName(username) == null){
			return true;
		}
		else {
			return false;
		}
	}

	public ArrayList<HashMap> manageUser() {
		ArrayList<HashMap> memberList = dao.manageUser();

		ArrayList<HashMap> orderCount = orderDao1.countByUser();
		ArrayList<HashMap> broughtCount = goodsOrderDao.countByUser();
		ArrayList<HashMap> releaseCount = userGoodsDAO.countByUser();
		ArrayList<HashMap> sessionCount = sessionDao.countByUser();

		memberList.forEach(new Consumer<HashMap>() {
			@Override
			public void accept(HashMap hashMap) {
				Integer id = (Integer) hashMap.get("id");

				orderCount.forEach(new Consumer<HashMap>() {
					@Override
					public void accept(HashMap hashMap1) {
						if(Objects.equals(id, (Integer) hashMap1.get("id"))){
							hashMap.put("orderCount",hashMap1.get("n"));
						}
					}
				});

				broughtCount.forEach(new Consumer<HashMap>() {
					@Override
					public void accept(HashMap hashMap1) {
						if(Objects.equals(id, (Integer) hashMap1.get("id"))){
							hashMap.put("broughtCount",hashMap1.get("n"));
						}
					}
				});

				releaseCount.forEach(new Consumer<HashMap>() {
					@Override
					public void accept(HashMap hashMap1) {
						if(Objects.equals(id, (Integer) hashMap1.get("id"))){
							hashMap.put("releaseCount",hashMap1.get("n"));
						}
					}
				});

				sessionCount.forEach(new Consumer<HashMap>() {
					@Override
					public void accept(HashMap hashMap1) {
						if(Objects.equals(id, (Integer) hashMap1.get("id"))){
							hashMap.put("sessionCount",hashMap1.get("n"));
						}
					}
				});
			}
		});
		return memberList;
	}

	public void enableAuthority(Integer uid) {
		dao.enableAuthority(uid);
	}
	public void disableAuthority(Integer uid) {
		dao.disableAuthority(uid);
	}

	public void enableUser(Integer uid) {
		dao.enableUser(uid);
	}
	public void disableUser(Integer uid) {
		dao.disableUser(uid);
	}

	public void deleteUser(Integer uid) {
		dao.deleteUser(uid);
	}
}
