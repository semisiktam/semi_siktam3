package ztest.test.test;

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
import static com.kh.semi.common.JDBCTemplate.*;

import com.kh.semi.reservation.model.dao.ReservationDao;

import ztest.test.test.test.TestVo2;

public class TestDao {
	
	private Properties prop;
	public TestDao() {
		prop = new Properties();
		
		String filePath = ReservationDao.class.getResource("/config/testzone-query.properties").getPath();

		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<TestVo2> rList(Connection con, String ownerId) {
		System.out.println("testDao진입");
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("myReserveList");
		TestVo2 tvo=null;
		ArrayList<TestVo2> tvolist=new ArrayList();;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ownerId);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				tvo=new TestVo2();
				tvo.setResNo(rset.getString(1));
				tvo.setUserId(rset.getString(2));
				tvo.setShopPid(rset.getString(3));
				tvo.setrDate(rset.getDate(4));
				tvo.setrTime(rset.getString(5));
				tvo.setMenuNo(rset.getString(6));
				tvo.setTotalPay(15000);
				tvo.setAcceptYN(rset.getString(7));
				tvo.setShopName(getShopName(con,tvo.getShopPid()));//getShopName 메소드
				tvo.setUserName(getUserInfo(con,tvo.getUserId())[1]);//getUserName 메소드
				tvo.setUserPhone(getUserInfo(con,tvo.getUserId())[0]);//getUserPhone 메소드
				tvolist.add(tvo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return tvolist;
	}
	
	private String getShopName(Connection con,String shopPid) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String shopName="";
		String sql=prop.getProperty("getShopName");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, shopPid);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				shopName=rset.getString(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return shopName;
	}
	
	private String[] getUserInfo(Connection con,String userId) {
		String[] str=new String[2];
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("getUserInfo");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				str[0]=rset.getString(1);
				str[1]=rset.getString(2);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return str;
	}
	public int updateAccept(Connection con, String resNo) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("updateAccept");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, resNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateReject(Connection con, String resNo) {
		int result=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String sql=prop.getProperty("updateReject");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, resNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
}





















