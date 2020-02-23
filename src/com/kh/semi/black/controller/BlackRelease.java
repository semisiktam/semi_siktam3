package com.kh.semi.black.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.black.model.service.BlackService;

/**
 * Servlet implementation class BlackRelease
 */
@WebServlet("/bRelease.bl")
public class BlackRelease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlackRelease() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BlackService bs = new BlackService();
		
		int result = bs.deleteZero();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(result>0) {
			out.println("<html><script>alert('"+ result +"명의 회원이 블랙리스트에서 해제되었습니다');");
		}else {
			out.println("<html><script>alert('변경사항이 없습니다.');");
		}
		out.println("document.location.href='bList.bl'");
		out.println("</script></html>");
		out.flush();
		out.close();
		
//		response.sendRedirect("bList.bl");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
