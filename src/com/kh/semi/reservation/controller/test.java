//package com.kh.semi.reservation.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//import com.kh.semi.reservation.model.service.ReservationService;
//import com.kh.semi.reservation.model.vo.ReservationTest;
//import com.kh.semi.shop.model.vo.Shop;
//
///**
// * Servlet implementation class Reservation
// */
//@WebServlet("/confirmResTest.do")
//public class test extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public test() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession s=request.getSession();
//		
//		ArrayList<Shop> slist=(ArrayList<Shop>)s.getAttribute("shop");
//		slist.get(0).getUserId();
//		String[] shopPidArr=new String[slist.size()-1];
//		for(int i=0;i<shopPidArr.length;i++) {
//			shopPidArr[i]=slist.get(i).getShopPid();
//		}
//		
//		String shopPid = request.getParameter("shopPid");
//		
//		System.out.println(shopPid);
//		ArrayList<ReservationTest> list = new ReservationService().Reservation(userId);
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("json/application; charset=UTF-8");
//		
//		String page = "";
//		JSONObject resInfo=null;
//		JSONArray result=new JSONArray();
//		for(ReservationTest rt:list) {
//			resInfo=new JSONObject();
//			resInfo.put("shopName",rt.getShopName());
//			resInfo.put("userId",rt.getUserId());
//			resInfo.put("rDate", rt.getShopEndTime());
//			resInfo.put("rTime", rt.getShopName());
//			result.add(resInfo);
//		}
//		response.getWriter().print(result.toJSONString());
//		
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
