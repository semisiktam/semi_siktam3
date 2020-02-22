<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.semi.shop.model.vo.*"%>

<%
	ArrayList<Shop> list = (ArrayList<Shop>) request.getAttribute("list");
	String eno = (String)request.getParameter("eno");
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
<link rel="stylesheet" href="/siktam/resources/css/notice_5.css">

<style>
.tbl td {
	height: 200px;
}

.deleteButton {
	width: 55px;
	color: #fff;
	background-color: #d9534f;
	border-color: #d43f3a;
	cursor: pointer;
	background-image: none;
	border: 1px solid transparent;
	padding: 6px 12px;
	border-radius: 4px;
}

#insertButton {
	width: 55px;
	color: #fff;
	background-color: #d9534f;
	border-color: #d43f3a;
	cursor: pointer;
	background-image: none;
	border: 1px solid transparent;
	padding: 6px 12px;
	border-radius: 4px;
	line-height: normal;
	position: absolute;
	margin-left:2px;
}
.inputButton {
	width: 55px;
	color: #fff;
	background-color: #d9534f;
	border-color: #d43f3a;
	cursor: pointer;
	background-image: none;
	border: 1px solid transparent;
	padding: 6px 12px;
	border-radius: 4px;
	line-height: normal;
}
.shopPid1{
	border:1px solid black;
}
.shopPid1 td{
width: 17%;
}
.shopPid1 input{
    margin: 15px;
    margin-left:27%;
}

#searchArea {
	width: 100%;
}

#searchBox {
	margin: 0 auto;
	width: 100%;
	height: 35px;
	text-align: center;
	font-size: 17px;
}
</style>
</head>
<body style="height: 1080px">

	<%@ include file="common/admin_header.jsp"%>

	<div class="container" style="margin-top: 50px">

		<div class="pagesearch"></div>

		<div class="noticeTitle">
			<h1>업체</h1>
		</div>


		<div id="searchArea">
			<input id="searchBox" type="search" placeholder="매장을 검색하세요">
			<input id="insertButton" type="button" value="검색">
		</div>
		<div id="searchList" style="width: 100%; height: auto;">
			<table id="listArea1" style="margin-top: 0;">
			</table>
			
		</div>

		<script>
				
			
			$('#insertButton').click(function(){
				$.ajax({
					url:"/siktam/esSearch.es",
					type:"get",
					data:{
						searchInfo:$('#searchBox').val()
					},success:function(data){
						console.log(data);
						
						$.each(data,function(index,value){
							var $tr = $('<tr class="shopPid1">');
							var $shopPid =$('<td>').text(value.shopPid);
							var $userId =$('<td>').text(value.userId);
							var $shopName =$('<td>').text(value.shopName);
							var $sAddr =$('<td>').text(value.sAddr);
							var $sPhone =$('<td>').text(value.sPhone);
							
							var $input = $('<input type="button" class="inputButton" onclick="shopInsert();" value="등록">');
					
							$tr.append($shopPid);
							$tr.append($userId);
							$tr.append($shopName);
							$tr.append($sAddr);
							$tr.append($sPhone);
							$tr.append($input);
							
						
							$('#listArea1').append($tr);	
						});
						
						
						
					},error:function(data){
						console.log("실패");
					}
				});
			});
			
			function shopInsert(){
				var insertCheck = $('.inputButton').parent().children('td').eq(0).text();
				console.log(insertCheck);
				var conis = confirm("업체를 등록하시겠습니까?");
				if(conis == true){
					location.href="/siktam/esInsert.es?insertCheck="+insertCheck+"&eno="+<%=eno%>;
				} 
			}
			
		</script>

		<div class="tbl">
			<table class="table table-hover" id="tbl">

				<tr>
					<th class="eventInfo" style="width: 16%;">매장등록번호</th>
					<th class="eventInfo" style="width: 16%;">사용자아이디</th>
					<th class="eventInfo" style="width: 16%;">매장명</th>
					<th class="eventInfo" style="width: 16%;">매장주소</th>
					<th class="eventInfo" style="width: 16%;">매장전화번호</th>
					<th class="eventInfo" style="width: 16%;"></th>
				</tr>

				

				<div class="tableDiv">
					<table id="listArea" style="margin-top: 0;">

						<tbody>
							<%
								for (Shop s : list) {
							%>
							<tr class="shopPid">
								<td style="height: 60px;"><%=s.getShopPid()%></td>
								<td style="height: 60px;"><%=s.getUserId()%></td>
								<td style="height: 60px;"><%=s.getShopName()%></td>
								<td style="height: 60px;"><%=s.getsAddr()%></td>
								<td style="height: 60px;"><%=s.getsPhone()%></td>
								<td style="height: 60px;"><input class="deleteButton"
									type="button" value="삭제"></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>

				</div>
			</table>
		</div>
	</div>
	</div>

	<!-- class container -->
	<script>
		$(function() {
			$('.deleteButton').click(function() {
				var check = $(this).parent().parent().children('td').eq(0).text();
				console.log(check);
				var conf = confirm("정말 삭제 하시겠습니까?");
				if(conf == true){
					location.href="/siktam/esDelete.es?check="+check;
				}
				
				
			});
		});
	</script>
</body>
</html>