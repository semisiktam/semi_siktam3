package com.kh.semi.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.reservation.model.vo.ReservationTest;

/**
 * Servlet implementation class ReservationPay
 */
@WebServlet("/reservationPay.rc")
public class ReservationPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationPay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
			
		//String[] mlist = request.getParameter("m0list").split(",");
		String[] mlist = request.getParameterValues("m0list");

		int sum = 0;
		int total = 0;
		ArrayList<ReservationTest> list = new ArrayList<ReservationTest>();
		
		for(int i=0; i<mlist.length; i=i+3) {
			ReservationTest rt = new ReservationTest();
			
			rt.setMenuName(mlist[i]);
			rt.setMenuPrice(Integer.parseInt(mlist[i+1]) * Integer.parseInt(mlist[i+2]));
			rt.setMenuCount(Integer.parseInt(mlist[i+2]));
			
			total = (Integer.parseInt(mlist[i+1]) * Integer.parseInt(mlist[i+2]));
			sum += total;
			
			rt.setTotal(sum);
			
			if(rt.getMenuCount() > 0) {
				
				list.add(rt);
			}
			
		}
		
		
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
