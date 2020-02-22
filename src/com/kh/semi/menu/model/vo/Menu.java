package com.kh.semi.menu.model.vo;

public class Menu {
	private String menuNo      ; //메뉴번호
	private String shopPid     ; //매장등록번호
	private String menuName    ; //메뉴명
	private String menuImg     ; //메뉴이미지
	private int menuPrice   ; //메뉴가격
	private String menuInfo    ; //메뉴설명
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(String shopPid, String menuName, String menuImg, int menuPrice, String menuInfo) {
		super();
		this.shopPid = shopPid;
		this.menuName = menuName;
		this.menuImg = menuImg;
		this.menuPrice = menuPrice;
		this.menuInfo = menuInfo;
	}
	public Menu(String menuNo, String shopPid, String menuName, String menuImg, int menuPrice, String menuInfo) {
		super();
		this.menuNo = menuNo;
		this.shopPid = shopPid;
		this.menuName = menuName;
		this.menuImg = menuImg;
		this.menuPrice = menuPrice;
		this.menuInfo = menuInfo;
	}
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public String getShopPid() {
		return shopPid;
	}
	public void setShopPid(String shopPid) {
		this.shopPid = shopPid;
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
	public String getMenuInfo() {
		return menuInfo;
	}
	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}
	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", shopPid=" + shopPid + ", menuName=" + menuName + ", menuImg=" + menuImg
				+ ", menuPrice=" + menuPrice + ", menuInfo=" + menuInfo + "]";
	}
	
}
