package com.kh.semi.pay.model.service;

import java.sql.Connection;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.pay.model.dao.payDao;
import com.kh.semi.pay.model.vo.Pay;
import static com.kh.semi.common.JDBCTemplate.*;
public class payService {
	
	payDao pDao = new payDao();
	
	public Pay PayPrint() {
		Connection con = getConnection();
		
		Pay p = pDao.PayPrint(con);
		return p;
	}

	public Member payinfo(String userId) {

		Connection con = getConnection();
		Member mc = pDao.payInfo(con,userId);
		close(con);
		
		return mc;
	}

}
