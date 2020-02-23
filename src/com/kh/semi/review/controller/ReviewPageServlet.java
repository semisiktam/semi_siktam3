package com.kh.semi.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.review.model.vo.PageInfo;
import com.kh.semi.review.model.service.ReviewService;
import com.kh.semi.review.model.vo.Review;
import com.kh.semi.review.model.vo.ReviewScore;
import com.kh.semi.shop.model.vo.Shop;

/**
 * Servlet implementation class ReviewPageServlet
 */
@WebServlet("/rPage.ro")
public class ReviewPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 리뷰 리스트 받아오기 최신순
		// 멤버(로그인정보)(헤더에 딸려온다) 와 가게 번호 받아오기 -> 가게 번호로 가게 정보 가져오는 기능
		
		String shopPid = request.getParameter("shopPid");
		String howSelect = request.getParameter("howSelect");
		
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
		allReviewList = rs.selectAllReviewList(shopPid);
		
		
		
		Shop s = new Shop();
		
		s = rs.selectShop(shopPid);
		
		// 점수 처리
		// 각각 갯수
		int five = 0;
		int four = 0;
		int three = 0;
		int two = 0;
		int one = 0;
		// 총 점수
		int total = 0;
		for(Review rg : allReviewList ) {
			switch(rg.getScore()) {
				case 1 : one++; total+=1; break;
				case 2 : two++; total+=2; break;
				case 3 : three++; total+=3; break;
				case 4 : four++; total+=4; break;
				case 5 : five++; total+=5; break;
			}
		}
		
		double score = (double)total/(double)listCount;
		int fScore = 0;
		if(score < 1.5) {
			fScore = 1;
		}else if(score < 2.5) {
			fScore = 2;
		}else if(score < 3.5) {
			fScore = 3;
		}else if(score < 4.5) {
			fScore = 4;
		}else {
			fScore = 5;
		}
		
		score = Math.round(score*10)/10.0;
		
		
		ReviewScore rScore = new ReviewScore(one,two,three,four,five,total,score,fScore);
		
		String page="";
		
	
		if(rList != null) {
			
			page = "/views/productReviewPage_7.jsp";
			request.setAttribute("reviewList", rList);
			request.setAttribute("shop", s);
			request.setAttribute("ReviewScore",rScore);
			request.setAttribute("allReviewList", allReviewList);
			request.setAttribute("howSelect", howSelect);
			
			PageInfo pi = new PageInfo(currentPage, listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("pi", pi);
			
		}else {
			request.setAttribute("msg", "공지사항 목록 불러오기 에러 ");
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
