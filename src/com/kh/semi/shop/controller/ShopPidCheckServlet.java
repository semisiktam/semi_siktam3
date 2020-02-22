package com.kh.semi.shop.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShopPidCheckServlet
 */
@WebServlet("/spc.me")
public class ShopPidCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopPidCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchPid = request.getParameter("Shoppid"); 
		String searchName = request.getParameter("Shopname");
		
	String address = "http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch?serviceKey=J7gW4zUA9N1YP74mfR%2BCv9bRE1jBZsjxpJoj1ASuF2ncC3aO2Yu7U7uirQTKxcGtSx5aV2WKmdZfAAO8hDHP6w%3D%3D&wkpl_nm="
			+ searchName + "&bzowr_rgst_no=" + searchPid;
		
	System.out.println(searchPid);
	System.out.println(searchName);
	System.out.println(address);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
