package com.kh.semi.eventShop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.eventShop.model.service.EventShopService;
import com.kh.semi.shop.model.vo.Shop;

/**
 * Servlet implementation class eventShopListServlet
 */
@WebServlet("/esList.es")
public class eventShopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventShopListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eno = request.getParameter("eno");
		
		ArrayList<Shop> list = new ArrayList<Shop>();

		EventShopService ess = new EventShopService();
		
		list = ess.selectList(eno);
		
		String page = "";
		
		if(list != null) {
			page = "views/admin_eventBannerSelect.jsp";
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
