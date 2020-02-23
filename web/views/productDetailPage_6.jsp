<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.shop.model.vo.*, com.kh.semi.menu.model.vo.* ,
     com.kh.semi.member.model.vo.*" %>

<% 
	Shop s = (Shop)request.getAttribute("shop");
	ArrayList<Menu> list = (ArrayList<Menu>)request.getAttribute("mList");
	Member mem = (Member)request.getAttribute("member");
	String favorite = String.valueOf(request.getAttribute("favorite"));
	
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상세페이지</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/productDetailPage_6.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
    <!-- 지도 설치 스크립트 -->
    
    <!-- 지도 라이브러리 불러오기 -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b75b48c17de2e99d89241117f1dc015c&libraries=services"></script>
    
    
    <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>


</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->

    <div id="detailbox">
        <!-- 메인 이미지 -->
        <input type="hidden" id="shopPid" value="<%= s.getShopPid() %>"/>
        <div class="pagemainimg"></div>
        
        <!-- 2020.02.10 수정 시작(현희) < 즐겨찾기 추가 > -->
		
        <div class="bookmark">
            <p id="star">★</p>
        </div>
   		
   		<input type="hidden" id="fav" value="<%= favorite %>">
   		
        <script>
        	$(document).ready(function(){
        		if($('#fav').val()=='o'){
        			$('#star').css({'color':'rgb(255, 184, 53)'});
        			$('#star').toggle(function(){
        				$(this).css({'color':'#eee'});
                        $.ajax({
                    	  	url:"/siktam/shopDeleteFavorite.si",
              				type:"get",
              				data:{
              					shopPid : $('#shopPid').val()
              				},
              				success: function(data){
              					console.log(data);
              				},
              				error: function(){
              					console.log("결과 전송 실패");
              				}
                      });
                    },function(){
                    	$(this).css({'color':'rgb(255, 184, 53)'});
                        $.ajax({
                    	  	url:"/siktam/shopInsertFavorite.si",
              				type:"get",
              				data:{
              					shopPid : $('#shopPid').val()
              				},
              				success: function(data){
              					console.log(data);
              				},
              				error: function(){
              					console.log("결과 전송 실패");
              				}
                      });
                    });
        		}else{
        			$('#star').css({'color':'#eee'});
        			$('#star').toggle(function(){
                        $(this).css({'color':'rgb(255, 184, 53)'});
                        $.ajax({
                    	  	url:"/siktam/shopInsertFavorite.si",
              				type:"get",
              				data:{
              					shopPid : $('#shopPid').val()
              				},
              				success: function(data){
              					console.log(data);
              				},
              				error: function(){
              					console.log("결과 전송 실패");
              				}
                      });
                    },function(){
                        $(this).css({'color':'#eee'});
                        $.ajax({
                    	  	url:"/siktam/shopDeleteFavorite.si",
              				type:"get",
              				data:{
              					shopPid : $('#shopPid').val()
              				},
              				success: function(data){
              					console.log(data);
              				},
              				error: function(){
              					console.log("결과 전송 실패");
              				}
                      });
                    });
        		}
        	});
        	
        	/* 탐희 즐겨찾기 AJAX 추가 */
            $(document).ready(function(){
                $('#star').toggle(function(){
                    $(this).css({'color':'rgb(255, 184, 53)'});
                    $.ajax({
                	  	url:"/siktam/shopInsertFavorite.si",
          				type:"get",
          				data:{
          					shopPid : $('#shopPid').val()
          				},
          				success: function(data){
          					console.log(data);
          				},
          				error: function(){
          					console.log("결과 전송 실패");
          				}
                  });
                },function(){
                    $(this).css({'color':'#eee'});
                    $.ajax({
                	  	url:"/siktam/shopDeleteFavorite.si",
          				type:"get",
          				data:{
          					shopPid : $('#shopPid').val()
          				},
          				success: function(data){
          					console.log(data);
          				},
          				error: function(){
          					console.log("결과 전송 실패");
          				}
                  });
                });
            })
        </script>
    
        <!-- 2020.02.10 수정 끝 (현희) -->

        
        <div class="pageselect">
            <!-- %% 업체정보연결-->
            <a href="productDetailPage_6.jsp"><div id="information"><span>업체정보</span></div></a>

            <!-- %% 리뷰연결-->

            <!-- %% 리뷰연결-->
          <a href="/siktam/rPage.ro?shopPid=<%=s.getShopPid()%>&howSelect=new"><div id="review"><span>리뷰</span></div></a>

        </div>
        <!-- 상단 업체명/설명/예약버튼 -->
        <div id="pagetop">
            <h3><%= s.getShopName() %></h3>
            <span><%= s.getsInfo() %></span>
            <!-- %% 예약페이지연결-->
            <input type="button" id="reservation" onclick="location.href='<%=request.getContextPath()%>/reservation.rc?ShopId='+'<%= s.getShopPid()%>'" value="예약하기">
        </div>
		
		
    <!-- 매장정보 -->
    <div id="pageinfo">
        <div id="pageinfodiv">
            <div id="infospan"> 매장정보 </div><div id="infohr"><hr></div>
            <div class="pageicon">
                <img class="iconimg" src="/siktam/resources/images/search.png" alt="">
                <p class="icontext">1인 테이블</p>
            </div>
            <div class="pageicon">
                <img class="iconimg" src="/siktam/resources/images/search.png" alt="">
                <p class="icontext">1인 테이블</p>
            </div>
            <div class="pageicon">
                <img class="iconimg" src="/siktam/resources/images/search.png" alt="">
                <p class="icontext">1인 테이블</p>
            </div>
            <div class="pageicon">
                <img class="iconimg" src="/siktam/resources/images/search.png" alt="">
                <p class="icontext">1인 테이블</p>
            </div><br>
            <p class="infop">매장 전화번호 : </p> <p class="infop2"><%= s.getsPhone() %></p><br>
            <p class="infop">매장 주소 : </p> <p class="infop2"><%=s.getsAddr() %></p><br>
            <p class="infop">매장 영업시간 : </p> <p class="infop2"><%= s.getsTime() %> ~ <%= s.geteTime() %></p><br>
        </div>
    </div>

    <!-- 메뉴 -->
    <div id="pagemenu">
        <div id="pagemenudiv">
            <div id="menuspan"> 메뉴 </div><div id="menuhr"><hr></div>
            
            <!-- 지원 잠시 주석처리 -->
            <% for(Menu me : list) { %>
            <div class="menubox">
                <div class="menuimg"><img src="<%=me.getMenuImg() %>" alt=""></div>
                <div class="menutext">
                    <h4><%=me.getMenuName() %></h4>
                    <p><%=me.getMenuInfo() %></p>
                    <p class="menuprice"><b><%=me.getMenuPrice() %></b></p>
                </div>
            </div>
            <% } %>
            
        </div>
    </div>

    <!-- 상세주소 -->
    <div id="pageaddress">
        <div id="pageaddressdiv">
            <div id="addressspan">상세 주소</div><div id="addresshr"><hr></div>
            <div id="addinfo">
                <p class="infop">업체 주소 :</p> <p class="infop2"><%=s.getsAddr() %></p><br>
                <a href="https://map.kakao.com/link/search/<%=s.getsAddr()%>"><input id="mapButton" type="button" value="카카오맵으로 확인하기!"></a><br>
                <p class="infop">대표자명 : </p> <p class="infop2"><%--<%=mem.getName() %> --%></p><br>
                <p class="infop">사업자 등록번호 : </p> <p class="infop2"><%=s.getOwnerId() %></p><br>
            </div>
            
            <!-- 지도 api -->
            <div id="map" style="width: 430px;height: 300px;border:1px solid black;"></div>
     
            <script>           
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
             mapOption = {
                 center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                 level: 3 // 지도의 확대 레벨
             };  
	         // 지도를 생성합니다    
	         var map = new kakao.maps.Map(mapContainer, mapOption); 	
	         // 주소-좌표 변환 객체를 생성합니다
	         var geocoder = new kakao.maps.services.Geocoder();	
	         // 주소로 좌표를 검색합니다
	         geocoder.addressSearch('<%=s.getsAddr()%>', function(result, status) {	
	             // 정상적으로 검색이 완료됐으면 
	              if (status === kakao.maps.services.Status.OK) {
	                 var coords = new kakao.maps.LatLng(result[0].y, result[0].x);	
	                 // 결과값으로 받은 위치를 마커로 표시합니다
	                 var marker = new kakao.maps.Marker({
	                     map: map,
	                     position: coords
	                 });
	                 // 인포윈도우로 장소에 대한 설명을 표시합니다
	                 var infowindow = new kakao.maps.InfoWindow({
	                     content: '<div style="width:150px;text-align:center;padding:6px 0;">식탐 맛집!</div>'
	                 });
	                 infowindow.open(map, marker);
	                 // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	                 map.setCenter(coords);
	             } 
	         });    
         </script>
	    		
       
            
            
            
            <!-- 지도 api (끝) -->
            <!-- <div id="daumRoughmapContainer1578697903624" 
            class="root_daum_roughmap root_daum_roughmap_landing">
            </div>

            <script charset="UTF-8">
                new daum.roughmap.Lander({
                   "timestamp" : "1578697903624",
                   "key" : "wk9k",
                   "mapWidth" : "400",
                   "mapHeight" : "200"
                }).render();
             </script> -->
        </div>
    </div>






    </div>
 

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
