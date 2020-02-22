package com.kh.semi.reservation.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4067547534801366386L;
	private String resNo    ; //예약내역고유번호
	private String userId        ; //사용자아이디
	private String shopPid      ; //매장등록번호
	private Date rDate  ;//예약날짜
	private String rTime  ;//예약시간
	private int mNo       ;//메뉴번호
//	private int mprice    ;//메뉴가격
	private String acceptYN     ;//수락여부
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reservation(String resNo, String userId, String shopPid, Date rDate, String rTime, int mNo, String acceptYN) {
		super();
		this.resNo = resNo;
		this.userId = userId;
		this.shopPid = shopPid;
		this.rDate = rDate;
		this.rTime = rTime;
		this.mNo = mNo;
		this.acceptYN = acceptYN;
	}
	public String getResNo() {
		return resNo;
	}
	public void setResNo(String resNo) {
		this.resNo = resNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getShopPid() {
		return shopPid;
	}
	public void setShopPid(String shopPid) {
		this.shopPid = shopPid;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public String getrTime() {
		return rTime;
	}
	public void setrTime(String rTime) {
		this.rTime = rTime;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getAcceptYN() {
		return acceptYN;
	}
	public void setAcceptYN(String acceptYN) {
		this.acceptYN = acceptYN;
	}
	@Override
	public String toString() {
		return "Reservation [resNo=" + resNo + ", userId=" + userId + ", shopPid=" + shopPid + ", rDate=" + rDate
				+ ", rTime=" + rTime + ", mNo=" + mNo + ", acceptYN=" + acceptYN + "]";
	}
	
}
