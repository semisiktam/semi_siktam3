package com.kh.semi.coupon.model.vo;

import java.io.Serializable;

public class Coupon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1464233682605691974L;
	private int couponNo; //쿠폰번호
	private String couponName; //쿠폰명
	private int discount; //할인가격
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coupon(int couponNo, String couponName, int discount) {
		super();
		this.couponNo = couponNo;
		this.couponName = couponName;
		this.discount = discount;
	}
	public int getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Coupon [couponNo=" + couponNo + ", couponName=" + couponName + ", discount=" + discount + "]";
	}
	
}	
