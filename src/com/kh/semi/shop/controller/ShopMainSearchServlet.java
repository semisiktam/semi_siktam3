package com.kh.semi.shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.shop.model.service.ShopService;
import com.kh.semi.shop.model.vo.ShopSearch;

/**
 * Servlet implementation class ShopMainSearchServlet
 */
@WebServlet("/searchMain.sc")
public class ShopMainSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopMainSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2020-02-11 2020-02-11 현희 수정(서치기능)
		
		// 검색
		String keyword = request.getParameter("keyword");
		
		if(keyword == null || keyword =="") {
			keyword = null;
		}
		
		System.out.print(keyword);
		ArrayList<ShopSearch> list = new ArrayList<ShopSearch>();
		
		ShopService ss = new ShopService();
		
		list = ss.searchMain(keyword);
		
		//--------------------------------------------------------------
		
		String page = "";
		
//		System.out.println(list.isEmpty());
		
		if(list != null) { 
			page = "views/searchConditions_4.jsp";
			request.setAttribute("list", list);
			request.setAttribute("skeyword", keyword);
		}else {
			page = "views/errorPage.jsp";
			request.setAttribute("msg", "지역 검색에 실패했답니다~");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
		// 2020-02-11 2020-02-11 현희 수정(서치기능)
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
