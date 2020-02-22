<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%
	String userId = (String) request.getAttribute("mem");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/siktam/resources/css/header_idpw.css">
<link rel="stylesheet" href="/siktam/resources/css/IdFind_1.css">
<title>Find Id</title>

</head>

<body>
	<%@ include file="common/header_idpw.jsp"%>

	<!-- 여기부터 -->
	<div id="container">

		<div id="area1">
			<a href="main_6.jsp">
				<div id="area1Img">
					<img
						src="/siktam/resources/images/KakaoTalk_20200101_193858750.png"
						alt="">
				</div>
			</a> <a href="IdFind_1.jsp">
				<div id="area3">
					<div class="idDiv">
						<h1>아이디 찾기</h1>
						<hr class="hr">
					</div>
			</a> <a href="FindPassword_1.jsp">
				<div class="pwdDiv">
					<h1>비밀번호 찾기</h1>
					<hr class="hr">
				</div>
		</div>
		</a>
		<div id="area2">
			<div class="div2">
				<h4>아이디 찾기 방법 중 가능한 방법을 선택해 주세요.</h4>
				<br>
<%--  				<div>
					<input type="radio" id="phone" class="radio" name="find"
						onclick="divshow();">&nbsp;<label for="phone">이메일
						인증</label><br>
					<div id="f1" class="radioDiv" style="display: none;">
						내 명의로 가입한 아이디와, 이름/이메일이 일치하는 아이디를 찾습니다<br> <input
							type="button"
							onclick="location.href='<%=request.getContextPath()%>FindIdResult.jsp'"
							value="다음단계">
					</div>
				</div>  --%>
				<div>
					<form action="/siktam/fip.me" method="post">
						<input type="radio" id="rphone" class="radio" name="find"
							onclick="divshow();">&nbsp;<label for="rphone">등록된
							핸드폰으로 찾기</label><br>
						<div id="f1" class="radioDiv">
							<input type="text" class="text" name="phoneName" id="phoneName"
								placeholder="이름을 입력해 주세요" required><br> <input type="text"
								class="text" name="phoneNumber" id="phoneNumber" placeholder="가입했을때 등록된 핸드폰 번호" required>&nbsp;
							<input type="button" id="idresult1" value="찾기">

						</div>
					</form>
				</div>
<!-- 				<div>
					<form action="/siktam/fie.me" method="post">
					<input type="radio" id="email" class="radio" name="find"
						onclick="divshow();">&nbsp;<label for="email">등록된
						이메일로 찾기</label><br>
					<div id="f3" class="radioDiv">
					<input type="text" class="text" name="emailName" id="emailName" placeholder="이름을 입력해주세요" required>&nbsp;
					<input type="email" class="text" name="eemail" id="eemail" placeholder="이메일을 입력해주세요" required>&nbsp;
							<input type="button" id="idresult3" value="다음단계">
					</div>
				</div> -->
				<div>
					<form action="/siktam/fibg.me" method="post">
						<input type="radio" id="pid" class="radio" name="find"
							onclick="divshow();">&nbsp;<label for="pid">등록된
							이름/생년월일/성별 찾기</label><br>
						<div id="f2" class="radioDiv">
							<input type="text" class="text" name="BirthName" id="BirthName"
								placeholder="이름을 입력해 주세요" required>&nbsp;
								<input
								type="text" class="text" name="Birth" id="Birth"
								placeholder="주민번호 앞자리를 입력하세요(900217형식으로 입력)" required>&nbsp;
							<input type="text" class="text" name="Gender" id="Gender"
								placeholder="성별을 입력해 주세요(남성/여성으로 입력)" required>&nbsp;
								<input type="button" id="idresult2" value="찾기">
								
							<!-- <input
								type="date" name="Birth" id="Birth" class="text">&nbsp;
							<select style="height: 29px;" id="Gender" name="Gender">
								<option value="남자">남자</option>
								<option value="여자">여자</option>
							</select> -->
					</form>
				</div>
			</div>
		</div>


		<script>
        function divshow() {
            if ($('input:radio[id=rphone]').is(':checked')) {
                $('#f1').slideDown();
            } else {
                $('#f1').slideUp();
            }
            if ($('input:radio[id=pid]').is(':checked')) {
                $('#f2').slideDown();
            } else {
                $('#f2').slideUp();
            }
        }
/*             if ($('input:radio[id=email]').is(':checked')) {
                $('#f3').slideDown();
            } else {
                $('#f3').slideUp();
            }
            if ($('input:radio[id=pid]').is(':checked')) {
                $('#f4').slideDown();
            } else {
                $('#f4').slideUp();
            } */

        
<%--           function IdResultph(){
       	 if('<%=userId%>' != null && '<%=userId%>' !=""){
       		 alert("찾으시는 아이디는" + '<%=userId%>' + "입니다.");
       	 }else{
       		 alert("찾으시는 아이디가 없습니다");
       	 }
       	 	
        } 
         --%>
        
         $("#idresult1").click(function(){
 			$.ajax({
 				
 				url : "/siktam/fip.me",
 				type : "get",
 				data :{
 					phoneName:$('#phoneName').val(),
 					phoneNumber:$('#phoneNumber').val()
 				}, success:function(result){
 					 
 					if(!result==""){
 						alert(result);
 					}else{
 						alert("해당하는 아이디가 없습니다");
 					}
 					
 				},error :  function(request,errorcode,error){
 					alert("페이지에러");

 				}
 			});
 		});
         
         
         
          $("#idresult2").click(function(){
			$.ajax({
				
				url : "/siktam/fibg.me",
				type : "get",
				data :{
					BirthName:$('#BirthName').val(),
					Birth:$('#Birth').val(),
					Gender:$('#Gender').val()
				}, success:function(result){
					 
					if(!result==""){
						alert(result);
					}else{
						alert("해당하는 아이디가 없습니다");
					}
					
				},error :  function(request,errorcode,error){
					alert("페이지에러");

				}
			});
		});
          
          

          
/*           function  popup(){
             var url = "FindIdResult.jsp";
             var name = "아이디찾기결과";
             var option = "width = 300, height = 150, top = 100, left = 200, location = no"
             window.open(url, name, option);
         } 
 */

    </script>


		<div class="div3">
			비밀번호 찾으시나요? &nbsp;<a href="FindPassword_1.jsp" style="color: black;">비밀번호
				찾기 (이동)</a>
		</div>
		<br>
	</div>
	</div>


</body>

</html>
