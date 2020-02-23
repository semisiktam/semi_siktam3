package com.kh.semi.eventBanner.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.eventBanner.model.vo.EventBanner;

import static com.kh.semi.common.JDBCTemplate.*;

public class EventBannerDao {

	private Properties prop;
	
	public EventBannerDao() {
		prop = new Properties();
		
		String filePath= EventBanner.class.getResource("/config/event-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int insertNotice(Connection con, EventBanner eb) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertEvent");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, eb.getEventName());
			pstmt.setString(2, eb.getEventImg());
			
			result = pstmt.executeUpdate();
			
			System.out.println("DAO"+result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
	}

	public ArrayList<EventBanner> selectList(Connection con) {

		ArrayList<EventBanner> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<EventBanner>();
			
			while(rset.next()) {
				EventBanner eb = new EventBanner();
				
				eb.setEventNo(rset.getString(1));
				eb.setEventName(rset.getString("EVENT_NAME"));
				eb.setEventImg(rset.getString("EVENT_IMG"));
				
				list.add(eb);
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}

	public EventBanner eSelectOne(Connection con, String eno) {
		EventBanner eb = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("eSelectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, eno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				eb = new EventBanner();
				
				eb.setEventNo(rset.getString("EVENT_NO"));
				eb.setEventName(rset.getString("EVENT_NAME"));
				eb.setEventImg(rset.getString("EVENT_IMG"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		
		
		return eb;
	}

	public int deleteEvent(Connection con, String check1) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteEvent");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, check1);
		
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
