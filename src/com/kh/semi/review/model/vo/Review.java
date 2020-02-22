package com.kh.semi.review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable {             
	/**
	 * 
	 */
	private static final long serialVersionUID = 2834416249344370030L;
	private String rNo         ; //리뷰번호
	private String userId         ; //사용자아이디
	private String shopPid       ; //매장등록번호
	private String rContent ; //리뷰내용
	private String reviewImg     ; //리뷰이미지
	private int score             ; //별점
	private Date rDate      ; //작성일
	
	
	public Review() {
		super();
	}
	public Review(String rNo, String userId, String shopPid, String rContent, String reviewImg, int score, Date rDate) {
		super();
		this.rNo = rNo;
		this.userId = userId;
		this.shopPid = shopPid;
		this.rContent = rContent;
		this.reviewImg = reviewImg;
		this.score = score;
		this.rDate = rDate;
		
	}
	public String getrNo() {
		return rNo;
	}
	public void setrNo(String rNo) {
		this.rNo = rNo;
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
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	
	@Override
	public String toString() {
		return "Review [rNo=" + rNo + ", userId=" + userId + ", shopPid=" + shopPid + ", rContent=" + rContent
				+ ", reviewImg=" + reviewImg + ", score=" + score + ", rDate=" + rDate + "]";
	}
	
}
