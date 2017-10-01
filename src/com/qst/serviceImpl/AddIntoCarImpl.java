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
	public int  addInshopcar(int u_id, int g_id) {
		return addincardao.addintocar(u_id, g_id);
	}

}
