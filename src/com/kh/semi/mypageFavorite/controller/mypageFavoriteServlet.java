package com.kh.semi.mypageFavorite.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.mypageFavorite.model.service.mypageFavoriteService;
import com.kh.semi.shop.model.vo.Shop;

/**
 * Servlet implementation class mypageFavoriteServlet
 */
@WebServlet("/mypageFavorite.mf")
public class mypageFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mypageFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 즐겨찾기 form 새로 생성한 servlet
		
		HttpSession session = request.getSession();
		Member m=(Member)session.getAttribute("member");
		
		ArrayList<Shop> favorShopList = new ArrayList<Shop>();
		
		mypageFavoriteService mfs = new mypageFavoriteService();
		
		favorShopList = mfs.selectFavoriteShop(m.getUserId());
		
		String page = "";
		
		System.out.println(favorShopList);
		
		if(favorShopList!=null) {
		page = "views/mypagePerson_5.jsp";
		request.setAttribute("favorShopList", favorShopList);
		}else {
			request.setAttribute("msg", "예약내역 불러오기 에러 ");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
