package com.kh.semi.black.model.vo;

import java.io.Serializable;
import java.util.Date;

public class BlackList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3550295093482221301L;
	private String bno;
	private String userId;
	private Date banDate;
	private String banTerm;
	private String banReason;
	
	public BlackList() {}

	
	public BlackList(String userId, String banTerm, String banReason) {
		super();
		this.userId = userId;
		this.banTerm = banTerm;
		this.banReason = banReason;
	}

	public BlackList(String bno, String userId, Date banDate, String banTerm, String banReason) {
		super();
		this.bno = bno;
		this.userId = userId;
		this.banDate = banDate;
		this.banTerm = banTerm;
		this.banReason = banReason;
	}

	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBanDate() {
		return banDate;
	}

	public void setBanDate(Date banDate) {
		this.banDate = banDate;
	}

	public String getBanTerm() {
		return banTerm;
	}

	public void setBanTerm(String banTerm) {
		this.banTerm = banTerm;
	}

	public String getBanReason() {
		return banReason;
	}

	public void setBanReason(String banReason) {
		this.banReason = banReason;
	}

	@Override
	public String toString() {
		return "BlackList [bno=" + bno + ", userId=" + userId + ", banDate=" + banDate + ", banTerm=" + banTerm
				+ ", banReason=" + banReason + "]";
	}
	
	
}
