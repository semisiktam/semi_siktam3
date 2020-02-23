package com.kh.semi.coupon.model.vo;

import java.io.Serializable;

import org.apache.tomcat.jdbc.pool.interceptor.SlowQueryReportJmxMBean;

public class discount implements Serializable{

	private int mile;
	private int totalPay;
	
	public discount() {}
	
	public discount(int mile, int totalPay) {
		super();
		this.mile = mile;
		this.totalPay = totalPay;
	}

	public int getMile() {
		return mile;
	}

	public void setMile(int mile) {
		this.mile = mile;
	}

	public int getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}

	@Override
	public String toString() {
		return "discount [mile=" + mile + ", totalPay=" + totalPay + "]";
	}
	
	
}
