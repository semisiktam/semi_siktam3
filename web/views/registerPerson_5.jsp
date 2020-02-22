<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입(개인)</title>
    <link rel="stylesheet" href="/siktam/resources/css/register_person_5.css">
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
            <form action="/siktam/mInsert.me" method="post" onsubmit="return validate();">
                <div class="wrap" align="center">
                    <h1 align="center">회원가입</h1>
                    <h4 align="center">회원정보 입력</h4><br>
                <table class="regist">
                    <tr>
                        <th align="left">아이디 </th>
                        <td><input type="text" class="form-control" name="id" id="id" placeholder="영어 소문자+숫자 4~12자리 입력해주세요"></td>  
                        <td><button id="confirm" class="idCheck" type="button">중복 확인</button></td>      
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
                        <td><input type="text" class="form-control" id="name" name="name"></td>       
                    </tr>
                     
                    <tr>
                        <th align="left">주민번호 </th>
                        <td><input type="text" class="form-control" id="pid1" name="pid1" maxlength="6"> - 
                        <input type="text" class="form-control" id="pid2" name="pid2" maxlength="1"> ******
                        </td>      
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
                        <td><input type="tel" class="form-control" id="tel4" name="tel4"></td>
                        
                        
                    </tr> -->
         
                </table><br>
                <div id="chkwrap1" >
                    <h3>약관동의</h3>
                </div>
                <div id="chkwrap2">
                    
                    <div class="all-chk">
                        <label>
                            <input type="checkbox" class="chk_1" name="all_agree" id="all_agree" value="all_agree" onclick="allselect(this.checked)"> 전체동의
                        </label>
                    </div>
                    <div class="chk">
                        <ul>
                            <li class="chk-info">
                                <label>
                                    <input type="checkbox" class="chk_1" name="agree1" id="agree1" value="agree1">
                                    이용약관동의(필수)
                                </label>
                                <a href="termsOfUse_5.jsp" target="_blank"><sub>내용보기</sub></a>
                            </li>
                            <li class="chk-info">
                                <label>
                                    <input type="checkbox" class="chk_1" name="agree1" id="agree2" value="agree2">
                                    개인정보수집 및 이용동의(필수)
                                </label>
                                <a href="termsOfUse_5.jsp" target="_blank"><sub>내용보기</sub></a>
                            </li>
                            <li class="chk-info">
                                <label>
                                    <input type="checkbox" class="chk_1" name="agree1" id="agree3" value="agree3">
                                    전자금융거래 이용약관(필수)
                                </label>
                                <a href="termsOfUse_5.jsp" target="_blank"><sub>내용보기</sub></a>
                            </li>
                            <li class="chk-info">
                                <label>
                                    <input type="checkbox" class="chk_1" name="agree1" id="agree4" value="agree4">
                                    만 14세 이상 이용자(필수)
                                </label>
                                <a href="termsOfUse_5.jsp" target="_blank"><sub>내용보기</sub></a>
                            </li>
                            <li class="chk-info">
                                <label>
                                    <input type="checkbox" class="chk_1"name="agree1" id="agree5" value="agree5">
                                    식탐 혜택알림 동의(선택)
                                </label>
                                <a href="termsOfUse_5.jsp" target="_blank"><sub>내용보기</sub></a>
                            </li>
                            
                            
                        </ul>
                    </div>
                    
                </div>
                <input type="submit" class="btn" value="회원가입">
                
                
                <!-- <input type="reset" class="btn" value="취소"> -->
             </div>
        </form> 
    
        <script>
            function allselect(chd) {
            var agree1 = document.getElementsByName("agree1");
            for (var i = 0; i < agree1.length; i++) {
                agree1[i].checked = chd;
            }
        }
            
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
		    
		    $('.idCheck').click(function(){
		    	$.ajax({
		    		url:"/siktam/idDup.me",
		    		type:"post",
		    		data:{
		    			id:$('#id').val()
		    		},
		    		success:function(data){
		    			console.log(data);
		    			
		    			if(data=='ok'){
		    				alert("사용 가능한 아이디입니다.");
		    			}else{
		    				alert("이미 사용중인 아이디입니다.");
		    				$('#id').select();
		    			}
		    		},error:function(){
		    			console.log("---ERROR---");
		    		}
		    	});
		    });
		    
		    function passwordCheckFunction(){
				var password1 = $("#password1").val();
				var password2 = $("#password2").val();
				if(password1 != password2){
					$("#checkMessage").html("비밀번호 불일치");
				} else {
					$("#checkMessage").html("비밀번호 일치");
				}
			}
		    
		    function validate(){
		    	console.log('test3');
		    	var id = document.getElementById("id");
		    	var pass1 = document.getElementById("password1");
		    	var pass2 = document.getElementById("password2");
		    	var zipCode = document.getElementById("zipCode");
		    	var address1 = document.getElementById("address1");
		    	var address2 = document.getElementById("address2");
		    	var name = document.getElementById("name");
		    	var pid1 = document.getElementById("pid1");
		    	var pid2 = document.getElementById("pid2");
		    	var tel1 = document.getElementById("tel1");
		    	var tel2 = document.getElementById("tel2");
		    	var tel3 = document.getElementById("tel3");
		    	
		    	// 아이디 미입력시 알림
		    	if ((id.value) == ""){
		            alert("아이디를 입력하지 않았습니다.");
		            id.focus();
		            return false;
		        }
		    	
		    	// 비밀번호 미입력시 알림
		    	if ((pass1.value) == "" || (pass2.value)==""){
		            alert("비밀번호를 입력하지 않았습니다.");
		            pass1.focus();
		            return false;
		        }
		    	
		    	// 주소 미입력시 알림
		    	if ((zipCode.value) == "" || (address1.value)=="" || (address2.value)==""){
		            alert("주소를 입력하지 않았습니다.");
		            zipCode.focus();
		            return false;
		        }
		    		    	
		    	// 아이디 유효성 검사
		    	if(!chk(/^[a-z][a-z\d]{3,11}$/,id,"아이디의 첫글자는 영문 소문자, 4~12자 입력하세요!")){
	                return false;
	            }
	            if(!chk(/[0-9]/,id,"아이디에 숫자 하나 이상 포함")){
	                return false;
	            }
	            
	            // 이름 미입력시 알림	            
	            if ((name.value) == ""){
		            alert("이름을 입력하지 않았습니다.");
		            name.focus();
		            return false;
		        }            
	       
	            // 이름 유효성 검사	    
	            if(!chk(/^[가-힣]{2,}/,name,"이름은 한글로 2글자 이상을 넣으세요!")){
	                return false;
	            }
	            
	         	// 전화번호 미입력시 알림	            
	            if ((tel1.value) == "" || (tel2.value) == "" || (tel3.value) == ""){
		            alert("전화번호를 입력하지 않았습니다.");
		            tel1.focus();
		            return false;
		        } 
	         
	            // 전화번호 유효성 검사
	            if(!chk(/^0(2|1[01679])$/,tel1,"지역번호 2자리 이상 입력"))
	                return false;
	            if(!chk(/^[0-9]{3,}$/,tel2,"국번 3자리 이상 입력"))
	                        // 위에 maxlength로 4까지 주었기 때문에 {3,}로 가능
	                return false;
	            if(!chk(/^[0-9]{4}$/,tel3,"전화번호 뒷 4자리 입력"))
	                return false;
	            
	            // 주민번호 앞자리 유효성 검사
	            if(!chk(/([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/,pid1,"주민번호 앞자리를 다시 입력해주세요")){
	            	return false;
	            }
	            
	            // 주민번호 뒷자리 유효성 검사
	            if ((pid2.value) < 1 || (pid2.value) > 4) { 
	            	alert("주민등록번호 뒷자리를 다시 입력하세요.");
	            	pid2.focus();
	            	return false; 
	            }
	            
	            // 주민번호 미입력시 알림
	            if((pid1.value)=="" || (pid2.value)==""){
	            	alert("주민등록번호를 입력하지 않았습니다.");
		            pid1.focus();
		            return false;
	            }
	            	

	            

	            		
	            
	            
		    	
		    }
		    
		    function chk(re, ele, msg){
	            if(!re.test(ele.value)){ 
	                alert(msg);
	                ele.select();
	                console.log("ttses2");
	                return false;
	            }
	            return true;
	        }
        </script>

    

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
