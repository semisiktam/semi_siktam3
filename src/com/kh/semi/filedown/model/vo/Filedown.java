package com.kh.semi.filedown.model.vo;

import java.io.Serializable;

public class Filedown implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 867452455309528685L;
	private String fileNo; //파일고유번호
	private int boardNo; //게시판번호
	private String fileName; //파일명
	public Filedown() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filedown(String fileNo, int boardNo, String fileName) {
		super();
		this.fileNo = fileNo;
		this.boardNo = boardNo;
		this.fileName = fileName;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "Filedown [fileNo=" + fileNo + ", boardNo=" + boardNo + ", fileName=" + fileName + "]";
	}
	
}
