<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.shop.model.vo.*, com.kh.semi.member.model.vo.*"%>
<% ArrayList<MemberReservationList> mrList = (ArrayList<MemberReservationList>)request.getAttribute("mrList"); 
   ArrayList<Shop> fsList = (ArrayList<Shop>)request.getAttribute("fsList");
	/* Shop se = (Shop)session.getAttribute("selectShop"); */
   /* ArrayList<Shop> mList = (ArrayList<Shop>)session.getAttribute("selectShop");  */
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지(개인)</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/mypage_person_5.css">
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
    <script>
    
    	$(function(){
    		$.ajax({
    			url:"/siktam/shopRecentRecord.sr",
    			type:"get",
    			success:function(data){
    				console.log(data);
    				var $content3 = $('#content3');
    				var $recent = $('.recent');
    				var $ul = $('<ul>');
    				$.each(data,function(index,value){
	    				var $li = $('<li>');
	    				var $recentDiv = $('<div class="registStore2" id="recentDiv">');
	    				var $imgArea = $('<img src="" class="registStoreImg" alt="" width="170px" height="120px"><br>').text(value.shopImg);
	    				var $h4 = $('<h4 align="center">').text(value.shopName);
	    				var $p = $('<p align="center" style="word-break: keep-all;">');
	    				var $small = $('<small>').text(value.sAddr);
    				
	    				$content3.append($recent);
	    				$recent.append($ul);
	    				$ul.append($li);
	    				$li.append($recentDiv);
	    				$recentDiv.append($imgArea);
	    				$recentDiv.append($h4);
	    				$recentDiv.append($p);
	    				$p.append($small);
    				
    				});
    			},error:function(){
    				console.log("오류에요");
    			}
    			
    		});
    		
    	});	

    </script>
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
    <div id="wrap">
        <div class ="content" id="content1">
            <h1 align="center">마이페이지_개인</h1><br>
            <hr>
            <div id="imgDiv"><div id="storeImg"></div></div>
            <div id="storeInfo1">
                <ul class="storeInfo2">
                    <li id="userName"><b><%= m.getName() %></b>님 안녕하세요</li>
                    <li><b>내 프로필</b>
                    <a href="views/registerPerson_5_7.jsp"><input type="button" class="btn1" value="수정하기"></a></li><hr>
                    <li><b>예약 내역</b>
                    <input type="button" id="userReserve" class="btn1" value="수정하기" onclick="test1();"></li><hr>
                    <li><b>결제 내역</b>
                    <input type="button" class="btn1" value="확인하기" onclick="test3();"></li><hr>
                </ul>
            </div>
        </div>
		
		<!-- <form action="/siktam/selectUserReserv.re" method="post"> -->
        <div id="modal1">
            <div class="modal_content">
                <h2>예약 내역</h2>
                <br><br>
                <table id="reservationTb1">
                    <thead>
                        <tr class="reservationTr">
                            <th>매장명</th>
                            <th>예약날짜</th>
                            <th>예약시간</th> 
                            <th>예약메뉴</th> 
                            <th>예약상태</th> 
                         </tr>
                    </thead>
                    <tbody>
                      <%for(MemberReservationList rr : mrList){ %>
	                        <tr class="reservationTr">
	                        	<input type="hidden" class="reserveNo" value="<%=rr.getResNo() %>" />
	                        	<input type="hidden" class="shopPid" value="<%=rr.getShopPid() %>" />
	                            <td><%=rr.getShopName() %></td>
	                            <td><%=rr.getrDate() %></td>
	                            <td><%=rr.getrTime() %></td>
	                            <td ><%=rr.getmNo() %></td>
	                            <%if(rr.getAcceptYN().equals("W")){ %>
	                            <td>대기중</td>
	                            <%} else if(rr.getAcceptYN().equals("Y")){%>
	                            <td>예약확정</td>
	                            <%} else { %>
	                            <td>예약거절</td>
	                            <%} %>
<!-- 	                            변경 클릭 시 예약변경 페이지로 이동
	                            <td colspan="2">
	                            	<td colspan="2"><input type="button" value="변경" class="confirm" id="change" onclick="modify();"> &nbsp;
	                            	<input type="button" value="변경" class="confirm" id="change"> &nbsp;
	                            	<input type="button" value="취소" class="cancel" id="cancel">
	                            </td> -->
	                        </tr>
                       <% } %>
                                      
                    </tbody>
                </table>
                <br><br>
                <button id="modal_close_btn1" onclick="test2();">창 닫기</button>
            </div>
            <div class="modal_layer"></div>
        </div>
        <!-- </form> -->
        

        <div id="modal2">
            <div class="modal_content">
                <h2>결제 내역</h2>
                <br><br>
                <table id="reservationTb2">
                    <thead>
                        <tr class="reservationTr">
                            <th>매장명</th>
                            <th>메뉴</th> 
                            <th>결제금액</th>  
                            <th>결제방식</th>  
                         </tr>
                    </thead>
                    <tbody>
                    
                    	<%for(MemberReservationList rp : mrList){ %>
                    	<%if(rp.getTotalPay()!=0){ %>
                        <tr class="reservationTr">
                            <td><%=rp.getShopName() %></td>
                            <td><%=rp.getmNo() %></td>
                            <td><%=rp.getTotalPay() %></td>
                            <td><%=rp.getPayType() %></td>
                        </tr>
                        <%}  %>
                        <% } %>
                       
                        
                    </tbody>
                </table>
                <br><br>
                <button id="modal_close_btn2" onclick="test4();">창 닫기</button>
            </div>
            <div class="modal_layer"></div>
        </div>

        <script>
            function test1(){
                document.getElementById('modal1').style.display = "block";
                document.getElementById('content2').style.display = "none";
            }

            function test2(){
                document.getElementById('modal1').style.display = "none";
                document.getElementById('content2').style.display = "block";
            }

            function test3(){
                document.getElementById('modal2').style.display = "block";
                document.getElementById('content2').style.display = "none";
            }
            function test4(){
                document.getElementById('modal2').style.display = "none";
                document.getElementById('content2').style.display = "block";
            }
            

            
            $(".confirm").click(function(){
            	var reserveNo = $(this).parent().siblings(":eq(0)").val();
            	/* console.log(reserveNo); */
            	
            	var shopPid = $(this).parent().siblings(":eq(1)").val();
            	/* console.log(shopPid); */
            	location.href="/siktam/reserveModify.rm?reserveNo="+reserveNo+"&shopPid="+shopPid;
            });
             
             $(".cancel").click(function(){
            	 var reserveNo = $(this).parent().siblings(":eq(0)").val();
             	/* console.log(reserveNo); */
             	
             	var shopPid = $(this).parent().siblings(":eq(1)").val();
             	/* console.log(shopPid); */
             	
            	 var confirmAlert = confirm("예약을 취소하시겠습니까?");
            	 if(confirmAlert == true){
            		 location.href="/siktam/reserveModifyDelete.rm?reserveNo="+reserveNo+"&shopPid="+shopPid;
            	 }
            	 else if(confirmAlert == false){
            	   self.close();
            	 }
             	
             })
            
            
            
            
            /*예약내역 ajax
             DB에서 값은 넘어오는데 출력이 안됨
            */
            /*
            $('#userReserve').click(function(){
            	$.ajax({
            		url:"/siktam/selectUserReserv.re",
            		type:"get",
            		 dataType : "json", 
            		success:function(data){
            			console.log(data);
            			$.each(data,function(index,value){
            				var $tr = $('<tr>');
            				var $shopName = $('<td>').text(value.shopName);
            				var $rDate = $('<td>').text(value.rDate);
            				var $rTime = $('<td>').text(value.rTime);
            				var $menu = $('<td>').text(value.menu);
            				var $acceptYn = $('<td>').text(value.acceptYn);
            				var $aa = $('<td>').text(value.acceptYn);
            				
            				$tr.append($shopName);
            				$tr.append($rDate);
            				$tr.append($rTime);
            				$tr.append($menu);
            				$tr.append($acceptYn);
            				$tr.append($aa);
            				
            				$('#reservationTb1').append($tr);
            			});
            		}, error:function(data){
            			console.log("에러입니다.");
            		}
            	});
            });
           */
        </script>
       	 
		<!-- <form action="/siktam/mypageFavorite.mf" method="post"> -->
        <div class ="content" id="content2">
            <h3 id="contentTxt" align="left">내가 즐겨찾기 한 음식점</h3>
            <div id="registStore">
                <ul>
                 <%for(Shop s : fsList){ %>
                    <li>
                        <div class="registStore2" onclick="location.href='productDetailPage_6.jsp'">
                        	<input type="hidden" id="shopPid" value="<%= s.getShopPid() %>"/>
                            <img src="<%=s.getShopImg() %>" class="registStoreImg" alt="" width="170px" height="120px"><br>
                            <h4 align="center"><%=s.getShopName() %></h4>
                            <p align="center"><small><%=s.getsAddr() %></small></p>
                        </div>
                        <div class="bookmark">
                        <p class="star" style="color:rgb(255, 184, 53)">★</a>
                        </div>                        
                    </li>
                    <%} %>
                    
                </ul>
            </div>
           </div>
          <!-- </form> -->
			<script>
                  $(document).ready(function(){
                  	$('.star').toggle(function(){
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
                  });
            </script>



        <div class ="content" id="content3">
            <h3 id="contentTxt" align="left">최근 들여다 본 음식점</h3 id="contentTxt">
                
            
                <div id="registStore" class="recent">
                 
                </div>

        </div>
    
        
    </div>
            
    

    <!-- 푸터 시작 -->
   <%@ include file="common/footer.jsp" %>
</body>
</html>
    