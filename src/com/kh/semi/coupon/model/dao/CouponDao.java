package com.kh.semi.coupon.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.semi.common.SelectQueryMaker;
import com.kh.semi.coupon.model.vo.Coupon;

public class CouponDao {

	public Coupon Coupon(Connection con, int cNo) {
		Coupon c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = null;
		SelectQueryMaker query = null;
		
		query = new SelectQueryMaker.Builder()
				.select().column("*").enter()
				.from().column("COUPON").enter()
				.where().columnName("COUPON_NO").equal().condition(cNo)
				.build();
		
		System.out.println(query.getQuery());
		sql = query.getQuery().toString();
		
		try {
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Coupon();
				c.setCouponNo(rset.getInt("COUPON_NO"));
				c.setCouponName(rset.getString("COUPON_NAME"));
				c.setDiscount(rset.getInt("DISCOUNT"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}


}
