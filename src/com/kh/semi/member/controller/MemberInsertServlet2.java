package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.dao.MemberDao;
import com.kh.semi.member.model.service.MemberService;
import com.kh.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/mInsert2.me")
public class MemberInsertServlet2 extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 1. 사용자페이지(회원가입페이지)에서 전달받은 값을 가져오기
      String userId = request.getParameter("id");
      String password = request.getParameter("pass1");
      String addr = request.getParameter("zipCode")+", "
				+ request.getParameter("address1")+", "
				+ request.getParameter("address2");
      String name = request.getParameter("name");
      String pid = request.getParameter("pid1")+"-"+request.getParameter("pid2");
      String phone = request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3");
      
      Member m = new Member(userId, password, addr, name, pid, phone);
      
      System.out.println("가입 회원 정보 확인 : " + m);
      int result=new MemberService().insertMember2(m);
      if(result>0) {
    	  HttpSession sessionId=request.getSession();
    	  sessionId.setAttribute("userId", userId);
    	  request.getRequestDispatcher("/views/registerCompany_2.jsp").forward(request, response);
      }else {
    	  response.sendRedirect("/index.jsp");
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