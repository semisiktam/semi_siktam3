package com.kh.semi.black.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.black.model.dao.BlackDao;
import com.kh.semi.black.model.vo.BlackList;
import com.kh.semi.member.model.dao.MemberDao;

public class BlackService {
	private Connection con;
	private BlackDao bDao = new BlackDao();
	private MemberDao mDao = new MemberDao();
	
	public int getListCount() {
		con = getConnection();
		
		int listCount = bDao.getListCount(con);
		
		close(con);
				
		return listCount;
	}

	public ArrayList<BlackList> selectList(int currentPage, int limit) {
		con = getConnection();
		
		ArrayList<BlackList> blist = bDao.selectList(con, currentPage, limit);
		
		close(con);
		
		return blist;
	}

	public BlackList selectOne(String userId) {
		con = getConnection();
		
		
		BlackList bl = bDao.selectOne(con, userId);
		
		close(con);
		
		return bl;
	}

	public int updateBlack(BlackList bl) {
		con = getConnection();
		
		int result = bDao.updateBlack(con, bl);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int deleteZero() {
		con = getConnection();
		
		bDao.updateZero(con);
		
		int result = bDao.deleteZero(con);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
				
		return result;
	}

}
