package com.qst.serviceImpl;

import com.qst.dao.ImageDAO;
import com.qst.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by tomatofrommars on 10/6/17.
 * Email: tomatofrommars@gmail.com
 */
@Service
public class ImageService {
	@Autowired
	private ImageDAO imageDAO;

	public ArrayList<String> getImageUrl(int image_id) {
		return imageDAO.getImageUrl(image_id);
	}

	public Image getImage(long goodsnumber) {
		return imageDAO.getImage(goodsnumber);
	}

	public Image showSmallPic(int gooId) {
		// TODO Auto-generated method stub
		return imageDAO.showSmallPic(gooId);
	}
	
	public void insertImage(Image image){
		 imageDAO.insertImage(image);
	}
	
	public int findImageByid(int goodId){
		return imageDAO.findImageByid(goodId);
	} 
	
	public void updateImgae(Image image){
		imageDAO.updateImage(image);
	}
}
