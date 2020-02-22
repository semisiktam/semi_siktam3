package com.kh.semi.reservation.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
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
	
	/**
	 * 탐희 마이페이지 예약 결제 내역
	 * @param userid
	 * @param reserveNo
	 * @return
	 */
	public ArrayList<MemberReservationList> reservationModify(String userid, String reserveNo) {
		Connection con = getConnection();
		
		ArrayList<MemberReservationList> mrList = rDao.reservationModify(con,userid,reserveNo);
		
		close(con);
		return mrList;
	}

}
