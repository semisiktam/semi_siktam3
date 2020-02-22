package com.kh.semi.menu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.menu.model.sevice.MenuService;

/**
 * Servlet implementation class DeleteMenuServlet
 */
@WebServlet("/DeleteMenuServlet")
public class DeleteMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuNo=request.getParameter("menuNo");
		String shopPid=request.getParameter("shopPid");
		int result=new MenuService().deleteMenu(menuNo);
		
		if(result>0) {
			request.setAttribute("shopPid", shopPid);
			request.getRequestDispatcher("/myMenulist.menu").forward(request, response);

		}else {
			request.setAttribute("msg", "삭제 실패!");
			request.getRequestDispatcher("/views/common/errorPage.jsp");
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
