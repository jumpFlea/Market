package com.qst.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.Goods;
import com.qst.model.UserGoods;
import com.qst.serviceImpl.GoodsService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class ReleaseGoodsAction extends ActionSupport {

	@Autowired
	private GoodsService rgs;
	private Goods goods;
	private File upload;
	private String uploadFileName;
	private UserGoods userGoods;


	public String releaseGoods() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		System.out.println(date);
		int uid = (int) request.getSession().getAttribute("uid");
		goods.setU_id(uid);
		String savePath = "C:\\Users\\Administrator\\Desktop\\ourImage\\";
		//随机产生一个文件名
		String fileName = UUID.randomUUID().toString() + "_" + uploadFileName;
		File file = new File(savePath + fileName);
		try {
			FileUtils.copyFile(upload, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		goods.setImage_zhanshi(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
		rgs.releaseGoods(goods);
		userGoods = new UserGoods();
		userGoods.setUserId(uid);
		userGoods.setGoodsId(goods.getG_id());
		userGoods.setDate(date);
		rgs.saveUserGoods(userGoods);

	/*	System.out.println("sadasdsad"+goods.getG_id());*/
		//System.out.println("asdfasdfads:"+i);
		/*if (i != 0) {
			return SUCCESS;
		} else
			return ERROR;*/
		return "success";
	}

	public UserGoods getUserGoods() {
		return userGoods;
	}

	public void setUserGoods(UserGoods userGoods) {
		this.userGoods = userGoods;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
