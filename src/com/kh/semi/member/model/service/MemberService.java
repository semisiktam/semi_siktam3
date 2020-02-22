package com.kh.semi.member.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.black.model.vo.BlackList;
import com.kh.semi.member.model.dao.MemberDao;
import com.kh.semi.member.model.vo.Member;
import com.kh.semi.member.model.vo.MemberReservationList;
import com.kh.semi.shop.model.vo.Shop;

public class MemberService {
   private Connection con;
   private MemberDao mDao = new MemberDao(); 
   
   public Member selectMember(Member m) {
      con = getConnection();
      
      Member result = mDao.selectMember(con, m);
      
      close(con);
      
      return result;
   }
   
   public int insertMember(Member m) {
      con = getConnection();
      // 연결객체와 member객체 넘기기
      int result = mDao.insertMember(con,m);
      
      if(result>0) commit(con);
      else rollback(con);
      
      close(con);
      
      return result;
   }
   
   public int insertMember2(Member m) {
      con = getConnection();
      // 연결객체와 member객체 넘기기
      int result = mDao.insertMember2(con,m);
      
      if(result>0) commit(con);
      else rollback(con);
      
      close(con);
      
      return result;
   }

   public int idDupCheck(String id) {
      con = getConnection();
      
      int result = mDao.idDupCheck(con,id);
      
      close(con);
      
      return result;
   }

   public int upDateMember(Member m) {
      con = getConnection();
      
      int result = mDao.upDateMember(con,m);
      
      if(result>0) {
         commit(con);
      }else {
         rollback(con);
      }
      
      close(con);
      
      return result;
   }
   public ArrayList<Member> selectList(int currentPage, int limit) {
      Connection con = getConnection();
      
      ArrayList<Member> mlist = mDao.selectList(con, currentPage, limit);
      
      close(con);

      return mlist;
   }

   public int getListCount() {
      Connection con = getConnection();
      int listCount = mDao.getListCount(con);
      
      close(con);
      return listCount;
   }

public ArrayList<MemberReservationList> selectUserReserve(String id) {
	Connection con = getConnection();
	
	ArrayList<MemberReservationList> mrList = mDao.selectUserReserve(con,id);
	
	close(con);
	
	return mrList;
}

/**
 * 서지가 한거
 * @param userId
 * @return
 */
public ArrayList<Shop> selectFSList(String userId) {
	
	Connection con = getConnection();
	
	ArrayList<Shop> fsList = mDao.selectFSList(con,userId);
	
	close(con);
	
	return fsList;
}

public Member selectMember(String userId) {
	Connection con = getConnection();
	
	Member m = mDao.selectMember(con, userId);
	
	close(con);
	
	return m;
}

public int updateAdminMember(Member m, BlackList bl) {
	Connection con = getConnection();
	
	int result = mDao.updateAdminMember(con, m);
	
	mDao.insertAdminBlack(con, bl);

	if(result>0) commit(con);
	else rollback(con);
	
	close(con);
	
	return result;
}

public int deleteMember(String userId, String password) {
	Connection con = getConnection();
	int result = mDao.deleteMember(con,userId,password);
	
	if(result>0) commit(con);
	else rollback(con);
	
	close(con);
	
	return result;
	
}

public int updateAdminMember2(Member m) {
	Connection con = getConnection();
	
	int result = mDao.updateAdminMember(con, m);
	
	String userId = m.getUserId();
	
	mDao.deleteAdminBlack(con, userId);

	if(result>0) commit(con);
	else rollback(con);
	
	close(con);
	
	return result;
}

public int getListCount(String category, String keyword) {
	Connection con = getConnection();
    int listCount = mDao.getListCount(con, category, keyword);
    
    close(con);
    return listCount;
}

public ArrayList<Member> mAdminSearch(String category, String keyword, int currentPage, int limit) {
	Connection con = getConnection();
    
    ArrayList<Member> mlist = mDao.selectList(con, category, keyword, currentPage, limit);
    
    close(con);

    return mlist;
}




}