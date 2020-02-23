package com.kh.semi.eventShop.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.eventShop.model.dao.EventShopDao;
import com.kh.semi.eventShop.model.vo.EventShop;
import com.kh.semi.shop.model.vo.Shop;

public class EventShopService {

	private EventShopDao esDao = new EventShopDao();
	
	public ArrayList<Shop> selectList(String eno) {
		Connection con = getConnection();
		
		ArrayList<Shop> list = esDao.selectList(con,eno);
		
		close(con);
		
		return list;
	}

	public ArrayList<Shop> searchShop(String searchInfo) {
		Connection con = getConnection();
		
		ArrayList<Shop> list = null;
		
		
		list = esDao.searchShop(con,searchInfo);
			
		
		return list;
	}

	public int deleteShop(String check) {

		Connection con = getConnection();
		
		int result = esDao.deleteShop(con,check);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int insertEventShop(EventShop es, String eno, String insertCheck) {
		Connection con = getConnection();
		
		int result = esDao.insertEventShop(con,es,eno,insertCheck);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<Shop> mainShopList(String eno) {
		Connection con = getConnection();
		
		ArrayList<Shop> list = esDao.mainShopList(con,eno);
		
		close(con);
		
		return list;
	}

}
