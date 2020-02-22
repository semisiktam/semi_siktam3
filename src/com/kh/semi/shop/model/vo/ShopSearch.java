package com.kh.semi.shop.model.vo;

import java.io.Serializable;

public class ShopSearch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2113878173480294859L;
	
	private double star;
	private int reviewCount;
	private int reservationCount;
	private String shopPid;
	private String shopImg;
	private String shopName;
	private String shopAddr;
	private String tableType;
	private String MenuCategory;
	private String MainMenu;
	
	public ShopSearch(){}

	public ShopSearch(double star, int reviewCount, int reservationCount, String shopPid, String shopImg,
			String shopName, String shopAddr, String tableType, String menuCategory, String mainMenu) {
		super();
		this.star = star;
		this.reviewCount = reviewCount;
		this.reservationCount = reservationCount;
		this.shopPid = shopPid;
		this.shopImg = shopImg;
		this.shopName = shopName;
		this.shopAddr = shopAddr;
		this.tableType = tableType;
		this.MenuCategory = menuCategory;
		this.MainMenu = mainMenu;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getReservationCount() {
		return reservationCount;
	}

	public void setReservationCount(int reservationCount) {
		this.reservationCount = reservationCount;
	}

	public String getShopPid() {
		return shopPid;
	}

	public void setShopPid(String shopPid) {
		this.shopPid = shopPid;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
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

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public String getMenuCategory() {
		return MenuCategory;
	}

	public void setMenuCategory(String menuCategory) {
		MenuCategory = menuCategory;
	}

	public String getMainMenu() {
		return MainMenu;
	}

	public void setMainMenu(String mainMenu) {
		MainMenu = mainMenu;
	}

	@Override
	public String toString() {
		return "ShopSearch [star=" + star + ", reviewCount=" + reviewCount + ", reservationCount=" + reservationCount
				+ ", shopPid=" + shopPid + ", shopImg=" + shopImg + ", shopName=" + shopName + ", shopAddr=" + shopAddr
				+ ", tableType=" + tableType + ", MenuCategory=" + MenuCategory + ", MainMenu=" + MainMenu + "]";
	}
	
	
}
