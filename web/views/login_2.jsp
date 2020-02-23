<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>headerfooterLayout</title>
    <link rel="stylesheet" href="/siktam/resources/css/login_2.css">
</head>
<body>
	
    <!-- 이 안에 작업하기 -->
    <div id="container">
        <div id="area1">
            
            <div class="logo">
            <a href="/siktam/listMain.ma"><img src="/siktam/resources/images/KakaoTalk_20200101_193858750.png" alt="logo"></a>    
            </div>
        
        <div class="line"></div>
        <div class="login-wrap">
             
            <form action="/siktam/login.do" method="get">     	  
	            <div class="form">
	            	
		            <input type="text" placeholder="아이디를 입력해주세요!" name="userId" class="info" />
		            <hr>
		            <input type="password" placeholder="비밀번호를 입력해 주세요!" name="password" class="info" />
		            <hr>
		            <button type="submit">Login</button>
		            
		            <div class="idPass">
		                <a href="join_3.jsp"> <p> 아직 아이디가 없나요? 아이디를 만들어 보세요! </p></a>
		                <a href="IdFind_1.jsp"> <p> 아이디/비밀번호가 기억나지 않으세요?</p></a>
		            </div>
	            </div>
            </form>
            
        </div>

        </div>
    </div>


</body>
</html>
