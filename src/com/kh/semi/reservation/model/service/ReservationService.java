package com.kh.semi.reservation.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
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

}
