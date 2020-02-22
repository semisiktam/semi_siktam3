package com.kh.semi.pay.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.pay.model.service.payService;
import com.kh.semi.pay.model.vo.PayInfo;

/**
 * Servlet implementation class Pay
 */
@WebServlet("/pay.pc")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
	    Member m = (Member)session.getAttribute("member");
	    //마일리지/쿠폰 번호
	    Member mc = new payService().payinfo(m.getUserId());
	    System.out.println(m.getUserId());
	    //결제 정보
	    String shopName = request.getParameter("shopName");
	    String shopAddr = request.getParameter("shopAddr");
		String[] menuName = request.getParameterValues("menuName");
		String[] menuCount = request.getParameterValues("menuCount");
		String[] menuPrice = request.getParameterValues("menuPrice");
		int total = Integer.parseInt(request.getParameter("hdtotal"));
		
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String shopPid = request.getParameter("shopPid");
		
		System.out.println(time);
		
		PayInfo pi = null;
		ArrayList<PayInfo>list = new ArrayList<PayInfo>();
		for(int i=0; i<menuName.length; i++) {
			pi = new PayInfo();
			pi.setRshopName(shopName);
			pi.setRshopAddr(shopAddr);
			pi.setRmenuName(menuName[i]);
			pi.setRmenuCount(menuCount[i]);
			pi.setRmenuPrice(menuPrice[i]);
			pi.setTotalPay(total);
			
			list.add(pi);
		}
		
		for(PayInfo pi2 : list) {
			System.out.println(pi2);
		}
		
		String page ="";
		
		if(mc != null && list != null) {
			request.setAttribute("mc", mc);
			request.setAttribute("list", list);
			page = "/views/pay_5.jsp";
		}else {
			
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
