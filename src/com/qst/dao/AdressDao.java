package com.qst.dao;

import java.util.ArrayList;

import com.qst.model.Adress;

public interface AdressDao {

	ArrayList<Integer> getAlladid(int u_id);

	Adress getAdress(int ad_id);

	int setAdress(String name, String phone, String region, String street);

	int updateAdress(String name, String phone, String region, String street);

}
