package com.qst.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.Goods;
import com.qst.service.ReleaseGoodsService;

import jdk.management.cmm.SystemResourcePressureMXBean;

@Component
public class ReleaseGoodsAction extends ActionSupport {

	@Resource
	private ReleaseGoodsService rgs;
	private Goods goods;
	private File upload;
	private String uploadFileName;







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

	public String releaseGoods() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = (int)request.getSession().getAttribute("uid");
		goods.setU_id(id);
		String savePath = ServletActionContext.getServletContext().getRealPath("/images/upload");
		//随机产生一个文件名
		String fileName= UUID.randomUUID().toString() + "_" + uploadFileName;
		File file = new File(savePath+fileName);
		try {
			FileUtils.copyFile(upload,file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goods.setImage_zhanshi("images"+File.separator+"upload"+fileName);
		rgs.releaseGoods(goods);
	/*	System.out.println("sadasdsad"+goods.getG_id());*/
		//System.out.println("asdfasdfads:"+i);
		/*if (i != 0) {
			return SUCCESS;
		} else
			return ERROR;*/
		return "success";
	}

	public ReleaseGoodsService getRgs() {
		return rgs;
	}

	public void setRgs(ReleaseGoodsService rgs) {
		this.rgs = rgs;
	}

}
