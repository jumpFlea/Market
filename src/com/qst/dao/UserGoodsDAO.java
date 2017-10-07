package com.qst.dao;

import com.qst.model.UserGoods;
import org.springframework.stereotype.Component;

/**
 * Created by tomatofrommars on 10/6/17.
 * Email: tomatofrommars@gmail.com
 */
@Component
public interface UserGoodsDAO {
	void saveUserGoods(UserGoods userGoods);
}
