package com.kh.semi.reservation.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.member.model.vo.MemberReservationList;
import com.kh.semi.reservation.model.vo.ReservationTest;
public class ReservationDao {

	private Properties prop;
	
	public ReservationDao() {
		prop = new Properties();
		
		String filePath = ReservationDao.class.getResource("/config/reservation-query.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ReservationTest> Reservation(Connection con, String shopPid) {
		
		ArrayList<ReservationTest>list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reservation");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shopPid);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ReservationTest>();
			
			while(rset.next()) {
				ReservationTest r = new ReservationTest();
				
				r.setShopPid(rset.getString("SHOP_PID"));
				r.setMenuNo(rset.getString("MENU_NO"));
				r.setMenuImg(rset.getString("MENU_IMG"));
				r.setMenuName(rset.getString("MENU_NAME"));
				r.setMenuPrice(rset.getInt("MENU_PRICE"));
				r.setShopAddr(rset.getString("SHOP_ADDR"));
				r.setShopDay(rset.getString("SHOP_DAY"));
				r.setShopEndTime(rset.getString("SHOP_ENDTIME"));
				r.setShopName(rset.getString("SHOP_NAME"));
				r.setShopStartTime(rset.getString("SHOP_STARTTIME"));
				r.setUserId(rset.getString("USERID"));
				
				list.add(r);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int reservationInsert(Connection con, String userId, String shopPid, Date rdate, String time, String menu, int total) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reservationInsert");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, shopPid);
			pstmt.setDate(3, rdate);
			pstmt.setString(4, time);
			pstmt.setString(5, menu);
			pstmt.setInt(6, total);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		System.out.println(result);
		return result;
	}

	public String reservationNo(Connection con, String userId, String shopPid) {
		
		String rNo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("reservationNo");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, shopPid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rNo = rset.getString(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rNo;
	}

	public int reservationDelete(Connection con, String rNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reservationDelete");
		System.out.println(rNo);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rNo);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	public ArrayList<MemberReservationList> reservationModify(Connection con, String userid, String reserveNo) {
		ArrayList<MemberReservationList> mrList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("reservationModify");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, reserveNo);
			
			rset = pstmt.executeQuery();
			
			mrList = new ArrayList<MemberReservationList>();
			while(rset.next()) {
				MemberReservationList mr = new MemberReservationList();
				mr.setResNo(rset.getString("RESERVE_NO"));
				mr.setmNo(rset.getString("MENU_NO"));
				mr.setShopPid(rset.getString("SHOP_PID"));
				mr.setsAddr(rset.getString("SHOP_ADDR"));
				mr.setsStartTime(rset.getString("SHOP_STARTTIME"));
				mr.setsEndTime(rset.getString("SHOP_ENDTIME"));
				mr.setsDay(rset.getString("SHOP_DAY"));
				mr.setMenuImg(rset.getString("MENU_IMG"));
				mr.setMenuPrice(rset.getInt("MENU_PRICE"));
				mr.setShopName(rset.getString("SHOP_NAME"));
				mr.setrDate(rset.getDate("RESERVE_DATE"));
				mr.setrTime(rset.getString("RESERVE_TIME"));
				mr.setMenuName(rset.getString("MENU_NAME"));
				mr.setAcceptYN(rset.getString("ACCEPT_YN"));

				
				mrList.add(mr);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mrList;
	}

	public int reservationUpdate(Connection con,String userid, String shopPid, String resNo, Date rdate, String time, String menu, int total) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("reservationUpdate");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setDate(1, rdate);
			pstmt.setString(2, time);
			pstmt.setString(3, menu);
			pstmt.setInt(4, total);
			pstmt.setString(5, userid);
			pstmt.setString(6, shopPid);
			pstmt.setString(7, resNo);
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int reservationModifyDelete(Connection con, String reserveNo, String shopPid) {
		int result=0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("reservationModifyDelete");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reserveNo);
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
