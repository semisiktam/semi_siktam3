package com.kh.semi.qna.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.notice.model.vo.Notice;
import com.kh.semi.qna.model.vo.Qna;


public class QnaDao {

	private Properties prop;
	
	public QnaDao() {
		prop = new Properties();
		
		String filePath = Notice.class.getResource("/config/qna-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 리스트 조회용
	 * @param con
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<Qna> selectList(Connection con) {
		// Select문을 실행하고 Java에서 사용할 객체를 선언
		ArrayList<Qna> list = null;
		// 검색 쿼리를 담을 객체를 선언한것(Statement를 사용한 이유는 where절이 없기때문일듯?)
		Statement stmt = null;
		// sql쿼리문을 Statement 객체에 담아서 실행하고 DB에서 전달받은 받을 변수
		// (select절을 사용할 경우 반환형은 ResultSet 타입으로 넘어오니깐 java에서도 ResultSet 타입으로 선언하고 받을 준비)
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListAll");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<Qna>();
			
			while(rset.next()) {
				Qna q = new Qna();
				
				// rset.getString("DB의 컬럼명:대소문자상관없음.)
				q.setqNo(rset.getInt(1)); 
				q.setUserId(rset.getString("QWRITER"));
				q.setqTitle(rset.getString("QTITLE"));
				q.setqContext(rset.getString("QCONTEXT"));
				q.setqReply(rset.getString("QREPLY"));
				q.setqDate(rset.getDate("QDATE"));
				
				list.add(q);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		
		return list;	
	}
	/**
	 * 페이징 처리용 전체 조회
	 * @param con
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<Qna> selectList(Connection con, int currentPage, int limit) {
		
		ArrayList<Qna> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1)*limit+1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Qna>();
			
			while(rset.next()) {
				Qna q = new Qna();
				
				q.setqNo(rset.getInt(1)); 
				q.setUserId(rset.getString("QWRITER"));
				q.setqTitle(rset.getString("QTITLE"));
				q.setqContext(rset.getString("QCONTEXT"));
				q.setqReply(rset.getString("QREPLY"));
				q.setqDate(rset.getDate("QDATE"));
				
				list.add(q);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	public Qna qSelectOne(Connection con, int qno) {

		Qna q = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("qSelectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qno);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				q = new Qna();
				
				q.setqNo(rset.getInt("QNO"));
				q.setUserId(rset.getString("QWRITER"));
				q.setqDate(rset.getDate("QDATE"));
				q.setqTitle(rset.getString("QTITLE"));
				q.setqContext(rset.getString("QCONTEXT"));
				q.setqReply(rset.getString("QREPLY"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return q;
	}

	public ArrayList<Qna> searchQna(Connection con, String category, String keyword) {

		ArrayList<Qna> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		switch(category) {
		case "writer" : sql = prop.getProperty("searchWriterQna"); break;
		case "title" : sql = prop.getProperty("searchTitleQna"); break;
		case "context" : sql = prop.getProperty("searchContextQna"); break;
		}
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Qna>();
			
			while(rset.next()) {
				Qna q = new Qna();
				
				q.setqNo(rset.getInt("QNO"));
				q.setUserId(rset.getString("QWRITER"));
				q.setqDate(rset.getDate("QDATE"));
				q.setqTitle(rset.getString("QTITLE"));
				q.setqContext(rset.getString("QCONTEXT"));
				q.setqReply(rset.getString("QREPLY"));
				
				list.add(q);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	public int insertQna(Connection con, Qna q) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQna");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, q.getUserId());
			pstmt.setString(2, q.getqTitle());
			pstmt.setString(3, q.getqContext());
			
			result = pstmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int updateQna(Connection con, Qna q) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("qnaUpdate");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, q.getqTitle());
			pstmt.setString(2, q.getqContext());
			pstmt.setInt(3, q.getqNo());

			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int qnaDelete(Connection con, int q) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("qnaDelete");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getListCount(Connection con) {

		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		
		return listCount;
	}



	public int getListAdminCount(Connection con) {
		int listAdminCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listAdminCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listAdminCount = rset.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listAdminCount;
	}



	public ArrayList<Qna> selectAdminList(Connection con, int currentPage, int limit) {
		ArrayList<Qna> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAdminList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1)*limit+1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Qna>();
			
			while(rset.next()) {
				Qna q = new Qna();
				
				q.setqNo(rset.getInt(1)); 
				q.setUserId(rset.getString("QWRITER"));
				q.setqTitle(rset.getString("QTITLE"));
				q.setqContext(rset.getString("QCONTEXT"));
				q.setqReply(rset.getString("QREPLY"));
				q.setqDate(rset.getDate("QDATE"));
				
				list.add(q);
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
	 * 관리자에서 답글 등록
	 * @param con
	 * @param qno
	 * @return
	 */
	public int updateAdminList(Connection con, int qno, String qReply) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAdminList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qReply);
			pstmt.setInt(2, qno);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
