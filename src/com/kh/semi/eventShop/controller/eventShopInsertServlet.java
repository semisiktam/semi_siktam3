package com.kh.semi.eventShop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.eventShop.model.service.EventShopService;
import com.kh.semi.eventShop.model.vo.EventShop;

/**
 * Servlet implementation class eventShopInsertServlet
 */
@WebServlet("/esInsert.es")
public class eventShopInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventShopInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eno = (String)request.getParameter("eno");
		String insertCheck = (String)request.getParameter("insertCheck");
		
		EventShop es = new EventShop();
		
		EventShopService ess = new EventShopService();
		
		int result = ess.insertEventShop(es,eno,insertCheck);
		
		if(result > 0) {
			response.sendRedirect("esList.es?eno="+eno);	
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
