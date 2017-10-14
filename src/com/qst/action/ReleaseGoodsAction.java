package com.qst.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.qst.model.Goods;
import com.qst.model.Image;
import com.qst.model.Page;
import com.qst.model.UserGoods;
import com.qst.serviceImpl.GoodsService;
import com.qst.serviceImpl.ImageService;

@Controller
public class ReleaseGoodsAction extends ActionSupport {

	@Autowired
	private GoodsService rgs;
	@Autowired
	private ImageService ims;

	private Image image;
	private Goods goods;
	private File upload;
	private String uploadFileName;
	private UserGoods userGoods;
	private int goodId;
	int page = 1;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// 发布商品
	public String releaseGoods() {
		HttpServletRequest request = ServletActionContext.getRequest();//获取request后获取session
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		//得到系统当前的日期
		// System.out.println(date);
		int uid = (int) request.getSession().getAttribute("uid");
		goods.setU_id(uid);
		//把uid设置到设置到goods中
		String savePath = "C:\\Users\\Administrator\\Desktop\\ourImage\\";
		// 随机产生一个文件名
		String fileName = UUID.randomUUID().toString() + "_" + uploadFileName;//给图片随机生成一个文件名
		File file = new File(savePath + fileName);//生成一个文件
		try {
			FileUtils.copyFile(upload, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//抛出异常

//		int imgId = ims.findImageByid(goodId);
		// 将图片地址放进image里面
		image = new Image();
//		image.setImage_id(imgId);
		image.setUrl1(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
		image.setUrl2(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
		image.setUrl3(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
		image.setUrl4(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
		ims.insertImage(image);
		// 将发布的商品信息放进goods里面
		goods.setImage_zhanshi(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
		goods.setImage_id(image.getImage_id());//插入图片的主键
		rgs.releaseGoods(goods);

		// 把商品的信息也存到user_goods表中
		userGoods = new UserGoods();
		userGoods.setUserId(uid);
		userGoods.setGoodsId(goods.getG_id());
		userGoods.setDate(date);
		rgs.saveUserGoods(userGoods);
		return "success";
	}

	// 用户查询自己所有的发布信息
	public String showReleaseGoods() {
		Page<Goods> showRelease = new Page<Goods>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int uid = (int) request.getSession().getAttribute("uid");
		showRelease = rgs.showReleaseGoods(page, uid);
		if (showRelease != null) {
			request.setAttribute("showRelease", showRelease);
			return SUCCESS;
		}
		return "noContent";

	}

	// 显示用户单件发布信息
	public String showUserGoods() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Goods good = new Goods();
		good = rgs.showGoods(goodId);
		request.setAttribute("good", good);
		return SUCCESS;

	}

	// 修改用户的商品信息
	public String updateUserGoods() {
		HttpServletRequest request = ServletActionContext.getRequest();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		// System.out.println(date);
		// int uid = (int) request.getSession().getAttribute("uid");
		// goods.setU_id(uid);
		String savePath = "C:\\Users\\Administrator\\Desktop\\ourImage\\";
		// 随机产生一个文件名
		String fileName = UUID.randomUUID().toString() + "_" + uploadFileName;
		File file = new File(savePath + fileName);
		if (file != null) {
			try {
				FileUtils.copyFile(upload, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 将图片地址放进image里面
			image = new Image();
			image.setUrl1(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
			image.setUrl2(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
			image.setUrl3(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
			image.setUrl4(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
			ims.updateImgae(image);
		}
		// 将发布的商品信息放进goods里面
		goods.setImage_zhanshi(File.separator + "image" + File.separator + "upload" + File.separator + fileName);
		goods.setG_id(goodId);
		rgs.upadateReleaseGoods(goods);

		return "success";

	}

	// 用户删除自己的发布信息
	public String deleteReleaseGoods() {
		rgs.deleteReleaseGood(goodId);
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

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
