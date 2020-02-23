package com.kh.semi.pay.model.service;

import static com.kh.semi.common.JDBCTemplate.*;
import static com.kh.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;

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


}
