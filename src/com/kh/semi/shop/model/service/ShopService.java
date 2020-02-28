package com.kh.semi.shop.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.member.model.vo.MemberPayListShop;
import com.kh.semi.shop.model.dao.ShopDao;
import com.kh.semi.shop.model.vo.Shop;
import com.kh.semi.shop.model.vo.ShopSearch;

public class ShopService {
	private ShopDao sDao;
	public ShopService(){
		sDao= new ShopDao();
	}

	/**
	 * 메인 페이지 검색
	 * @param keyword
	 * @return
	 */
	public ArrayList<ShopSearch> searchMain(String keyword) {
		Connection con = getConnection();
		 
		ArrayList<ShopSearch> list = null;
		
		
			list=new ArrayList<ShopSearch>();
			list = sDao.searchMain(con,keyword);
		
		close(con);
		
		return list;
	}

	public ArrayList<ShopSearch> SearchCondition(String keyword, String line, String[] tlist, String[] clist, String[] plist) {
		Connection con = getConnection();
		
		ArrayList<ShopSearch> list = sDao.SearchCondition(con,keyword,line,tlist,clist,plist);
		
		close(con);
		return list;
	}

	public int insertShop(Shop s) {
		int result=0;
		Connection con= getConnection();
		result=sDao.insertShop(con,s);
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
		
	}

	public ArrayList<Shop> selectList(String userId) {
		
		Connection con=getConnection();
		
		ArrayList<Shop> s=new ShopDao().selectList(con,userId);
		close(con);
		return s;
	}

	
	
	public Shop selectOne(String shopPid) {
		
		Connection con = getConnection();
		
		Shop s = sDao.selectOne(con,shopPid);
		
		close(con);
		
		return s;
	}

	/**
	 * 전체 업체수 조회
	 * @return
	 */
	public int getListCount() {
		Connection con = getConnection();

		int listCount = sDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}


	/**
	 * 관리자에서 업체리스트 조회
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	public ArrayList<Shop> shopAdminList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Shop> list = new ShopDao().shopAdminList(con, currentPage, limit);
		
		close(con);
		
		return list;
	}

	/**
	 * 관리자에서 매장정보 수정
	 * @param s
	 * @return
	 */
	public int updateAdminShop(Shop s) {
		Connection con = getConnection();
		
		int result = new ShopDao().updateAdminShop(con, s);
		
		System.out.println("서비스" + result);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	/**
	 * 마이페이지(개인) 최근 들여다본 기록 넣기
	 * @param userId
	 * @param shopPid
	 * @return
	 */
	public int shopRecordInsert(String userId, String shopPid) {
		Connection con = getConnection();
		
		int result = new ShopDao().shopRecordInsert(con,userId,shopPid);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

	/**
	 * 마이페이지(개인) 최근 들여다본 기록 갖고오기
	 * @param userId
	 * @return
	 */
	public ArrayList<Shop> SelectShopRecentRecord(String userId) {
		Connection con = getConnection();
		
		ArrayList<Shop> recordShop = new ShopDao().SelectShopRecentRecord(con,userId);
		
		close(con);
		return recordShop;
	}

	/**
	 * 탐희 즐겨찾기 등록하기
	 * @param userId
	 * @param shopPid
	 * @return
	 */
	public int shopFavoriteInsert(String userId, String shopPid) {
		Connection con = getConnection();
		
		int result = new ShopDao().shopFavoriteInsert(con,userId,shopPid);
		
		if(result>0)commit(con);
		else rollback(con);
		return result;
	}

	/**
	 * 탐희 즐겨찾기 삭제하기
	 * @param userId
	 * @param shopPid
	 * @return
	 */
	public int shopFavoriteDelete(String userId, String shopPid) {
		Connection con = getConnection();
		
		int result = new ShopDao().shopFavoriteDelete(con,userId,shopPid);
		
		if(result>0)commit(con);
		else rollback(con);
		return result;
	}

	/**
	 * 탐희 마이페이지(업체) 결제내역 불러오기
	 * @param userId
	 * @return
	 */
	public ArrayList<MemberPayListShop> shopPayList(String userId) {
		Connection con = getConnection();
		
		ArrayList<MemberPayListShop> shopPayList = new ShopDao().shopPayList(con,userId);
		
		close(con);
		return shopPayList;
	}

 
} 
