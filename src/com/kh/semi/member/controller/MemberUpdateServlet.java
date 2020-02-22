package com.kh.semi.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.service.MemberService;
import com.kh.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mUpdate.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("pass1");
	    String addr = request.getParameter("zipCode")+", "
					+ request.getParameter("address1")+", "
					+ request.getParameter("address2");
	    String name = request.getParameter("name");
	    String phone = request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3");
	    
	    HttpSession session = request.getSession(false);
	    
	    Member m = (Member)session.getAttribute("member");
	    
	    m.setPassword(password);
	    m.setAddr(addr);
	    m.setName(name);
	    m.setPhone(phone);
	    
	    System.out.println("변경한 정보 확인 : " + m);
	    
	    MemberService ms = new MemberService();
	    
	    int result = ms.upDateMember(m);
	    
	    System.out.println(result);
	    
	    if(result>0) {
	    	response.sendRedirect("mypageMember.mm");
	    }else{
	    	  request.setAttribute("msg", "회원가입실패!");
	    	  PrintWriter out = response.getWriter();
	    	  out.println("<script>alert('error');</script>");
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
