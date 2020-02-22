package com.kh.semi.filecategory.model.vo;

import java.io.Serializable;

public class Filecategory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -150808312482028855L;
	private int boardNo; //게시판번호
	private String boardType; //게시판구분
	public Filecategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filecategory(int boardNo, String boardType) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Filecategory [boardNo=" + boardNo + ", boardType=" + boardType + "]";
	}
	
}
