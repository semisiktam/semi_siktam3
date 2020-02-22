package com.kh.semi.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Notice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6910103580620084685L;
	
	private int nNo     ; //notice번호
	private String nTitle  ; //제목
	private String nWriter ; //작성자
	private Date nDate   ; //작성일
	private int nCount  ; //조회수
	private String nContext; //글내용
	
	
	public Notice() {
	}
	
	public Notice(int nNo, String nTitle, String nContext) {
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nContext = nContext;
	}
	
	public Notice(String nWriter, String nTitle, String nContext) {
		this.nWriter = nWriter;
		this.nTitle = nTitle;
		this.nContext = nContext;
	}
	
	/**
	 * 전체 생성자
	 * @param nNo
	 * @param nTitle
	 * @param nWriter
	 * @param nDate
	 * @param nCount
	 * @param nContext
	 */
	public Notice(int nNo, String nTitle, String nWriter, Date nDate, int nCount, String nContext) {
		super();
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nWriter = nWriter;
		this.nDate = nDate;
		this.nCount = nCount;
		this.nContext = nContext;
	}
	/**
	 * 공지사항 띄우기용
	 * @param nNo
	 * @param nTitle
	 * @param nWriter
	 * @param nDate
	 * @param nCount
	 */
	public Notice(int nNo, String nTitle, String nWriter, Date nDate, int nCount) {
		super();
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nWriter = nWriter;
		this.nDate = nDate;
		this.nCount = nCount;
	}
	public int getnNo() {
		return nNo;
	}
	public void setnNo(int nNo) {
		this.nNo = nNo;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnWriter() {
		return nWriter;
	}
	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}
	public Date getnDate() {
		return nDate;
	}
	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}
	public int getnCount() {
		return nCount;
	}
	public void setnCount(int nCount) {
		this.nCount = nCount;
	}
	public String getnContext() {
		return nContext;
	}
	public void setnContext(String nContext) {
		this.nContext = nContext;
	}
	@Override
	public String toString() {
		return "Notice [nNo=" + nNo + ", nTitle=" + nTitle + ", nWriter=" + nWriter + ", nDate=" + nDate + ", nCount="
				+ nCount + ", nContext=" + nContext + "]";
	}
	
}
