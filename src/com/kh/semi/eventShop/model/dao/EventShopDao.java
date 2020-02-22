package com.kh.semi.eventShop.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.eventBanner.model.vo.EventBanner;
import com.kh.semi.eventShop.model.vo.EventShop;
import com.kh.semi.shop.model.vo.Shop;

public class EventShopDao {
	
	private Properties prop;

	public EventShopDao() {
		prop = new Properties();
		
		String filePath= EventBanner.class.getResource("/config/event-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Shop> selectList(Connection con,String eno) {
		
		ArrayList<Shop> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("esSelectList");
		
		list = new ArrayList<Shop>();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, eno);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Shop s = new Shop();
				
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

	public ArrayList<Shop> searchShop(Connection con, String searchInfo) {
		ArrayList<Shop> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchShop");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, searchInfo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Shop>();
			
			while(rset.next()) {
				Shop s = new Shop();
				
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

	public int deleteShop(Connection con, String check) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteShop");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, check);
		
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
