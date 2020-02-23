package com.kh.semi.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.pay.model.service.payService;
import com.kh.semi.pay.model.vo.Pay;

/**
 * Servlet implementation class PayInsertServlet
 */
@WebServlet("/pInsert.pa")
public class PayInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String payType = request.getParameter("payType");
//	    int totalPrice = Integer.parseInt(request.getParameter("totalPay"));
//	    int mileage = Integer.parseInt(request.getParameter("mileage"));
//	    int couponNo = Integer.parseInt(request.getParameter("couponNo"));
	    
		String payType = request.getParameter("payType");
	    int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
	    int mileage = Integer.parseInt(request.getParameter("mileage"));
	    int couponNo = Integer.parseInt(request.getParameter("couponNo"));
	    String resNo = request.getParameter("rNo");
		
	    System.out.println(totalPrice);
	    
	    Pay pay = new Pay(resNo, payType, totalPrice, mileage, couponNo);
	    payService ps = new payService();
	    int insertPay = ps.insertPay(pay);
		
	    response.sendRedirect("/siktam/views/main_6.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
