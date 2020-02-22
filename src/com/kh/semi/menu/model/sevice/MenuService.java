package com.kh.semi.menu.model.sevice;

import com.kh.semi.menu.model.dao.MenuDao;
import com.kh.semi.menu.model.vo.Menu;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class MenuService {

	private MenuDao mDao = new MenuDao();

	public ArrayList<Menu> selectList(String shopPid) {
		
		Connection con = getConnection();
		
		ArrayList<Menu> list = mDao.selectList(con,shopPid);
		
		close(con);
		
		return list;
	}

	public int insertMenu(Menu m) {
		Connection con=getConnection();
		int result=0;
		result=mDao.insertMenu(con,m);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	public int updateMenu(Menu m) {
		Connection con=getConnection();
		int result=mDao.updateMenu(con,m);
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}

	public int deleteMenu(String menuNo) {
		Connection con=getConnection();
		int result=0;
		result=mDao.deleteMenu(con,menuNo);
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}
	
	

	
	
	
	
}
