package com.qst.service;

import java.util.ArrayList;

import com.qst.model.Adress;

public interface AdressService {
	 ArrayList<Integer> getAlladid(int u_id);
	 Adress getAdress(int ad_id);
	 void setAdress(String name,String phone,String region,String street);
	 int updateAdress(String name,String phone,String region,String street);
	 int getMaxAd_id();
	 int setUs_Ad(int uid,int adid);
	 int editAdress(int ad_id,String name,String phone,String region,String street);
}
