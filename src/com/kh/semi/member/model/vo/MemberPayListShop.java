package com.kh.semi.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class MemberPayListShop implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1079694966553308236L;
	private String resNo    ; //예약내역고유번호
	private String shopPid      ; //매장등록번호
	private String mNo       ;//메뉴번호
	private String pNo;       //결제번호
	private String sAddr;     //매장주소
	private String menuImg; //매뉴이미지
	private int menuPrice; //메뉴가격
	private int menuCount; //메뉴개수
	private String sStartTime; // 매장 시작시간
	private String sEndTime; //매장 종료시간
	private String sDay; //매장휴무일
	private String shopName; //매장명
	private Date rDate  ;//예약날짜
	private String rTime  ;//예약시간
	private String menuName    ; //메뉴명
	private String acceptYN     ;//수락여부
	private String payType; // 결제방식
	private int totalPay; // 총 결제금액
	private String userName; //사용자 이름
	
	public MemberPayListShop(String resNo, String shopPid, String mNo, String pNo, String sAddr, String menuImg,
			int menuPrice, int menuCount, String sStartTime, String sEndTime, String sDay, String shopName, Date rDate,
			String rTime, String menuName, String acceptYN, String payType, int totalPay) {
		super();
		this.resNo = resNo;
		this.shopPid = shopPid;
		this.mNo = mNo;
		this.pNo = pNo;
		this.sAddr = sAddr;
		this.menuImg = menuImg;
		this.menuPrice = menuPrice;
		this.menuCount = menuCount;
		this.sStartTime = sStartTime;
		this.sEndTime = sEndTime;
		this.sDay = sDay;
		this.shopName = shopName;
		this.rDate = rDate;
		this.rTime = rTime;
		this.menuName = menuName;
		this.acceptYN = acceptYN;
		this.payType = payType;
		this.totalPay = totalPay;
	}
	
	

	public MemberPayListShop() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MemberPayListShop(String resNo, String shopPid, String mNo, String pNo, Date rDate, String payType,
			int totalPay, String userName) {
		super();
		this.resNo = resNo;
		this.shopPid = shopPid;
		this.mNo = mNo;
		this.pNo = pNo;
		this.rDate = rDate;
		this.payType = payType;
		this.totalPay = totalPay;
		this.userName = userName;
	}



	public String getResNo() {
		return resNo;
	}

	public void setResNo(String resNo) {
		this.resNo = resNo;
	}

	public String getShopPid() {
		return shopPid;
	}

	public void setShopPid(String shopPid) {
		this.shopPid = shopPid;
	}

	public String getmNo() {
		return mNo;
	}

	public void setmNo(String mNo) {
		this.mNo = mNo;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getsAddr() {
		return sAddr;
	}

	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getMenuCount() {
		return menuCount;
	}

	public void setMenuCount(int menuCount) {
		this.menuCount = menuCount;
	}

	public String getsStartTime() {
		return sStartTime;
	}

	public void setsStartTime(String sStartTime) {
		this.sStartTime = sStartTime;
	}

	public String getsEndTime() {
		return sEndTime;
	}

	public void setsEndTime(String sEndTime) {
		this.sEndTime = sEndTime;
	}

	public String getsDay() {
		return sDay;
	}

	public void setsDay(String sDay) {
		this.sDay = sDay;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getAcceptYN() {
		return acceptYN;
	}

	public void setAcceptYN(String acceptYN) {
		this.acceptYN = acceptYN;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public int getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "MemberPayListShop [resNo=" + resNo + ", shopPid=" + shopPid + ", mNo=" + mNo + ", pNo=" + pNo
				+ ", sAddr=" + sAddr + ", menuImg=" + menuImg + ", menuPrice=" + menuPrice + ", menuCount=" + menuCount
				+ ", sStartTime=" + sStartTime + ", sEndTime=" + sEndTime + ", sDay=" + sDay + ", shopName=" + shopName
				+ ", rDate=" + rDate + ", rTime=" + rTime + ", menuName=" + menuName + ", acceptYN=" + acceptYN
				+ ", payType=" + payType + ", totalPay=" + totalPay + ", userName=" + userName + "]";
	}
	
	
	
	

}
