package com.kh.semi.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.semi.review.model.service.ReviewService;
import com.kh.semi.review.model.vo.Review;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/rInsert.ro")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maxSize = 1024*1024*10;
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			// 만약 올바른 multipart/form-data로 전송되지 않았을 경우
			// 에러페이지로 즉시 이동시킨다.
			request.setAttribute("msg", "multipart를 통한 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		// 3. 웹 상의 루트(최상위 경로) 경로를 활용하여 저장할 폴더의 위치 지정하기
		String root = request.getServletContext().getRealPath("/");
		System.out.println("root : " + root);
		// 게시판의 첨부파일을 저장할 폴더 이름 지정하기
		String savePath = root + "resources/images";
		
		MultipartRequest mrequest = new MultipartRequest(
									request, // 변경하기 위한 원본 객체
									savePath, // 파일 저장 경로
									maxSize,	// 저장할 파일의 최대 크기
									"UTF-8",	// 저장할 문자셋 설정
									new DefaultFileRenamePolicy()
									// 동일한 이름의 파일을 저장했을 경우
									// 기존의 파일과 구분하기 위해
									// 새로운 파일명 뒤에 숫자를 붙이는 규칙				
		);
		// 5-1. 기본 전송값 처리
		String userId = request.getParameter("userId");
		String shopPid = request.getParameter("shopPid");
		int rScore = Integer.parseInt(request.getParameter("rScore"));
		
		String rContent = mrequest.getParameter("rContent");
		// 5-2 전송된 파일 처리하기
		// 전달받은 파일을 먼저 저장하고, 그 파일의 이름을 가져오는 메소드를 실행한다.
		String fileName = mrequest.getFilesystemName("file");
		
		
		if(fileName==null) {
			fileName = "review.png";
		}
		
		if(rContent.equals("")) {
			rContent = "작성안함";
		}
		
		// VO에 담기
		Review r = new Review();
		r.setUserId(userId);
		r.setShopPid(shopPid);
		r.setScore(rScore);
		r.setReviewImg(fileName);
		r.setrContent(rContent);
		
		System.out.println(userId);
		System.out.println(shopPid);
		System.out.println(rScore);
		System.out.println(fileName);
		System.out.println(rContent);
		
		ReviewService rs = new ReviewService();
		
		int result = rs.reviewInsert(r);
		
		// TODO 해야함
		int result2 = rs.reviewInsertUpdate(shopPid,userId);
		
		if(result > 0) {
			response.sendRedirect("/siktam/rPage.ro?shopPid="+shopPid+"&howSelect=new&currentPage=1");
		}else {
			request.setAttribute("msg", "등록실패");
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
