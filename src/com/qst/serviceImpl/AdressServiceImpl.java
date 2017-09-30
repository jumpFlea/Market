package com.qst.serviceImpl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.qst.dao.AdressDao;
import com.qst.model.Adress;
import com.qst.service.AdressService;

@Component
public class AdressServiceImpl implements AdressService {
	@Resource
	AdressDao adressDao;

	public ArrayList<Integer> getAlladid(int u_id) {

		return adressDao.getAlladid(u_id);
	}

	public Adress getAdress(int ad_id) {
		return adressDao.getAdress(ad_id);
	}

	public int setAdress(String name, String phone, String region, String street) {
		return adressDao.setAdress(name, phone, region, street);
	}

	public int updateAdress(String name, String phone, String region, String street) {
		return adressDao.updateAdress(name, phone, region, street);

	}
}
