package com.kh.semi.shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.menu.model.sevice.MenuService;
import com.kh.semi.menu.model.vo.Menu;
import com.kh.semi.mypageFavorite.model.service.mypageFavoriteService;
import com.kh.semi.mypageFavorite.model.vo.MypageFavorite;
import com.kh.semi.shop.model.service.ShopService;
import com.kh.semi.shop.model.vo.Shop;

/**
 * Servlet implementation class ShopSelectOneServlet
 */
@WebServlet("/sSelect.so")
public class ShopSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String shopPid = request.getParameter("shopPid");
		
		ShopService ss = new ShopService();
		
		Shop s = ss.selectOne(shopPid);
		
		HttpSession session=request.getSession();
		Member m=(Member)session.getAttribute("member");
		
//		System.out.println(m.getUserId());
		System.out.println(s.getShopPid());
		
		
		String result2 ="";
		// 조건문처리 해라 임마 (서지원) ↓ - 비회원일때 보면 안보이다 임뫄, 빵도 두개 가져간다 현희꺼
		if(m!=null) {
			MypageFavorite mf = new MypageFavorite(m.getUserId(), s.getShopPid());
			mypageFavoriteService mfs = new mypageFavoriteService();
			int resultFavor = mfs.isExist(mf);
			System.out.println("컨트롤러" + resultFavor);
			if(resultFavor>0) {
				result2="o";
			}else {
				result2="x";
			}
			
		}
		
		
		
		ArrayList<Menu> list = new ArrayList<Menu>();
		
		MenuService ms = new MenuService();
		
		list = ms.selectList(shopPid);
		
		// 탐희 마이페이지(개인) 들여다본기록 하는중
		
		String page = "";
		if(s != null) {
			page = "views/productDetailPage_6.jsp";
			
			if(m != null) {
				String userId = m.getUserId();
				int result = ss.shopRecordInsert(userId,shopPid);
				
				if(result > 0) {
					System.out.println("최근방문등록성공");
				}else {
					System.out.println("최근방문등록실패");
				}
			}
			request.setAttribute("mList", list);
			request.setAttribute("shop", s);
			request.setAttribute("favorite", result2);
			// 탐희
/*			HttpSession session = request.getSession();
			session.setAttribute("selectShop", s);*/
			
		}else {
			request.setAttribute("msg", "공지사항 상세보기 실패");
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
