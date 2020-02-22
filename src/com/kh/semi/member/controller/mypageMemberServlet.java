package com.kh.semi.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.service.MemberService;
import com.kh.semi.member.model.vo.Member;
import com.kh.semi.member.model.vo.MemberReservationList;
import com.kh.semi.mypageFavorite.model.service.mypageFavoriteService;
import com.kh.semi.shop.model.vo.Shop;

/**
 * Servlet implementation class selectUserReservServlet
 */
@WebServlet("/mypageMember.mm")
public class mypageMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mypageMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Member m=(Member)session.getAttribute("member");
		
		ArrayList<MemberReservationList> mrList= new ArrayList<MemberReservationList>();
		MemberService ms = new MemberService();	
		mrList = ms.selectUserReserve(m.getUserId());

		String page = "";
		
		// 서지가 해본다
		ArrayList<Shop> fsList = new ArrayList<Shop>();
		fsList = ms.selectFSList(m.getUserId());
		
		System.out.println(mrList);
		System.out.println(fsList);
		

		
		if(mrList!=null) {
			page = "views/mypagePerson_5.jsp";
			request.setAttribute("mrList", mrList);	
			request.setAttribute("fsList", fsList);
		}else {
			request.setAttribute("msg", "예약내역 불러오기 에러 ");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
		// 탐희 즐겨찾기 > 오류
//		ArrayList<Shop> favorShopList = new ArrayList<Shop>();
//		mypageFavoriteService mfs = new mypageFavoriteService();
//		favorShopList = mfs.selectFavoriteShop(m.getUserId());
//		System.out.println(favorShopList);
		
//		if(favorShopList!=null) {
//			page = "views/mypagePerson_5.jsp";
//			request.setAttribute("favorShopList", favorShopList);
//		}else {
//			request.setAttribute("msg", "예약내역 불러오기 에러 ");
//		}

		
		/*
		 * 타미 json > 실패
		 * JSONObject userInfo = null;
		JSONArray result = new JSONArray();
		
		for(MemberReservationList user : mrList) {
			userInfo = new JSONObject();
			
			userInfo.put("shopName", user.getShopName());
			userInfo.put("rDate", user.getrDate());
			userInfo.put("rTime", user.getrTime());
			userInfo.put("menu", user.getMenuName());
			userInfo.put("acceptYn", user.getAcceptYN());
			
			result.add(userInfo);
		}
		
		response.getWriter().print(result.toJSONString());*/
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
