package com.kh.semi.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.qna.model.service.QnaService;
import com.kh.semi.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaAdminSelectServlet
 */
@WebServlet("/qAdminSelect.qna")
public class QnaAdminSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaAdminSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		Qna q = new Qna();
		QnaService qs = new QnaService();
		
		q = qs.qSelectOne(qno);
		
		String page = "";
		if(q != null) {
			page = "views/admin_questionsDetail.jsp";
			request.setAttribute("qna", q);
			
		}else {
			request.setAttribute("msg", "문의사항 상세보기 실패");
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
