package com.kh.semi.qna.model.service;
import java.sql.Connection;
import static com.kh.semi.common.JDBCTemplate.*;

import java.util.ArrayList;

import com.kh.semi.qna.model.dao.QnaDao;
import com.kh.semi.qna.model.vo.Qna;

public class QnaService {

	private QnaDao qDao = new QnaDao();
	
	/**
	 * 문의사항 조회용
	 * @return
	 */
	public ArrayList<Qna> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Qna> list = qDao.selectList(con,currentPage,limit);
		
		close(con);
		
		return list;
	}

	public Qna qSelectOne(int qno) {
		Connection con = getConnection();
		
		Qna q = qDao.qSelectOne(con,qno);
		
		// 카운트
		
		close(con);
		
		return q;
	}

	public ArrayList<Qna> searchQna(String category, String keyword) {
		
		Connection con = getConnection();
		
		ArrayList<Qna> list = null;
		
		if(category.length()>0) {
			list = qDao.searchQna(con,category,keyword);
		}else {
			list = qDao.selectList(con);
		}
		
		return list;
	}

public int insertQna(Qna q) {
		
		Connection con = getConnection();
		int result = qDao.insertQna(con,q);
		
		if(result >=1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateQna(Qna q) {
		Connection con = getConnection();
		int result = qDao.updateQna(con,q);
		
		if(result >=1) commit(con);
		else rollback(con);
		
		close(con);
		
		
		return result;
	}

	public Qna updateList(int qno) {
		Connection con = getConnection();
		
		Qna q = qDao.qSelectOne(con, qno);
		
		close(con);
		
		return q;
	}

	public int qnaDelete(int q) {
		Connection con = getConnection();
		int result = qDao.qnaDelete(con,q);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = qDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public int getListAdminCount() {
		Connection con = getConnection();
		
		int listAdminCount = qDao.getListAdminCount(con);
		
		close(con);
		
		return listAdminCount;
	}

	public ArrayList<Qna> selectAdminList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Qna> list = qDao.selectAdminList(con,currentPage,limit);
		
		close(con);
		
		return list;
	}

	public int updateAdminList(int qno, String qReply) {
		Connection con = getConnection();
		
		int result = qDao.updateAdminList(con, qno, qReply);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

}



































