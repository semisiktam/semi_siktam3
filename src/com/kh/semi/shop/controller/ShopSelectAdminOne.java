package com.kh.semi.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.shop.model.service.ShopService;
import com.kh.semi.shop.model.vo.Shop;

/**
 * Servlet implementation class ShopSelectAdminOne
 */
@WebServlet("/sAdminSelect.sh")
public class ShopSelectAdminOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopSelectAdminOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopPid = request.getParameter("shopPid");

		Shop shop = null; // 혹시 오류나면 new Shop();
		ShopService ss = new ShopService();
		String page = "";
		try {
			shop = ss.selectOne(shopPid);
			if(shop != null) {
				page = "views/admin_shopDetail_4.jsp";
				request.setAttribute("shop", shop);
			}else {
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "업체정보 조회 실패");
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
