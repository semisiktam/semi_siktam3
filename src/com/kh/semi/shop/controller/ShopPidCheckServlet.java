package com.kh.semi.shop.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;



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
	
		response.setContentType("application/json; charset=UTF-8");
		
		String searchPid = request.getParameter("Shoppid"); 
		String searchName = request.getParameter("Shopname");
	try {	
	String address = "http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch";
	String serviceKey = "J7gW4zUA9N1YP74mfR%2BCv9bRE1jBZsjxpJoj1ASuF2ncC3aO2Yu7U7uirQTKxcGtSx5aV2WKmdZfAAO8hDHP6w%3D%3D";
	address += "?"+URLEncoder.encode("ServiceKey","UTF-8") +"="+serviceKey;
	address += "&"+URLEncoder.encode("wkpl_nm","UTF-8") +"="+URLEncoder.encode(searchName,"UTF-8");
	address += "&"+URLEncoder.encode("bzowr_rgst_no","UTF-8") +"="+searchPid;
	address += "&"+URLEncoder.encode("_type","UTF-8") + "=json";
			
		
				
		
	//System.out.println(searchPid);
	//System.out.println(searchName);
	//System.out.println(address);
	URL url = new URL(address);
	
	
	
	InputStream in = url.openStream();
	
	ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
	
	IOUtils.copy(in, bos1);
	in.close();
	bos1.close();
	
	String item = bos1.toString("UTF-8"); //바이트 형식으로 들어옴
	
	byte[] b = item.getBytes("UTF-8"); //바이트 배열화
	String s= new String(b,"UTF-8");//바이트를 스트링으로 만들고
	
	// System.out.println(s);
	JSONParser paser = new JSONParser(); //json객체로 변환해줄 객체 생성
	JSONObject pob = (JSONObject)paser.parse(s); //만들어진 결과 스트링을 json객체로 변환
	
	//JSONArray bookInfoArray JSONArray()
	
	
	new Gson().toJson(pob,response.getWriter());//그 객체를 gson을 사용해 넘겨줌

	
	}catch(Exception e) {
		e.printStackTrace();
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
