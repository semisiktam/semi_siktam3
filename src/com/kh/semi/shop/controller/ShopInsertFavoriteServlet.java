package com.kh.semi.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.semi.member.model.vo.Member;
import com.kh.semi.mypageFavorite.model.vo.MypageFavorite;
import com.kh.semi.shop.model.service.ShopService;

/**
 * Servlet implementation class ShopInsertFavoriteServlet
 */
@WebServlet("/shopInsertFavorite.si")
public class ShopInsertFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopInsertFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		
		HttpSession session=request.getSession();
		Member m=(Member)session.getAttribute("member");
		String userId = m.getUserId();
		String shopPid = request.getParameter("shopPid");
		
		MypageFavorite mf = new MypageFavorite(userId,shopPid);
		
		ShopService ss = new ShopService();
		
		int result = ss.shopFavoriteInsert(userId, shopPid);
		
		System.out.println(result);
		
		new Gson().toJson(result,response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
