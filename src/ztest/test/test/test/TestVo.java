package ztest.test.test.test;

import java.io.Serializable;
import java.sql.Date;

public class TestVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3610032680795665474L;
	
	private String resNo;//예약번호: 고유키
	private String userId;//:유저아이디==>를 이용하여 이름과 핸드폰 번호 추출
	private String shopPid;//:세션에 등록된 업주의 아이디로 pid와 shopName추출
	private Date rDate;
	private String rTime;
	private String menuNo;
	private int totalPay;
	private String acceptYN;
	
	@Override
	public String toString() {
		return "TestVo [resNo=" + resNo + ", userId=" + userId + ", shopPid=" + shopPid + ", rDate=" + rDate
				+ ", rTime=" + rTime + ", menuNo=" + menuNo + ", totalPay=" + totalPay + ", acceptYN=" + acceptYN + "]";
	}
	public TestVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestVo(String resNo, String userId, String shopPid, Date rDate, String rTime, String menuNo, int totalPay,
			String acceptYN) {
		super();
		this.resNo = resNo;
		this.userId = userId;
		this.shopPid = shopPid;
		this.rDate = rDate;
		this.rTime = rTime;
		this.menuNo = menuNo;
		this.totalPay = totalPay;
		this.acceptYN = acceptYN;
	}
	public String getResNo() {
		return resNo;
	}
	public void setResNo(String resNo) {
		this.resNo = resNo;
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
	
}
