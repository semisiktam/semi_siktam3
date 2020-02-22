package com.kh.semi.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.review.model.service.ReviewService;
import com.kh.semi.review.model.vo.PageInfo;
import com.kh.semi.review.model.vo.Review;

/**
 * Servlet implementation class ReviewPageViewServlet
 */
@WebServlet("/review.do")
public class ReviewPageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPageViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		
		String shopPid = request.getParameter("shopPid");
		String howSelect = request.getParameter("howSelect");
		
		System.out.println(shopPid);
		System.out.println(howSelect);
		
		ArrayList<Review> allReviewList = new ArrayList<Review>();
		ArrayList<Review> rList = new ArrayList<Review>();
		
		ReviewService rs = new ReviewService();
		
		// 페이지 처리
		int startPage; // 가장 앞 페이지
		int endPage; // 가장 뒷 페이지
		int maxPage; // 가장 마지막 페이지
		int currentPage; // 사용자 현재 페이지
		int limit; // 총 페이지 수 ( 한페이지당 보여줄 게시글 수)
		
		currentPage = 1;
		
		limit = 5;
		
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 리뷰 전체 갯수
		int listCount = rs.getListCount(shopPid);
		
		maxPage = (int)((double)listCount/limit+0.9);
		
		startPage = ((currentPage-1)/limit)*limit+1;// ((int)((double)currentPage/limit+0.9)-1)*limit+1;
		
		endPage = startPage + limit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		// 페이지 처리
		
		rList = rs.selectReviewList(shopPid,howSelect,currentPage,limit);
		PageInfo pi = new PageInfo(currentPage, listCount,limit,maxPage,startPage,endPage);
		
		Map<String,Object> hmap = new HashMap<>();
		hmap.put("rList", rList);
		hmap.put("pi", pi);
		
		new Gson().toJson(hmap,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
