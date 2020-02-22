package com.kh.semi.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.shop.model.service.ShopService;
import com.kh.semi.shop.model.vo.Shop;

/**
 * Servlet implementation class ShopAdminUpdate
 */
@WebServlet("/sAdminUpdate.sh")
public class ShopAdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopAdminUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopPid = request.getParameter("shopPid");
		String userId = request.getParameter("userId");
		String shopName = request.getParameter("shopName");
		String shopImg = request.getParameter("shopImg");
		String sAddr = request.getParameter("sAddr");
		String sPhone = request.getParameter("sPhone");
		String sInfo = request.getParameter("sInfo");
		String ownerId = request.getParameter("ownerId");
		String sTime = request.getParameter("sTime");
		String eTime = request.getParameter("eTime");
		String shopDay = request.getParameter("shopDay");
		String menuCategory = request.getParameter("menuCategory");
		String tableType = request.getParameter("tableType");
		int avgPay = Integer.parseInt(request.getParameter("avgPay"));
		String outYn = request.getParameter("outYn");
		
		Shop s = new Shop(shopPid, userId, shopName, shopImg, sAddr, 
				sPhone, sInfo, ownerId, sTime, eTime, 
				shopDay, menuCategory, tableType, avgPay, outYn);
		
		int result = new ShopService().updateAdminShop(s);
		
		System.out.println("컨트롤러"+result);
		
		if(result>0) {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<html><script>alert('"+ shopPid +"의 업체정보 변경이 적용되었습니다');");
			out.println("document.location.href='sAdminList.sh'");
			out.println("</script></html>");
			out.flush();
			out.close();
		}else {
			request.setAttribute("msg", "업체정보 수정 실패");
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
