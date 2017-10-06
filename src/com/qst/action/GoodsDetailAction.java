package com.qst.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.Goods;
import com.qst.model.Image;
import com.qst.serviceImpl.GoodsService;
import com.qst.serviceImpl.ImageService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GoodsDetailAction extends ActionSupport {

	final private GoodsService goodsService;
	final private ImageService imageService;
	// 得到index中传来的goodId的值
	int goodId;

	@Autowired
	public GoodsDetailAction(GoodsService goodsService, ImageService imageDAO) {
		this.goodsService = goodsService;
		this.imageService = imageDAO;
	}


	public String showGoods() {
		Goods good = new Goods();
		Image image = new Image();
		/*System.out.println(goodId);*/
		//此方法显示商品详情界面的大图
		good = goodsService.showGoods(goodId);
		//此方法用用来查询相关联的imgae表的小图片
		image = imageService.showSmallPic(goodId);
		if (good != null && image != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("good", good);
			request.setAttribute("image", image);
			return SUCCESS;
		} else
			return ERROR;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

}
