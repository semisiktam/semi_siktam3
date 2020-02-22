package com.kh.semi.pay.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.pay.model.service.payService;
import com.kh.semi.pay.model.vo.PayInfo;
import com.kh.semi.reservation.model.service.ReservationService;

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
	    //결제 정보
	    String shopName = request.getParameter("shopName");
	    String shopAddr = request.getParameter("shopAddr");
		String[] menuName = request.getParameterValues("menuName");
		String[] menuCount = request.getParameterValues("menuCount");
		String[] menuPrice = request.getParameterValues("menuPrice");
		int total = Integer.parseInt(request.getParameter("hdtotal"));
		
		//예약 insert 정보
		String[] menuNo = request.getParameterValues("menuNo");
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String shopPid = request.getParameter("shopPid");
		StringBuilder menuList = new StringBuilder();
		String menu = null;
		
		for(int k=0; k<menuName.length; k++) {
			
			menuList.append(menuNo[k]);
			menuList.append(",");
			menuList.append(menuName[k]);
			menuList.append(",");
			menuList.append(menuCount[k]);
			menuList.append(",");
			menuList.append(menuPrice[k]);
			menuList.append(",");
		}
		
		menu = menuList.toString();
		
		String[] dateArr = date.split("-");
		int[] intdate = new int[dateArr.length];
		
		Date rdate = null;
		for(int i=0; i<dateArr.length; i++) {
			intdate[i] = Integer.parseInt(dateArr[i]);
			System.out.println(intdate[i]);
		}
		
		rdate = new Date(new GregorianCalendar(
				intdate[0],intdate[1]-1,intdate[2]).getTimeInMillis());
		
		System.out.println(m.getUserId());
		System.out.println(shopPid);
		System.out.println(rdate);
		System.out.println(time);
		System.out.println(menu);
		//예약 insert
		int result = new ReservationService().reservationInsert(m.getUserId(),shopPid,rdate,time,menu); 
		/*String userId, String shopPid, Date rDate, String rTime, int mNo*/
		
		//마일리지/쿠폰 번호
		
		//예약번호
		String rNo = null;
		
		if(result > 0) {
			rNo = new ReservationService().reservationNo(m.getUserId(),shopPid);
		}
		
		//payInfo
		PayInfo pi = null;
		ArrayList<PayInfo>list = null;
		
		if(rNo != null) {
			list = new ArrayList<PayInfo>();
			for(int j=0; j<menuName.length; j++) {
				System.out.println(menuNo[j]);
				pi = new PayInfo();
				pi.setrNo(rNo);
				pi.setRshopPid(shopPid);
				pi.setRshopName(shopName);
				pi.setRshopAddr(shopAddr);
				pi.setRmenuName(menuName[j]);
				pi.setRmenuCount(menuCount[j]);
				pi.setRmenuPrice(menuPrice[j]);
				pi.setTotalPay(total);
				
				list.add(pi);
			}
		}
		
		Member mc = new payService().payinfo(m.getUserId());
		System.out.println(m.getUserId());
		
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
