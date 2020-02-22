package com.kh.semi.pay.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Pay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String payNo       ; //결제고유번호
	private String resNo   ; //예약고유번호
	private String payType     ; //결제방식
	private Date payDate     ; //결제일
	private int totalPay    ; //총 결제금액
	private int mileage       ; //마일리지
	private int couponNo    ; //쿠폰번호
	public Pay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pay(String payNo, String resNo, String payType, Date payDate, int totalPay, int mileage, int couponNo) {
		super();
		this.payNo = payNo;
		this.resNo = resNo;
		this.payType = payType;
		this.payDate = payDate;
		this.totalPay = totalPay;
		this.mileage = mileage;
		this.couponNo = couponNo;
	}
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getResNo() {
		return resNo;
	}
	public void setResNo(String resNo) {
		this.resNo = resNo;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public int getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}
	@Override
	public String toString() {
		return "Pay [payNo=" + payNo + ", resNo=" + resNo + ", payType=" + payType + ", payDate=" + payDate
				+ ", totalPay=" + totalPay + ", mileage=" + mileage + ", couponNo=" + couponNo + "]";
	}
	
	
}                       
