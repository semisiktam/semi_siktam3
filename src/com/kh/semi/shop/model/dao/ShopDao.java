package com.kh.semi.shop.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.common.SelectQueryMaker;
import com.kh.semi.shop.model.vo.Shop;
import com.kh.semi.shop.model.vo.ShopSearch;

public class ShopDao {

	private Properties prop;

	public ShopDao() {
		prop = new Properties();

		String filePath = ShopDao.class.getResource("/config/shop-query.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<ShopSearch> searchMain(Connection con, String keyword) {
		ArrayList<ShopSearch> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = null;
		if (keyword == null) {
			sql = prop.getProperty("searchAddrMain2");
		} else {
			sql = prop.getProperty("searchAddrMain");
		}

		try {
			pstmt = con.prepareStatement(sql);
			
			if (keyword != null) {
				pstmt.setString(1, keyword);
			}

			rset = pstmt.executeQuery();
			list = new ArrayList<ShopSearch>();

			while (rset.next()) {
				ShopSearch sc = new ShopSearch();

				sc.setStar(rset.getDouble("NVL(AVG(RE.SCORE),0)"));
				sc.setReviewCount(rset.getInt("COUNT(RE.SHOP_PID)"));
				sc.setReservationCount(rset.getInt("COUNT(RES.SHOP_PID)"));
				sc.setShopPid(rset.getString("SHOP_PID"));
				sc.setShopImg(rset.getString("SHOP_IMG"));
				sc.setShopName(rset.getString("SHOP_NAME"));
				sc.setShopAddr(rset.getString("SHOP_ADDR"));
				sc.setTableType(rset.getString("TABLE_TYPE"));
				sc.setMenuCategory(rset.getString("MENU_CATEGORY"));

				list.add(sc);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("SQL이외의 에러발생");
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);

		return list;

	}

	public int insertShop(Connection con, Shop s) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertShop");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getUserId());
			pstmt.setString(2, s.getShopName());
			pstmt.setString(3, s.getShopImg());
			pstmt.setString(4, s.getsAddr());
			pstmt.setString(5, s.getsPhone());
			pstmt.setString(6, s.getsInfo());
			pstmt.setString(7, s.getOwnerId());
			pstmt.setString(8, s.getsTime());
			pstmt.setString(9, s.geteTime());
			pstmt.setString(10, s.getShopDay());
			pstmt.setString(11, s.getMenuCategory());
			pstmt.setString(12, s.getTableType());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(sql + "확인");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<ShopSearch> SearchCondition(Connection con, String keyword, String line, String[] tlist, String[] clist, String[] plist) {
		ArrayList<ShopSearch> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = null;
		SelectQueryMaker query = null;

		String avgPay1 = "10000";
		String avgPay2 = "10000";
		String avgPay3 = "20000";
		String avgPay4 = "20000";
		String avgPay5 = "30000";
		String avgPay6 = "30000";
		String line_up = "";
		System.out.println(keyword);
		
		if (plist != null) {
			for (int i = 0; i < plist.length; i++) {
				if (!plist[i].equals("10000")) {
					avgPay1 = "0";
				}
				if (!plist[i].equals("10000~20000")) {
					avgPay2 = "0";
					avgPay3 = "1";
				}
				if (!plist[i].equals("20000~30000")) {
					avgPay4 = "0";
					avgPay5 = "1";
				}
				if (!plist[i].equals("30000")) {
					avgPay6 = "99999999";
				}
			}
		}
		
		if(line != null) {
			if(line.equals("리뷰 순")) {
				line_up= "COUNT(RE.SHOP_PID)";
			}else if(line.equals("방문 순")) {
				line_up = "COUNT(RES.SHOP_PID)";
			}else if(line.equals("평점 순")){
				line_up = "ROUND(NVL(AVG(RE.SCORE),1),0)";
			}
		}else {
			line_up = "1";
		}
		
		
		if (keyword == null) {
			if (tlist == null && clist == null) {
				if (plist == null) {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				} else {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("AVG_PAY").inequalityRigth(avgPay1).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay2, avgPay3).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay4, avgPay5).enter()
							.or().columnName("AVG_PAY").inequalityLeft(avgPay6).enter()
							
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				}
			} else if (tlist == null) {
				if (plist == null) {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("S.MENU_CATEGORY").in().condition(clist).enter()
							
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				} else {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("MENU_CATEGORY").in().condition(clist).enter()
							.and().leftbracket().columnName("AVG_PAY").inequalityRigth(avgPay1).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay2, avgPay3).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay4, avgPay5).enter()
							.or().columnName("AVG_PAY").inequalityLeft(avgPay6).enter().rightbracket()
							
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				}
			} else if (clist == null) {
				if (plist == null) {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
					
							.where().columnName("TABLE_TYPE").in().condition(tlist).enter()
					
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				} else {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("TABLE_TYPE").in().condition(tlist).enter()
							.and().leftbracket().columnName("AVG_PAY").inequalityRigth(avgPay1).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay2, avgPay3).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay4, avgPay5).enter()
							.or().columnName("AVG_PAY").inequalityLeft(avgPay6).enter().rightbracket()
							
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				}
			} else if (plist == null) {
				query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
						.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
						.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
						.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
						.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
						
						.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
						.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
						.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
						
						.where().columnName("TABLE_TYPE").in().condition(tlist).enter()
						.and().columnName("MENU_CATEGORY").in().condition(clist).enter()
						
						.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
						.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
						.column("S.MENU_CATEGORY").enter()
						
						.orderBy().columnName(line_up).desc()
						
						.build();
			}else if(tlist != null && clist != null && plist != null) {
				query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
						.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
						.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
						.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
						.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
						
						.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
						.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
						.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
						
						.where().columnName("TABLE_TYPE").in().condition(tlist).enter()
						.and().columnName("MENU_CATEGORY").in().condition(clist).enter()
						.and().leftbracket().columnName("AVG_PAY").inequalityRigth(avgPay1).enter()
						.or().columnName("AVG_PAY").betweenAnd(avgPay2, avgPay3).enter()
						.or().columnName("AVG_PAY").betweenAnd(avgPay4, avgPay5).enter()
						.or().columnName("AVG_PAY").inequalityLeft(avgPay6).enter().rightbracket()
				
						.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
						.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
						.column("S.MENU_CATEGORY").enter()
						
						.orderBy().columnName(line_up).desc()
						
						.build();
			}
		} else {
			if (tlist == null && clist == null) {
				if (plist == null) {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("SHOP_ADDR").like().bothPattern(keyword).enter()
					
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
					
				} else {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("SHOP_ADDR").like().bothPattern(keyword).enter()
							.and().leftbracket().columnName("AVG_PAY").inequalityRigth(avgPay1).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay2, avgPay3).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay4, avgPay5).enter()
							.or().columnName("AVG_PAY").inequalityLeft(avgPay6).enter().rightbracket()
							
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				}
			} else if (tlist == null) {
				if (plist == null) {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("SHOP_ADDR").like().bothPattern(keyword).enter()
							.and().columnName("MENU_CATEGORY").in().condition(clist).enter()
							
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				} else {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("SHOP_ADDR").like().bothPattern(keyword).enter()
							.and().columnName("MENU_CATEGORY").in().condition(clist).enter()
							.and().leftbracket().columnName("AVG_PAY").inequalityRigth(avgPay1).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay2, avgPay3).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay4, avgPay5).enter()
							.or().columnName("AVG_PAY").inequalityLeft(avgPay6).enter().rightbracket()
					
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
					
				}
			} else if (clist == null) {
				if (plist == null) {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("SHOP_ADDR").like().bothPattern(keyword).enter()
							.and().columnName("TABLE_TYPE").in().condition(tlist).enter()
							
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				} else {
					query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
							.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
							.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
							.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
							.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
							
							.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
							.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
							.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
							
							.where().columnName("SHOP_ADDR").like().bothPattern(keyword).enter()
							.and().columnName("TABLE_TYPE").in().condition(tlist).enter()
							.and().leftbracket().columnName("AVG_PAY").inequalityRigth(avgPay1).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay2, avgPay3).enter()
							.or().columnName("AVG_PAY").betweenAnd(avgPay4, avgPay5).enter()
							.or().columnName("AVG_PAY").inequalityLeft(avgPay6).enter().rightbracket()
							
							.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
							.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
							.column("S.MENU_CATEGORY").enter()
							
							.orderBy().columnName(line_up).desc()
							
							.build();
				}
			} else if (plist == null) {
				query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
						.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
						.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
						.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
						.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
						
						.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
						.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
						.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
						
						.where().columnName("SHOP_ADDR").like().bothPattern(keyword).enter()
						.and().columnName("TABLE_TYPE").in().condition(tlist).enter()
						.and().columnName("MENU_CATEGORY").in().condition(clist).enter()
						
						.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
						.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
						.column("S.MENU_CATEGORY").enter()
						
						.orderBy().columnName(line_up).desc()
						
						.build();
			}else if(tlist != null && clist != null && plist != null) {
				query = new SelectQueryMaker.Builder().select().column("S.SHOP_PID").comma()
						.column("S.SHOP_IMG").comma().column("S.SHOP_NAME").comma().column("S.SHOP_ADDR")
						.comma().column("S.TABLE_TYPE").comma().column("S.MENU_CATEGORY").comma()
						.column("S.MENU_CATEGORY").comma().column("ROUND(NVL(AVG(RE.SCORE),1),0)").comma()
						.column("COUNT(RE.SHOP_PID)").comma().column("COUNT(RES.SHOP_PID)").enter()
						
						.from().tableName("Shop").as("S").Leftjoin().tableName("REVIEW").as("RE").on()
						.equalCondition("S.SHOP_PID", "RE.SHOP_PID").Leftjoin().tableName("RESERVATION").as("RES")
						.on().equalCondition("RE.SHOP_PID", "RES.SHOP_PID").enter()
						
						.where().columnName("SHOP_ADDR").like().bothPattern(keyword).enter()
						.and().columnName("TABLE_TYPE").in().condition(tlist).enter()
						.and().columnName("MENU_CATEGORY").in().condition(clist).enter()
						.and().leftbracket().columnName("AVG_PAY").inequalityRigth(avgPay1).enter()
						.or().columnName("AVG_PAY").betweenAnd(avgPay2, avgPay3).enter()
						.or().columnName("AVG_PAY").betweenAnd(avgPay4, avgPay5).enter()
						.or().columnName("AVG_PAY").inequalityLeft(avgPay6).enter().rightbracket()
				
						.groupBy().column("RE.SHOP_PID").comma().column("S.SHOP_PID").comma().column("S.SHOP_IMG").comma()
						.column("S.SHOP_NAME").comma().column("S.SHOP_ADDR").comma().column("S.TABLE_TYPE").comma()
						.column("S.MENU_CATEGORY").enter()
						
						.orderBy().columnName(line_up).desc()
						
						.build();
			}
		}

		System.out.println(query.getQuery());

		sql = query.getQuery().toString();

		try {
			pstmt = con.prepareStatement(sql);

			rset = pstmt.executeQuery();
			list = new ArrayList<ShopSearch>();

			while (rset.next()) {
				ShopSearch sc = new ShopSearch();
				
				sc.setStar(rset.getDouble("ROUND(NVL(AVG(RE.SCORE),1),0)"));
				sc.setReviewCount(rset.getInt("COUNT(RE.SHOP_PID)"));
				sc.setReservationCount(rset.getInt("COUNT(RES.SHOP_PID)"));
				sc.setShopPid(rset.getString("SHOP_PID"));
				sc.setShopImg(rset.getString("SHOP_IMG"));
				sc.setShopName(rset.getString("SHOP_NAME"));
				sc.setShopAddr(rset.getString("SHOP_ADDR"));
				sc.setTableType(rset.getString("TABLE_TYPE"));
				sc.setMenuCategory(rset.getString("MENU_CATEGORY"));
//				sc.setMainMenu(rset.getString(""));

				list.add(sc);
			}

			System.out.println(list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Shop> selectList(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> s = null;
		String sql = prop.getProperty("selectList");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			s = new ArrayList<Shop>();
			while (rset.next()) {
				Shop shop = new Shop(rset.getString("SHOP_PID"), rset.getString("USERID"), rset.getString("SHOP_NAME"),
						rset.getString("SHOP_IMG"), rset.getString("SHOP_ADDR"), rset.getString("SHOP_PHONE"),
						rset.getString("SHOP_INFO"), rset.getString("OWNER_ID"), rset.getString("SHOP_STARTTIME"),
						rset.getString("SHOP_ENDTIME"), rset.getString("SHOP_DAY"), rset.getString("MENU_CATEGORY"),
						rset.getString("TABLE_TYPE"), rset.getInt("AVG_PAY"), rset.getString("OUT_YN"));
				s.add(shop);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return s;
	}


	public Shop selectOne(Connection con, String shopPid) {

		Shop s = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectOne");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shopPid);
			rset = pstmt.executeQuery();
			s = new Shop();

			if (rset.next()) {

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
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return s;
	}

	/**
	 * 전체 업체수 조회
	 * 
	 * @param con
	 * @return
	 */
	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("listCount");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	/**
	 * 관리자에서 업체리스트 조회
	 * @param con
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<Shop> shopAdminList(Connection con, int currentPage, int limit) {
		ArrayList<Shop> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("shopAdminList");
		
		try {
			 pstmt = con.prepareStatement(sql);
	         int startRow = (currentPage-1)*limit+1;
	         int endRow = startRow + limit - 1;
	         
	         pstmt.setInt(1, endRow);
	         pstmt.setInt(2, startRow);
	         
	         rset = pstmt.executeQuery();
	         
	         list = new ArrayList<Shop>();
	         

	         while(rset.next()) {
	        	Shop s = new Shop();
	            
	            s.setShopPid(rset.getString("shop_pid"));
	            s.setUserId(rset.getString("userid"));
	            s.setShopName(rset.getString("shop_name"));
	            s.setShopImg(rset.getString("shop_img"));
	            s.setsAddr(rset.getString("shop_addr"));
	            s.setsPhone(rset.getString("shop_phone"));
	            s.setsInfo(rset.getString("shop_info"));
	            s.setOwnerId(rset.getString("owner_id"));
	            s.setsTime(rset.getString("shop_starttime"));
	            s.seteTime(rset.getString("shop_endtime"));
	            s.setShopDay(rset.getString("shop_day"));
	            s.setMenuCategory(rset.getString("menu_category"));
	            s.setTableType(rset.getString("table_type"));
	            s.setAvgPay(rset.getInt("avg_pay"));
	            s.setOutYn(rset.getString("out_yn"));
	            
	            list.add(s);
	         }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * 관리자에서 매장정보 수정, shopPid와 userId는 수정불가
	 * @param con
	 * @param s
	 * @return
	 */
	public int updateAdminShop(Connection con, Shop s) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAdminShop");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getShopName());
			pstmt.setString(2, s.getShopImg());
			pstmt.setString(3, s.getsAddr());
			pstmt.setString(4, s.getsPhone());
			pstmt.setString(5, s.getsInfo());
			pstmt.setString(6, s.getOwnerId());
			pstmt.setString(7, s.getsTime());
			pstmt.setString(8, s.geteTime());
			pstmt.setString(9, s.getShopDay());
			pstmt.setString(10, s.getMenuCategory());
			pstmt.setString(11, s.getTableType());
			pstmt.setInt(12, s.getAvgPay());
			pstmt.setString(13, s.getOutYn());
			pstmt.setString(14, s.getShopPid());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int shopRecordInsert(Connection con, String userId, String shopPid) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("shopRecordInsert");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, shopPid);
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Shop> SelectShopRecentRecord(Connection con, String userId) {
		ArrayList<Shop> recordShop = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("SelectShopRecentRecord");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			recordShop = new ArrayList<Shop>();
			
			while(rset.next()) {
				Shop s = new Shop();
				
				s.setShopImg(rset.getString("shop_img"));
				s.setShopName(rset.getString("shop_name"));
				s.setsAddr(rset.getString("shop_addr"));
				
				recordShop.add(s);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return recordShop;
	}

	/**
	 * 즐겨찾기 등록하기
	 * @param con
	 * @param userId
	 * @param shopPid
	 * @return
	 */
	public int shopFavoriteInsert(Connection con, String userId, String shopPid) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("shopFavoriteInsert");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,userId);
			pstmt.setString(2, shopPid);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 즐겨찾기 삭제하기
	 * @param con
	 * @param userId
	 * @param shopPid
	 * @return
	 */
	public int shopFavoriteDelete(Connection con, String userId, String shopPid) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("shopFavoriteDelete");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,userId);
			pstmt.setString(2, shopPid);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


}
