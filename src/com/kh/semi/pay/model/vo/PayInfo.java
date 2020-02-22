package com.kh.semi.pay.model.vo;

import java.io.Serializable;

public class PayInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5335010840198086515L;
	private String rshopName;
	private String rshopAddr;
	private String rmenuName;
	private String rmenuCount;
	private String rmenuPrice;
	private int totalPay;
	
	public PayInfo(){}

	public PayInfo(String rshopName, String rshopAddr, String rmenuName, String rmenuCount, String rmenuPrice,
			int totalPay) {
		super();
		this.rshopName = rshopName;
		this.rshopAddr = rshopAddr;
		this.rmenuName = rmenuName;
		this.rmenuCount = rmenuCount;
		this.rmenuPrice = rmenuPrice;
		this.totalPay = totalPay;
	}

	public String getRshopName() {
		return rshopName;
	}

	public void setRshopName(String rshopName) {
		this.rshopName = rshopName;
	}

	public String getRshopAddr() {
		return rshopAddr;
	}

	public void setRshopAddr(String rshopAddr) {
		this.rshopAddr = rshopAddr;
	}

	public String getRmenuName() {
		return rmenuName;
	}

	public void setRmenuName(String rmenuName) {
		this.rmenuName = rmenuName;
	}

	public String getRmenuCount() {
		return rmenuCount;
	}

	public void setRmenuCount(String rmenuCount) {
		this.rmenuCount = rmenuCount;
	}

	public String getRmenuPrice() {
		return rmenuPrice;
	}

	public void setRmenuPrice(String rmenuPrice) {
		this.rmenuPrice = rmenuPrice;
	}

	public int getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PayInfo [rshopName=" + rshopName + ", rshopAddr=" + rshopAddr + ", rmenuName=" + rmenuName
				+ ", rmenuCount=" + rmenuCount + ", rmenuPrice=" + rmenuPrice + ", totalPay=" + totalPay + "]";
	}
	
	
	
}
