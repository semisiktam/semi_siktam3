<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String userId=(String)session.getAttribute("userId");
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입(업체)</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/registerCompany_2.css">
    <script src="/siktam/resources/js/jquery-3.4.1.min.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
    <input type="file" id="file" style="display:none;">
    <form action="/siktam/sInsert.sh" method="get">
        <div class="wrap" align="center">
            <h1 align="center">업체등록</h1>
            <%if(m!=null){ %>
            	<h4 align="center"><b><%=m.getName() %></b>님! 식탐과 함께 할 매장을 등록해주세요!</h4><br>
            <%} else{%>
            	<h4 align="center"><b><%=userId %></b>님! 식탐과 함께 할 매장을 등록해주세요!</h4><br>
            <%} %>
        <table class="regist">
            <tr>
                <th align="left">매장명 </th>
                <td><input type="text" class="form-control" name="shopName" placeholder="매장명을 등록해주세요"></td>  
                <!-- <td><button id="confirm">중복 확인</button></td>       -->
            </tr>
            <tr>
                <th align="left">매장 사진 </th>
                <td>
                    <!-- <input type="text" class="form-control" name="pass1" placeholder=""> -->
                    <!-- <button id="upload" type="button" onclick="oncolick=document.all.file.click()">매장 사진 등록하기</button> -->
                    <!--평소에는 보이지 않다가 사진을 등록하면 script를 통해 div를 추가시킬 예정-->
                    <!--버튼 클릭시 파일을 삽입할 수 있도록 할 예정 -->
                    <!-- <input type="file" name="uploadFile" id="uploadFile" multiple>
                    <div id="preview"></div> -->
                    <input type="file" name="shopImg" style="width:500px;" accept="image/*" multiple onchange="fileInfo(this)" /><br>
                    <div id="img_box"></div>
                
                </td>    
            </tr>  
            
            <tr>
                <th align="left">우편번호검색 </th>
                <td><input type="text" class="form-control" id="zipCode" name="zipCode">
                <input type="button" id="confirm" onclick="addrSearch();" value="검색하기">
                </td>
           </tr>
           <tr>
                <th align="left">주소 </th>
                <td><input type="text" class="form-control" id="address1" name="address1"></td>      
           </tr>
           <tr>
                <th align="left">상세주소 </th>
                <td><input type="text" class="form-control" id="address2" name="address2"></td>    
           </tr>  
                    
                    
            <!-- <tr>
                <th align="left">매장주소 </th>
                <td><input type="text" class="form-control" name="address" placeholder=""></td>        
            </tr>  -->
            <tr>
                <th align="left">매장 전화번호 </th>
                <td><input type="text" class="form-control" name="phone"></td>       
            </tr>
             
            <tr>
                <th align="left">사업자 등록번호 </th><!--사업자 등록 조회 API삽입-->

                <!--<td> <input type="text" class="form-control" name="pid"> -->
                   <!--  <<button id="shopNum" onclick="window.open('ShopPidCheck.jsp','사업자 번호 조회','width=300,height=100,location=no,status=no,scrollbars=no')">;
                    </button> -->
                <td><input type="text" class="form-control" name="pid" id="ShopPid_reg" placeholder="체크하기 버튼을 누르세요" readonly>
                    
                    <input type="button" id="shopNum" value="체크하기" placeholder="앞자리6자리" onclick="openPidChk()">

                </td>       
                
            </tr>
             
            <tr>
                <th align="left">영업시간 </th>
                <td>
                    <input type="time" name="startTime">부터
                    <input type="time" name="endTime">까지
                    <br>
                    <input type="text" style="width:200px" name="Day" placeholder="휴무일을 입력해주세요">
                    
                </td>
                <!-- <td><input type="text" class="form-control" id="pid1" name="pid" maxlength="6"> -  -->
                <!-- <input type="text" class="form-control" id="pid2" name="pid" maxlength="1"> ****** -->
                <!-- </td>       -->
            </tr>

            <tr>
                <th align="left">메뉴 카테고리 </th>
                <td><div id="category">
                    <input type="checkbox" name="eatType" id="a" value="한식"><label for="a">한식</label>
                    <input type="checkbox" name="eatType" id="b" value="중식"><label for="b">중식</label>
                    <input type="checkbox" name="eatType" id="c" value="분식"><label for="c">분식</label>
                    <input type="checkbox" name="eatType" id="d" value="양식"><label for="d">양식</label>
                    <input type="checkbox" name="eatType" id="e" value="일식"><label for="e">일식</label><br>
                    <input type="checkbox" name="eatType" id="f" value="카페/디저트"><label for="f">카페/디저트</label>&nbsp;
                    <input type="checkbox" name="eatType" id="g" value="치킨"><label for="g">치킨</label>
                    <input type="checkbox" name="eatType" id="h" value="피자"><label for="h">피자</label>
                    <input type="checkbox" name="eatType" id="i" value="족발/보쌈"><label for="i">족발/보쌈</label><br>
                    <input type="checkbox" name="eatType" id="j" value="도시락"><label for="j">도시락</label>
                    <input type="checkbox" name="eatType" id="k" value="찜/탕"><label for="k">찜/탕</label>
                    <input type="checkbox" name="eatType" id="l" value="프랜차이즈"><label for="l">프랜차이즈</label>
                </div></td>
                <!-- <td><input type="tel" class="form-control" name="tel"></td> -->
                <!-- <td><button id="confirm">휴대폰인증</button></td> -->
            </tr>
                <!-- <tr>
                    <th align="left">메뉴 등록 </th>
                    <td>
                        <h4>메뉴명<br></h4><input type="text" class="form-control" name="menuName"><br>
                        <h4>사진등록<br></h4><input type="text" class="form-control" name="menuImg">등록한 사진의 경로를 표시
                        &nbsp;
                        <button type="button" id="upload2" onclick="document.all.file.click();">메뉴사진등록</button><br>
                        <h4>가격<br></h4>
                        <input type="text" class="form-control" name="menuPrice"><br>
                        
                        <h4>기타설명<br></h4>
                        <input type="text" class="form-control" name="menuInfo"><br><br>
                        
                        <button type="button" id="menu" ><h3>메뉴 등록</h3></button>메뉴등록 버튼을 누르면 등록한 사진과 value를 바탕으로 하단에 메뉴 생성
                        
                        <div id="uploadpic2" style="width: 100px; height: auto; background: white; color:black; margin-top:10px;">
                           이미지를 디코드 할 방법 모색이 필요해 보임 size를 설정해도 div 태그를 넘어감
                        </div>메뉴명의 vaule와 등록한 사진 경로로 이미지 등록할 예정
                    </td>
                </tr> -->


            <tr>
                <th align="left">테이블형태</th>
                <td><div id="tableForm">
                    <input type="checkbox" name="table" id="t1" value="1인석"><label for="t1">1인석</label>
                    <input type="checkbox" name="table" id="t2" value="2인석"><label for="t2">2인석</label>
                    <input type="checkbox" name="table" id="t3" value="칸막이"><label for="t3">칸막이</label>
                    <input type="checkbox" name="table" id="t4" value="바테이블"><label for="t4">바테이블</label>
                    <input type="checkbox" name="table" id="t5" value="셀프주문"><label for="t5">셀프주문</label>
                </div></td>
            </tr>
            
 
        </table><br>
        </form>
        <button class="button" type="submit">업체 등록 완료</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/siktam/listMain.ma"><button class="button" type="button">업체 등록 취소</button></a>
        
        <script>
            $("#upload").click(function(){
                $("#uploadpic1").css("display","block");
                console.log("aaaa")
            });
            $("#menu").click(function(){
                $("#uploadpic2").css("display","block").css("background","gray");
                
                console.log("aaaa")
            });
            
            
            
            
            
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
   		    
   		    /*사업자번호 조회 관련*/
   		    
    
        var openChk;
    
        function openPidChk()
        {
            window.name = "/siktam/spc.me";
            openChk = window.open("/siktam/views/ShopPidCheck.jsp",
                    "사업자번호체크", "width=560, height=50, resizable = no, scrollbars = no status= no");    
        }
    		    
   		    
        </script>
    </div>
    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
