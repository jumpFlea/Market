package com.qst.dao;

import java.util.ArrayList;

import com.qst.model.Adress;

public interface AdressDao {
	
	public ArrayList<Integer> getAlladid(int u_id);

	public Adress getAdress(int ad_id);
	
}
