package com.kh.semi.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet("/rDelete.ro")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rno = request.getParameter("reviewNo");
		String shopPid = request.getParameter("shopPid");
		String userId = request.getParameter("userId");
		ReviewService rs = new ReviewService();
		
		int result = rs.deleteReview(rno);
		
		int result2 = rs.deleteReviewUpdate(shopPid,userId);
		
		if(result>0) {
			response.sendRedirect("/siktam/rPage.ro?shopPid="+shopPid+"&howSelect=new");
		}else {
			request.setAttribute("msg", "공지사항 삭제 실패");
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
