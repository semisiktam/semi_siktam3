package com.kh.semi.shop.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Shop implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6769301326156610577L;
	private String shopPid      ;
	private String userId        ;
	private String shopName		;
	private String shopImg      ;
	private String sAddr     ;
	private String sPhone    ;
	private String sInfo     ;
	private String ownerId      ;
	private String sTime     ;//매장시작시간
	private String eTime	   ;//매장종료시간
	private String shopDay ;//휴무일
	private String menuCategory ;
	private String tableType    ;
	private int avgPay       ;
	private String outYn; //폐업유무
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(String shopPid, String userId, String shopName, String shopImg, String sAddr, String sPhone,
			String sInfo, String ownerId, String sTime, String eTime, String shopDay, String menuCategory, String tableType,
			int avgPay, String outYn) {
		super();
		this.shopPid = shopPid;
		this.userId = userId;
		this.shopName = shopName;
		this.shopImg = shopImg;
		this.sAddr = sAddr;
		this.sPhone = sPhone;
		this.sInfo = sInfo;
		this.ownerId = ownerId;
		this.sTime = sTime;
		this.eTime = eTime;
		this.shopDay = shopDay;
		this.menuCategory = menuCategory;
		this.tableType = tableType;
		this.avgPay = avgPay;
		this.outYn = outYn;
	}
	public Shop(String shopName,String userId, String shopImg, String sAddr, String sPhone, String sInfo, String ownerId,
			String shopDay, String menuCategory, String tableType) {
		super();
		this.shopName = shopName;
		this.userId=userId;
		this.shopImg = shopImg;
		this.sAddr = sAddr;
		this.sPhone = sPhone;
		this.sInfo = sInfo;
		this.ownerId = ownerId;
		this.shopDay = shopDay;
		this.menuCategory = menuCategory;
		this.tableType = tableType;
	}
	
	public Shop(String shopName,String userId, String shopImg, String sAddr, String sPhone, String sInfo, String ownerId,
			String sTime,String eTime,
			String shopDay, String menuCategory, String tableType) {
		super();
		this.sTime=sTime;
		this.eTime=eTime;
		this.shopName = shopName;
		this.userId=userId;
		this.shopImg = shopImg;
		this.sAddr = sAddr;
		this.sPhone = sPhone;
		this.sInfo = sInfo;
		this.ownerId = ownerId;
		this.shopDay = shopDay;
		this.menuCategory = menuCategory;
		this.tableType = tableType;
	}
	
	public String getShopPid() {
		return shopPid;
	}
	public void setShopPid(String shopPid) {
		this.shopPid = shopPid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public String getsAddr() {
		return sAddr;
	}
	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getsInfo() {
		return sInfo;
	}
	public void setsInfo(String sInfo) {
		this.sInfo = sInfo;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public String geteTime() {
		return eTime;
	}
	public void seteTime(String eTime) {
		this.eTime = eTime;
	}
	public String getShopDay() {
		return shopDay;
	}
	public void setShopDay(String shopDay) {
		this.shopDay = shopDay;
	}
	public String getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	public int getAvgPay() {
		return avgPay;
	}
	public void setAvgPay(int avgPay) {
		this.avgPay = avgPay;
	}
	public String getOutYn() {
		return outYn;
	}
	public void setOutYn(String outYn) {
		this.outYn = outYn;
	}
	@Override
	public String toString() {
		return "Shop [shopPid=" + shopPid + ", userId=" + userId + ", shopName=" + shopName + ", shopImg=" + shopImg
				+ ", sAddr=" + sAddr + ", sPhone=" + sPhone + ", sInfo=" + sInfo + ", ownerId=" + ownerId + ", sTime="
				+ sTime + ", eTime=" + eTime + ", shopDay=" + shopDay + ", menuCategory=" + menuCategory
				+ ", tableType=" + tableType + ", avgPay=" + avgPay + ", outYn=" + outYn + "]";
	}
	
}
