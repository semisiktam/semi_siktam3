package com.kh.semi.reservation.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.semi.member.model.vo.MemberReservationList;
import com.kh.semi.reservation.model.dao.ReservationDao;
import com.kh.semi.reservation.model.vo.ReservationTest; 
public class ReservationService {

	ReservationDao rDao = new ReservationDao();
	
	public ArrayList<ReservationTest> Reservation(String shopPid) {
		Connection con = getConnection();
		
		ArrayList<ReservationTest> list = rDao.Reservation(con,shopPid);
		
		close(con);
		return list;
	}

	public int reservationInsert(String userId, String shopPid, Date rdate,
			String time, String menu, int total) {
		
		Connection con = getConnection();
		
		int result = rDao.reservationInsert(con,userId,shopPid,rdate,time,menu,total);
		
		if (result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public String reservationNo(String userId, String shopPid) {
		
		Connection con = getConnection();
		
		String rNo = rDao.reservationNo(con,userId,shopPid);
		return rNo;
	}

	public int reservationDelete(String rNo) {
		
		Connection con = getConnection();
		
		int result = rDao.reservationDelete(con,rNo);
		
		System.out.println(result);
		if(result >0) commit(con);
		else rollback(con);
		return result;
	}
	
	public ArrayList<MemberReservationList> reservationModify(String userid, String reserveNo) {
		Connection con = getConnection();
		
		ArrayList<MemberReservationList> mrList = rDao.reservationModify(con,userid,reserveNo);
		
		close(con);
		return mrList;
	}

	public int reservationUpdate(String userid, String shopPid, String resNo, Date rdate, String time, String menu, int total) {
		Connection con = getConnection();
		int result = rDao.reservationUpdate(con,userid,shopPid,resNo,rdate,time,menu,total);
		
		if (result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

}
