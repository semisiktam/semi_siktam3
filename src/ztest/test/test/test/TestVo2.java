package ztest.test.test.test;

import java.io.Serializable;
import java.sql.Date;

public class TestVo2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8309032172784233267L;
	private String resNo;
	private String shopName;//
	private String userId;
	private String userName;//
	private String userPhone;//
	private String shopPid;
	private Date rDate;
	private String rTime;
	private String menuNo;
	private int totalPay;
	private String acceptYN;
	
	@Override
	public String toString() {
		return "TestVo2 [resNo=" + resNo + ", shopName=" + shopName + ", userId=" + userId + ", userName=" + userName
				+ ", userPhone=" + userPhone + ", shopPid=" + shopPid + ", rDate=" + rDate + ", rTime=" + rTime
				+ ", menuNo=" + menuNo + ", totalPay=" + totalPay + ", acceptYN=" + acceptYN + "]";
	}

	public String getResNo() {
		return resNo;
	}

	public void setResNo(String resNo) {
		this.resNo = resNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getShopPid() {
		return shopPid;
	}

	public void setShopPid(String shopPid) {
		this.shopPid = shopPid;
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

	public String getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}

	public int getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}

	public String getAcceptYN() {
		return acceptYN;
	}

	public void setAcceptYN(String acceptYN) {
		this.acceptYN = acceptYN;
	}

	public TestVo2(String resNo, String shopName, String userId, String userName, String userPhone, String shopPid,
			Date rDate, String rTime, String menuNo, int totalPay, String acceptYN) {
		super();
		this.resNo = resNo;
		this.shopName = shopName;
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.shopPid = shopPid;
		this.rDate = rDate;
		this.rTime = rTime;
		this.menuNo = menuNo;
		this.totalPay = totalPay;
		this.acceptYN = acceptYN;
	}

	public TestVo2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
