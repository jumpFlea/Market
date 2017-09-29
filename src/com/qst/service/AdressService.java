package com.qst.service;

import java.util.ArrayList;

import com.qst.model.Adress;

public interface AdressService {
	 ArrayList<Integer> getAlladid(int u_id);
	 Adress getAdress(int ad_id);
}
