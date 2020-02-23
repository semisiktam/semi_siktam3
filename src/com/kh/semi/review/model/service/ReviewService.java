package com.kh.semi.review.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.notice.model.vo.Notice;
import com.kh.semi.review.model.dao.ReviewDao;
import com.kh.semi.review.model.vo.Review;
import com.kh.semi.shop.model.vo.Shop;

public class ReviewService {

	private ReviewDao rDao = new ReviewDao();

	public int getListCount(String shopPid) {
		
		Connection con = getConnection();
		int listCount = rDao.getListCount(con,shopPid);
		
		close(con);
		
		return listCount;
	}

	/**
	 * 해당 가게의 리뷰 리스트 출력
	 * @param shopPid
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<Review> selectReviewList(String shopPid,String howSelect, int currentPage, int limit) {
		
		Connection con = getConnection();
		
		ArrayList<Review> rList = rDao.selectReviewList(con,shopPid,howSelect,currentPage,limit);
		
		close(con);
		
		return rList;
	}

	/**
	 * 샵 정보 가져오기
	 * @param shopPid
	 * @return
	 */
	public Shop selectShop(String shopPid) {
		
		Connection con = getConnection();
		
		Shop s = rDao.selectShop(con,shopPid);
		
		close(con);
		
		return s;
	}

	public ArrayList<Review> selectAllReviewList(String shopPid) {
		Connection con = getConnection();
		
		ArrayList<Review> allReviewList = rDao.selectAllReviewList(con,shopPid);
		
		return allReviewList;
	}

	public int rPossible(String shopPid, String userId) {
		Connection con = getConnection();
		int rPossible = rDao.rPossible(con,shopPid,userId);
		close(con);
		return rPossible;
	}

	public int reviewInsert(Review r) {
		
		Connection con = getConnection();
		
		int result = rDao.insertNotice(con,r);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int reviewInsertUpdate(String shopPid, String userId) {
		
		Connection con = getConnection();
		int result2 = rDao.reviewInsertUpdate(con,shopPid,userId);
		if(result2 >= 1) commit(con);
		else rollback(con);
		close(con);
		return result2;
	}

	public int deleteReview(String rno) {
		
		Connection con = getConnection();
		
		int result = rDao.deleteReview(con,rno);
		
		if(result >= 1) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int deleteReviewUpdate(String shopPid, String userId) {
		Connection con = getConnection();
		int result2 = rDao.reviewDeleteUpdate(con,shopPid,userId);
		if(result2 >= 1) commit(con);
		else rollback(con);
		close(con);
		return result2;
	}
	
	
}
