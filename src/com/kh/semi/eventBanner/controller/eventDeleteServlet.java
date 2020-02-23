package com.kh.semi.eventBanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.eventBanner.model.service.EventBannerService;

/**
 * Servlet implementation class eventDeleteServlet
 */
@WebServlet("/evDelete.ev")
public class eventDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check1 = request.getParameter("check1");
		
		EventBannerService ebs = new EventBannerService();

		int result = ebs.deleteEvent(check1);
		System.out.println(result);
		if(result > 0) {
			response.sendRedirect("/siktam/eSelectList.ev");
		}else {
			request.setAttribute("msg", "업체 삭제 실패");
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
