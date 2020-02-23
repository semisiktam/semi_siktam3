package ztest.test.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.kh.semi.member.model.vo.Member;

import ztest.test.test.test.TestVo2;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("json/application; charset=UTF-8");
		HttpSession s=request.getSession();
		String ownerId=((Member)s.getAttribute("member")).getUserId();
		System.out.println(ownerId);
		ArrayList<TestVo2> tvo=new TestService().rList(ownerId);
		for(TestVo2 t:tvo) {
			System.out.println(t);
		}
		request.setAttribute("rlist", tvo);
		JSONObject rInfo=null;
		JSONArray rlist=new JSONArray();
		for(TestVo2 tv:tvo) {
			rInfo=new JSONObject();
			rInfo.put("resNo", tv.getResNo());
			rInfo.put("shopName", tv.getShopName());
			rInfo.put("userId", tv.getUserId());
			rInfo.put("userName", tv.getUserName());
			rInfo.put("userPhone", tv.getUserPhone());
			rInfo.put("shopPid", tv.getShopPid());
			rInfo.put("rDate", tv.getrDate());
			rInfo.put("rTime", tv.getrTime());
			rInfo.put("menuNo", tv.getMenuNo());
			rInfo.put("totalPay", tv.getTotalPay());
			rInfo.put("acceptYn", tv.getAcceptYN());
			System.out.println(rInfo);
			rlist.add(rInfo);
			System.out.println("=======================================================\n"+rlist);
		}
		new Gson().toJson(rlist,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
