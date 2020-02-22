package test.test.test.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

 class shopIdAPI_sample {
		
		String json;
		shopIdAPI_sample() throws Exception{
			
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("매장명을 입력하세요");
			String searchName = sc.next();
			System.out.println("사업자번호 앞자리 6자리를 입력하세요");
			int searchPid = sc.nextInt();
			String address = "http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch?ldong_addr_mgpl_dg_cd=41&ldong_addr_mgpl_sggu_cd=117&ldong_addr_mgpl_sggu_emd_cd=101&wkpl_nm="
					+ searchName + "&bzowr_rgst_no=" + searchPid + "&pageNo=10&startPage=10&numOfRows=1&pageSize=1&serviceKey=J7gW4zUA9N1YP74mfR%2BCv9bRE1jBZsjxpJoj1ASuF2ncC3aO2Yu7U7uirQTKxcGtSx5aV2WKmdZfAAO8hDHP6w%3D%3D";
		
			System.out.println(address);
		
		
		BufferedReader br;
		URL url;
		HttpURLConnection conn;
		String protocol = "GET";

		url = new URL(address);
		conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod(protocol);
		br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		json = br.readLine();
        //테스트출력
		//System.out.println(json);	
		
		
		
		
		}
		}