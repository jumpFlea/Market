package com.qst.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qst.dao.AddInCarDao;
import com.qst.service.AddIntoCar;
@Service
public class AddIntoCarImpl implements AddIntoCar{
@Resource
AddInCarDao addincardao;
	@Override
	public void  addInshopcar(int u_id, int g_id) {
		addincardao.addintocar(u_id, g_id);
	}

}
