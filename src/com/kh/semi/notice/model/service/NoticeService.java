package com.kh.semi.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.notice.model.dao.NoticeDao;
import com.kh.semi.notice.model.vo.Notice;

import static com.kh.semi.common.JDBCTemplate.*;

public class NoticeService {

	private NoticeDao nDao = new NoticeDao();

	public int getListCount() {
		
		Connection con = getConnection();
		int listCount = nDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}
	
	
	/**
	 * 공지 사항 조회용
	 * @return
	 */
	public ArrayList<Notice> selectList(int currentPage, int limit) {
		
		Connection con = getConnection();
		
		ArrayList<Notice> list = nDao.selectList(con,currentPage,limit);
		
		close(con);
		
		return list;
	}

	/**
	 * 공지사항 상세 보기용
	 * @param nno
	 * @return
	 */
	public Notice selectOne(int nno) {
		
		Connection con = getConnection();
		
		Notice n = nDao.selectOne(con,nno);
		
		if(n != null) {
			int result = nDao.updateReadCount(con,nno);
			
			if(result > 0) commit(con);
			else rollback(con);
		}
		close(con);
		
		return n;
		
	}

	/**
	 * 공지사항 검색용
	 * @param category
	 * @param keyword
	 * @return
	 */
	public ArrayList<Notice> searchNotice(String category, String keyword, int currentPage, int limit) {
		
		Connection con = getConnection();
		
		ArrayList<Notice> list = null;
		
		if(category.length() > 0) {
			list = nDao.searchNotice(con,category,keyword,currentPage,limit);
		}else {
			list = nDao.selectList(con);
		}
		
		
		return list;
	}


	public int insertNotice(Notice n) {
		
		Connection con = getConnection();
		
		int result = nDao.insertNotice(con,n);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	public int updateNotice(Notice n) {
		
		Connection con = getConnection();
		
		int result = nDao.updateNotice(con,n);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	public Notice updateView(int nno) {
		Connection con = getConnection();
		
		Notice n = nDao.selectOne(con, nno);
		
		close(con);
		
		return n;
	}


	public int deleteNotice(int nno) {
		
		Connection con = getConnection();
		
		int result = nDao.deleteNotice(con,nno);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	
}
