package com.kh.semi.black.model.vo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BlackList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7474943525142290561L;
	private String bno;
	private String userId;
	private Date banDate;
	private String banTerm;
	private long remainTerm;
	private String endDate;
	private String banReason;
	


	public BlackList() {}

	
	public BlackList(String userId, String banTerm, String banReason) {
		super();
		this.userId = userId;
		this.banTerm = banTerm;
		this.banReason = banReason;
	}

	public String getEndDate() {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(banDate);
		cal.add(Calendar.DATE, Integer.parseInt(banTerm));
		
		endDate = sdf.format(cal.getTime());
		
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public long getRemainTerm() {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date end = sdf.parse(endDate);
			Date current = new Date();
			
			long calDate = end.getTime() - current.getTime();
			remainTerm = calDate / (24*60*60*1000);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		return remainTerm;
	}
	
	
	public void setRemainTerm(long remainTerm) {
		this.remainTerm = remainTerm;
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
