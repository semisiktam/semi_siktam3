package com.kh.semi.mypageFavorite.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.mypageFavorite.model.dao.mypageFavoriteDao;
import com.kh.semi.mypageFavorite.model.vo.MypageFavorite;
import com.kh.semi.shop.model.vo.Shop;
import static com.kh.semi.common.JDBCTemplate.*;

public class mypageFavoriteService {

	private mypageFavoriteDao mfDao = new mypageFavoriteDao();

	public ArrayList<Shop> selectFavoriteShop(String userId) {
		Connection con = getConnection();
		
		ArrayList<Shop> favorShopList = mfDao.selectFavoriteShop(con,userId);
		
		close(con);
		
		return favorShopList;
	}

	public int isExist(MypageFavorite mf) {
		Connection con = getConnection();
		
		int result = mfDao.isExist(con, mf);
		
		System.out.println("서비스" + result);
		
		close(con);
		
		return result;
	}

}
