package com.kh.semi.eventBanner.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.eventBanner.model.dao.EventBannerDao;
import com.kh.semi.eventBanner.model.vo.EventBanner;


public class EventBannerService {

	private EventBannerDao eDao = new EventBannerDao();
	
	public int InsertEvent(EventBanner eb) {

		Connection con = getConnection();
		
		int result = eDao.insertNotice(con,eb);

		System.out.println("service"+result);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<EventBanner> selectList() {
		Connection con = getConnection();
		
		ArrayList<EventBanner> list = eDao.selectList(con);
		
		close(con);
		
		return list;
	}

	public EventBanner eSelectOne(String eno) {
		Connection con = getConnection();
		
		EventBanner eb = eDao.eSelectOne(con,eno);
		
		close(con);
		
		return eb;
	}

	public int deleteEvent(String check1) {
		Connection con = getConnection();
		
		int result = eDao.deleteEvent(con,check1);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

}
