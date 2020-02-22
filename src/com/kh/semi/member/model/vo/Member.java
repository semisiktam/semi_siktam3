package com.kh.semi.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2502439390240888474L;
	
	private String userId       ; //사용자아이디
	private String password     ; //비밀번호 
	private String addr      	; //주소
	private String name         ; //이름
	private String pid          ; //주민번호
	private String phone        ; //핸드폰번호
	private String shopYN      	; //업체유무
	private int mileage      	; //마일리지
	private int couponNo    	; //쿠폰번호
	private String blackYN    	; //블랙리스트유무
	private String outYN       	; //회원유무
	private Date enrolldate   	; //가입일
	
	public Member() {}

	public Member(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public Member(String userId, String password, String addr, String name, String pid, String phone, String shopYN,
			int mileage, int couponNo, String blackYN, String outYN) {
		super();
		this.userId = userId;
		this.password = password;
		this.addr = addr;
		this.name = name;
		this.pid = pid;
		this.phone = phone;
		this.shopYN = shopYN;
		this.mileage = mileage;
		this.couponNo = couponNo;
		this.blackYN = blackYN;
		this.outYN = outYN;
	}

	public Member(String userId, String password, String addr, String name, String pid, String phone, String shopYN,
			int mileage, int couponNo, String blackYN, String outYN, Date enrolldate) {
		super();
		this.userId = userId;
		this.password = password;
		this.addr = addr;
		this.name = name;
		this.pid = pid;
		this.phone = phone;
		this.shopYN = shopYN;
		this.mileage = mileage;
		this.couponNo = couponNo;
		this.blackYN = blackYN;
		this.outYN = outYN;
		this.enrolldate = enrolldate;
	}

	
	
	public Member(String userId, String password, String addr, String name, String pid, String phone) {
		super();
		this.userId = userId;
		this.password = password;
		this.addr = addr;
		this.name = name;
		this.pid = pid;
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShopYN() {
		return shopYN;
	}

	public void setShopYN(String shopYN) {
		this.shopYN = shopYN;
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

	public String getBlackYN() {
		return blackYN;
	}

	public void setBlackYN(String blackYN) {
		this.blackYN = blackYN;
	}

	public String getOutYN() {
		return outYN;
	}

	public void setOutYN(String outYN) {
		this.outYN = outYN;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", addr=" + addr + ", name=" + name + ", pid="
				+ pid + ", phone=" + phone + ", shopYN=" + shopYN + ", mileage=" + mileage + ", couponNo=" + couponNo
				+ ", blackYN=" + blackYN + ", outYN=" + outYN + ", enrolldate=" + enrolldate + "]";
	}
}
