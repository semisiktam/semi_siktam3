package com.kh.semi.shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.kh.semi.member.model.vo.Member;
import com.kh.semi.shop.model.service.ShopService;
import com.kh.semi.shop.model.vo.Shop;

/**
 * Servlet implementation class ShopInsertServlet
 */
@WebServlet("/sInsert.sh")
public class ShopInsertServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session=request.getSession(); 
      Member m=(Member)session.getAttribute("member");
	  String shopName = request.getParameter("shopName"); //매장명
      String shopImg = request.getParameter("shopImg"); //매장사진
      String userId=m.getUserId();
      String sAddr = request.getParameter("zipCode")+", "
				+ request.getParameter("address1")+", "
				+ request.getParameter("address2"); //매장주소
      String sPhone = request.getParameter("phone"); //매장전화번호
      String sInfo="정말 맛있는 식당!";
      String ownerId = request.getParameter("pid"); //사업자번호
      String sTime = request.getParameter("startTime"); //영업시작시간-->10:00
      String eTime = request.getParameter("endTime"); //영업종료시간-->22:00
      String shopDay = request.getParameter("Day"); //휴무일
      String menuCategory = String.join(", ", request.getParameterValues("eatType")); //메뉴카테고리
      String tableType = String.join(", ", request.getParameter("table")); //테이블형태
      Shop s=new Shop(shopName,userId,shopImg,sAddr,sPhone,sInfo,ownerId,sTime,eTime,shopDay,menuCategory,tableType);
//      System.out.println(s);
      ShopService ss=new ShopService();
      int result=ss.insertShop(s);
      if(result>0&&session.getAttribute("shop")!=null) {
    	  ArrayList<Shop> slist=ss.selectList(m.getUserId());
    	  System.out.println(m);
    	  System.out.println(s);
    	  session.invalidate();
    	  session=request.getSession();
    	  session.setAttribute("member", m);
    	  session.setAttribute("shop", slist);
      }
      
      response.sendRedirect("views/mypageShop_5.jsp");
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}