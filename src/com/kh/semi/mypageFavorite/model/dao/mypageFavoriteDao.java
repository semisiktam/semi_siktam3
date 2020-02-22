package com.kh.semi.mypageFavorite.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.mypageFavorite.model.vo.MypageFavorite;
import com.kh.semi.shop.model.vo.Shop;

public class mypageFavoriteDao {
	private Properties prop;
	
	public mypageFavoriteDao() {
		prop = new Properties();
		
		String filePath=mypageFavoriteDao.class.getResource("/config/myfavorite-query.properties").getPath();
	      
	      try {
	         prop.load(new FileReader(filePath));
	      }catch(FileNotFoundException e) {
	         e.printStackTrace();
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
	}

	/**
	 * 마이페이지(개인) 즐겨찾기 조회용
	 * @param con
	 * @param userId
	 * @return
	 */
	public ArrayList<Shop> selectFavoriteShop(Connection con, String userId) {
		ArrayList<Shop> favorShopList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFavorite");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			favorShopList = new ArrayList<Shop>();
			
			while(rset.next()) {
				Shop s = new Shop();
				
				s.setShopName(rset.getString("shop_name"));
				s.setShopImg(rset.getString("shop_img"));
				s.setsAddr(rset.getString("shop_addr"));
				
				favorShopList.add(s);
				
			}
			System.out.println(favorShopList);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		for(Shop n : favorShopList) {
			System.out.println(n);
		}
		return favorShopList;
	}

	public int isExist(Connection con, MypageFavorite mf) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("isExist");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mf.getUserId());
			pstmt.setString(2, mf.getShopPid());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

}
