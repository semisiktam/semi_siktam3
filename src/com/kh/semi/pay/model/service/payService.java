package com.kh.semi.pay.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.semi.member.model.dao.MemberDao;
import com.kh.semi.pay.model.dao.payDao;
import com.kh.semi.pay.model.vo.Pay;
public class payService {
	
	payDao pDao = new payDao();
	public Pay PayPrint() {
		Connection con = getConnection();
		
		Pay p = pDao.PayPrint(con);
		
		close(con);
		return p;
	}

	public int insertPay(Pay pay) {
		Connection con = getConnection();
		
		int result = pDao.insertPay(con, pay);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
				
		return result;
	}

	public int updateMile(String userId, int mileage) {
		Connection con = getConnection();
		
		int beforeMile = pDao.selectMile(con, userId);
		
		int afterMile = beforeMile - mileage;
		
		int result = pDao.updateMile(con, userId, afterMile);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateCoupon(String userId) {
		Connection con = getConnection();
		
		int result = pDao.updateCoupon(con, userId);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

}
