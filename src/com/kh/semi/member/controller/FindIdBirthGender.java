package com.kh.semi.member.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.member.model.service.FindIdService;
import com.kh.semi.member.model.vo.Member;

/**
 * Servlet implementation class FindIdBirthGender
 */
@WebServlet("/fibg.me")
public class FindIdBirthGender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdBirthGender() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("application/json; charset=UTF-8");
		String name = request.getParameter("BirthName");
		String birth = request.getParameter("Birth");// 890717-2
		String gender = request.getParameter("Gender"); //여성(글자로)
		

		
		
		int checkGender = 1;
		if(gender.equals("남성")) {
			checkGender = 1;
		}else {
			checkGender = 2;
		}
		
		String pid = birth + "-" + checkGender;
		
		System.out.println(pid);
		System.out.println(name);
		System.out.println(birth);
		System.out.println(gender);

		
		Member m = new Member();
		m.setName(name);
		m.setPid(pid);
		System.out.println(m);
		
		FindIdService fId = new FindIdService();

		String mem = fId.FindIdBirthGender(m);
		
		System.out.println("뭐나오나" + m);
		System.out.println("서블릿:"+ mem);
		
		new Gson().toJson(mem,response.getWriter());
//		String page = "";
//		if(mem != null) { 
//			
//			page = "views/FindIdResult.jsp";
//			
//			request.setAttribute("mem", mem);
//		}else {
//			page="views/common/errorPage.jsp";
//		}
//		request.getRequestDispatcher(page).forward(request, response);
		
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
