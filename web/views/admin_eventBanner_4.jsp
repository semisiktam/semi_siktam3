<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.semi.eventBanner.model.vo.*"%>

<%
	ArrayList<EventBanner> list = (ArrayList<EventBanner>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>admin mode</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/siktam/resources/css/admin_4.css">

<style>
.tbl td {
	height: 200px;
}

#insertForm {
	
}

.insertEventName, .updateEventName {
	display: inline-block;
	width: 30%;
	margin: 0px 10px 0px 10px;
}

.insertEventImg, .updateEventImg {
	display: inline-block !important;
}

.submitButton, .deleteEvent, .updateEvent, .updateButton {
	color: #fff;
	background-color: #d9534f;
	border-color: #d43f3a;
	display: inline-block;
	margin-bottom: 0;
	font-weight: 400;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	background-image: none;
	border: 1px solid transparent;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	border-radius: 4px;
	float: right;
	margin-right: 8px;
}

.updateAreaTd {
	display: inline;
}
</style>
</head>
<body style="height: 1080px">

	<%@ include file="common/admin_header.jsp"%>

	<div class="container" style="margin-top: 50px">
		<div class="title">
			<h1>
				<b>이벤트배너 관리</b>
			</h1>
		</div>

		<div class="pagesearch">
			<!-- <div class="search">
      <input class="form-control input-lg" id="inputlg" type="text">
      <button style="border-radius: 6px;" ><span class="glyphicon glyphicon-search" style="color: white; font-size: 18px;"></span></button>
    </div> -->

			<!-- <div class="page">
      <ul class="pagination">
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">6</a></li>
        <li><a href="#">7</a></li>
        <li><a href="#">8</a></li>
        <li><a href="#">9</a></li>
        <li><a href="#">></a></li>
        <li><a href="#">>></a></li>
      </ul>
    </div>
    class page -->

		</div>

		<div class="tbl">
			<div id="insertForm">
				<form action="<%=request.getContextPath()%>/evInsert.ev"
					method="get">
					<h5
						style="display: inline-block; color: rgb(110, 0, 0); font-weight: bold;">이벤트
						추가</h5>
					<input class="insertEventName" name="eventName" type="text"
						placeholder="이벤트명을 입력해주세요"> <input class="insertEventImg"
						name="eventImg" type="file">

					<button type="submit" class="submitButton" style="width: 55px;">등록</button>

				</form>

			</div>


			<table class="table table-hover" id="tbl">
				<tr>
					<th class="eventInfo">이벤트명</th>
					<th class="eventInfo">이벤트이미지</th>
					<th></th>

				</tr>

				<%
					for (EventBanner eb : list) {
				%>
				<tr>
					<td style="display: none;"><%=eb.getEventNo()%></td>
					<td class="eventNameTd"><%=eb.getEventName()%></td>


					<td><img src="<%=eb.getEventImg()%>" alt=""
						style="width: 300px; height: 300px;"></td>
					<td class="text-right">
						<button type="button" class="deleteEvent">삭제</button>
						<button type="button" class="updateEvent">수정</button>

					</td>

				</tr>
				
				<tr class="updateArea" style="cursor: pointer; width: 198%; float: left; background: #eee; padding: 7px 0px 26px;">
					<td class="updateAreaTd" style="border-top: 1px solid #eee !important;"><h5 style="display: inline-block; color: rgb(110, 0, 0); font-weight: bold;">이벤트 수정</h5> 
						<input class="updateEventName" name="eventNameUpdate" type="text" placeholder="변경할 이벤트명을 입력해주세요"> 
						<input class="updateEventImg" name="eventImgUpdate" type="file">
						<button type="button" class="updateButton" style="width: 55px;">수정</button>
					</td>

				</tr>
				
				<% } %>

			</table>
		</div>
		<!-- class tbl -->

	</div>
	<!-- class container -->
	<script>
//수정



$(function(){
	$('.updateArea').css('display','none');
	
	/* $("#tbl td").mouseenter(function(){
		$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
	}).mouseout(function(){
		$(this).parent().css({"background":"white"});
	}) */<%-- .click(function(){
		//console.log($(this).parent().children().eq(0).text());
		var eno = $(this).parent().children().eq(0).text();
		location.href="<%=request.getContextPath()%>/esList.es?eno=" + eno;
	}) --%>;
	
});
// 수정
 $(function(){
   	  $('.updateEvent').click(function(){
          $(this).parent().parent().next().slideToggle();
          
      });
   	  
   	  $('.updateButton').click(function(){
	   		var check2 = $(this).parent().parent().prev().children('td').eq(0).text();
			console.log(check2);
			
			var eventName = $(this).parent('td').children('input').eq(0).val();
			console.log(eventName);
			
			var eventImg = $(this).parent('td').children('input').eq(1).val();
			console.log(eventImg);
		<%-- 	
			location.href="<%=request.getContextPath()%>/evUpdate.ev?check2=" + check2 + "&eventName=" + eventName +"&eventImg=" + eventImg;
    --%>	  });
   	  
  
});

<%-- 
$(function(){
	$('.updateEvent').click(function(){
		$('.updateArea').css('display','block');
		var check2 = $(this).parent().parent().children('td').eq(0).text();
		console.log(check2);
		location.href="<%=request.getContextPath()%>/evUpdate.ev?check2=" + check2;
		
	});
}); --%>

// 선택
$(function(){
	 $('.eventNameTd').click(function(){
		//console.log($(this).parent().children().eq(0).text());
		var eno = $(this).parent().children().eq(0).text();
		location.href="<%=request.getContextPath()%>/esList.es?eno=" + eno;
	});
});



// 삭제
$(function() {
	$('.deleteEvent').click(function() {
		var check1 = $(this).parent().parent().children('td').eq(0).text();
		console.log(check1);
		var conf = confirm("정말 삭제 하시겠습니까?");
		if(conf == true){
			location.href="/siktam/evDelete.ev?check1="+check1;
		}
		
		
	});
});


</script>


</body>
</html>
