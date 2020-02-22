package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.service.MemberService;
import com.kh.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/deleteMember.dm")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
	    Member m=(Member)session.getAttribute("member");
	    
	    String userId = m.getUserId();
	    String password = request.getParameter("password");
	    
	    MemberService ms = new MemberService();
	    
	    try {
	    	ms.deleteMember(userId,password);
	    	System.out.println("회원탈퇴성공!");
			
			// 세션 정보 삭제
			session.invalidate();
			
			response.sendRedirect("views/main_6.jsp");
	    }catch(Exception e) {
	    	request.setAttribute("msg", "회원탈퇴 중 오류 발생");
	    	request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
