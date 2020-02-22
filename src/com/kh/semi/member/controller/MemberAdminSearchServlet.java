package com.kh.semi.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.model.service.MemberService;
import com.kh.semi.member.model.vo.Member;
import com.kh.semi.member.model.vo.MemberPageInfo;

/**
 * Servlet implementation class MemberAdminSearchServlet
 */
@WebServlet("/mAdminSearch.me")
public class MemberAdminSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAdminSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("con");
		String keyword = request.getParameter("keyword");
		
		MemberService ms = new MemberService();
		ArrayList<Member> list = new ArrayList<>();
		
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
		
		int listCount = ms.getListCount(category, keyword);
		
		System.out.println("해당 회원수 : " + listCount);
		
		maxPage = (int)((double)listCount/limit + 0.9);
		startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
		endPage = startPage + limit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = ms.mAdminSearch(category, keyword, currentPage, limit);
		
		String page = "";
		if(list != null) {
			page="views/admin_memberList_4.jsp";
			request.setAttribute("list", list);
			
			MemberPageInfo mpi = new MemberPageInfo(currentPage, listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("mpi", mpi);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 목록 조회 실패");
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
