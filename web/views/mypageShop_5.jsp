<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이페이지(업체)</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/mypage_shop_5.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->
    
   
    <div id="wrap">
        <div class ="content" id="content1">
            <h1 align="center">마이페이지_업체</h1><br>
            <hr>
            <div id="imgDiv"><div id="storeImg"></div></div>
            <div id="storeInfo1">
                <ul class="storeInfo2">
                    <li id="userName"><b><%=m.getName() %></b>님 안녕하세요</li>
                    <li><b>내가 등록한 업체</b>
                    <input type="button" class="btn1" value="확인하기" onclick="test5();"></li><hr>
                    <li><b>예약 내역</b>
                    <input type="button" class="btn1" value="확인하기" onclick="test1();"></li><hr>
                    <li><b>결제 내역</b>
                    <input type="button" class="btn1" value="확인하기" onclick="test3();"></li><hr>
                </ul>
            </div>
        </div>

        <div id="modal1">
            <div class="modal_content">
                <h2>예약 내역</h2>
                <br><br>
                <table id="reservationTb1">
                    <thead>
                        <tr class="reservationTr">
                            <th>매장명</th>
                            <th>예약자명</th> 
                            <th>핸드폰 번호</th> 
                            <th>예약 테이블 형태</th> 
                            <th>예약 메뉴</th> 
                            <th>예약 시간</th> 
                            <th>결제 금액</th> 
                            <th colspan="2">예약 수락/거절</th>  
                         </tr>
                    </thead>
                    <tbody>
                        <tr class="reservationTr">
                            <td></td>
                            <td>안도건</td>
                            <td>010-2222-3333</td>
                            <td>1인 테이블</td>
                            <td>김치우동 1</td>
                            <td>12:00~13:00</td>
                            <td>3,500원</td>
                            <td><input type="button" value="수락" class="confirm" id="change"> &nbsp;
                                <input type="button" value="거절" class="confirm" id="cancel"></td>
                        </tr>
                        <tr class="reservationTr">
                            <td>곱창이야기</td>
                            <td>이탐희</td>
                            <td>010-4443-2332</td>
                            <td>1인 테이블</td>
                            <td>곱창모듬 1</td>
                            <td>18:00~19:00</td>
                            <td>11,000원</td>
                            <td><input type="button" value="수락" class="confirm" id="change"> &nbsp;
                                <input type="button" value="거절" class="confirm" id="cancel"></td>
                        </tr>
                        <tr class="reservationTr">
                            <td>역전우동</td>
                            <td>김현희</td>
                            <td>010-3221-4533</td>
                            <td>바 테이블</td>
                            <td>어묵우동 1</td>
                            <td>12:00~13:00</td>
                            <td>4,000원</td>
                            <td><input type="button" value="수락" class="confirm" id="change"> &nbsp;
                                <input type="button" value="거절" class="confirm" id="cancel"></td>
                        </tr>
                        <tr class="reservationTr">
                            <td>싸움의고수</td>
                            <td>서지원</td>
                            <td>010-2678-3243</td>
                            <td>2인 테이블</td>
                            <td>보쌈정식XL 1</td>
                            <td>13:00~14:00</td>
                            <td>7,000원</td>
                            <td><input type="button" value="수락" class="confirm" id="change"> &nbsp;
                                <input type="button" value="거절" class="confirm" id="cancel"></td>
                        </tr>
                        <tr class="reservationTr">
                            <td>곱창이야기</td>
                            <td>권지안</td>
                            <td>010-8554-4313</td>
                            <td>2인 테이블</td>
                            <td>소막창 1</td>
                            <td>18:00~19:00</td>
                            <td>11,000원</td>
                            <td><input type="button" value="수락" class="confirm" id="change"> &nbsp;
                                <input type="button" value="거절" class="confirm" id="cancel"></td>
                        </tr>
                        <tr class="reservationTr">
                            <td>싸움의고수</td>
                            <td>장한솔</td>
                            <td>010-9911-7542</td>
                            <td>1인 테이블</td>
                            <td>족발정식XL 1</td>
                            <td>13:00~14:00</td>
                            <td>8,000원</td>
                            <td><input type="button" value="수락" class="confirm" id="change"> &nbsp;
                                <input type="button" value="거절" class="confirm" id="cancel"></td>
                        </tr>
                        <tr class="reservationTr">
                            <td>역전우동</td>
                            <td>이녹영</td>
                            <td>010-7422-2203</td>
                            <td>바 테이블</td>
                            <td>토마토찍먹우동 1</td>
                            <td>11:00~12:00</td>
                            <td>7,000원</td>
                            <td><input type="button" value="수락" class="confirm" id="change"> &nbsp;
                                <input type="button" value="거절" class="confirm" id="cancel"></td>
                        </tr>
                    </tbody>
                </table>
                <br><br>
                <button id="modal_close_btn1" onclick="test2();">창 닫기</button>
            </div>
            <div class="modal_layer"></div>
        </div>

        <div id="modal2">
            <div class="modal_content">
                <h2>결제 내역</h2>
                <br><br>
                <table id="reservationTb2">
                    <thead>
                        <tr class="reservationTr">
                            <th>매장명</th>
                            <th>예약자명</th> 
                            <th>메뉴</th> 
                            <th>결제금액</th>  
                            <th>결제방식</th>  
                         </tr>
                    </thead>
                    <tbody>
                        <tr class="reservationTr">
                            <td>역전우동</td>
                            <td>안도건</td>
                            <td>김치우동 1</td>
                            <td>3,500원</td>
                            <td>네이버페이</td>
                        </tr>
                        <tr class="reservationTr">
                            <td>곱창이야기</td>
                            <td>이탐희</td>
                            <td>곱창모듬 1</td>
                            <td>11,000원</td>
                            <td>신용카드</td>
                        </tr>
                        <tr class="reservationTr">
                            <td>역전우동</td>
                            <td>김현희</td>
                            <td>어묵우동 1</td>
                            <td>4,000원</td>
                            <td>카카오페이</td>
                        </tr>
                        <tr class="reservationTr">
                            <td>싸움의고수</td>
                            <td>서지원</td>
                            <td>보쌈정식XL 1</td>
                            <td>7,000원</td>
                            <td>네이버페이</td>
                        </tr>
                        <tr class="reservationTr">
                            <td>곱창이야기</td>
                            <td>권지안</td>
                            <td>소막창 1</td>
                            <td>11,000원</td>
                            <td>신용카드</td>
                        </tr>
                        <tr class="reservationTr">
                            <td>싸움의고수</td>
                            <td>장한솔</td>
                            <td>족발정식XL 1</td>
                            <td>8,000원</td>
                            <td>네이버페이</td>
                        </tr>
                        <tr class="reservationTr">
                            <td>역전우동</td>
                            <td>이녹영</td>
                            <td>토마토찍먹우동 1</td>
                            <td>7,000원</td>
                            <td>카카오페이</td>
                        </tr>
                        
                    </tbody>
                </table>
                <br><br>
                <button id="modal_close_btn2" onclick="test4();">창 닫기</button>
            </div>
            <div class="modal_layer"></div>
        </div>

        <div id="modal3">
            <div class="modal_content">
                <h2>업체 정보 수정</h2>
                <br><br>
                <table id="reservationTb1">
                    <thead>
                        <tr class="reservationTr">
                            <th>매장명</th>
                            <th>사업자등록번호</th> 
                            <th>메뉴 카테고리</th> 
                            <th>매장 전화번호</th> 
                            <th>매장 주소</th> 
                            <th colspan="2">정보 수정/삭제</th> 
                         </tr>
                    </thead>
                    <tbody>
                    <%for(Shop s: slist){%>
                        <tr class="reservationTr">
                            <td><%=s.getShopName() %></td>
                            <td><%=s.getOwnerId() %></td>
                            <td><%=s.getMenuCategory() %></td>
                            <td><%=s.getsPhone() %></td>
                            <td><%=s.getsAddr() %></td>
                            <td><input type="button" value="수정" class="confirm" id="change" onclick="location.href='registerCompany_2_5.jsp'">
                                <input type="button" value="삭제" class="confirm" id="cancel"></td>
                        </tr>
                        <%} %>
                        <!-- <tr class="reservationTr">
                            <td>곱창이야기</td>
                            <td>645-88-44154</td>
                            <td>한식</td>
                            <td>02-558-1154</td>
                            <td>서울 서초구 강남대로69길 10</td>
                            <td><input type="button" value="수정" class="confirm" id="change" onclick="location.href='registerCompany_2_5.jsp'">
                                <input type="button" value="삭제" class="confirm" id="cancel"></td>
                        </tr>
                        <tr class="reservationTr">
                            <td>싸움의고수</td>
                            <td>321-55-11545</td>
                            <td>한식</td>
                            <td>02-887-8878</td>
                            <td>서울 서대문구 명물길 20</td>
                            <td><input type="button" value="수정" class="confirm" id="change" onclick="location.href='registerCompany_2_5.jsp'">
                                <input type="button" value="삭제" class="confirm" id="cancel"></td>
                        </tr> -->
                        
                    </tbody>
                </table>
                <br><br>
                <button id="modal_close_btn3" onclick="test6();">창 닫기</button>
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

            function test5(){
                document.getElementById('modal3').style.display = "block";
                document.getElementById('content2').style.display = "none";
            }
            function test6(){
                document.getElementById('modal3').style.display = "none";
                document.getElementById('content2').style.display = "block";
            }
            
            
        
        </script>

        <div class ="content" id="content2">


            <h3 id="contentTxt" align="left">메뉴 등록</h3>


            <div id="registStore">
                <ul>
                <%for(int i=0;i<slist.size();i++){ %>
                    <li>
                  
                        <div class="registStore2"><!--  onclick="location.href='registerMenu_5.jsp'" -->
                            <!-- <img src="/siktam/resources/images/역전우동.png" class="registStoreImg" alt="역전우동" width="170px" height="120px"><br> -->
                            <form action="/siktam/myMenulist.menu" method="get" class=myMenu>
                            <input type="hidden" name="shopPid" value="<%=slist.get(i).getShopPid()%>">
                            <h4 align="center"><%=slist.get(i).getShopName() %></h4>
                            <%-- <p align="center"><small><%=slist.get(i).getsAddr() %></small></p> --%>
                            </form>
                        </div>
                    
                    </li>
                    <%} %>
                    
                    
                   <!--  <li>
                        <div class="registStore2" onclick="location.href='registerMenu_5.jsp'">
                            <img src="/siktam/resources/images/곱창이야기.png" class="registStoreImg" alt="곱창이야기" width="170px" height="120px"><br>
                            <h4 align="center">곱창이야기</h4>
                            <p align="center"><small>서울 서초구 강남대로69길 10</small></p>
                        </div>
                    </li>
                    <li>
                        <div class="registStore2" onclick="location.href='registerMenu_5.jsp'">
                            <img src="/siktam/resources/images/싸움의고수.png" class="registStoreImg" alt="싸움의고수" width="170px" height="120px"><br>
                            <h4 align="center">싸움의고수</h4>
                            <p align="center"><small>서울 서대문구 명물길 20</small></p>
                        </div>
                    </li> -->
                    <li class="registStore2Add">
                        <div>
                            <div id="plusBtn1">
                            <input type="button" id="plusBtn2" value="+" onclick="location.href='registerCompany_2.jsp'">
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            




        <div class ="content" id="content3">
            <h3 id="contentTxt" align="left">다가오는 예약 목록</h3 id="contentTxt">
            
            



            <div id="registStore">
                <ul>
                    <li>
                        <div class="reserve2">
                            <div class="reserve3">
                                <h3>역전우동</h3><br>
                                <h4>장한솔</h4>
                                <p>2020.01.15<br>
                                12:00~13:00<br>
                                </p>
                            </div>
                            <input type="button" value="예약정보확인">
                        </div>
                    </li>
                    <li>
                        <div class="reserve2">
                            <div class="reserve3">
                                <h3>곱창이야기</h3><br>
                                <h4>이탐희</h4>
                                <p>2020.01.16<br>
                                18:00~20:00<br>
                                </p>
                            </div>
                            <input type="button" value="예약정보확인">
                        </div>
                    </li>
                    <li>
                        <div class="reserve2">
                            <div class="reserve3">
                                <h3>역전우동</h3><br>
                                <h4>김현희</h4>
                                <p>2020.01.16<br>
                                15:00~16:00<br>
                                </p>
                            </div>
                            <input type="button" value="예약정보확인">
                        </div>
                    </li>
                    <li>
                        <div class="reserve2">
                            <div class="reserve3">
                                <h3>싸움의고수</h3><br>
                                <h4>권지안</h4>
                                <p>2020.01.17<br>
                                16:00~17:00<br>
                                </p>
                            </div>
                            <input type="button" value="예약정보확인">
                        </div>
                    </li>
                    <li class="registStore2Add">
                        <div>
                            <div id="plusBtn1">
                            <input type="button" id="plusBtn2" value="+">
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            
            
           
        </div>
        </div>
    </div>
    <script>
    $( ".registStore2" ).click(function() {
    	console.log("확인");
    	 $(this).children("form").submit();
    	 
    	});
		/* $(".registStore2").click(function(){
    		var pid=$(this).find(".pid").val();
    		$.ajax({
    			url:"/siktam/myMenulist.menu",
    			type:"get",
    			data:{
    				shopPid:pid
    			} ,success:function(data){
    				
    				console.log(data);
    			} ,error:function(){
    				alert("에러");
    			}
    		
    		});
		});
     */
    </script>







   


    

    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>

