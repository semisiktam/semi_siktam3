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
 * Servlet implementation class eventInsertServlet
 */
@WebServlet("/eInsert.ev")
public class eventInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventName = request.getParameter("eventName");
		String eventImg = request.getParameter("eventImg");
		System.out.println(eventName+"  "+eventImg);
		EventBanner eb = new EventBanner(eventName,eventImg);
		
		EventBannerService es= new EventBannerService();
		
		int result = es.InsertEvent(eb);

		System.out.println("servlet"+result);
		
		if(result > 0) {
			response.sendRedirect("eSelectList.ev");			
		}else {
			request.setAttribute("msg", "등록실패");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
