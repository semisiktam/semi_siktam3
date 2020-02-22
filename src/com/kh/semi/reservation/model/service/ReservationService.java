package com.kh.semi.reservation.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

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
			String time, String menu) {
		
		Connection con = getConnection();
		
		int result = rDao.reservationInsert(con,userId,shopPid,rdate,time,menu);
		
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
		
		int result = rDao.reservationDelete(rNo);
		
				
		return result;
	}

}
