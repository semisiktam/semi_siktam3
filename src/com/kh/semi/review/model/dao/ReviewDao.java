package com.kh.semi.review.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.notice.model.vo.Notice;
import com.kh.semi.review.model.vo.Review;
import com.kh.semi.shop.model.vo.Shop;

import static com.kh.semi.common.JDBCTemplate.*;

public class ReviewDao {

	private Properties prop;
	
	public ReviewDao() {
		prop = new Properties();
		
		String filePath = Review.class.getResource("/config/review-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 리뷰 전체 갯수 가져오기
	 * @param con
	 * @param shopPid
	 * @return
	 */
	public int getListCount(Connection con, String shopPid) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shopPid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	/**
	 * 리뷰 정보 가져오기
	 * @param con
	 * @param shopPid
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<Review> selectReviewList(Connection con, String shopPid,String howSelect, int currentPage, int limit) {
		ArrayList<Review> rList = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = ""; 
//		= prop.getProperty("selectReviewList");
		
		switch(howSelect) {
			case "new" : sql = prop.getProperty("selectReviewList");  break;
			case "rowScore" : sql = prop.getProperty("selectReviewRowList");  break;
			case "highScore" : sql = prop.getProperty("selectReviewHighList");  break;
		}
		
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1)*limit+1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, shopPid);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review r = new Review();
				
				r.setrNo(rset.getString("review_no"));
				r.setUserId(rset.getString("userid"));
				r.setShopPid(rset.getString("shop_pid"));
				r.setrContent(rset.getString("review_content"));
				r.setReviewImg(rset.getString("review_img"));
				r.setScore(rset.getInt("score"));
				r.setrDate(rset.getDate("review_date"));
				
				rList.add(r);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return rList;
	}

	/**
	 * 가게 정보 가져오기
	 * @param shopPid
	 * @return
	 */
	public Shop selectShop(Connection con,String shopPid) {
		Shop s = new Shop();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShop");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shopPid);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				s = new Shop();

				s.setShopPid(rset.getString("SHOP_PID"));
				s.setUserId(rset.getString("USERID"));
				s.setShopName(rset.getString("SHOP_NAME"));
				s.setShopImg(rset.getString("SHOP_IMG"));
				s.setsAddr(rset.getString("SHOP_ADDR"));
				s.setsPhone(rset.getString("SHOP_PHONE"));
				s.setsInfo(rset.getString("SHOP_INFO"));
				s.setOwnerId(rset.getString("OWNER_ID"));
				s.setsTime(rset.getString("SHOP_STARTTIME"));
				s.seteTime(rset.getString("SHOP_ENDTIME"));
				s.setShopDay(rset.getString("SHOP_DAY"));
				s.setMenuCategory(rset.getString("MENU_CATEGORY"));
				s.setTableType(rset.getString("TABLE_TYPE"));
				s.setAvgPay(rset.getInt("AVG_PAY"));
				s.setOutYn(rset.getString("OUT_YN"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return s;
	}

	public ArrayList<Review> selectAllReviewList(Connection con, String shopPid) {
		
		ArrayList<Review> allReviewList = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAllReviewList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shopPid);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review r = new Review();
				
				r.setrNo(rset.getString("review_no"));
				r.setUserId(rset.getString("userid"));
				r.setShopPid(rset.getString("shop_pid"));
				r.setrContent(rset.getString("review_content"));
				r.setReviewImg(rset.getString("review_img"));
				r.setScore(rset.getInt("score"));
				r.setrDate(rset.getDate("review_date"));
				
				allReviewList.add(r);
			}
			
		}catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
		
		
		return allReviewList;
	}
	
	
	
	
	
	
	
	
}
