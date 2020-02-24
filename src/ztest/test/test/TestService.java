package ztest.test.test;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import ztest.test.test.test.TestVo2;

public class TestService {
	
	private TestDao tdao=new TestDao();
	public ArrayList<TestVo2> rList(String ownerId) {
		System.out.println("TestService진입");
		Connection con=getConnection();
		
		ArrayList<TestVo2> tvo=tdao.rList(con,ownerId);
		close(con);
		
		
		return tvo;
		
	}
	public int updateAccept(String resNo) {
		Connection con=getConnection();
		int result=tdao.updateAccept(con,resNo);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}
	
	public int updateReject(String resNo) {
		Connection con=getConnection();
		int result=tdao.updateReject(con,resNo);
		
		if(result>0) {
			commit(con);
			
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
