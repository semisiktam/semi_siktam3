package com.kh.semi.coupon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.coupon.model.vo.discount;

/**
 * Servlet implementation class coupon
 */
@WebServlet("/coupon.cc")
public class coupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coupon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		int coupon = Integer.parseInt(request.getParameter("coupon"));
		int useMile = Integer.parseInt(request.getParameter("useMile"));
		int getMile = Integer.parseInt(request.getParameter("getMile"));
		int total = Integer.parseInt(request.getParameter("total"));
		
		System.out.println(coupon);
		System.out.println(total);
		int mile = getMile - useMile;
		int totalPay = total-coupon-useMile;
		
		discount dc = new discount();
		dc.setMile(mile);
		dc.setTotalPay(totalPay);
		
		new Gson().toJson(dc,response.getWriter());
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
