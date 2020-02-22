<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.semi.shop.model.vo.*, java.util.*"%>
<%
	Shop s = (Shop)request.getAttribute("shop");
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
	
	<form action="<%=request.getContextPath()%>/sAdminUpdate.sh" method="post" onsubmit="return validate();">
	<div id="container1">
		<h1>매장 정보</h1>
		<br>
		<input type="submit" class="btn" value="수정완료">
        <input type="reset" class="btn" value="취소" onclick="location.href='sAdminList.sh'">
	</div>
	
	<div id="container2">
		<table style='width: 500px; border-style: solid; border-width: 1px; left: 50%; position: absolute; height: 200px; text-align: center; margin: 0px 0pt 0pt -250px; border-color:gray' cellspacing="0" cellpadding="0">
			<tr>
				<td>매장등록번호</td>
				<td> <input type="text" class="inputInfo" name="shopPid" value="<%= s.getShopPid() %>"></td>
			</tr>
			<tr>
				<td>사용자아이디</td>
				<td> <input type="text" class="inputInfo" name="userId" value="<%= s.getUserId() %>"></td>
			</tr>
			<tr>
				<td>매장명</td>
				<td> <input type="text" class="inputInfo" name="shopName" value="<%= s.getShopName() %>"></td>
			</tr>
			<tr>
				<td>사진</td>
				<td> <input type="text" class="inputInfo" name="shopImg" value="<%= s.getShopImg() %>"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td> <input type="text" class="inputInfo" name="sAddr" value="<%= s.getsAddr() %>"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td> <input type="text" class="inputInfo" name="sPhone" value="<%= s.getsPhone() %>"></td>
			</tr>
			<tr>
				<td>상세정보</td>
				<td> <input type="text" class="inputInfo" name="sInfo" value="<%= s.getsInfo() %>"></td>
			</tr>
			<tr>
				<td>사업자번호</td>
				<td> <input type="text" class="inputInfo" name="ownerId" value="<%= s.getOwnerId() %>"></td>
			</tr>
			<tr>
				<td>시작시간</td>
				<td> <input type="text" class="inputInfo" name="sTime" value="<%= s.getsTime() %>"></td>
			</tr>
			<tr>
				<td>종료시간</td>
				<td> <input type="text" class="inputInfo" name="eTime" value="<%= s.geteTime() %>"></td>
			</tr>
			<tr>
				<td>휴무일</td>
				<td> <input type="text" class="inputInfo" name="shopDay" value="<%= s.getShopDay() %>"></td>
			</tr>
			<tr>
				<td>메뉴업태</td>
				<td> <input type="text" class="inputInfo" name="menuCategory" value="<%= s.getMenuCategory() %>"></td>
			</tr>
			<tr>
				<td>테이블타입</td>
				<td> <input type="text" class="inputInfo" name="tableType" value="<%= s.getTableType() %>"></td>
			</tr>
			<tr>
				<td>평균가격대</td>
				<td> <input type="text" class="inputInfo" name="avgPay" value="<%= s.getAvgPay() %>"></td>
			</tr>
			<tr>
				<td>폐업유무</td>
				<td> <input type="text" class="inputInfo" name="outYn" value="<%= s.getOutYn() %>"></td>
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