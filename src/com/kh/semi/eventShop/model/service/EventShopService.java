package com.kh.semi.eventShop.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.eventShop.model.dao.EventShopDao;
import com.kh.semi.shop.model.vo.Shop;

public class EventShopService {

	private EventShopDao esDao = new EventShopDao();
	
	public ArrayList<Shop> selectList(String eno) {
		Connection con = getConnection();
		
		ArrayList<Shop> list = esDao.selectList(con,eno);
		
		close(con);
		
		return list;
	}

}
