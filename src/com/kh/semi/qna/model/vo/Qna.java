package com.kh.semi.qna.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Qna implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5783420113925221129L;

	private int qNo; // qna글번호
	private String userId   ; // 사용자아이디
	private String qTitle   ; // 글제목
	private String qContext ; // 글내용
	private String qReply   ; // 답변
	private Date qDate;		  // 작성일

	public Qna() {
		super();
	}
	
	public Qna(String userId,String qTitle, String qContext) {
		this.userId = userId;
		this.qTitle = qTitle;
		this.qContext = qContext;
	}
	
	public Qna(int qNo, String userId, String qTitle, String qContext, String qReply, Date qDate) {
		super();
		this.qNo = qNo;
		this.userId = userId;
		this.qTitle = qTitle;
		this.qContext = qContext;
		this.qReply = qReply;
		this.qDate = qDate;
	}
	public Date getqDate() {
		return qDate;
	}
	public void setqDate(Date qDate) {
		this.qDate = qDate;
	}
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqContext() {
		return qContext;
	}
	public void setqContext(String qContext) {
		this.qContext = qContext;
	}
	public String getqReply() {
		return qReply;
	}
	public void setqReply(String qReply) {
		this.qReply = qReply;
	}
	@Override
	public String toString() {
		return "Qna [qNo=" + qNo + ", userId=" + userId + ", qTitle=" + qTitle + ", qContext=" + qContext + ", qReply="
				+ qReply + "]";
	}
	
	
}
