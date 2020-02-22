package com.kh.semi.eventShop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.eventShop.model.service.EventShopService;
import com.kh.semi.shop.model.vo.Shop;

/**
 * Servlet implementation class eventShopSearchServlet
 */
@WebServlet("/esSearch.es")
public class eventShopSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public eventShopSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");

		String searchInfo = request.getParameter("searchInfo");
		
		ArrayList<Shop> list = new ArrayList<Shop>();
		
		EventShopService es = new EventShopService();
		
		list = es.searchShop(searchInfo);
		
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
