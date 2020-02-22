package com.kh.semi.black.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.black.model.service.BlackService;
import com.kh.semi.black.model.vo.BlackList;

/**
 * Servlet implementation class BlackUpdateServlet
 */
@WebServlet("/bUpdate.bl")
public class BlackUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlackUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String banTerm = request.getParameter("banTerm");
		String banReason = request.getParameter("banReason");
		
		System.out.println(userId);
		System.out.println(banTerm);
		System.out.println(banReason);
		
		BlackList bl = new BlackList(userId, banTerm, banReason);
		BlackService bs = new BlackService();
		
		int result = bs.updateBlack(bl);
		String page = "";
		
		if(result>0) {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<html><script>alert('"+ userId +"님의 차단정보 변경이 적용되었습니다');");
			out.println("document.location.href='bList.bl'");
			out.println("</script></html>");
			out.flush();
			out.close();
		}else {
			request.setAttribute("msg", "차단정보 수정 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp");
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
