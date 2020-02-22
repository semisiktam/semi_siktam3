package com.kh.semi.eventBanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.kh.semi.eventBanner.model.service.EventBannerService;
import com.kh.semi.eventBanner.model.vo.EventBanner;

/**
 * Servlet implementation class eventSelectOneServlet
 */
@WebServlet("/eSelctOne.ev")
public class eventSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eno = request.getParameter("eno");
		
		EventBannerService es = new EventBannerService();
		
		EventBanner eb = es.eSelectOne(eno);
		
		String page = "";
		
		if(eb != null) {
			page = "views/admin_eventBannerSelect.jsp";
			request.setAttribute("EventBanner", eb);
			
		}else {
			request.setAttribute("msg", "문의사항 상세보기 실패");
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
