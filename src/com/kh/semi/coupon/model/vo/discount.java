package com.kh.semi.coupon.model.vo;

import java.io.Serializable;

import org.apache.tomcat.jdbc.pool.interceptor.SlowQueryReportJmxMBean;

public class discount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2232800806132093458L;
	
	private int mile;
	private int useMile;
	private int getMile;
	private int totalPay;
	
	public discount() {}
	
	public discount(int mile, int useMile, int getMile, int totalPay) {
		super();
		this.mile = mile;
		this.useMile = useMile;
		this.getMile = getMile;
		this.totalPay = totalPay;
	}
	public int getMile() {
		return mile;
	}
	public void setMile(int mile) {
		this.mile = mile;
	}
	public int getUseMile() {
		return useMile;
	}
	public void setUseMile(int useMile) {
		this.useMile = useMile;
	}
	public int getGetMile() {
		return getMile;
	}
	public void setGetMile(int getMile) {
		this.getMile = getMile;
	}
	public int getTotalPay() {
		return totalPay;
	}
	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}
	@Override
	public String toString() {
		return "discount [mile=" + mile + ", useMile=" + useMile + ", getMile=" + getMile + ", totalPay=" + totalPay
				+ "]";
	}

	
}
