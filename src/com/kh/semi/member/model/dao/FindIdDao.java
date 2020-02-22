package com.kh.semi.member.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.semi.member.model.vo.Member;


public class FindIdDao {

	private Properties prop;


	public FindIdDao() {
		prop = new Properties();

		String filePath=FindIdDao.class.getResource("/config/findId-query.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
/*	
	public Member FindIdPhone(Connection con,String name, String phone) {
		

	int result = -1; // 오류나면 실패라고 뜸
	
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("idDupCheck");
	
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {

			userId = rset.getInt(1);
		}
		
	}catch(SQLException e){
		e.printStackTrace();
	}finally {
		close(rset);
		close(pstmt);
	}
	
	return userId;
}
*/

	public String FindIdPhone(Connection con, Member m) {
		
		String userId="";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("FindIdPhone");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getPhone());
			
			rset = pstmt.executeQuery();
			if(rset.next()){
				userId=rset.getString("USERID");
			 }
			 System.out.print("DAO:"+userId);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}	
		return userId;
	}

	public String FindIdBirthGender(Connection con, Member m) {
String userId="";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("FindIdBirth");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getPid());
			
			rset = pstmt.executeQuery();
			if(rset.next()){
				userId=rset.getString("USERID");
			 }
			 System.out.print("DAO:"+userId);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}	
		return userId;
}
	
	public String FindPwdPhone(Connection con, Member m) {
		
		String password="";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("FindPwdPhone");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getPhone());
			
			rset = pstmt.executeQuery();
			if(rset.next()){
				password=rset.getString("PASSWORD");
			 }
			 System.out.print("DAO:"+password);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}	
		return password;
	}

	public int FindIdCheck(Connection con, String chkId) {
		
		int result = -1;
		String userId = "";
				
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("FindPwdChk");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, chkId);			
		
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				 userId = rset.getString(1);
			 }
			
			if(userId == null || userId == "") {
				result = 0;
			}else
			{
				result = 1; 
			}
			 System.out.print("DAO:"+chkId);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}	
		return result;
	}
		
	
}

