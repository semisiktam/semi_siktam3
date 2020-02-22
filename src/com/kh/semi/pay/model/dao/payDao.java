package com.kh.semi.pay.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.semi.member.model.dao.MemberDao;
import com.kh.semi.member.model.vo.Member;
import com.kh.semi.pay.model.vo.Pay;

public class payDao {
	private Properties prop;
	
	public payDao() {
		prop = new Properties();
		
		String filePath=MemberDao.class.getResource("/config/pay-query.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Pay PayPrint(Connection con) {
		Pay p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("PayPrint"); 
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "P1");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Pay();
				
				p.setPayNo(rset.getString("PAY_NO"));
				p.setResNo(rset.getString("RESERVE_NO"));
				p.setPayType(rset.getString("PAY_TYPE"));
				p.setPayDate(rset.getDate("PAY_DATE"));
				p.setTotalPay(rset.getInt("TOTAL_PAY"));
				p.setMileage(rset.getInt("MILEAGE"));
				p.setCouponNo(rset.getInt("COUPON_NO"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return p;
	}

	public Member payInfo(Connection con, String userId) {
		Member mc = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("payInfo");
		
		try {
			System.out.println(userId);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mc = new Member();
				mc.setMileage(rset.getInt("MILEAGE"));
				mc.setCouponNo(rset.getInt("COUPON_NO"));
			}
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mc;
	}

}
