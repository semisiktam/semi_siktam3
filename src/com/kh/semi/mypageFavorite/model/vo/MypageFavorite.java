package com.kh.semi.mypageFavorite.model.vo;

import java.io.Serializable;

public class MypageFavorite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2075124048794260879L;
	private String userId; //사용자아이디
	private String shopPid; //매장등록번호
	public MypageFavorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MypageFavorite(String userId, String shopPid) {
		super();
		this.userId = userId;
		this.shopPid = shopPid;
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
	@Override
	public String toString() {
		return "MypageFavorite [userId=" + userId + ", shopPid=" + shopPid + "]";
	}
	
}
