package com.qst.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.SessionDao;
import com.qst.model.Goods_Session;

@Service
public class SessionService {
	@Resource
	SessionDao sessionDao;
	public int setSession(String evaluate,int uid,long ordernumber) {
		return sessionDao.setSession(evaluate, uid, ordernumber);
	}
	
	public int getMaxFromSession(){
		return sessionDao.getMaxFromSession();
	}
	
	public int setGoods_Session(int session_id,int g_id){
		return sessionDao.setGoods_Session(session_id, g_id);
	}
	
	public Goods_Session goodsSold(int u_id) {
		return sessionDao.getGoodsSession(u_id);
	}
}
