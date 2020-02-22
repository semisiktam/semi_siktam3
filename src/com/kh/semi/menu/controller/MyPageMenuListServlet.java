package com.kh.semi.menu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.menu.model.sevice.MenuService;
import com.kh.semi.menu.model.vo.Menu;

/**
 * Servlet implementation class MyPageMenuListServlet
 */
@WebServlet("/myMenulist.menu")
public class MyPageMenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyPageMenuListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		response.setContentType("application/json; charset=UTF-8");
		String shopPid = request.getParameter("shopPid");
		ArrayList<Menu> list=new ArrayList<Menu>();
//		System.out.println("is list empty?"+list.isEmpty());
		list=new MenuService().selectList(shopPid);
		System.out.println(list.isEmpty());
		
		//new Gson().toJson(list,response.getWriter());
		if(list.isEmpty()) {
			request.setAttribute("shopPid", shopPid);
		}else {
			request.setAttribute("mlist",list);
		}
		request.getRequestDispatcher("views/registerMenu_5.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
