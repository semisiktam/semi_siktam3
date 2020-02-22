<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.black.model.vo.*, java.util.*"%>
<%
	BlackList bl = (BlackList)request.getAttribute("bl");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체 상세 페이지</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/siktam/resources/css/admin_4.css">

<style>
	td{
		width: 100px;
	}
	tr{
		height: 40px;
		border-radius: 5px;
	}

	.inputInfo{
		width: 300px;
	}
	
	#container1{
		text-align: center;
		margin-top: 40px;
		margin-bottom: 40px;
	}
	
	#container2{
		min-width:100%; 
		min-height:100%; 
		_height:100%; 
		text-align:center; 
		vertical-align:middle;
	}
	
	#container3{
		text-align: center;
	}
</style>

</head>
<body>
	<%@ include file="common/admin_header.jsp" %>
	
	<form action="<%=request.getContextPath()%>/bUpdate.bl" method="post" onsubmit="return validate();">
	<div id="container1">
		<h1>차단내용 상세정보</h1>
		<br>
		<input type="submit" class="btn" value="수정완료">
        <input type="reset" class="btn" value="취소" onclick="location.href='bList.bl'">
	</div>
	
	<input type="hidden" class="inputInfo" name="bno" value="<%= bl.getBno() %>">
	<input type="hidden" class="inputInfo" name="userId" value="<%= bl.getUserId() %>">
	<input type="hidden" class="inputInfo" name="banDate" value="<%= bl.getBanDate() %>">
	<div id="container2">
		<table style='width: 500px; border-style: solid; border-width: 1px; left: 50%; position: absolute; height: 200px; text-align: center; margin: 0px 0pt 0pt -250px; border-color:gray' cellspacing="0" cellpadding="0">
			<tr>
				<td>아이디</td>
				<td style="text-align:left"><%= bl.getUserId() %></td>
			</tr>
			<tr>
				<td>차단일자</td>
				<td style="text-align:left"><%= bl.getBanDate() %></td>
			</tr>
			<tr>
				<td>차단기간</td>
				<td style="text-align:left"> <input type="text" class="inputInfo" name="banTerm" value="<%= bl.getBanTerm() %>"></td>
			</tr>
			<tr>
				<td>차단사유</td>
				<td style="text-align:left"> <input type="text" class="inputInfo" name="banReason" value="<%= bl.getBanReason() %>"></td>
			</tr>
		</table>
	</div>
	
	</form>
	
	<script>  
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"background":"lightgray", "cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css({"background":"white"});
			});
		});
		
		$('.inputInfo').click(function(){
			$(this).select();
		});
	</script>
</body>
</html>