<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/siktam/resources/css/header_idpw.css" type="text/css"/>
    <link rel="stylesheet" href="/siktam/resources/css/FindPassword_1.css" type="text/css"/>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>Find Id</title>
    <script>
    	$(function(){
    		$('#nextPwd').click(function(){
           		$.ajax({
           			url:"/siktam/idchk.me",
           			type:"get",
           			data:{
           				idchk:$('#nextPwdId').val()
           			},success:function(data){
           				console.log(data);
           				if(data == 1){
           					// 성공
           					alert("비밀번호 찾기 단계로 넘어갑니다.")
           					location.href="/siktam/views/HowFindPassword_1.jsp";
           				}else{
           					alert("등록된 아이디가 아니거나 공란입니다. 다시 확인하십시오");
           					$('#nextPwdId').select();
           				}
           			},error:function(){
           				console.log("에러");
           			}
           		});
           	});	
    	});
       	
       	
       
        </script>
</head>

<body>
    <%@ include file="common/header_idpw.jsp" %>

    <!-- 여기부터 -->
    <div id="container">

        <div id="area1">
            <a href="/siktam/views/main_6.jsp">
            <div id="area1Img">
                <img src="/siktam/resources/images/KakaoTalk_20200101_193858750.png" alt="">
            </div>
            </a>
        <div id="area3">
            <a href="/siktam/views/IdFind_1.jsp">
            <div class="idDiv">
                <h1>아이디 찾기</h1>
                <hr class="hr">
            </div>
            </a>
            <a href="FindPassword_1.jsp">
            <div class="pwdDiv">
                <h1>비밀번호 찾기</h1>
                <hr class="hr">
            </div>
            </a>
        </div>
        <div id="area2">
        <div class="div2">
        <!--      <h4>아이디를 입력해주세요.</h4>-->
            <input type="text" class="text" placeholder="아이디를 입력해 주세요" id="nextPwdId" name="nextPwdId" required>&nbsp;
            <input type="button" id="nextPwd" value="다음단계">
        </div>

        <div class="div3">
            아이디를 모르시나요? &nbsp;<a href="IdFind_1.jsp" style="color: black;">아이디 찾기 (이동)</a>
        </div>
        <br>
        </div>
    </div>
    </div>
    
    
   
</body>

</html>
