package com.kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.member.model.service.FindIdService;
import com.kh.semi.member.model.vo.Member;

/**
 * Servlet implementation class FindPwdPhoneServlet
 */
@WebServlet("/fpp.me")
public class FindPwdPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdPhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=UTF-8");
		String name = request.getParameter("pphoneName");
		String phone = request.getParameter("pphoneNumber");
		
		System.out.println(name);
		System.out.println(phone);
		
		Member m = new Member();
		m.setName(name);
		m.setPhone(phone);
		
		FindIdService fId = new FindIdService();
		
		// String userId = fId.FindIdPhone(m);
		// System.out.println(m);

		
		String mem= fId.FindPwdPhone(m);
		System.out.println("뭐나오나" + m);
		System.out.println("서블릿:"+mem);
		new Gson().toJson(mem,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
