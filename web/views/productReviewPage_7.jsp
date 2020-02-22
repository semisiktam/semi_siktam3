<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.review.model.vo.*"%>
<%
	ArrayList<Review> rList = (ArrayList<Review>)request.getAttribute("reviewList"); 
	ArrayList<Review> allReviewList = (ArrayList<Review>)request.getAttribute("allReviewList"); 
	Shop s = (Shop)request.getAttribute("shop");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ReviewScore rScore = (ReviewScore)request.getAttribute("ReviewScore");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage(); 
	/* Member mem = (Member)session.getAttribute("member"); */
%>   

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>리뷰 페이지</title>
    <link rel="stylesheet" href="/siktam/resources/css/headerfooterLayout.css">
    <link rel="stylesheet" href="/siktam/resources/css/productReviewPage_7.css">
    <script src="/siktam/resources/js/jquery-3.4.1.min.js"></script>

</head>
<body>
    <!-- 헤더 시작 -->
    <%@ include file="common/header.jsp" %>

    <!-- 이 안에 작업하기 -->

    <div id="all"> <!-- 전체 div-->
        <div class="pagemainimg"></div>
        <div class="pageselect">
            <!-- %% 업체정보연결-->
            <a href="productDetailPage_6.jsp"><div id="information"><span>업체정보</span></div></a>
            <!-- %% 리뷰연결-->
            <a href="productReviewPage_7.jsp"><div id="review"><span>리뷰(<%= allReviewList.size() %>)</span></div></a>
        </div>

        <div id="pagetop">
            <h3><%= s.getShopName() %></h3>
            <span><%= s.getsInfo() %></span>
        </div>

        <br>
        <h3>매장 평점</h3>
        <hr>

        <div id="score"> <!-- 평점 -->
            <div id="number" class="scoreIn">
                <h3 id="numberScore"><%= rScore.getScore() %>점</h3><br>
                <!--<img id="scoreNumber" src="/siktam/resources/images/star.png" alt="">-->
                <!-- <div class="starRev">
                    <span class="starR on">별1</span>
                    <span class="starR">별2</span>
                    <span class="starR">별3</span>
                    <span class="starR">별4</span>
                    <span class="starR">별5</span>
                </div> -->
               <p id="star_grade">
                    <a href="#">★</a>
                    <a href="#">★</a>
                    <a href="#">★</a>
                    <a href="#">★</a>
                    <a href="#">★</a>
                </p>
                
            </div>
            <div id="scores" class="scoreIn">
                <h4 class="jum">5점&nbsp;&nbsp;<progress value="<%= rScore.getFive() %>" max="<%= allReviewList.size() %>" class="var">Progress : 30%</progress></h4><br>
                <h4 class="jum">4점&nbsp;&nbsp;<progress value="<%= rScore.getFour() %>" max="<%= allReviewList.size() %>" class="var"></progress></h4><br>
                <h4 class="jum">3점&nbsp;&nbsp;<progress value="<%= rScore.getThree() %>" max="<%= allReviewList.size() %>" class="var"></progress></h4><br>
                <h4 class="jum">2점&nbsp;&nbsp;<progress value="<%= rScore.getTwo() %>" max="<%= allReviewList.size() %>" class="var"></progress></h4><br>
                <h4 class="jum">1점&nbsp;&nbsp;<progress value="<%= rScore.getOne() %>" max="<%= allReviewList.size() %>" class="var"></progress></h4><br>
                
            </div>
        </div>

        <br>
        <h4>리뷰</h4>
        <hr>
        <br>

        <div>
			
            <div id="wReview">
                <button id="wReviewbtn">리뷰 작성</button>
                <p>리뷰 쓰기</p>
            </div>
            <br>
            <div id="select1"> <!-- 리뷰 시작 -->
                <label>정렬방식</label> <!-- 리뷰 정렬 방식 선택-->
                <select id="selectArray" name="selectArray" > <!-- TODO -->
                    <option value="new">최신순</option>
                    <option value="rowScore">별점 낮은 순</option>
                    <option value="highScore">별점 높은 순</option>
                </select>
            </div>
            <br>
        </div>
        
        <br>
		<% if(m != null){ %>
	        <div id="reviewWriteText">
				<form action="/siktam/rInsert.ro" method="post" enctype="multipart/form-data" id="reviewForm">
	            <div class="allReview" id="writeReview">
	                <div>
	                    <img class="id1" src="/siktam/resources/images/person1.png" alt="">&nbsp;&nbsp;<label class="idLabel"><%= m.getUserId() %></label>
	                </div>
	                <br>
	                <label>별점 : </label>
	                <label id="star_grade_review">
	                    <a href="#">★</a>
	                    <a href="#">★</a>
	                    <a href="#">★</a>
	                    <a href="#">★</a>
	                    <a href="#">★</a>
	                </label>
	                <br><br>
	                <div>
	                    <label>사진 등록 : </label>
	                    <label>
	                        <input type="file" id="ex_file" accept="image/*" name="file">
	                    </label>
	                    <br><br>
	                    <textarea name="review" id="reviewText" cols="105" rows="10" placeholder="리뷰를 작성해 주세요"></textarea>
	                    <br>
	                    <button id="rwbtn" class="rwbtn">리뷰등록</button>
	                </div>
	            </div>
	   			</form>    
	        </div>
        <% }%>
        
        <br><br><br>

        <!-- 각 버튼은 리뷰 상세를 열고 닫는 버튼 설정 TODO-->

			<div class="allReview" id="reviewReview">
		<% for(Review r : rList){ %>
			
            <div class="personInfo">
                <img class="id1" src="/siktam/resources/images/person1.png" alt="">&nbsp;&nbsp;<label class="idLabel"><%= r.getUserId() %></label>
                <div class="bottomBtn">
                	<button id="btn1" class="reviewBtn">▼</button>
                ▼</div>
            </div>
            
            <div id="personReview1" class="personReview">
            	<div class="scoreScore" style="display : none;"><%= r.getScore() %></div>
                <label>별점 : </label>
                <label id="star_view1">
                    <a href="#">★</a>
                    <a href="#">★</a>
                    <a href="#">★</a>
                    <a href="#">★</a>
                    <a href="#">★</a>
                </label>
                <br><br>
                <div class="imgDiv">
                    <img src="/siktam/resources/images/<%=r.getReviewImg() %>" class="reviewImg" alt="">
                </div>
                <br>
                <p><%= r.getrContent() %></p>
            </div>
		<% } %>
        </div>
        
        <br>
        
        <!-- 페이지 버튼 -->
        
         <div class="pagingArea" align="center">
			<button onclick="location.href='<%= request.getContextPath() %>/rPage.ro?shopPid=<%=s.getShopPid()%>&currentPage=1'"><<</button>
			<%  if(currentPage <= 1){  %>
			<button disabled><</button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/rPage.ro?shopPid=<%=s.getShopPid()%>&currentPage=<%=currentPage - 1 %>'"><</button>
			<%  } %>
			
			<% for(int p = startPage; p <= endPage; p++){
					if(p == currentPage){	
			%>
				<button disabled><%= p %></button>
			<%      }else{ %>
				<button onclick="location.href='<%= request.getContextPath() %>/rPage.ro?shopPid=<%=s.getShopPid()%>&currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
			<% } %>
				
			<%  if(currentPage >= maxPage){  %>
			<button disabled>></button>
			<%  }else{ %>
			<button onclick="location.href='<%= request.getContextPath() %>/rPage.ro?shopPid=<%=s.getShopPid()%>&currentPage=<%=currentPage + 1 %>'">></button>
			<%  } %>
			<button onclick="location.href='<%= request.getContextPath() %>/rPage.ro?shopPid=<%=s.getShopPid()%>&currentPage=<%= maxPage %>'">>></button>
			
		</div>
        <br>
		
        <script>
        
        	
            $(function(){
				
            	$('#star_grade_review a').click(function(event){
            		
            		event.preventDefault ? event.preventDefault() : (event.returnValue = false);
            		
            		$(this).parent().children('a').removeClass('on');
            		$(this).addClass('on').prevAll('a').addClass('on');
            		
            	});
            	
            	$('#rwbtn').click(function(){
            		
            		alert("버튼 입력");
            			
	            	$('#reviewForm').attr("action","/siktam/rInsert.ro?shopPid=<%=s.getShopPid()%>&userId=<%=m.getUserId()%>&rScore="+$('#star_grade_review a.on').length+"&rContent="+$('#reviewText').val()); 
            		
            	});
            	
                $('.personReview').css('display','none');
                
                $('.personInfo').click(function(){
                	$(this).next().slideToggle();
                	var score = $(this).next().children('div').eq(0).text()-1;
                	$(this).next().children('label').eq(1).children('a').eq(score).addClass("on").prevAll('a').addClass('on');
                })
                
                $('#reviewWriteText').css('display','none');

				<% if ( rScore.getScore() < 1.5 ) {%>
                	$("#star_grade a").eq(0).addClass("on").prevAll("a").addClass("on").preventEvent();
				<% } else if ( rScore.getScore() < 2.5 ) {%>
            		$("#star_grade a").eq(1).addClass("on").prevAll("a").addClass("on").preventEvent();
				<% } else if ( rScore.getScore() < 3.5 ) {%>
        			$("#star_grade a").eq(2).addClass("on").prevAll("a").addClass("on").preventEvent();
				<% } else if ( rScore.getScore() < 4.5 ) {%>
            		$("#star_grade a").eq(3).addClass("on").prevAll("a").addClass("on").preventEvent();
				<% } else {%>
					$("#star_grade a").eq(4).addClass("on").prevAll("a").addClass("on").preventEvent();
				<% } %>
				
        });
            
        <% if(m != null) {%>
        
	      $(function(){
	    	  $('#wReviewbtn').click(function(){
                 	$('#reviewWriteText').slideToggle();
              });
	      });
        <% }else{%>
        	$(function(){
	    	  $('#wReviewbtn').click(function(){
               	alert("로그인 먼저 해주세요!");
            });
	      });
        <%}%>
        
        
        $("#select1").on({
            click: function () {
            	var selecthow = $('#selectArray').val();
            	console.log(selecthow);
            	$.ajax({
            		url : "/siktam/review.do?shopPid=<%=s.getShopPid()%>&howSelect="+selecthow,
            		type: "GET",
            		data:{
            			howSelect : selecthow
            		}, success:function(data){
            			console.log(data["rList"].length);
            			
                    	$('#reviewReview').children().remove();
                    
            			$.each(data["rList"],function(index,value){
            				console.log(value);
            				
            				
            				
            				var $div1 = $('<div class="personInfo">');
            				
            				var $label1 = $('<label class="idLabel">').html(value.userId)
            				// 아래 두개 묶음
            				var $div2 = $('<div class="bottomBtn">');
            				var $btn1 = $('<button id="btn1" class="reviewBtn">▼</button>▼');
            				
            				var $div3 = $('<div id="personReview1" class="personReview">');
            				var $div4 = $('<div style="display : none;">').text(value.score);
            				var $label2 = $('<label>별점 : ');
            				// 아래  묶음
            				var $label3 = $('<label id="star_view1">');
            				var $a1 = $('<a href="#">★');
            				var $a2 = $('<a href="#">★');
            				var $a3 = $('<a href="#">★');
            				var $a4 = $('<a href="#">★');
            				var $a5 = $('<a href="#">★');
            				var $br1 = $('<br><br>');
            				// 아래 두개 묶음
            				var $div5 = $('<div class="imgDiv">');
            				var $img = $('<img src="/siktam/resources/images" class="reviewImg">');
            				
            				var $br2 = $('<br>');
            				var $p = $('<p>').text(value.rContent);
            				
            				// div1 
            				$div2.append($btn1);
            				$div1.append($label1);
            				$div1.append($div2);
            				
            				// div3
            				$label3.append($a1);
            				$label3.append($a2);
            				$label3.append($a3);
            				$label3.append($a4);
            				$label3.append($a5);
            				
            				$div5.append($img);
            				
            				$div3.append($div4);
            				$div3.append($label2);
            				$div3.append($label3);
            				$div3.append($br1);
            				$div3.append($div5);
            				$div3.append($br2);
            				$div3.append($p);
            	
            				
            			$('#reviewReview').append($div1).append($div3);
            			});
            			
            		}, error:function(){
            			console.log("잘좀해라...");
            		}
            	});
            }
        });

        </script>

    </div>


    <!-- 푸터 시작 -->
    <%@ include file="common/footer.jsp" %>
</body>
</html>
