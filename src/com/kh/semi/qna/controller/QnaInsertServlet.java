package com.kh.semi.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.qna.model.service.QnaService;
import com.kh.semi.qna.model.vo.Qna;

/**
 * Servlet implementation class QnaInsertServlet
 */
@WebServlet("/qInsert.qn")
public class QnaInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String qwriter = request.getParameter("writer");
		String qtitle = request.getParameter("qtitle");
		String qcontext = request.getParameter("qcontext");
	
		Qna q = new Qna();
		
		QnaService qs = new QnaService();
		q.setUserId(qwriter);
		q.setqTitle(qtitle);
		q.setqContext(qcontext);
		
		int result = qs.insertQna(q);
		
		if(result > 0) {
			response.sendRedirect("QnaListServlet");
		}else {
			request.setAttribute("msg", "공지사항 등록 실패");
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
