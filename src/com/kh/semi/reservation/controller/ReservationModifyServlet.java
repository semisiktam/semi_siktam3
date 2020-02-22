package com.kh.semi.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.member.model.vo.MemberReservationList;
import com.kh.semi.menu.model.sevice.MenuService;
import com.kh.semi.menu.model.vo.Menu;
import com.kh.semi.reservation.model.service.ReservationService;

/**
 * Servlet implementation class ReservationModifyServlet
 */
@WebServlet("/reserveModify.rm")
public class ReservationModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m=(Member)session.getAttribute("member");
		
		String userid = m.getUserId();
		String reserveNo = request.getParameter("reserveNo");
		String shopPid = request.getParameter("shopPid");
		System.out.println(reserveNo);
		System.out.println(shopPid);
		
		ReservationService rs = new ReservationService();
		ArrayList<MemberReservationList> mrList = rs.reservationModify(userid,reserveNo);
		System.out.println("1 : " + mrList);
		
		ArrayList<Menu> list = new ArrayList<Menu>();
		MenuService ms = new MenuService();
		
		list = ms.selectList(shopPid);
		System.out.println("2 : " +  list);
		
		String page = "";
		
		if(mrList != null && list != null ) {
			page="views/modify_3.jsp";
			request.setAttribute("mrList", mrList);
			request.setAttribute("mList",list);
		}else {
			request.setAttribute("msg", "예약내역 불러오기 에러 ");
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
