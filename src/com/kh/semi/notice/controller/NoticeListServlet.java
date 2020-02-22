package com.kh.semi.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.notice.model.service.NoticeService;
import com.kh.semi.notice.model.vo.Notice;
import com.kh.semi.notice.model.vo.PageInfo;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/nselectList.no")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지사항 리스트 출력
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		NoticeService ns = new NoticeService();
		// 페이지 처리
		int startPage; // 가장 앞 페이지
		int endPage; // 가장 뒷 페이지
		int maxPage; // 가장 마지막 페이지
		int currentPage; // 사용자 현재 페이지
		int limit; // 총 페이지 수 ( 한페이지당 보여줄 게시글 수)
		
		currentPage = 1;
		
		limit = 10;
		
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = ns.getListCount();
		
		maxPage = (int)((double)listCount/limit+0.9);
		
		startPage = ((currentPage-1)/limit)*limit+1;// ((int)((double)currentPage/limit+0.9)-1)*limit+1;
		
		endPage = startPage + limit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		// 페이지 처리
		
		list = ns.selectList(currentPage,limit);
		
		HttpSession session = request.getSession();
		
		Member mem = (Member)session.getAttribute("member");
		
		String page="";
		
		if(list != null) {
			
			page = "views/notice_5.jsp";
			request.setAttribute("list", list);
			
			PageInfo pi = new PageInfo(currentPage, listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("pi", pi);
			
		}else {
			request.setAttribute("msg", "공지사항 목록 불러오기 에러 ");
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
