package com.kh.semi.eventBanner.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.eventBanner.model.service.EventBannerService;
import com.kh.semi.eventBanner.model.vo.EventBanner;
import com.kh.semi.qna.model.vo.QPageInfo;

/**
 * Servlet implementation class eventListServlet
 */
@WebServlet("/eSelectList.ev")
public class eventListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<EventBanner> list = new ArrayList<EventBanner>();
		
		EventBannerService es = new EventBannerService();
		
		list = es.selectList();
		
		String page = "";
		
		if(list != null) {
			page = "views/admin_eventBanner_4.jsp";
			request.setAttribute("list", list);
			
		}else {
			request.setAttribute("msg", " 불러오기 에러 ");
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
