package com.kh.semi.reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.reservation.model.service.ReservationService;

/**
 * Servlet implementation class ReservationModifyDeleteServlet
 */
@WebServlet("/reserveModifyDelete.rm")
public class ReservationModifyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationModifyDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reserveNo = request.getParameter("reserveNo");
		String shopPid = request.getParameter("shopPid");
		
		int result = new ReservationService().reservationModifyDelete(reserveNo,shopPid);
		
		if(result>0) {
			response.sendRedirect("mypageMember.mm");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
