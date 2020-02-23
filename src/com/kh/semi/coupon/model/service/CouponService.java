package com.kh.semi.coupon.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.coupon.model.dao.CouponDao;
import com.kh.semi.coupon.model.vo.Coupon;

public class CouponService {

	CouponDao cDao = new CouponDao();

	public Coupon Coupon(int cNo) {
		Connection con = getConnection();
		
		Coupon c = cDao.Coupon(con, cNo);
		
		close(con);
		return c;
	}

}
