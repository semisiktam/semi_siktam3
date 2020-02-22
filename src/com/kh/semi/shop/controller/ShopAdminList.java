package com.kh.semi.shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.shop.model.service.ShopService;
import com.kh.semi.shop.model.vo.Shop;
import com.kh.semi.shop.model.vo.ShopPageInfo;

/**
 * Servlet implementation class ShopAdminList
 */
@WebServlet("/sAdminList.sh")
public class ShopAdminList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopAdminList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Shop> list = new ArrayList<Shop>();
		ShopService ss = new ShopService();
		
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		currentPage = 1;
		limit = 10;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = ss.getListCount();
		
		System.out.println("전체 업체수 : " + listCount);
		
		maxPage = (int)((double)listCount/limit + 0.9);
		startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
		endPage = startPage + limit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = ss.shopAdminList(currentPage, limit);
		
		String page = "";
		if(list!=null) {
			page="views/admin_storeList_4.jsp";
			request.setAttribute("list", list);
			
			ShopPageInfo spi = new ShopPageInfo(currentPage, listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("spi", spi);
		}else {
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "업체 목록 조회 실패");
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
