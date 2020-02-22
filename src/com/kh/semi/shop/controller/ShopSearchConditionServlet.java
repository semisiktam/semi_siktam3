package com.kh.semi.shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.semi.shop.model.service.ShopService;
import com.kh.semi.shop.model.vo.ShopSearch;

/**
 * Servlet implementation class ShopSearchConditionServlet
 */
@WebServlet("/SearchCondition.sc")
public class ShopSearchConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopSearchConditionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
				request.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=UTF-8");
				
				String keyword = request.getParameter("key");
				String[] tlist = request.getParameterValues("tlist");
				String[] clist = request.getParameterValues("clist");
				String[] plist = request.getParameterValues("plist");			
				String line = request.getParameter("line");
				
				/*HttpSession session=request.getSession();
				session.setAttribute("tlist", tlist);
				session.setAttribute("tlist", clist);
				session.setAttribute("tlist", plist);
				session.setAttribute("tlist", line);
				*/
				
				
				System.out.println(keyword);
				
				if(keyword.equals("null") || keyword == null) {
					keyword = null;
				}
				
				ArrayList<ShopSearch> list = new ShopService().SearchCondition(keyword,line,tlist,clist,plist);
				
				for(ShopSearch sc : list) {
					System.out.println(sc);
				}
				
				/*String page = "";
				if(list !=null) {
					page = "views/searchConditions_4.jsp";
					request.setAttribute("list", list);
				}
				request.getRequestDispatcher(page).forward(request, response);*/
				
				new Gson().toJson(list,response.getWriter());
				
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
