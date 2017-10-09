package com.qst.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qst.model.Adress;
import org.springframework.stereotype.Component;

@Component
public interface AddressDao {

	ArrayList<Integer> getAlladid(int u_id);

	Adress getAdress(int ad_id);

	@Insert("insert into adress (name,phone,region,street) values(#{name},#{phone},#{region},#{street})")
	void setAdress(@Param("name") String name, @Param("phone") String phone, @Param("region") String region,
			@Param("street") String street);

	int updateAdress(String name, String phone, String region, String street);

	@Select("SELECT MAX(ad_id) FROM adress")
	int getMaxadid();

	@Insert("INSERT INTO us_ad (ad_id,u_id) VALUES(#{ad_id},#{u_id})")
	int setUs_Ad(@Param("ad_id") int ad_id, @Param("u_id") int u_id);

	@Update("update adress set name=#{name},phone=#{phone},region=#{region},street=#{street} where ad_id=#{ad_id};")
	int editAdress(@Param("ad_id") int ad_id, @Param("name") String name, @Param("phone") String phone,
			@Param("region") String region, @Param("street") String street);
	
	
	@Delete("DELETE FROM adress where ad_id=#{ad_id};")
	int deleteAddress(@Param("ad_id") int ad_id);
}
