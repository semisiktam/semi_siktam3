package com.kh.semi.reservation.model.vo;

import java.io.Serializable;

public class ReservationTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8036960503602690875L;
	private String userId;
	private String shopPid;
	private String shopName;
	private String shopAddr;
	private String shopDay;
	private String shopStartTime;
	private String shopEndTime;
	private String menuName;
	private String menuImg;
	private int menuPrice;
	private int menuCount;
	private int total;
	
	public ReservationTest() {}
	
	public ReservationTest(String userId, String shopPid,String shopName, String shopAddr, String shopDay, String shopStartTime,
			String shopEndTime, String menuName, String menuImg, int menuPrice, int menuCount, int total) {
		super();
		this.userId = userId;
		this.shopPid = shopPid;
		this.shopName = shopName;
		this.shopAddr = shopAddr;
		this.shopDay = shopDay;
		this.shopStartTime = shopStartTime;
		this.shopEndTime = shopEndTime;
		this.menuName = menuName;
		this.menuImg = menuImg;
		this.menuPrice = menuPrice;
		this.menuCount = menuCount;
		this.total = total;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public String getShopDay() {
		return shopDay;
	}

	public void setShopDay(String shopDay) {
		this.shopDay = shopDay;
	}

	public String getShopStartTime() {
		return shopStartTime;
	}

	public void setShopStartTime(String shopStartTime) {
		this.shopStartTime = shopStartTime;
	}

	public String getShopEndTime() {
		return shopEndTime;
	}

	public void setShopEndTime(String shopEndTime) {
		this.shopEndTime = shopEndTime;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
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
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ReservationTest [userId=" + userId + ", shopPid=" + shopPid + ", shopName=" + shopName + ", shopAddr="
				+ shopAddr + ", shopDay=" + shopDay + ", shopStartTime=" + shopStartTime + ", shopEndTime="
				+ shopEndTime + ", menuName=" + menuName + ", menuImg=" + menuImg + ", menuPrice=" + menuPrice
				+ ", menuCount=" + menuCount + ", total=" + total + "]";
	}

	

	
	
}

