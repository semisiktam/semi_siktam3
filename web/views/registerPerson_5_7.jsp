<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원정보 수정</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/register_person_5_7.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
            <form action="/siktam/mUpdate.me" method="post" onsubmit="return validate();">
                <div class="wrap" align="center">
                    <h1 align="center">회원정보 수정</h1>
                    <h4 align="center">수정정보 입력</h4><br>
                <table class="regist">
                    <tr>
                        <th align="left">아이디 </th>
                        <td><input type="text" class="form-control" name="id" value="<%=m.getUserId() %>" disabled></td>      
                    </tr>
                    <tr>
                        <th align="left">비밀번호 </th>
                        <td><input type="password" id="password1" class="form-control" name="pass1" placeholder="비밀번호를 입력해주세요"></td>      
                    </tr>  
                    <tr>
                        <th align="left">비밀번호 확인 </th>
                        <td><input type="password" id="password2" onkeyup="passwordCheckFunction();" class="form-control" name="pass2" placeholder="비밀번호를 다시 입력해주세요"></td>        
                    	<td><span id="checkMessage" style="color:red;font-weight:bold"></span></td>
                    </tr> 
                    <tr>
                        <th align="left">우편번호검색 </th>
                        <td><input type="text" class="form-control" id="zipCode" name="zipCode"></td>
                        <td><input type="button" id="confirm" onclick="addrSearch();" value="검색하기"></td>       
                    </tr>
                    <tr>
                        <th align="left">주소 </th>
                        <td><input type="text" class="form-control" id="address1" name="address1"></td>      
                    </tr>
                    <tr>
                        <th align="left">상세주소 </th>
                        <td><input type="text" class="form-control" id="address2" name="address2"></td>    
                    </tr>
                     
                    <tr>
                        <th align="left">이름 </th>
                        <td><input type="text" class="form-control" name="name" value="<%=m.getName()%>"></td>       
                    </tr>

                    <tr>
                        <th align="left">휴대폰 번호 </th>
                        <td><input type="text" class="tel-control" id="tel1" name="tel1" maxlength="3"> -
                        <input type="text" class="tel-control" id="tel2" name="tel2" maxlength="4"> -
                        <input type="text" class="tel-control" id="tel3" name="tel3" maxlength="4">
                        </td>
                        <!-- <td><button id="confirm">휴대폰인증</button></td> -->
                    </tr>
                    <!-- 
                    	휴대폰 인증 보류
                    <tr>
                        <th align="left">인증번호 입력 </th>
                        <td><input type="tel" class="form-control" name="tel"></td>
                    </tr> -->
         
                </table><br>
                <input type="submit" class="btn" value="수정">
                <input type="button" class="btn" value="탈퇴" onclick="passwordChk()">

                <br><br>
            </div>
       </form>
       <script>
       function passwordChk(){
    	   var password = prompt("비밀번호를 입력하세요");
    	   var userPassword = '<%=m.getPassword()%>';
    	   
    	   if(password!=userPassword){
    		   alert("비밀번호가 틀렸습니다. 다시 입력해주세요.");
    		   password.focus();
    	   }else{
    		   location.href="/siktam/deleteMember.dm"
       			+"?password="+password;
    	   }
    	   
       }
       
       $(function(){
    	   var addressArr = '<%= m.getAddr() %>'.split(', ');
			
			$('#zipCode').val(addressArr[0]);
			$('#address1').val(addressArr[1]);
			$('#address2').val(addressArr[2]);
			
			var phoneArr = '<%= m.getPhone()%>'.split('-');
			
			$('#tel1').val(phoneArr[0]);
			$('#tel2').val(phoneArr[1]);
			$('#tel3').val(phoneArr[2]);
			
       })
    // 참조 API : http://postcode.map.daum.net/guide
		function addrSearch() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullAddr = ''; // 최종 주소 변수
	                var extraAddr = ''; // 조합형 주소 변수

	                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    fullAddr = data.roadAddress;

	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    fullAddr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
	                if(data.userSelectedType === 'R'){
	                    //법정동명이 있을 경우 추가한다.
	                    if(data.bname !== ''){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있을 경우 추가한다.
	                    if(data.buildingName !== ''){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
	                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                $('#zipCode').val(data.zonecode); //5자리 새우편번호 사용
	                
	                $('#address1').val(fullAddr);

	                // 커서를 상세주소 필드로 이동한다.
	                $('#address2').focus();
	            }
	        }).open();
	    };
	    
	    function passwordCheckFunction(){
			var password1 = $("#password1").val();
			var password2 = $("#password2").val();
			if(password1 != password2){
				$("#checkMessage").html("비밀번호 불일치");
			} else {
				$("#checkMessage").html("비밀번호 일치");
			}
		}
       
       </script>
       

    

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
