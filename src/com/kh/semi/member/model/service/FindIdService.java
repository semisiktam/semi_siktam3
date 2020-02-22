package com.kh.semi.member.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.semi.member.model.dao.FindIdDao;
import com.kh.semi.member.model.dao.MemberDao;
import com.kh.semi.member.model.vo.Member;



public class FindIdService {
	
	private Connection con;
	private FindIdDao idDao = new FindIdDao();
	
	public String FindIdPhone(Member m) {
	
		Connection con = getConnection();
		String userId = idDao.FindIdPhone(con,m);
		System.out.println("서비스:"+userId);
		close(con);
		
		return userId;
		
	}

	public String FindIdBirthGender(Member m) {
		
		Connection con = getConnection();
		String userId = idDao.FindIdBirthGender(con,m);
		System.out.println("서비스:"+userId);
		close(con);
		
		return userId;
			}

	public String FindPwdPhone(Member m) {
		Connection con = getConnection();
		String password = idDao.FindPwdPhone(con,m);
		System.out.println("서비스:"+password);
		close(con);
		
		return password;
	}

	public int FindIdCheck(String chkId) {
		
		Connection con = getConnection();
		int result = idDao.FindIdCheck(con,chkId);
		
		System.out.println("서비스:"+chkId);
		close(con);
		
		return result;
	}
}
