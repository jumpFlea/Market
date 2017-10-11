package com.qst.serviceImpl;

import com.qst.dao.AddressDao;
import com.qst.model.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AddressServiceImpl {
	final
	AddressDao addressDao;

	@Autowired
	public AddressServiceImpl(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public ArrayList<Integer> getAlladid(int u_id) {

		return addressDao.getAlladid(u_id);
	}

	public Adress getAdress(int ad_id) {

		return addressDao.getAdress(ad_id);
	}

	public void setAdress(String name, String phone, String region, String street) {
		addressDao.setAdress(name, phone, region, street);
	}

	public int updateAdress(String name, String phone, String region, String street) {
		return addressDao.updateAdress(name, phone, region, street);

	}

	public int getMaxAd_id() {
		return addressDao.getMaxadid();
	}

	public int setUs_Ad(int uid, int adid) {
		return addressDao.setUs_Ad(adid, uid);
	}

	public int editAdress(int ad_id, String name, String phone, String region, String street) {
		return addressDao.editAdress(ad_id, name, phone, region, street);
	}

	public int deleteAddress(int ad_id){
		return addressDao.deleteAddress(ad_id);
	}


	public Adress getDefaultAddress(int id) {
		return addressDao.findDefaultAddress(id);
	}

	public ArrayList<HashMap> getAllAddressByUser(int id) {
		return addressDao.findAllAddressByUser(id);
	}
}
