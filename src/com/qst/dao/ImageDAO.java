package com.qst.dao;

import com.qst.model.Image;

import java.util.ArrayList;

/**
 * Created by tomatofrommars on 10/6/17.
 * Email: tomatofrommars@gmail.com
 */
public interface ImageDAO {

	ArrayList<String> getImageUrl(int image_id);

	Image getImage(long goodsnumber);

	Image showSmallPic(int goodId);
}
