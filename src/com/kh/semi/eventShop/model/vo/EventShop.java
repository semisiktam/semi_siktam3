package com.kh.semi.eventShop.model.vo;

import java.io.Serializable;

public class EventShop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4403830760964526767L;
	private String eventNo; // 이벤트 번호
	private String shopPid;// 매장등록번호
	
	public EventShop() {
	}

	public EventShop(String eventNo, String shopPid) {
		super();
		this.eventNo = eventNo;
		this.shopPid = shopPid;
	}

	public EventShop(String shopPid) {
		super();
		this.shopPid = shopPid;
	}

	public String getEventNo() {
		return eventNo;
	}

	public void setEventNo(String eventNo) {
		this.eventNo = eventNo;
	}

	public String getShopPid() {
		return shopPid;
	}

	public void setShopPid(String shopPid) {
		this.shopPid = shopPid;
	}

	@Override
	public String toString() {
		return "EventShop [eventNo=" + eventNo + ", shopPid=" + shopPid + "]";
	}
	
	
	
	
	
}
