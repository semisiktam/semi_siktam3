package com.kh.semi.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.qna.model.service.QnaService;
import com.kh.semi.qna.model.vo.QPageInfo;
import com.kh.semi.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaAdminListServlet
 */
@WebServlet("/qAdminList.qna")
public class QnaAdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaAdminListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Qna> list = new ArrayList<Qna>();
		
		QnaService qs = new QnaService();
		
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
				
		int listAdminCount = qs.getListAdminCount();
		
		System.out.println("서블릿: " + listAdminCount);
		
		maxPage = (int)((double)listAdminCount/limit+0.9);
				
		startPage = ((currentPage-1)/limit)*limit+1;
				
		endPage = startPage + limit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = qs.selectAdminList(currentPage,limit);
		
		String page = "";

    	if(list != null) {
			page = "views/admin_questions_4.jsp";
			request.setAttribute("list", list);
			
			QPageInfo qpi = new QPageInfo(currentPage, listAdminCount,limit,maxPage,startPage,endPage);
			request.setAttribute("qpi", qpi);
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
