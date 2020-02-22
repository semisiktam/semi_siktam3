package com.kh.semi.black.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.black.model.service.BlackService;
import com.kh.semi.black.model.vo.BlackList;
import com.kh.semi.black.model.vo.BlackPageInfo;

/**
 * Servlet implementation class BlackListServlet
 */
@WebServlet("/bList.bl")
public class BlackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlackListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BlackList> list = new ArrayList<BlackList>();
		BlackService bs = new BlackService();
		
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		currentPage = 1;
		limit = 10;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = bs.getListCount();
		
		System.out.println("전체 회원수 : " + listCount);
		
		maxPage = (int)((double)listCount/limit + 0.9);
		startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
		endPage = startPage + limit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = bs.selectList(currentPage, limit);
		
		String page = "";
		if(list!=null) {
			page="views/admin_blackList_4.jsp";
			request.setAttribute("list", list);
			
			BlackPageInfo bpi = new BlackPageInfo(currentPage, listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("bpi", bpi);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "블랙리스트 조회 실패");
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
