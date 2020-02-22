package com.kh.semi.black.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.black.model.service.BlackService;
import com.kh.semi.black.model.vo.BlackList;

/**
 * Servlet implementation class BlackSelectOne
 */
@WebServlet("/bSelect.bl")
public class BlackSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlackSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		System.out.println(userId);
		
		BlackList bl = new BlackList();
		BlackService bs = new BlackService();
		
		bl = bs.selectOne(userId);
		
		System.out.println(bl);
		
		String page = "";
		try {
		
			if(bl != null) {
				page = "views/admin_blackDetail.jsp";
				request.setAttribute("bl", bl);
			}else {
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "블랙리스트 상세보기 실패");
			}
			
			request.getRequestDispatcher(page).forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
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
