package com.kh.semi.menu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.menu.model.sevice.MenuService;
import com.kh.semi.menu.model.vo.Menu;

/**
 * Servlet implementation class InsertMenuServlet
 */
/**
 * @author 이녹영
 *업체 메뉴 등록 서블릿
 */
@WebServlet("/InsertMenuServlet")
public class InsertMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public InsertMenuServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopPid=request.getParameter("shopPid");
		String menuName=request.getParameter("menuName");
		String menuImg=request.getParameter("menuImg");
		int menuPrice=Integer.parseInt(request.getParameter("menuPrice"));
		String menuInfo=request.getParameter("menuInfo");
		Menu m=new Menu(shopPid, menuName, menuImg, menuPrice, menuInfo);
		
		int result=new MenuService().insertMenu(m);

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
