package com.qst.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.SessionDao;

@Service
public class SessionService {
	@Resource
	SessionDao sessionDao;
	public int setSession(String evaluate) {
		return sessionDao.setSession(evaluate);
	}
	
	public int getMaxFromSession(){
		return sessionDao.getMaxFromSession();
	}
	
	public int setGoods_Session(int session_id,int g_id){
		return sessionDao.setGoods_Session(session_id, g_id);
	}
}